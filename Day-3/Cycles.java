package practice;
/*
 * Interface of cycle having a method called ride
 */
interface Cycle{
	void ride();
}

/*
 * Interface of a factory of the cycles, having a method produce cycle
 */
interface CycleFactory{
	Cycle produceCycle();
}


/*
 * Each specific class implementing the cycle interface and
 * defining the ride method.
 */
class Unicycle implements Cycle{
	public void ride(){
		System.out.println("I am riding unicycle.");
	}
}
/*
 *Each factory implementing the CycleFactory interface 
 *and creating respective type of cycles.
 */
class UniycleFactory implements CycleFactory{

	public Cycle produceCycle() {
		return new Unicycle();
	}
	
}


class Bicycle implements Cycle{
	public void ride(){
		System.out.println("I am riding bicycle.");
	}
}

class BiycleFactory implements CycleFactory{

	public Cycle produceCycle() {
		return new Bicycle();
	}
}


class Tricycle implements Cycle{
	public void ride(){
		System.out.println("I am riding tricycle.");
	}
}

class TriycleFactory implements CycleFactory{

	public Cycle produceCycle() {
		return new Tricycle();
	}	
}

/*
 * In the main method we are creating cycles of each type 
 * from the respective factories and running their ride method. 
 */
public class Cycles {
	public static void main(String[] args){
		
		Cycle uni = new UniycleFactory().produceCycle();
		Cycle bi = new BiycleFactory().produceCycle();
		Cycle tri = new TriycleFactory().produceCycle();
		
		uni.ride();
		bi.ride();
		tri.ride();
		
	}
}
