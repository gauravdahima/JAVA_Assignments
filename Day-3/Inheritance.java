/*
 * Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. 
 * In the base class, provide methods that are common to all Rodents, 
 * and override these in the derived classes to perform different behaviors 
 * depending on the specific type of Rodent. Create an array of Rodent, 
 * fill it with different specific types of Rodents, and call your base-class 
 * methods to see what happens. Make the methods of Rodent abstract whenever 
 * possible and all classes should have default constructors that print a 
 * message about that class.
 */


/* This is the parent class having its own constructor 
 * and two methods.
 */
class Rodent{
	public Rodent(){
		System.out.println("Rodent Constructor.");
	}
	
	// method is abstract
	public void eat() {}
	
	// method is abstract
	public void jump() {}
}

class Hamster extends Rodent{
	public Hamster(){
		System.out.println("Hamster Constructor.");
	}
	
	public void eat(){
		System.out.println("Hamster is eating.");
	}
	
	public void jump(){
		System.out.println("Hamster is jumping.");
	}
}

class Mouse extends Rodent{
	public Mouse(){
		System.out.println("Mouse Constructor.");
	}
	
	public void eat(){
		System.out.println("Mouse is eating.");
	}
	
	public void jump(){
		System.out.println("Mouse is jumping.");
	}
}

class Gerbil extends Rodent{
	public Gerbil(){
		System.out.println("Gerbil Constructor.");
	}
	
	public void eat(){
		System.out.println("Gerbil is eating.");
	}
	
	public void jump(){
		System.out.println("Gerbil is jumping.");
	}
}

public class Inheritance {
	public static void main(String[] args){
		/*
		 * An array of Rodent, filled with different specific types of Rodents.
		 * While calling the constructor of child class, the constructor of its parent
		 * is called first, so it goes on till the top of the hierarchy chain. This
		 * is called Constructor Chaining.
		 */
		Rodent[] rod = { 		
					new Rodent(),
					new Mouse(),
					new Gerbil(),
					new Hamster()
			};
			System.out.println("\n");
			
			/* calling the methods of each class.
			 * We have override the methods in the derived class.
			 * 
			*/
			for(int i=0;i<rod.length ;i++){
				rod[i].eat();
				rod[i].jump();
			}
	}
}
