
/* This is the parent class having its own constructor 
 * and two methods.
 */
class Rodent{
	public Rodent(){
		System.out.println("Rodent Constructor.");
	}
	
	public void eat(){
		System.out.println("Rodent is eating.");
	}
	
	public void jump(){
		System.out.println("Rodent is jumping.");
	}
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
