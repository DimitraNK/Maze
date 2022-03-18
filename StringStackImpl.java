import java.io.PrintStream;
import java.util.NoSuchElementException;
// StringStackImpl class implements StringStack and uses a LinkedList(StackList) to create a stack.
public class StringStackImpl<T> implements StringStack<T>{
	private SingleLinkedList<T> StackList = new SingleLinkedList<>();
	// If StackList is empty returns true, otherwise returns false, 
	// using SingleLinkedList's isEmpty() method.
	@Override
	public boolean isEmpty(){
		return StackList.isEmpty();
	}
	// Adds a new generic type T item to our StackList using 
	// SingleLinkedList's InsertAtFront(T ItemToInsert) method.
	@Override
	public void push(T item){
		StackList.InsertAtFront(item);
	}
	// Removes an item from our StackList using 
	// SingleLinkedList's RemoveFromFront() method.
	@Override
	public T pop() throws NoSuchElementException{
		return StackList.RemoveFromFront();
	}
	// Returns our StackList's first element using
	// SingleLinkedList's peek() method.
	@Override
	public T peek() throws NoSuchElementException{
		return StackList.peek();
	}
	// Prints our StackList using 
	// SingleLinkedList's print(String message, PrintStream stream) method.
	@Override
	public void printStack(PrintStream stream){
		String message = "Stack";
		StackList.print(message, stream);
	}
	// Returns our StackList's size using
	// SingleLinkedList's size() method.
	@Override
	public int size(){
		return StackList.size();
	}
}