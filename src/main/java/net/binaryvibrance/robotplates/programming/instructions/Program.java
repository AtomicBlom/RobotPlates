package net.binaryvibrance.robotplates.programming.instructions;

import net.binaryvibrance.robotplates.api.programming.IEvent;
import net.binaryvibrance.robotplates.api.programming.IInstruction;
import net.binaryvibrance.robotplates.api.programming.ITriggerListener;
import net.binaryvibrance.robotplates.entity.BaseRobot;
import net.binaryvibrance.robotplates.utility.LogHelper;

import java.util.LinkedList;
import java.util.List;

public class Program implements ITriggerListener {

	private final List<IEvent> events;
	private final List<InternalProgramState> runningEvents;
	private boolean running;
	private BaseRobot robot;

	public Program(BaseRobot robot) {
		this.robot = robot;
		events = new LinkedList<IEvent>();
		runningEvents = new LinkedList<InternalProgramState>();
	}

	public void AddEvent(IEvent event) {
		event.setTriggerListener(this);
		events.add(event);
	}

	public void startEvent(IEvent event) {
		synchronized (runningEvents) {
			InternalProgramState internalState = new InternalProgramState(event, robot);
			if (!runningEvents.contains(internalState)) {
				runningEvents.add(internalState);
			} else {
				LogHelper.warn("attempting to add event while it's running");
			}
		}
	}

	public void start() {
		running = true;
		for (IEvent event : events) {
			event.getHandler().register(event);
		}
	}

	public void stop() {
		for (IEvent event : events) {
			event.getHandler().unregister(event);
		}
		running = false;
	}

	public void update() {
		if (!running) { return; }
		int allowedInstructions = 500;

		List<InternalProgramState> runningEvents;
		synchronized (this.runningEvents) {
			runningEvents = new LinkedList<InternalProgramState>(this.runningEvents);
		}

		//LogHelper.info("Running %d events", this.runningEvents.size());

		while (runningEvents.size() > 0 && allowedInstructions > 0) {
			List<InternalProgramState> finishedEvents = new LinkedList<InternalProgramState>();

			for (InternalProgramState state : runningEvents) {

				state.executeOneInstruction();
				allowedInstructions--;
				if (state.isFinished()) {
					finishedEvents.add(state);
				}
			}

			synchronized (this.runningEvents) {
				for (InternalProgramState stateToRemove : finishedEvents) {
					this.runningEvents.remove(stateToRemove);
					runningEvents.remove(stateToRemove);
				}
			}
		}

		if (this.runningEvents.size() > 0) {
			LogHelper.info("FYI - quit out with jobs still to complete.");
		}

	}

	class InternalProgramState {
		private final IEvent event;
		private final LinkedList<IInstruction> pendingInstructions = new LinkedList<IInstruction>();
		private final ProgramState state;

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			InternalProgramState that = (InternalProgramState) o;

			if (!event.equals(that.event)) return false;
			if (!state.getRobot().equals(that.state.getRobot())) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = event.hashCode();
			result = 31 * result + state.getRobot().hashCode();
			return result;
		}

		InternalProgramState(IEvent event, BaseRobot robot) {
			this.event = event;
			this.state = new ProgramState(robot);
			for (IInstruction instruction : event.getInstructions()) {
				pendingInstructions.addLast(instruction);
			}
		}

		public IEvent getEvent() {
			return event;
		}

		public boolean isFinished() {
			return pendingInstructions.size() == 0;
		}

		public void executeOneInstruction() {
			if (!isFinished()) {

				IInstruction i = pendingInstructions.removeFirst();
				//LogHelper.info("Executing instruction %s triggered by %s on robot %s", i.getClass().getSimpleName(), event.getClass().getSimpleName(), state.getRobot());
				Iterable<IInstruction> nextInstructions = i.execute(state);
				if (nextInstructions != null) {
					for (IInstruction instruction : nextInstructions) {
						pendingInstructions.addLast(instruction);
					}
				}
			}
		}
	}
}
