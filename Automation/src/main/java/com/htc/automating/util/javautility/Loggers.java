package com.htc.automating.util.javautility;

import org.apache.log4j.Logger;

public class Loggers {
	
	public static void info(String classname,String info) throws MyException {
		try {
			Logger logger = Logger.getLogger(classname);
			logger.info(info);	
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
}