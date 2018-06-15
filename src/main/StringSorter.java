package main;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringSorter {
	public String sorter(String input) throws UnExpectedInputException {
		StringBuffer sb = new StringBuffer();
		if( Pattern.matches("^[a-z0-9]*$", input) ) {
			
			String alpha = alphaExt(input);
			String number = numberExt(input);
			if(alpha.length() > 0) alpha = sort(alpha);
			if(number.length() > 0) number = sort(number);
			
			for(int i=0; i < input.length() ; i++) {
				if(i < alpha.length()) sb.append(alpha.charAt(i));
				if(i < number.length()) sb.append(number.charAt(i));
			}
			
		} else {
			throw new UnExpectedInputException();
		}
		return sb.toString();
	}
	
	
	public String alphaExt(String i) {

		return i.replaceAll("[^a-z]", "");
	}
	
	public String numberExt(String i) {

		return i.replaceAll("[^0-9]", "");
	}
	
	public String sort(String i) {
		char[] c = i.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	

}
