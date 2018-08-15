package org.maxwellhaley.mct;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class DecodeTests {

  @Test
  void decodeSimpleSentance() throws FileNotFoundException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputMorse = "... .--. .... -.-- -. -..-  --- ..-.  -... .-.. .- -.-. -.-  --.- ..- .- .-. - --..  .--- ..- -.. --. .  -- -.--  ...- --- .--";
    String outputAlpha = "sphynx of black quartz judge my vow";
    
    assertEquals(outputAlpha, mct.decode(inputMorse));
  }
  
  @Test
  void decodeComplexSentance() throws FileNotFoundException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputMorse = "... .--. .... -.-- -. -..-  --- ..-.  -... .-.. .- -.-. -.-  --.- ..- .- .-. - --.. --··--  .--- ..- -.. --. .  -- -.--  ...- --- .-- -·-·--";
    String outputAlpha = "sphynx of black quartz, judge my vow!";

    assertEquals(outputAlpha, mct.decode(inputMorse));
  }
  
  @Test
  void decodeNumerals() throws FileNotFoundException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputMorse = "----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";
    String outputAlpha= "0123456789";
    
    assertEquals(outputAlpha, mct.decode(inputMorse));
  }
  
  @Test
  void decodeStdSpecialChars() throws FileNotFoundException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputMorse = "-·-·-- ·--·-· ···-··- ·-··· -·--· -·--·- -····- ··--·- -···- ·-·-· --··-- ·-·-·- -··-· ··--·· -·-·-· ---··· ·----· ·-··-·";
    String outputAlpha = "!@#$%^&*()-_=+,<.>/?|\\;:'\"~`";
    
    assertEquals(outputAlpha, mct.decode(inputMorse));
  }

}
