/*
 * Here we have created two nested class, the inner class has its own custom constructor
 * which is taking string as a parameter.
 */
class First{
	public First(){
		System.out.println("Constructor of First class.");
	}
	class Second{
		String name;
		public Second(String name) {
			this.name = name;
			System.out.println(name);
			System.out.println("Constructor of Second class.");
		}
	}
}

/*
 * Again we have created two nested class, the inner class is extending the Second class 
 * defined above. It has its own custom constructor, and a method called presence which
 * is just outputting that we are in Fourth class right now.
 */

class Third{
	public Third(){
		System.out.println("Constructor of Third class.");
	}
	class Fourth extends First.Second{
		public Fourth(First first, String name) {
			first.super(name);
			System.out.println("Constructor of Fourth class.");
		}
		
		void presence(){
			System.out.println("Currently I am in Fourth class.");
		}
		
	}
}

/*
 * main method to test by creating a method of Fourth class and running its presence method.
 */
public class InnerClasses {
	public static void main(String[] args){
		Third.Fourth obj = new Third().new Fourth(new First(), "Gaurav");
		obj.presence();
	}
}