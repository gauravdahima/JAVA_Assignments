
class City {
    String name;

    public City(String name) {
        this.name = name;
        System.out.println(name);
    }
}

public class ArrayInitialization {
	
    public static void main(String[] args) {
    	/*
    	 * An array of object references to this class city has been 
    	 * created, but we havn't actually created the objects 
    	 * to assign into the array. So while running the program the
    	 * initialization messages are not printing as we haven't created the object yet
    	 */ 
    	City[] cities = new City[5];
        
    }
}