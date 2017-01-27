/* Author: Sovichea Cheth ID: 985421 */

package Lab2Question1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Mapper {

	private File file;
	private List<Pair> list = new ArrayList<Pair>();

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<Pair> getList() {
		return list;
	}

	public void setList(List<Pair> list) {
		this.list = list;
	}

	public Mapper(File file) {
		this.file = file;
		// this.list = list;
	}

	//read file function from Lab1
	public void readFile() throws IOException {
		String line;
		String words[] = null;

		try {
			InputStream testData = new FileInputStream("/Volumes/VICHEA/testDataForW1D1.txt");
			InputStreamReader streamReader = new InputStreamReader(testData);
			BufferedReader bufferReader = new BufferedReader(streamReader);
			// System.out.println("Open file!!!");

			while ((line = bufferReader.readLine()) != null) {
				words = line.split(" ");
				for (int i = 0; i < words.length; i++) {

					// allow alphabet use regular expression
					String regex = "([a-zA-Z])+";
					words[i] = words[i].toLowerCase();
					if (words[i].matches(regex)) {

						// System.out.println("Teeeee");

						// allow hyphen
						if (words[i].contains("-")) {
							String[] text = words[i].split("-");

							for (int j = 0; j < text.length; j++) {
								list.add(new Pair(1, text[j]));

							}
						} else {
							list.add(new Pair<Object>(1, words[i]));
						}
					}

				}
			}

			bufferReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Errror file not found");
		}
	}


	//Sort
	public void sort(){

		Collections.sort(list);
	}

	//output
	public void mapperOutput(){
		System.out.println(list.toString());
		//System.out.println();
	}

}
