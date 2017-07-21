package gaurav.assignment.main;

import gaurav.assignment.data.Data;
import gaurav.assignment.singleton.Singleton;

public class Main {
	public static void main(String[] args){
		Data obj1 = new Data();
		obj1.samplePrint1();
		obj1.samplePrint2();
		
		Singleton obj2 = Singleton.sampleMethod("Hello Zemoso !!");
		obj2.printString();
		
	}
}
