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