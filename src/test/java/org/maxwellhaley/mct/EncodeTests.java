package org.maxwellhaley.mct;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class EncodeTests {

  @Test
  void encodeSimpleSentance() throws FileNotFoundException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputAlpha = "Sphynx of black quartz judge my vow";
    String outputMorse = "... .--. .... -.-- -. -..-  --- ..-.  -... .-.. .- -.-. -.-  --.- ..- .- .-. - --..  .--- ..- -.. --. .  -- -.--  ...- --- .--";
    assertEquals(outputMorse, mct.encode(inputAlpha));
  }
  
  @Test
  void encodeComplexSentance() throws FileNotFoundException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputAlpha = "Sphynx of black quartz, judge my vow!";
    String outputMorse = "... .--. .... -.-- -. -..-  --- ..-.  -... .-.. .- -.-. -.-  --.- ..- .- .-. - --.. --··--  .--- ..- -.. --. .  -- -.--  ...- --- .-- -·-·--";
    
    assertEquals(outputMorse, mct.encode(inputAlpha));
  }
  
  @Test
  void encodeNumerals() throws FileNotFoundException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputAlpha = "0123456789";
    String outputMorse = "----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";
    
    assertEquals(outputMorse, mct.encode(inputAlpha));
  }
  
  @Test
  void encodeStdSpecialChars() throws FileNotFoundException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputAlpha = "!@#$%^&*()-_=+,<.>/?|\\;:'\"~`";
    String outputMorse = "-·-·-- ·--·-· ···-··- ·-··· -·--· -·--·- -····- ··--·- -···- ·-·-· --··-- ·-·-·- -··-· ··--·· -·-·-· ---··· ·----· ·-··-·";
    
    assertEquals(outputMorse, mct.encode(inputAlpha));
  }

}
