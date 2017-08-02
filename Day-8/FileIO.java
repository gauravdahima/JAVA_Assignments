
/*
 * Using TextFile and a Map<Character,Integer>, create a program that takes 
 * the file name as a command line argument and counts the occurrence of all 
 * the different characters. Save the results in a text file.
 */


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;

/*
 * In this class we are taking the name of the text file as 
 * an argument from the user. After that we are using FileReader
 * to read the text file, similarly we are using FileWriter to 
 * write to the text file.
 * After that we have created a map which stores a character as a 
 * key and corresponding number of occurrences as its value, which  
 * is written to the output file using FileWriter.
 */


public class FileIO {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader(args[0]);
		FileWriter fw = new FileWriter("write.txt");
		/*
		 * Map<K,V> is an interface.
		 * HashMap<K,V> is a class that implements Map.
		 */
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		
		/*
		 * The read() method of FileReader class returns an int which contains 
		 * the char value of the character read. It it returns a value of -1 that
		 * means we have reached the end of the file.
		 */
		
		int temp;
		char c;
		while ((temp = fr.read())!=-1){
			c = (char)temp;
			/*
			 * In the given text file there are three end line character.
			 * if(c == '\n'){
			 * 		System.out.println("I am end line char");
			 * }				
			 * 
			 * 
			 * If map contains a key then the pair will be replaced 
			 * (value will be increased by 1). otherwise a new pair will be created
			 * and its corresponding value will be assigned as 1.		
			 */
			
			
			
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
				else {
					map.put(c, 1);
				}
		}
		/*
		 * Keys in the java.util.HashMap are unordered.
		 * An instance of iterator is created to iterate over the map.
		 * After that corresponding key and values are written to the 
		 * text file using the FileWriter.
		 */
		Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Character, Integer> pair = it.next();
			fw.write("\""+pair.getKey()+"\" = "+pair.getValue()+"\n");
		}
		
		/*
		 * FileReader and FileWriter are closed.
		 */
        fr.close();
        fw.close();
	}
}
