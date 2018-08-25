/*
 * Copyright 2018 Maxwell Haley
 * 
 * This file is part of Morse Code Translator
 * (https://github.com/Llewxamris/morse-code-translator)
 * 
 * Morse Code Translator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * Morse Code Translator is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Morse Code Translator. If not, see http://www.gnu.org/licenses/.
 */

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
