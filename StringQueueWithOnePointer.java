import java.io.PrintStream;
import java.util.NoSuchElementException;
// StringQueueWithOnePointer class implements StringQueue and 
// uses a CircularLinkedList(OnePointerQueue) to create a queue with one pointer.
public class StringQueueWithOnePointer<T> implements StringQueue<T>{
	private CircularLinkedList<T> OnePointerQueue = new CircularLinkedList<>();
	// If OnePointerQueue is empty returns true, otherwise returns false, 
	// using CircularLinkedList's isEmpty() method.
	@Override
	public boolean isEmpty(){
		return OnePointerQueue.isEmpty();
	}
	// Adds a new generic type T item to our OnePointerQueue using 
	// CircularLinkedList's InsertItem(T ItemToInsert) method.
	@Override
	public void put(T item){
		OnePointerQueue.InsertItem(item);
	}
	// Removes an item from our OnePointerQueue using 
	// CircularLinkedList's RemoveItem() method.
	@Override
	public T get() throws NoSuchElementException{
		return OnePointerQueue.RemoveItem();
	}
	// Returns our OnePointerQueue's oldest element using
	// CircularLinkedList's peek() method.
	@Override
	public T peek() throws NoSuchElementException{
		return OnePointerQueue.peek();
	}
	// Prints our OnePointerQueue using 
	// CircularLinkedList's print(String message, PrintStream stream) method.
	@Override
	public void printQueue(PrintStream stream){
		String message = "Queue with one pointer ";
		OnePointerQueue.print(message, stream);
	}
	// Returns our OnePointerQueue's size using
	// CircularLinkedList's size() method.
	@Override
	public int size(){
		return OnePointerQueue.size();
	}
}