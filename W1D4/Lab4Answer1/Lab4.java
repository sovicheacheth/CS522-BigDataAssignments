package Lab4Answer1;

public class Lab4 {

	public static void main(String[] args) {

		String inputSplits[] = { "\"cat bat\" mat-pat mum.edu sat. \nfat 'rat eat cat' mum_cs mat",
				"\"bat-hat mat pat \"oat \nhat rat mum_cs eat oat-pat\"",
				"zat lat-cat pat jat. \nhat rat. kat sat wat" };

		InMapperWordCount c = new InMapperWordCount(inputSplits);

		c.mapperOutput();
		c.sendToReducer();
		c.reducerInput();
		c.reducerOutput();

	}

}
