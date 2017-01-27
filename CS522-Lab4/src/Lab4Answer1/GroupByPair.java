package Lab4Answer1;

import java.util.List;

public class GroupByPair<K, V> {

	private K key;
	private List<V> values;

	public GroupByPair() {
	}

	public GroupByPair(K k, List<V> v) {
		this.key = k;
		this.values = v;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public List<V> getValues() {
		return values;
	}

	public void setValues(List<V> values) {
		this.values = values;
	}

	public String toString() {
		return "< " + key + " , " + values + " >";
	}

}
