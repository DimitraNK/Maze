import java.io.PrintStream;
import java.util.NoSuchElementException;
// StringQueueImpl class implements StringQueue and uses a LinkedList(QueueList) to create a queue.
public class StringQueueImpl<T> implements StringQueue<T>{
	private SingleLinkedList<T> QueueList = new SingleLinkedList<>();
	// If QueueList is empty returns true, otherwise returns false, 
	// using SingleLinkedList's isEmpty() method.
	@Override
	public boolean isEmpty(){
		return QueueList.isEmpty();
	}
	// Adds a new generic type T item to our QueueList using 
	// SingleLinkedList's InsertAtBack(T ItemToInsert) method.
	@Override
	public void put(T item){
		QueueList.InsertAtBack(item);
	}
	// Removes an item from our QueueList using 
	// SingleLinkedList's RemoveFromFront() method.
	@Override
	public T get() throws NoSuchElementException{
		return QueueList.RemoveFromFront();
	}
	// Returns our QueueList's oldest element using
	// SingleLinkedList's peek() method.
	@Override
	public T peek() throws NoSuchElementException{
		return QueueList.peek();
	}
	// Prints our QueueList using 
	// SingleLinkedList's print(String message, PrintStream stream) method.
	@Override
	public void printQueue(PrintStream stream){
		String message = "Queue";
		QueueList.print(message, stream);
	}
	// Returns our QueueList's size using
	// SingleLinkedList's size() method.
	@Override
	public int size(){
		return QueueList.size();
	}
}