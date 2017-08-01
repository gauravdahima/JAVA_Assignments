/*
 * write and test a regular expression that checks a sentence to see 
 * that it begins with a capital letter and ends with a period.
 */


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String[] args){
		
		/*
		 * We are creating an input array of strings having different
		 * kinds of input to test for the regular expression.
		 */
		String input[] = new String[8];
		
		input[0] = "My name is Gaurav.";
		input[1] = " My name is Gaurav.";
		input[2] = "My name is Gaurav. ";
		input[3] = " My name is Gaurav. ";
		input[4] = "this is a test run.";
		input[5] = "Oh my god !!";
		input[6] = "i am learning regexx";
		input[7] = "M.";
		
		/*
		 * This regular expression is used to check whether a string begins
		 * with a capital letter and ends with a period('.').
		 * '[A-Z]' is used to check whether the starting point of string is capital letter.
		 * '.*'  this means zero or more of any character.
		 * '\\.$' is used to ensure that the string ends with a period.
		 */
		String regex = "(^[A-Z]).*(\\.$)";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher ;
		/*
		 * We are testing this pattern for different types of input 
		 * and returns true is the pattern is found otherwise false is returned.
		 */
		for(int i=0;i<input.length;i++){
			matcher = pattern.matcher(input[i]);
			System.out.println(matcher.find());
		}
		
	}
}
