package net.binaryvibrance.robotplates.utility;

import cpw.mods.fml.common.FMLLog;
import net.binaryvibrance.robotplates.reference.Reference;
import org.apache.logging.log4j.Level;

/**
 * Based on LogHelper from EE3
 */
public class LogHelper {
	public static void log(Level logLevel, Object object) {

		FMLLog.log(Reference.MOD_ID, logLevel, String.valueOf(object));
	}

	public static void log(Level logLevel, String format, Object... object) {
		FMLLog.log(Reference.MOD_ID, logLevel, format, object);
	}

	public static void all(Object object) {
		log(Level.ALL, object);
	}

	public static void debug(Object object) {
		log(Level.DEBUG, object);
	}

	public static void debug(String format, Object... parameters) {
		log(Level.DEBUG, format, parameters);
	}

	public static void error(Object object) {
		log(Level.ERROR, object);
	}

	public static void error(String format, Object... parameters) {
		log(Level.ERROR, format, parameters);
	}

	public static void fatal(Object object) {
		log(Level.FATAL, object);
	}

	public static void info(Object object) {
		log(Level.INFO, object);
	}

	public static void info(String format, Object... parameters) {
		log(Level.INFO, format, parameters);
	}

	public static void off(Object object) {
		log(Level.OFF, object);
	}

	public static void trace(Object object) {
		log(Level.TRACE, object);
	}

	public static void trace(String format, Object... parameters) {
		log(Level.TRACE, format, parameters);
	}

	public static void warn(Object object) {
		log(Level.WARN, object);
	}

	public static void warn(String format, Object... parameters) {
		log(Level.WARN, format, parameters);
	}
}
