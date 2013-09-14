package com.massifsource.purge;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nikolay
 * 
 */
public class App {

	private static Logger log = LoggerFactory.getLogger(App.class);
	private static boolean isRecursive = true;
	private static Mode mode = Mode.SEARCH;
	private static int filesFoundCount = 0;
	private static int filesPurgedCount = 0;
	
	private static enum Mode {
		PURGE, SEARCH
	}

	public static void main(String[] args) {
		if (args.length >= 4 && Mode.valueOf(args[3].toUpperCase()) != null) {
			mode = Mode.valueOf(args[3].toUpperCase());
		}
		if (args.length >= 3) {
			try {
				isRecursive = Boolean.parseBoolean(args[2].toLowerCase());
			} catch (Exception e) {

			}
		}
		log.debug("Mode: [{}]", mode.toString());
		purge(args[0], args[1]);
	}

	private static void purge(String directoryName, String regex) {
		File directory = new File(directoryName);
		if (directory.isDirectory()) {
			process(directory, regex);
		} else {
			log.error("{} is not a directory", directoryName);
			System.exit(1);
		}
		log.info("FIles found: {}", filesFoundCount);
		log.info("FIles purged: {}", filesPurgedCount);
	}

	private static void process(File directory, final String regex) {
		File[] pathnames = directory.listFiles();
		for (int i = 0; i < pathnames.length; i++) {
			File path = pathnames[i];
			if (path.isDirectory() && isRecursive) {
				process(path, regex);
			}
			if (!path.isDirectory() && path.getName().matches(regex)) {
				filesFoundCount++;
				switch (mode) {
					case PURGE:
						path.delete();
						log.debug("Deleted {} ", path.getAbsolutePath());
						filesPurgedCount++;
						break;
					case SEARCH:
						log.debug("Found {} ", path.getAbsolutePath());
						break;
					}
				path = null;
			}
		}
	}

}
