import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*
 * This class is used to find the range of the dates for KYC.
 * It takes two dates from user upto n times and find the KYC range of the 
 * dats given.
 */
public class KYC {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer n as number of inputs to be passed.");
		String str = sc.nextLine();
		int n = Integer.parseInt(str);
		
		Calendar signup_date = Calendar.getInstance();
		Calendar current_date = Calendar.getInstance();
		
		for(int i = 1;i <= n; i++){
			System.out.print("Enter two dates in the format \"dd-mm-yyyy dd-mm-yyyy\"");
			System.out.println(" where first date in signup date and second date is the current date.");
			try{
				str = sc.nextLine();
				if(isDateValid(str.split(" ")[0]) == false || isDateValid(str.split(" ")[1]) == false){
					throw new Exception();
				}
				
				signup_date.set(Calendar.DATE, Integer.parseInt(str.substring(0,2)));
				signup_date.set(Calendar.MONTH, Integer.parseInt(str.substring(3,5))-1);
				signup_date.set(Calendar.YEAR, Integer.parseInt(str.substring(6,10)));
				
				current_date.set(Calendar.DATE, Integer.parseInt(str.substring(11,13)));
				current_date.set(Calendar.MONTH, Integer.parseInt(str.substring(14,16))-1);
				current_date.set(Calendar.YEAR, Integer.parseInt(str.substring(17,21)));
				
				getRange(signup_date, current_date);
				
			}
			catch(Exception e){
				System.out.println("\nInvalid input exception !!!!\n");
			}
			
		}
		sc.close();	
	}
	
	/*
	 * function to check whether a date is valid or not.
	 */
	
	private static boolean isDateValid(String date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        try {
	        	dateFormat.setLenient(false);
	        	dateFormat.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	
	/*
	 * Function used to find the range for the KYC. It takes two parameter of type
	 * Calendar, one is the signupDate and another the current date.
	 */
	private static void getRange(Calendar signup_date, Calendar current_date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar anniversary_date = signup_date;
		
		if(signup_date.compareTo(current_date) > 0){
			System.out.println("\nThe range of dates for KYC form is :");
			System.out.println("No range\n");
			return;
		}
		
		while(anniversary_date.compareTo(current_date) < 0){
			anniversary_date.add(Calendar.YEAR,1);
		}
		if(anniversary_date.get(Calendar.YEAR) > current_date.get(Calendar.YEAR)){
			anniversary_date.add(Calendar.YEAR,-1);
		}
		anniversary_date.add(Calendar.DATE, -30);
		System.out.println("\nThe range of dates for KYC form is :");
		System.out.print(dateFormat.format(anniversary_date.getTime())+" ");
		
		anniversary_date.add(Calendar.DATE, 60);
		if(anniversary_date.compareTo(current_date) > 0){
			System.out.println(dateFormat.format(current_date.getTime())+"\n");
		}
		else{
			System.out.println(dateFormat.format(anniversary_date.getTime())+"\n");
		}
	}
}
