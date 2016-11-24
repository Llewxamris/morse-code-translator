package morseCodeTranslator;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class MorseCodeTest
{

	@Test
	public void testEncoding()
	{
		try
		{
			MorseCodeTree morse = new MorseCodeTree();
			assertEquals(morse.encode("all lowercase"),
					".- .-.. .-..  .-.. --- .-- . .-. -.-. .- ... .");
			assertEquals(morse.encode("ALL UPPERCASE"),
					".- .-.. .-..  ..- .--. .--. . .-. -.-. .- ... .");
			assertEquals(morse.encode("   crazy    "), "-.-. .-. .- --.. -.--");
			assertEquals(morse.encode("s-y!m@b*o&l^s"),
					"... -.-- -- -... --- .-.. ...");
			assertEquals(morse.encode(""), "");
			assertEquals(morse.encode("Sphinx of black quartz, judge my vow."),
					"... .--. .... .. -. -..-  --- ..-.  -... .-.. .- -.-. -.-  --.- ..- .- .-. - --..  .--- ..- -.. --. .  -- -.--  ...- --- .--");
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testDecoding()
	{
		try
		{
			MorseCodeTree morse = new MorseCodeTree();
			assertEquals(morse.decode("..-. .. .-. ... -"), "first");
			assertEquals(morse.decode("- .-- ---  .-- --- .-. -.. ..."), "two words");
			assertEquals(
					morse.decode("-. --- .--  - .... .-. . .  .-- --- .-. -.. ..."),
					"now three words");
			assertEquals(morse.decode("      "), "");
			assertEquals(morse.decode(""), " ");
			assertEquals(morse.decode("......."), "");
			assertEquals(
					morse.decode(
							"... .--. .... .. -. -..-  --- ..-.  -... .-.. .- -.-. -.-  --.- ..- .- .-. - --..  .--- ..- -.. --. .  -- -.--  ...- --- .--"),
					"sphinx of black quartz judge my vow");
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
