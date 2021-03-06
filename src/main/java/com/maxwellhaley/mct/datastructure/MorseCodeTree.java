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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Represents a binary tree tailored for use in the Morse Code Translator.
 * 
 * @author Maxwell Haley
 * @since 2018/08/15
 */
public class MorseCodeTree {

  /** The root node of the tree */
  private MorseCodeNode root;

  /**
   * Default constructor for the tree. Calls the method {@link this#init()}
   * 
   * @throws IOException
   */
  public MorseCodeTree() throws IOException {
    this.init();
  }

  /**
   * Encodes a plaintext message to morse code. Calls
   * {@link this#postOrderTraversal()} to order the nodes in a way that is
   * better for traversal. Passes the ordered nodes to
   * {@link this#generateMorseArray(Queue)} to generate an array with each morse
   * code symbol.
   * 
   * @param message the message to be encoded
   * @return the message encoded as morse code as a {@code String}
   */
  public String encode(String message) {
    message = message.trim().toLowerCase();

    // Post order starts from the bottom of the left branches to the child of
    // root, then the same on the right branches, then the node itself. This is
    // the best ordering for building our morse code symbols based on the
    // location of each node
    Queue<MorseCodeNode> traversedNodes = postOrderTraversal();

    // Get the array of morse code symbols
    String[] morseSymbols = generateMorseArray(traversedNodes);
    String encodedMessage = "";

    for (int k = 0; k < message.length(); k++) {
      if (message.charAt(k) == ' ') {
        encodedMessage.trim();
        encodedMessage += " ";
      } else {
        if (Character.isLetter(message.charAt(k))) {
          // Lowercase 'a' has the ASCII value of 97, 'b' of 98, etc.
          // By subtracting 97 from the ASCII value of each char, we get it's
          // position in the array.
          int ascii = (int) message.charAt(k);
          encodedMessage += morseSymbols[ascii - 97] + " ";
        }
      }
    }
    return encodedMessage.trim();
  }

  /**
   * Decodes a morese code message to plaintext. Crawls down the morse code tree
   * to find which character a morse symbol represents
   * 
   * @param message the message to be encoded
   * @return the message decoded as a {@code String}
   */
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

  /**
   * Creates the morse code tree. Loads in the {@code morseCodeTable.txt} file.
   * For each line, it grabs the character and stores it in the tree based on
   * the following morse code symbol.
   * 
   * @throws IOException
   */
  private void init() throws IOException {
    InputStream inputStream = getClass()
            .getResourceAsStream("/morseCodeTable.txt");
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(inputStream));
    this.root = new MorseCodeNode("");

    try (Stream<String> stream = reader
            .lines()) {
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

  /**
   * Creates the morse code array based on a pre-traversed queue of
   * {@link MorseCodeNode}s. Creates the morese code symbols by crawling up the
   * morse code tree, until it finds the root.
   * 
   * @param traversedNodes
   * @return
   */
  private String[] generateMorseArray(Queue<MorseCodeNode> traversedNodes) {
    String[] morseSymbolArray = new String[26];

    for (MorseCodeNode node : traversedNodes) {
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

          // Lowercase 'a' has the ASCII value of 97, 'b' of 98, etc.
          // By subtracting 97 from the ASCII value of each char, we get it's
          // position in the array.
          int ascii = (int) alpha;
          morseSymbolArray[ascii - 97] = morseSymbol;
        }
      }
    }

    return morseSymbolArray;
  }

  /**
   * Creates a queue of nodes that have been enqueue "post-order". Calls
   * {@link this#postOrderTraversal(MorseCodeNode, Queue)} to continue the
   * ordering in a recursive fashion.
   * 
   * @return traversedNodes the nodes post-ordered in a queue.
   */
  private Queue<MorseCodeNode> postOrderTraversal() {
    Queue<MorseCodeNode> traversedNodes = new LinkedList<>();
    traversedNodes = postOrderTraversal(root.getLeftChildNode(),
            traversedNodes);
    traversedNodes = postOrderTraversal(root.getRightChildNode(),
            traversedNodes);
    traversedNodes.add(root);
    return traversedNodes;
  }

  /**
   * Creates a queue of nodes that have been enqueued "post-order". Called by
   * {@link this#postOrderTraversal()} and itself recursively. 
   * @param node The current node being traversed
   * @param @return traversedNodes The current queue of traversed nodes
   */
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