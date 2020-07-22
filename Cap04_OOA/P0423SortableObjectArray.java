import java.util.Arrays;

public class P0423SortableObjectArray implements P0422Sortable {
	protected Object[] array;
	
	public P0423SortableObjectArray () { 
		this(10); 
	}
	public P0423SortableObjectArray (int tam) { 
		array = new Object[tam];
	}
	// realização da interface P0422Sortable
	public void sort() {
		Arrays.sort(array);
	}
	public Object get(int index) {
		return array[index];
	}
	public void set(int index, Object value) {
		array[index] = value;
	}
	@Override
	public String toString() {
		return Arrays.toString(array);
	}
}
