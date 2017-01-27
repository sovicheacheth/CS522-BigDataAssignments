/* Author: Sovichea Cheth ID: 985421*/

package Lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab1 {
	
	public static <T> void main(String[] args) throws IOException {
		List<Pair> arrayList = new ArrayList<Pair>();
		
		String line;
		String words[] = null;
		
		try{
			InputStream testData = new FileInputStream("C:/Users/985421/Desktop/testDataForW1D1.txt");
			InputStreamReader streamReader = new InputStreamReader(testData);
			BufferedReader bufferReader = new BufferedReader(streamReader);
			//System.out.println("Open file!!!");
			
			while((line = bufferReader.readLine()) != null){
				words = line.split(" ");
				for(int i=0; i<words.length; i++){
					
					//allow alphabet use regular expression 
					String regex = "([a-zA-Z])+";
					words[i] = words[i].toLowerCase();
					if(words[i].matches(regex)){
						
						//System.out.println("Teeeee");
						
						//allow hyphen
						if(words[i].contains("-")){
							String[] text = words[i].split("-");
							
							for(int j=0; j<text.length; j++){
								arrayList.add(new Pair<T>(1, text[j]));
								
								
							}
						}else{
							arrayList.add(new Pair<Object>(1, words[i]));
						}
					}
					
				}
			}
			
			bufferReader.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("Errror file not found");
		}
		
		
		Collections.sort(arrayList);
		for(int k=0; k<arrayList.size(); k++){
			System.out.println(arrayList.get(k).toString());
		}
		
		//System.out.println();
		
	}

	
}
