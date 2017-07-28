
/*
 * There are three Interfaces with each one of them having
 * two methodsS
 */
interface Phsyics {
	void mechanics();
	void electromagnetism();
}

interface Chemistry {
	void organic();
	void inorganic();
}

interface Maths {
	void algebra();
	void calculus();
}

/*
 * This interface inherit all the above three interfaces 
 * and added a new method of its own.
 */

interface Subjects extends Phsyics, Chemistry, Maths {
	void startTest();
}

class Marks{
	static void marks(){
		System.out.println("Marks awarded.");
	}
}

/*
 * Exam class inheriting Marks class and implementing 
 * the Subjects interface
 */
class Exam extends Marks implements Subjects{
	public void mechanics() {
		System.out.println("I am studying mechanics.");
	}
	public void electromagnetism() {
		System.out.println("I am studying electromagnetism.");
	}
	
	public void organic() {
		System.out.println("I am studying organic chemistry.");
	}
	public void inorganic() {
		System.out.println("I am studying inorganic chemistry.");
	}
	
	public void algebra() {
		System.out.println("I am studying algebra.");
	}
	public void calculus() {
		System.out.println("I am studying calculus.");
	}
	
	public void startTest() {
		System.out.println("I am giving test.");
	}
}


public class Interface {
	/*
	 * These methods are receiving object of type Exam
	 * and then calling the methods of the respective interface
	 */
	static void physicsExam (Phsyics p){
		p.mechanics();
	}
	static void chemistrtExam (Chemistry c){
		c.organic();
	}
	static void mathsExam (Maths m){
		m.algebra();
	}
	static void subjectExam (Subjects s){
		s.startTest();
	}
	
	
	/*
	 * main method to test the method created above.
	 */
	public static void main(String[] args) {
		Exam ex = new Exam();
		
		physicsExam(ex);
		chemistrtExam(ex);
		mathsExam(ex);
		subjectExam(ex);
		
		Exam.marks();
	}
}
