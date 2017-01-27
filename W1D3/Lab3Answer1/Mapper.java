/* Author: Sovichea Cheth ID: 985421 */

package Lab3Question1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Mapper {

	private File file;
	private List<Pair> list = new ArrayList<Pair>();;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Mapper(File file) {
		this.file = file;
	}

	public void map() throws IOException {

		String line;
		String[] words = null;
		try {
			InputStream testFile = new FileInputStream(file);
			InputStreamReader sReader = new InputStreamReader(testFile, Charset.forName("UTF-8"));
			BufferedReader bufReader = new BufferedReader(sReader);
			while ((line = bufReader.readLine()) != null) {
				words = line.split(" ");
				for (int i = 0; i < words.length; i++) {
					String regex = "([a-zA-Z-])+";
					words[i] = words[i].toLowerCase();
					if (words[i].matches(regex)) {
						if (words[i].contains("-")) {
							String[] txt = words[i].split("-");
							for (int j = 0; j < txt.length; j++) {
								list.add(new Pair<Object>(1, txt[j]));
							}
						} else {
							list.add(new Pair<Object>(1, words[i]));
						}

					}

				}

			}
			bufReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void sort() {
		Collections.sort(list);
	}

	public void print() {
		System.out.println(list.toString());
	}

}
