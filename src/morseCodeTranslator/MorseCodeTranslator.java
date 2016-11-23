package morseCodeTranslator;

import java.io.FileNotFoundException;

public class MorseCodeTranslator
{

	public static void main(String[] args)
	{
		try
		{
			MorseCodeTree test = new MorseCodeTree();
			test.encode("test");
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
