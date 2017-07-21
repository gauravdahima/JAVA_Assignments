package gaurav.assignment.singleton;

public class Singleton {
	String s;
	
	public static Singleton sampleMethod(String sample){
		Singleton obj = new Singleton();
		obj.s = sample;
		
		return obj;
	}
	
	public void printString(){
		System.out.println(s);
	}
}
