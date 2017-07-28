/*
 * Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. 
 * Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle. 
 * Create instances of all three types and upcast them to an array of Cycle. 
 * Try to call balance( ) on each element of the array and observe the results. 
 * Downcast and call balance( ) and observe what happens.
 */

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
