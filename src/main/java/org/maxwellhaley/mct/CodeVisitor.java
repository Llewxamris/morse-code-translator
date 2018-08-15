package org.maxwellhaley.mct;

import adts.binarytree.BinaryTreeNode;
import adts.binarytree.Visitor;
import adts.stack.LinkedStack;

public class CodeVisitor<E> implements Visitor<E> {
  private String[] morseArray = new String[26];

  public void visit(BinaryTreeNode<E> node) {
    System.out.println(node.element());
    LinkedStack<Character> morseStack = new LinkedStack<Character>();
    String morse = "";
    String theElement;
    BinaryTreeNode<E> currNode = node;
    char alpha = 0;
    int index = 0;
    boolean rootFound = false;

    while (!rootFound) {
      if (!currNode.element().equals(" ")) {
        if (currNode.parent().leftChild().equals(currNode)) {
          morseStack.push('.');
        } else {
          morseStack.push('-');
        }
        if (currNode.parent().element().equals(" ")) {
          theElement = (String) node.element();
          alpha = theElement.charAt(0);
          rootFound = true;
          while (!morseStack.isEmpty()) {
            morse += morseStack.pop();
          }
          index = (int) alpha;
          morseArray[index - 97] = morse;
        }
      } else {
        rootFound = true;
      }
      currNode = currNode.parent();
    }
  }

  public String[] getMorseArray() {
    return morseArray;
  }

}
