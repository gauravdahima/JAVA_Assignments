/*
 * Create an java program to search through the home directory and look for files 
 * that match a regular expression. The program should be able to take inputs 
 * repeatedly and should print out full absolute path of the matching files found.
 */


import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.regex.PatternSyntaxException;

/*
 * In this program we are repeatedly taking inputs in the form of regular expressions 
 * from the user, until user wants to quit.
 */
public class Assign1 {
	private static boolean match = false;
	static Scanner sc;
	public static void main(String[] args) throws IOException{
		
		sc = new Scanner(System.in);
		while(true){
			/*
			 * Menu for the user to select the options. 
			 * Input should be in the form of int. InputMismatchException will be thrown 
			 * if input other than int is provided.
			 */
			System.out.println("\nChoose from the following options :");
			System.out.println("1. Enter a regular expression for looking matching files.");
			System.out.println("2. Quit.");
			
			try{
				int input = sc.nextInt();
				sc.nextLine();
				if(input == 1){
					findMatchingFiles();
				}
				else if(input == 2){
					System.out.println("The End.");
					break;
				}
				else{
					System.out.println("\nPlease select a valid option.\n");
				}
			}
			catch(InputMismatchException e){
//				e.printStackTrace();
				System.out.println("\njava.util.InputMismatchException : Entered value is not an integer.\n");
				/*
				 * sc.next() will consume the token that causes the InputMismatchException, 
				 * which is invalid and needs to be discarded.
				 */
				sc.next();
			}
			
		}
		sc.close();
	}
	
	/*
	 * Function to find the matching files based on the regular expression
	 * provided by the user. PatternSyntaxException will be thrown if the syntax
	 * of the regular expression is incorrect.
	 * Array of files is passed to a recursive function.
	 */
	public static void findMatchingFiles() throws IOException{
		System.out.println("Enter a regular expression : ");
		sc = new Scanner(System.in);
		String regex = sc.nextLine();
		/*
		 * try and catch block to check if the regular expression entered by user
		 * is syntactically correct or not.
		 */
		try{
			
			/*
			 * Array of files is created. It consists of files as well as directory.
			 */
			String userHome = System.getProperty( "user.home" );
			File current_folder = new File(userHome);
			File[] fileList = current_folder.listFiles();
			System.out.println("\nMatching files are : ");
			
			recursivelyFindMatchingFiles(fileList,regex);
			if(match == false){
				System.out.println("There are no matching files.");
			}
			
		}
		catch(PatternSyntaxException e){
//			e.printStackTrace();
			System.out.println("\njava.util.regex.PatternSyntaxException: Entered regular expression is invalid.\n");
		}
	}
	/*
	 * Function to find the matching files Recursively in the home directory.
	 */
	public static void recursivelyFindMatchingFiles(File[] fileList, String regex) throws IOException{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher ;
		for(int i=0;i<fileList.length ;i++){
			matcher = pattern.matcher(fileList[i].getName());
			if(matcher.find() == true){
				match = true;
				if(fileList[i].isDirectory()){
					System.out.println("Directory : "+fileList[i].getCanonicalPath());
				}
				else{
					System.out.println("File : "+fileList[i].getCanonicalPath());
				}
			}
			
			if(fileList[i].isDirectory()){
				recursivelyFindMatchingFiles(fileList[i].listFiles(), regex);
			}
		}
	}
}
