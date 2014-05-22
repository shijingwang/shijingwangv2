package com.sjw.v2.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.log.Log;
import org.nutz.log.LogAdapter;
import org.nutz.log.impl.AbstractLog;
import org.nutz.plugin.Plugin;

/**
 * Apache log4j 适配器
 * 
 * <p/>存在<code>org.apache.log4j.Logger</code>就认为可用.
 * <p/>同样的,如果存在log4j-over-slf4j,则也会认为可用.
 * <p/>参考Issue : http://code.google.com/p/nutz/issues/detail?id=322
 * <p/>
 * <b>Log4J 1.2.11及之前的版本不支持Trace级别,默认转为使用Debug级别来Log</b>
 * 
 * @author Young(sunonfire@gmail.com)
 * @author wendal(wendal11985@gmail.com)
 */
public class MyLog4jLogAdapter implements LogAdapter, Plugin {

	public boolean canWork() {
		try {
			Class.forName("org.apache.logging.log4j.Logger", false, MyLog4jLogAdapter.class.getClassLoader());
			System.out.println("ALL Nutz Log via Log4jLogAdapter");
			return true;
		} catch (Throwable e) {
		}
		return false;
	}

	public Log getLogger(String className) {
		return new Log4JLogger(className);
	}

	static class Log4JLogger extends AbstractLog {

		public static final String SUPER_FQCN = AbstractLog.class.getName();
		public static final String SELF_FQCN = Log4JLogger.class.getName();

		private Logger logger;

		private static boolean hasTrace;

		static {
			try {
				Level.class.getDeclaredField("TRACE");
				hasTrace = true;
			} catch (Throwable e) {
			}
		}

		Log4JLogger(String className) {
			logger = LogManager.getLogger(className);
		}

		public void debug(Object message, Throwable t) {
			logger.debug(message.toString(), t);
		}

		public void error(Object message, Throwable t) {
			logger.error(message.toString(), t);

		}

		public void fatal(Object message, Throwable t) {
			logger.fatal(message.toString(), t);
		}

		public void info(Object message, Throwable t) {
			logger.info(message.toString(), t);
		}

		public void trace(Object message, Throwable t) {
			if (isTraceEnabled())
				logger.trace(message.toString(), t);
			else if ((!hasTrace) && isDebugEnabled())
				logger.debug(message.toString(), t);
		}

		public void warn(Object message, Throwable t) {
			logger.warn(message.toString(), t);
		}

		@Override
		protected void log(int level, Object message, Throwable tx) {
			switch (level) {
			case LEVEL_FATAL:
				logger.fatal(message.toString(), tx);
				break;
			case LEVEL_ERROR:
				logger.error(message.toString(), tx);
				break;
			case LEVEL_WARN:
				logger.warn(message.toString(), tx);
				break;
			case LEVEL_INFO:
				logger.info(message.toString(), tx);
				break;
			case LEVEL_DEBUG:
				logger.debug(message.toString(), tx);
				break;
			case LEVEL_TRACE:
				if (hasTrace)
					logger.trace(message.toString(), tx);
				else
					logger.debug(message.toString(), tx);
				break;
			default:
				break;
			}
		}
	}
}
