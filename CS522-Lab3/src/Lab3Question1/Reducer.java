package Lab3Question1;

import java.util.ArrayList;
import java.util.List;

public class Reducer {

	private List<Pair> pairList;
	private List resultList = new ArrayList();
	List<GroupByPair> groupByPairList = new ArrayList<GroupByPair>();

	public List getPairList() {
		return pairList;
	}

	public void setPairList(List<Pair> pairList) {
		this.pairList = pairList;
	}

	public Reducer(List<Pair> pairList) {
		this.pairList = pairList;
	}

	public void createGroupByList() {
		List<Integer> values = new ArrayList<Integer>();
		String initialStr = null;
		for (int k = 0; k < pairList.size(); k++) {
			String value = pairList.get(k).getValue();
			if (initialStr != null && !initialStr.equals(value)) {
				groupByPairList.add(new GroupByPair(initialStr, values));
				values = new ArrayList<Integer>();
			}
			initialStr = pairList.get(k).getValue();
			values.add(1);
		}
	}

	public void reduce(GroupByPair pair) {
		int sum = sum(pair.getValues());
		String key = pair.getKey();
		
		resultList.add(new Pair(sum, key));
	}

	public List getReduceResult() {
		return resultList;
	}

	public void setReduceResult(List reduceResult) {
		this.resultList = reduceResult;
	}

	public List<GroupByPair> getReducerList() {
		return groupByPairList;
	}

	public void setReducerList(List<GroupByPair> reducerList) {
		this.groupByPairList = reducerList;
	}

	public void printGroupByList() {
		System.out.println(groupByPairList.toString());
	}

	public void printReduce() {
		System.out.println(resultList.toString());
	}

	public static int sum(List values) {
		int total = 0;
		for (int i = 0; i < values.size(); i++)
			total++;
		return total;
	}

}
