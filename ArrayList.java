/**
 * ArrayList, implements list
 * @author Andrew
 * 
 */
public class ArrayList implements List {

	private Object[] arr;
	private int head = 0;
	
	/**
	 * Default of ArrayList, size default is 10
	 */
	public ArrayList() {
		arr = new Object[10];
	}
	
	/**
	 * Initiates size of arraylist
	 * @param size How long the arraylist should be
	 */
	public ArrayList(int size) {
		arr = new Object[size];
	}
	
	/**
	 * Adds object at the end of arraylist
	 * @param obj adds object to end of arraylist
	 */
	@Override
	public void add(Object obj) {
		add(head, obj);
	}
	
	/**
	 * Add object at said position
	 * @param pos position to add object
	 * @param obj object to add to arraylist
	 */
	@Override
	public void add(int pos, Object obj) {
		if (head + 1 == arr.length) {
			grow();
		}
		moveUp(pos);
		arr[pos] = obj;
		head++;
	}

	/**
	 * Returns object at pos
	 * @param pos position to get
	 * @return object Object at position
	 */
	@Override
	public Object get(int pos) {
		return arr[pos];
	}

	/**
	 * Removes object from pos
	 * @param pos position
	 * @return Object that was removed
	 */
	@Override
	public Object remove(int pos) {
		Object temp = arr[pos];
		moveDown(pos);
		return temp;
	}

	/**
	 * Size of arraylist
	 * @return count count of size of arraylist (excluding null)
	 */
	@Override
	public int size() {
		int count = 0;
		for (int x = 0; x < arr.length; x++) {
			if (arr[x] == null) {
				break;
			}
			count++;
		}
		return count;
	}
	
	/**
	 * Grows arraylist by doubling the size
	 */
	public void grow() {
		Object[] temp = new Object[arr.length * 2];
		for (int x = 0; x < arr.length; x++) {
			temp[x] = arr[x];
		}
		arr = temp;
	}
	
	/**
	 * Moves everything from pos upwards
	 * @param pos Starting position of moving everything upwards
	 */
	public void moveUp(int pos) {
		for (int x = arr.length - 1; x > pos; x--) { 
			arr[x] = arr[x - 1];
		}
	}
	
	/**
	 * Moves all elements downwards
	 * @param pos Position that ends the moving
	 */
	public void moveDown(int pos) {
		for (int x = pos; x < arr.length - 1; x++) { 
			arr[x] = arr[x + 1];
		}
	}
}
