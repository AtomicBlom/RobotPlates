package net.binaryvibrance.robotplates.programming.compiler;

import java.util.LinkedList;

public class CodePath {
	public LinkedList<InterconnectInfo> interconnects = new LinkedList<InterconnectInfo>();

	public void merge(CodePath locatedCodePath) {
		for (InterconnectInfo ic : interconnects) {
			ic.codePath = locatedCodePath;
			locatedCodePath.interconnects.addLast(ic);
		}
	}
}
