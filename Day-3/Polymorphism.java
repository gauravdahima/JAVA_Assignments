
class Cycle {
	
}

class Unicycle extends Cycle{
	void balance(){
		System.out.println("I am balancing a Unicycle !!");
	}
}

class Bicycle extends Cycle{
	void balance(){
		System.out.println("I am balancing a Bicycle !!");
	}
}

class Tricycle extends Cycle{
	
}




public class Polymorphism {
	public static void main(String[] args){
		/*
		 * Here we are creating instances of each subclasses and
		 * upcasting them to the Cycle class and observing the results
		 */
		
		Cycle[] c = {	
				new Unicycle(), new Bicycle(),new Tricycle()
				};
//		cannot call this method because balance method is undefined in Cycle class
//		c[0].balance();
//		c[1].balance();
//		c[2].balance();
		
		/*
		 * Now we will downcast them to observe the results.
		 */
		
		((Unicycle)c[0]).balance();
		((Bicycle)c[1]).balance();
		
		/*
		 * since balance method is undefined in class Tricycle
		 * so we cannot call it 
		 */
		//((Tricycle)c[2]).balance();
	}
}
