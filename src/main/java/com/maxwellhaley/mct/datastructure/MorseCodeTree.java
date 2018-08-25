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

  private MorseCodeNode root = new MorseCodeNode("");

  public MorseCodeTree() throws IOException {
    this.init();
  }

  public String encode(String message) {
    message = message.trim().toLowerCase();

    Queue<MorseCodeNode> traversedNodes = postOrderTraversal();

    String[] morseSymbols = this.generateMorseArray(traversedNodes);
    String encodedMessage = "";

    for (int k = 0; k < message.length(); k++) {
      if (message.charAt(k) == ' ') {
        encodedMessage.trim();
        encodedMessage += " ";
      } else {
        if (Character.isLetter(message.charAt(k))) {
          int asci = (int) message.charAt(k);
          encodedMessage += morseSymbols[asci - 97] + " ";
        }
      }
    }
    return encodedMessage.trim();
  }

  public String decode(String message) {
    String[] morseSymbols = message.split(" ");
    String decodedMessage = "";

    for (int k = 0; k < morseSymbols.length; k++) {
      MorseCodeNode currentNode = this.root;
      String morseSymbol = morseSymbols[k];

      if (morseSymbol.equals("")) {
        decodedMessage += " ";
      }

      for (int l = 0; l < morseSymbol.length(); l++) {
        char singleChar = morseSymbol.charAt(l);

        if (currentNode.getLeftChildNode() == null
                && currentNode.getRightChildNode() == null) {
          break;
        } else if (singleChar == '.') {
          currentNode = currentNode.getLeftChildNode();
        } else {
          currentNode = currentNode.getRightChildNode();
        }

        if (l == morseSymbol.length() - 1) {
          decodedMessage += currentNode.getValue();
        }
      }
    }
    return decodedMessage;
  }

  private void init() throws IOException {
    String morseCodeTableFileLocation = "src/main/resources/morseCodeTable.txt";
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

          for (int k = 0; k < morse.length(); k++) {
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

    // for (int i = traversedNodes.size(); i > 0; i--) {
    for (MorseCodeNode node : traversedNodes) {
      // MorseCodeNode node = traversedNodes.
      Stack<Character> morseSymbolStack = new Stack<Character>();
      MorseCodeNode currNode = node;
      boolean rootFound = false;
      
      if (currNode.getValue().equals("")) {
        rootFound = true;
      }

      while (!rootFound) {
        if (!currNode.value.equals("")) {
          if (currNode.getParentNode().getLeftChildNode().equals(currNode)) {
            morseSymbolStack.push('.');
            currNode = currNode.getParentNode();
          } else {
            morseSymbolStack.push('-');
            currNode = currNode.getParentNode();
          }
        } else {
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

  private Queue<MorseCodeNode> postOrderTraversal() {
    Queue<MorseCodeNode> traversedNodes = new LinkedList<>();
    traversedNodes = postOrderTraversal(root.getLeftChildNode(),
            traversedNodes);
    traversedNodes = postOrderTraversal(root.getRightChildNode(),
            traversedNodes);
    traversedNodes.add(root);
    return traversedNodes;
  }

  private Queue<MorseCodeNode> postOrderTraversal(MorseCodeNode node,
          Queue<MorseCodeNode> traversedNodes) {
    if (node != null) {
      traversedNodes = postOrderTraversal(node.getLeftChildNode(),
              traversedNodes);
      traversedNodes = postOrderTraversal(node.getRightChildNode(),
              traversedNodes);
      traversedNodes.add(node);
    }
    return traversedNodes;
  }

}