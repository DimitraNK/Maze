import java.util.NoSuchElementException;
import java.io.PrintStream;
public class CircularLinkedList<T>{
	// We use last and size to represent our CircularLinkedList's last LinkedNode and its size.
	private LinkedNode<T> last;
	private int size;
	
	public CircularLinkedList(){
		last = null;
		size = 0;
	}
	// Method isEmpty() returns true if our list is empty and false otherwise.
	public boolean isEmpty(){
		return size == 0;
	}
	
	// Inserts an item to the list.
	// generic type T ItemToInsert represents our new node's data.
	
	public void InsertItem(T ItemToInsert){
		LinkedNode<T> NewNode = new LinkedNode<>(ItemToInsert);
		size +=1;
		// If the list is empty the only node is the new node.
		if (last==null){
			last = NewNode;
			last.nextNode = last;
		}
		// If the list is not empty.
		else{
			NewNode.nextNode = last.nextNode;
			last.nextNode = NewNode;
			last = NewNode;
		}
	}
	// If the list is empty throws NoSuchElementException.
	// If not it returns and removes the data from our list's last node.
	public T RemoveItem() throws NoSuchElementException{
		if (isEmpty())
			throw new NoSuchElementException();
		T ItemToRemove = (last.nextNode).data;
		last.nextNode = last.nextNode.nextNode;
		size -=1;
		return ItemToRemove;
	}
	// Returns the first node's data.
	public T peek() throws NoSuchElementException{
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			return (last.nextNode).data;
		}
	}
	// Prints our list.
	// String message is used to determine what kind of structure we are using.
	public void print(String message, PrintStream stream){
		if (isEmpty()){
			System.out.println("The "+ message +" is Empty");
			return ;
		}
		System.out.println("The "+ message +" contains: ");
		LinkedNode<T> temp = last.nextNode;
		int counter = 0;
		// while not at end of the list, print each node's data.
		while (counter < size){
			stream.print(temp.data);
			temp = temp.nextNode;
			System.out.print(" ");
			counter += 1;
		}
		System.out.println();
	}
	// Returns our list's size.
	public int size(){
		return size;
	}
}