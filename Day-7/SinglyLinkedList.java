/*
 * 
 * Create a generic, singly linked list class called SList, which, to keep things 
 * simple, does not implement the List interface. Each Link object in the list 
 * should contain a reference to the next element in the list, but not the previous 
 * one (LinkedList, in contrast, is a doubly linked list, which means it maintains 
 * links in both directions). Create your own SListIterator which, again for simplicity, 
 * does not implement ListIterator. The only method in SList other than toString( ) 
 * should be iterator( ), which produces an SListIterator. The only way to insert and 
 * remove elements from an SList is through SListIterator. Write code to demonstrate SList.
 * 
 */


/*
 *  This is a node class having a data variable of generic type, and 
 *  a pointer to the next node in the list. This class has a constructor
 *  which takes the value of instance variable data. Also toString() method
 *  is provided in the class.
 */
class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		this.next = null;
	}
	
	public String toString(){
		if(data == null){
			return "null";
		}
		else {
			return data.toString();
		}
	}
}


/*
 * Class SList is generic class used to create the singly linked list.
 * This class has an instance variable of type Node that stores the 
 * value of the head of the linked list.
 * Along with toString() method this class also has a iterator() method
 * that returns object of class SListIterator(), which points to the
 * starting of the linked list.  
 */

class SList<T>{
	Node<T> head = new Node<T>(null);
	
	public String toString(){
		if(head.next == null){
			return "List is empty !!";
		}
		
		SListIterator<T> it = iterator();
		String s = "";
		while(it.hasNext()){
			s = s + it.next() + " -->";
		}
		return s+"END";
	}
	
	SListIterator<T> iterator(){
		return new SListIterator<T>(head);
	}
}

/*
 * This is an iterator class. It has two instance variable of type Node<T> one of which
 * points to the current node and other points to the head of the list. 
 * It has a constructor which points the curr and head variable to the starting of the 
 * linkedList(i.e. the head of the LinkedList).
 * This class has four methods: 
 * hasNext() : Checks whether the list has next node or not.
 * next() : returns the next node of the list.
 * insert(T) : It takes the data value as its parameter and add the node in front of 
 * 			   current node. Time Complexity : O(1)
 * remove() : It removes the last node of the list and update the curr pointer.
 * 			  Time Complexity : O(n)
 */

class SListIterator<T>{
	Node<T> curr;
	Node<T> head;
	public SListIterator(Node<T> head) {
		this.curr = head;
		this.head = head;
	}
	
	public boolean hasNext(){
		if(curr.next == null){
			return false;
		}
		else {
			return true;
		}
	}
	
	public Node<T> next(){
		curr = curr.next;
		return curr;
	}
	
	/*
	 * Time complexity of inserting a node : O(1)
	 */
	public void insert(T data) {
		System.out.println("Inserting "+data);
		curr.next = new Node<T>(data);
		curr = curr.next;
	}
	/*
	 * Time complexity of removing a node : O(n) 
	 */
	public void remove(){
		Node<T> temp = head;
		if(temp.next == null){
			System.out.println("Nothing to remove, list is empty !!!");
			return ;
		}
		while(temp.next.next != null){
			temp = temp.next;
		}
		curr = temp;
		System.out.println("Removing: "+temp.next.data);
		temp.next = null;
	}
	
}

/*
 * This class contains the main method use to test the singly linked list.
 * Here we are creating a singly list of type Integer and a corresponding 
 * iterator object. 
 * We have created a local variable to store the reference to the head of the list.
 */

public class SinglyLinkedList {
	public static void main(String[] args) {
		SList<Integer> s1 = new SList<Integer>();
		SListIterator<Integer> it = s1.iterator();
		
		System.out.println(s1); 	// printing the empty list.
		it.insert(1213);   	// inserting 1213 to the list.
		
		System.out.println(s1);
		it.insert(1213546);	// inserting 1213546 to the end of the list. 
		
		System.out.println(s1);
		it.insert(46);			// inserting 46 to the end of the list.
		
		System.out.println(s1);		
		it.remove();			// removing a node from the end of the list.
		
		System.out.println(s1);
		it.remove();			// removing another node from the end of the list.
		
		System.out.println(s1);
		it.insert(9999);		// adding a 9999 in the end of the list.
		
		System.out.println(s1);
		it.remove();			// removing a node from the end of the list.
		
		System.out.println(s1);
		it.remove();			// removing a node from the end of the list.
		
		System.out.println(s1); 	// Printing the empty list.
		
		it.remove();			// trying to remove from an empty list.
		System.out.println(s1);		// printing the empty list.
		
		
		/*
		 * Output :
		 * 
		 * List is empty !!
		 * Inserted 1213
		 * 1213 -->END
		 * Inserted 1213546
		 * 1213 -->1213546 -->END
		 * Inserted 46
		 * 1213 -->1213546 -->46 -->END
		 * Removed: 46
		 * 1213 -->1213546 -->END
		 * Removed: 1213546
		 * 1213 -->END
		 * Inserted 9999
		 * 1213 -->9999 -->END
		 * Removed: 9999
		 * 1213 -->END
		 * Removed: 1213
		 * List is empty !!
		 * Nothing to remove, list is empty !!!
		 * List is empty !!
		 * 
		 */
	}
}

