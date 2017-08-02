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
			s = s + it.next() + " ";
		}
		return s+"";
	}
	
	SListIterator<T> iterator(){
		return new SListIterator<T>(head);
	}
}

/*
 * This is an iterator class. It has an instance variable of type Node<T> which
 * points to the current node with which we are working. 
 * It has a constructor which points the curr variable to the starting of the 
 * linkedList(i.e. the head of the LinkedList).
 * This class has four methods: 
 * hasNext() : Checks whether the list has next node or not.
 * next() : returns the next node of the list.
 * insert(Node<T>, T) : It takes the head of the list and a data value as its 
 * 						parameter and traverse all the way to the end of the list
 * 						and insert the new node in the end of the list.
 * remove(Node<T>) : It takes the head of the list as parameter and removes the last 
 * 						node of the list.
 */

class SListIterator<T>{
	Node<T> curr;
	
	public SListIterator(Node<T> head) {
		this.curr = head;
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
	
	public void insert(Node<T> head,T data){
		Node<T> newNode = new Node<T>(data);
		while(head.next != null){
			head = head.next;
		}
		head.next = newNode;
	}
	
	public void remove(Node<T> head){
		if(head.next == null){
			System.out.println("Nothing to remove, list is empty !!!");
			return ;
		}
		while(head.next.next != null){
			head = head.next;
		}
		head.next = null;
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
		
		Node<Integer> head = s1.head;
		
		System.out.println(s1); 	// printing the empty list.
		it.insert(head,1213);   	// inserting 1213 to the list.
		
		System.out.println(s1);
		it.insert(head,1213546);	// inserting 1213546 to the end of the list. 
		
		System.out.println(s1);
		it.insert(head,46);			// inserting 46 to the end of the list.
		
		System.out.println(s1);		
		it.remove(head);			// removing a node from the end of the list.
		
		System.out.println(s1);
		it.remove(head);			// removing another node from the end of the list.
		
		System.out.println(s1);
		it.insert(head,9999);		// adding a 9999 in the end of the list.
		
		System.out.println(s1);
		it.remove(head);			// removing a node from the end of the list.
		
		System.out.println(s1);
		it.remove(head);			// removing a node from the end of the list.
		
		System.out.println(s1); 	// Printing the empty list.
		
		it.remove(head);			// trying to remove from an empty list.
		System.out.println(s1);		// printing the empty list. 
	}
}