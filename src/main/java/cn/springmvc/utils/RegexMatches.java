package cn.springmvc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	
	private static Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");
	
	public static String replace(String str) {
		if(str==null||"".equals(str)) {
			return str;
		}
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println("group " + matcher.group());
			String value = CorrelationUtils.getCorrelationValue(matcher.group(1)).toString();
			System.out.println("group1 " + matcher.group(1) + " values " + value);
			str = str.replace(matcher.group(), value);
		}
		return str;
	}
	
	public static String replaceForString(String str) {
		if(str==null||"".equals(str)) {
			return str;
		}
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println("group " + matcher.group());
			Object value = CorrelationUtils.getCorrelationValue(matcher.group(1));
			if(value instanceof String) {
				value = addSingleQuotes(value.toString());
			}
			System.out.println("group1 " + matcher.group(1) + " values " + value);
			str = str.replace(matcher.group(), value.toString());
		}
		return str;
	}

	
	public static String addSingleQuotes(String str) {
		return "'" + str + "'";
	}

}
