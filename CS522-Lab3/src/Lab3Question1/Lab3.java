package Lab3Question1;

import java.io.File;
import java.io.IOException;

public class Lab3 {

	public static void main(String[] args) throws IOException {

		File file0 = new File("C://Users/985421/Desktop/testData0.txt");
		File file1 = new File("C://Users/985421/Desktop/testData1.txt");
		File file2 = new File("C://Users/985421/Desktop/testData2.txt");

		// File file = new File("C://Users/985421/Desktop/testData.txt");
		
		File[] fileList = {file0, file1, file2};

		WordCount wordCount = new WordCount(3, 4, fileList);
		Mapper[] mapper = wordCount.getMapper();
		for (int i = 0; i < 3; i++) {
			// System.out.println("te");
			mapper[i] = new Mapper(fileList[i]);
			mapper[i].map();
		}

		wordCount.shuffleSort();
		wordCount.print();
	}

}
