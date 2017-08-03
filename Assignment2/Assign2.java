/*
 * Write a java function that checks if the input string contains all the 
 * letters of the alphabet a-z (case-insensitive). 
 */

import java.util.Scanner;

/*
 * This program takes an input string from the user and pass the string to 
 * method checkAlphabet() which checks if a string contains all the letters
 * of the alphabet a-z (case-insensitive).  
 */
public class Assign2 {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string : ");
		String s  = sc.nextLine();
		
		// a lower case string is passed to the function.
		if(checkAlphabet(s.toLowerCase())){
			System.out.println("Yes, string contains all the letters of the alphabet a-z (case-insensitive).");
		}
		else{
			System.out.println("NO, string does not contains all the letters of the alphabet a-z (case-insensitive).");
		}
		sc.close();
	}
	
	
	 /****************************
	 * Time Complexity  : O(n)   *
	 * Space Complexity : O(1)   *
	 ****************************/
	
	/*
	 * A boolean array of constant size 26 is created and all of its values are 
	 * initialized to false. An integer variable is used to store the ASCII value
	 * of a character minus ASCII value of char 'a'. If its value is 0, means 'a' is
	 * present and we filled corresponding place with true.
	 * 
	 * Finally, we iterate over the array and if there is a false value at any index ,
	 * then we will return false. otherwise will return true.
	 */
	static boolean checkAlphabet(String str){
		int temp ;
		boolean[] arr = new boolean[26];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = false;
		}
		
		for(int i=0; i<str.length() ;i++){
			temp = str.charAt(i) - 'a';
			if(temp >= 0 && temp <26){
				arr[temp] = true;
			}
		}
		for(int i=0 ; i<arr.length; i++){
			if(arr[i] == false){
				return false;
			}
		}
		return true;
	}
}
