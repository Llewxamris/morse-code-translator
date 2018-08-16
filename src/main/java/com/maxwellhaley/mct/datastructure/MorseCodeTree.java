package com.maxwellhaley.mct.datastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MorseCodeTree {

  private MorseCodeNode root;

  MorseCodeTree() {
    try {
      this.init();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  String encode(String message) {
    return null;
  }
  
  String decode(String message) {
    return null;
  }

  private void init() throws IOException {
    String morseCodeTableFileLocation = "moreseCodeTable.txt";
    this.root = new MorseCodeNode("");

    try (Stream<String> stream = Files
            .lines(Paths.get(morseCodeTableFileLocation))) {

      stream.forEach(new Consumer<String>() {

        @Override
        public void accept(String line) {
          String[] temp = line.split(" ");
          String alpha = temp[0];
          String morse = temp[1];
          MorseCodeNode lastNode = root;

          for (var k = 0; k < morse.length(); k++) {
            if (morse.length() - 1 == k) {
              if (morse.charAt(k) == '.') {
                lastNode.setLeftChildNode(new MorseCodeNode(alpha));
              } else {
                lastNode.setRightChildNode(new MorseCodeNode(alpha));
              }
            } else {
              if (morse.charAt(k) == '.') {
                lastNode = lastNode.getLeftChildNode();
              } else {
                lastNode = lastNode.getRightChildNode();
              }
            }
          }
        }
      });
    }
  }
}