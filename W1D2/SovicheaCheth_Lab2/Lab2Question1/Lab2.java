package Lab2Question1;

import java.io.IOException;

public class Lab2 {
	
	public static void main(String[] args) throws IOException {
		
		Mapper mapper = new Mapper(null);
		
		mapper.readFile();
		mapper.sort();
		mapper.mapperOutput();


		Reducer reducer = new Reducer(mapper.getList());
		reducer.groupByList();
		reducer.reduce();
		reducer.printGroupByList();
		reducer.printReduce();



	}



}
