package org.cryptonode.jncryptor;

import java.lang.reflect.Field;

import android.util.Log;

public class JNCryptorLogger {

	private static boolean DEBUG = true;
	
	public static void LOGGER(String logMessage){
		if (DEBUG){
			String sTag = getTag();
			Log.d(sTag, logMessage);
		}
	}
	
	/**
	 * Performs a bit of reflection to get the name of the calling class 
	 * @return String name of calling class
	 */
	private static String getTag() {
	    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
	    if (stackTraceElements.length > 6) {
	        return getTag(stackTraceElements[5]);
	    } else {
	        return "";
	    }
	}
	/**
	 * Performs reflection on a class that has the value <code>static final String TAG="some_class";</code>
	 * If it fails, return the default value represented by {@link StackTraceElement}.
	 * 
	 * @param stElement StackTraceElement that we're going to reflect on.
	 * @return String<br/>
	 * depending on condition<ul><li>if TAG is not found, returns some_java_file:some_line_number</li>
	    <li>otherwise returns value_of_TAG:some_java_file:some_line_number</li></ul>
	 * 
	 */
	private static String getTag(StackTraceElement stElement){
		String strTagValue = stElement.getFileName() + ":" + stElement.getLineNumber();
		boolean blnGotDeclTagField = false;
		boolean blnGotTagField = false;
		Class<?> clazz = stElement.getClass();
		Field f = null;
		try {
		    f = clazz.getDeclaredField("TAG");
		    blnGotDeclTagField = true;
		} catch (NoSuchFieldException e) {
		    // No need to print stacktrace in this logger!
		}
		if (blnGotDeclTagField && f != null){
			Object objField = null;
			Class<?> objFieldType = null;
			try {
			    objField = f.get(null);
			    blnGotTagField = true;
			} catch (IllegalArgumentException e) {
			    // Zip it!
			} catch (IllegalAccessException e) {
			    // Shush - FFS!
			}
			if (blnGotTagField){
			    objFieldType = f.getType();
			    if (objFieldType == String.class){
			        strTagValue = objField.toString() + ":" + stElement.getFileName() + ":" + stElement.getLineNumber();
			        }
			    }
			}
			return strTagValue;
		}
}
