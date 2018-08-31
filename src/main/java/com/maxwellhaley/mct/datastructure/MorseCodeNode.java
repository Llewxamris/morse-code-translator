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

/**
 * Represents a single node in the morse code tree. Has the ability to have a
 * left child, right child, parent, and a value.
 * 
 * @author Maxwell Haley
 * @since 2018/08/15
 */
public class MorseCodeNode {

  /** The direct parent node */
  MorseCodeNode parentNode;

  /** The child node on the nodes left branch */
  MorseCodeNode leftChildNode;

  /** The child node on the nodes right branch */
  MorseCodeNode rightChildNode;

  /** The value of the node as a String */
  String value;

  /**
   * Default constructor for {@code MorseCodeNode}. Sets everything to null.
   */
  MorseCodeNode() {
    this.parentNode = null;
    this.leftChildNode = null;
    this.rightChildNode = null;
    this.value = null;
  }

  /**
   * Constructor for {@code MorseCodeNode}.
   * 
   * @param value The value of the node
   */
  MorseCodeNode(String value) {
    this.parentNode = null;
    this.leftChildNode = null;
    this.rightChildNode = null;
    this.value = value;
  }

  /**
   * Constructor for {@code MorseCodeNode}
   * 
   * @param value      The value of the node
   * @param parentNode The parent node of this node
   */
  MorseCodeNode(String value, MorseCodeNode parentNode) {
    this.parentNode = parentNode;
    this.leftChildNode = null;
    this.rightChildNode = null;
    this.value = value;
  }

  /**
   * Get the parent node of this node
   * 
   * @return parentNode
   */
  protected MorseCodeNode getParentNode() {
    return parentNode;
  }

  /**
   * Set the parent node of this node
   * 
   * @param parentNode The parent node
   */
  protected void setParentNode(MorseCodeNode parentNode) {
    this.parentNode = parentNode;
  }

  /**
   * Get the left child of this node
   * 
   * @return leftChildNode
   */
  protected MorseCodeNode getLeftChildNode() {
    return leftChildNode;
  }

  /**
   * Set the left child of this node
   * 
   * @param leftChildNode The left child node
   */
  protected void setLeftChildNode(MorseCodeNode leftChildNode) {
    this.leftChildNode = leftChildNode;
  }

  /**
   * Get the right child of this node
   * 
   * @return rightChildNode
   */
  protected MorseCodeNode getRightChildNode() {
    return rightChildNode;
  }

  /**
   * Set the right child of this node
   * 
   * @param rightChildNode The right child node
   */
  protected void setRightChildNode(MorseCodeNode rightChildNode) {
    this.rightChildNode = rightChildNode;
  }

  /**
   * Get the value of this node
   * 
   * @return value
   */
  protected String getValue() {
    return value;
  }

  /**
   * Set the value of this node
   * 
   * @param value The value of this node as a {@code String}
   */
  protected void setValue(String value) {
    this.value = value;
  }
}