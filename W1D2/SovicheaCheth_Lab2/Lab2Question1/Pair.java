package Lab2Question1;

public class Pair<T> implements Comparable<T>  {
	
	private int key = 1;
	private String value = "";
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("<" + this.value + ", " + this.key + ">");
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		String value = ((Pair) o).getValue();
		return this.value.compareTo(value);
	}
	
	
	
	
	

}
