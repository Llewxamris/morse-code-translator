package org.maxwellhaley.mct;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.maxwellhaley.mct.datastructure.MorseCodeTree;

class DecodeTests {

  @Test
  void decodeSimpleSentance() throws IOException {
    MorseCodeTree mct = new MorseCodeTree();
    String inputMorse = "... .--. .... -.-- -. -..-  --- ..-.  -... .-.. .- -.-. -.-  --.- ..- .- .-. - --..  .--- ..- -.. --. .  -- -.--  ...- --- .--";
    String outputAlpha = "sphynx of black quartz judge my vow";
    
    assertEquals(outputAlpha, mct.decode(inputMorse));
  }
  
//  @Test
//  void decodeComplexSentance() throws IOException {
//    MorseCodeTree mct = new MorseCodeTree();
//    String inputMorse = "... .--. .... -.-- -. -..-  --- ..-.  -... .-.. .- -.-. -.-  --.- ..- .- .-. - --.. --··--  .--- ..- -.. --. .  -- -.--  ...- --- .-- -·-·--";
//    String outputAlpha = "sphynx of black quartz, judge my vow!";
//
//    assertEquals(outputAlpha, mct.decode(inputMorse));
//  }
//  
//  @Test
//  void decodeNumerals() throws IOException {
//    MorseCodeTree mct = new MorseCodeTree();
//    String inputMorse = "----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";
//    String outputAlpha= "0123456789";
//    
//    assertEquals(outputAlpha, mct.decode(inputMorse));
//  }
//  
//  @Test
//  void decodeStdSpecialChars() throws IOException {
//    MorseCodeTree mct = new MorseCodeTree();
//    String inputMorse = "-·-·-- ·--·-· ···-··- ·-··· -·--· -·--·- -····- ··--·- -···- ·-·-· --··-- ·-·-·- -··-· ··--·· -·-·-· ---··· ·----· ·-··-·";
//    String outputAlpha = "!@#$%^&*()-_=+,<.>/?|\\;:'\"~`";
//    
//    assertEquals(outputAlpha, mct.decode(inputMorse));
//  }

}
