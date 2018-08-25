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

public class MorseCodeNode {

  MorseCodeNode parentNode;
  MorseCodeNode leftChildNode;
  MorseCodeNode rightChildNode;
  String value;

  MorseCodeNode() {
    this.parentNode = null;
    this.leftChildNode = null;
    this.rightChildNode = null;
    this.value = null;
  }

  MorseCodeNode(String value) {
    this.parentNode = null;
    this.leftChildNode = null;
    this.rightChildNode = null;
    this.value = value;
  }

  MorseCodeNode(String value, MorseCodeNode parentNode) {
    this.parentNode = parentNode;
    this.leftChildNode = null;
    this.rightChildNode = null;
    this.value = value;
  }

  protected MorseCodeNode getParentNode() {
    return parentNode;
  }

  protected void setParentNode(MorseCodeNode parentNode) {
    this.parentNode = parentNode;
  }

  protected MorseCodeNode getLeftChildNode() {
    return leftChildNode;
  }

  protected void setLeftChildNode(MorseCodeNode leftChildNode) {
    this.leftChildNode = leftChildNode;
  }

  protected MorseCodeNode getRightChildNode() {
    return rightChildNode;
  }

  protected void setRightChildNode(MorseCodeNode rightChildNode) {
    this.rightChildNode = rightChildNode;
  }

  protected String getValue() {
    return value;
  }

  protected void setValue(String value) {
    this.value = value;
  }

}