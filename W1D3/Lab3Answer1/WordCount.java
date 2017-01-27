package Lab3Question1;

import java.io.File;

public class WordCount {

	private int m;
	private int r;
	private Mapper[] mapper;
	private Reducer[] reducer;
	private File[] file;

	public WordCount(int m, int r, File[] file) {
		this.m = m;
		this.r = r;
		mapper = new Mapper[m];
		reducer = new Reducer[r];
		this.file = file;
	}

	public Mapper[] getMapper() {
		return mapper;
	}

	public void setMapper(Mapper[] mapper) {
		this.mapper = mapper;
	}

	public Reducer[] getReducer() {
		return reducer;
	}

	public void setReducer(Reducer[] reducer) {
		this.reducer = reducer;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getPartition(String key) {
		return (int) key.hashCode() % r;
	}

	public void shuffleSort() {
		for (int i = 0; i < m; i++) {
			mapper[i].sort();
			int n = 0;
			for (int k = 0; k < mapper[i].getList().size(); k++) {
				Pair pair = (Pair) mapper[i].getList().get(k);
				n = getPartition(pair.getValue());
				reducer[n] = new Reducer(mapper[i].getList());
				reducer[n].createGroupByList();
				for (int j = 0; j < reducer[n].getReducerList().size(); j++) {
					reducer[n].reduce(reducer[n].getReducerList().get(j));
				}
				n = 0;
			}
		}

	}

	public void print() {
		for (int i = 0; i < r; i++) {
			System.out.println("\nReduce " + i + " output:");
			System.out.println(reducer[i].getReduceResult().toString());
		}
	}

}
