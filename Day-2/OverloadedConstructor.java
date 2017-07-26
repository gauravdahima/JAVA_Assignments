/*
 * This class has two overloaded constructor.
 * And we are calling the Overloaded constructor
 * from the default constructor.
 */
public class OverloadedConstructor {
	
	/*
	 * There are two instance variables in this sample class
	 */
	String name;
	int salary;
	
	
	/*
	 * This is the default constructor
	 * We are calling the Overloaded constructor 
	 * inside this one
	 */
	public OverloadedConstructor(){
		this("xyz",1234);
		System.out.println("This is the default constructor.");
	}
	
	/*
	 * This is the second constructor called within the first one
	 */
	public OverloadedConstructor(String name, int salary){
		this.name = name;
		this.salary = salary;
		System.out.println("This is the overloaded constructor.");
	}
	
	/*
	 * main method to create an object of the class and for testing
	 */
	public static void main(String[] args){
		OverloadedConstructor obj = new OverloadedConstructor();
		System.out.println("\nName : "+obj.name);
		System.out.println("Salary : "+obj.salary);
	}
	
}
