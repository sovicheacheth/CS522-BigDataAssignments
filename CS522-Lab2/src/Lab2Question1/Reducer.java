package Lab2Question1;

import java.util.ArrayList;
import java.util.List;



public class Reducer {
	private List<Pair> pairList;
	private List reduceResult = new ArrayList();
	List<GroupByPair> reducerList = new ArrayList<GroupByPair>();

	public List getPairList() {
		return pairList;
	}

	public Reducer(List<Pair> pairList) {
		this.pairList = pairList;
	}

	public void setPairList(List pairList) {
		this.pairList = pairList;
	}

	public void groupByList() {
		List<Integer> values = new ArrayList<Integer>();

		String initialStr = null;
		for (int k = 0; k < pairList.size(); k++) {
			String value = pairList.get(k).getValue();
			if (initialStr != null && !initialStr.equals(value)) {
				reducerList.add(new GroupByPair(initialStr, values));
				values = new ArrayList<Integer>();
			}
			initialStr = pairList.get(k).getValue();
			values.add(1);
		}
	}

	public void reduce() {
		for (int i = 0; i < reducerList.size(); i++) {
			int sum = sum(reducerList.get(i).getValues());
			String key = reducerList.get(i).getKey();
			reduceResult.add(new Pair(sum, key));
		}
	}

	public void printGroupByList(){
		System.out.println(reducerList.toString());
	}
	public void printReduce() {
		System.out.println(reduceResult.toString());
	}

	public static int sum(List values) {
		int total = 0;
		for (int i = 0; i < values.size(); i++)
			total++;
		return total;
	}

}
