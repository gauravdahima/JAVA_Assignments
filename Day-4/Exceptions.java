/*
 * Here we are creating three types of exceptions here.
 * All the custom made Exceptions classes are inheriting the
 * parent Exception class.
 */

class InvalidAgeException extends Exception{
	public InvalidAgeException(String error) {
		super(error);
	}
}

class InvalidMarksException extends Exception{
	InvalidMarksException(String error) {
		super(error);
	}
}

class InvalidSalaryException extends Exception{
	public InvalidSalaryException(String error) {
		super(error);
	}
}

/*
 * Here we are using a method which can throws all the above
 * exceptions depending upon the arguments provided to method
 */
public class Exceptions {
	
	static void check(int age, int marks, int salary) throws InvalidAgeException, 
													InvalidMarksException, InvalidSalaryException{
		
		/*
		 * If the age provided here is less than 18 then the user is not allowed
		 * to cast his vote and an exception will be thrown. Similarly for the other
		 * two parameters exceptions might be thrown.
		 */
		
		if(age < 18){
			throw new InvalidAgeException("Age not valid !!");
		}
		else {
			System.out.println("You can cast your vote !!");
		}
		if(marks < 33){
			throw new InvalidMarksException("You have failed !!");
		}
		else {
			System.out.println("You have successfully passed the exam.");
		}
		
		if(salary < 40000){
			throw new InvalidSalaryException("You are not allowed to apply for loan.");
		}
		else {
			System.out.println("You can apply for loan.");
		}
	}
	
	/*
	 * Here we are in the main method testing the above method. A single catch
	 * statement is used to catch three types of exceptions. 
	 */
	
	public static void main(String[] args){
		
		try{
			/*
			 * check(17,25,25000);
			 * if we call the check method by passing the above mentioned 
			 * parameters then the InvalidAgeException will be thrown.
			 */
			
			check((Integer) null,25,25000);
			/*
			 * Here we are passing a null value still the finally block is executed.
			 */
			 
		}
		catch(InvalidAgeException | InvalidMarksException | InvalidSalaryException e ){
				System.out.println("Exception occured: "+e);
				e.printStackTrace(System.out);
		}
		finally{
			System.out.println("I am outside the try-catch block and this is the final statement !!\n");
		}
	}
}
