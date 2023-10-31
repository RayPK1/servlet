package common;

import java.text.DecimalFormat;

public class Process {

	public static String getVaildString(String s) {
		if(s==null) return "";
		return s;
	}
	
	 public static String convertDoubleToStringWithComma(double d) {
         return new DecimalFormat("###,###").format(d);

 }
	 public static String riseString (long num, int digit) {
		num = num + 10000000000000000L; //17 số 0
		num++;
		String result = String.valueOf(num);
		return result.substring(result.length()-digit);
		 
	 }
	 public static boolean isVaidDigit(String str) {
		 return str!=null && str.matches("[0-9]+");
	 }
}
