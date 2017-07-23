import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyHashSet<T> {
	final List<T[]> mySet;
	final Map<Integer, Integer> myBucketMap;
	int index = 0;

	public MyHashSet() {
		mySet = new ArrayList<>();
		myBucketMap = new HashMap<>();
	}

	public boolean add(final T myObject) {
		final int myHashCode = myObject.hashCode() % 100;
		myBucketMap.put(myHashCode, index);
		index = index + 1;
		if(mySet.size()<=index){
			// mySet.
		}
		return false;

	}
}
