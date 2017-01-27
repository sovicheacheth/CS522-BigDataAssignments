package Lab4Answer1;

import java.util.Comparator;

public class GroupByPairComparator implements Comparator<GroupByPair<String, Integer>> {

	@Override
	public int compare(GroupByPair<String, Integer> o1, GroupByPair<String, Integer> o2) {
		return o1.getKey().compareToIgnoreCase(o2.getKey());
	}

}
