package com.maxwellhaley.mct.datastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
    message = message.trim().toLowerCase();

    Queue<MorseCodeNode> nodes = new LinkedList<>();
    Queue<MorseCodeNode> traversedNodes = new LinkedList<>();
    nodes.add(this.root);

    while (!nodes.isEmpty()) {
      MorseCodeNode node = nodes.remove();
      traversedNodes.add(node);

      if (node.getLeftChildNode() != null) {
        nodes.add(node.getLeftChildNode());
      }

      if (node.getRightChildNode() != null) {
        nodes.add(node.getRightChildNode());
      }
    }

    String[] morseSymbols = this.generateMorseArray(traversedNodes);
    String encodedMessage = "";

    for (var k = 0; k < message.length(); k++) {
      if (message.charAt(k) == ' ') {
        encodedMessage.trim();
        encodedMessage += "  ";
      } else {
        if (Character.isLetter(message.charAt(k))) {
          int asci = (int) message.charAt(k);
          encodedMessage += morseSymbols[asci - 97] + " ";
        }
      }
    }
    return encodedMessage;
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
                lastNode.setLeftChildNode(new MorseCodeNode(alpha, lastNode));
              } else {
                lastNode.setRightChildNode(new MorseCodeNode(alpha, lastNode));
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

  private String[] generateMorseArray(Queue<MorseCodeNode> traversedNodes) {
    String[] morseSymbolArray = new String[26];

    for (MorseCodeNode node : traversedNodes) {
      Stack<Character> morseSymbolStack = new Stack<Character>();
      boolean rootFound = false;

      while (!rootFound) {
        if (!node.value.equals(" ")) {
          if (node.getParentNode().getLeftChildNode().equals(node)) {
            morseSymbolStack.push('.');
          } else {
            morseSymbolStack.push('-');
          }
        }

        if (node.getParentNode().value.equals(" ")) {
          String morseSymbol = "";
          char alpha = node.value.charAt(0);
          rootFound = true;

          while (!morseSymbolStack.isEmpty()) {
            morseSymbol += morseSymbolStack.pop();
          }

          int asci = (int) alpha;
          morseSymbolArray[asci - 97] = morseSymbol;
        }
      }
    }

    return morseSymbolArray;
  }

}