package Lab3Question1;

import java.util.ArrayList;
import java.util.List;

public class GroupByPair {

	private String key;
	private List<Integer> values = new ArrayList<Integer>();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public GroupByPair(String key, List<Integer> values) {
		this.key = key;
		this.values = values;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("<" + this.key + "," + this.values.toString() + ">");
	}

}