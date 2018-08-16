package com.maxwellhaley.mct.datastructure;

public class MorseCodeNode {

  MorseCodeNode leftChildNode;
  MorseCodeNode rightChildNode;
  String value;

  MorseCodeNode() {
    this.leftChildNode = null;
    this.rightChildNode = null;
    this.value = null;
  }

  MorseCodeNode(String value) {
    this.leftChildNode = null;
    this.rightChildNode = null;
    this.value = value;
  }

  MorseCodeNode(MorseCodeNode leftChildNode,
          MorseCodeNode rightChildNode, String value) {
    this.leftChildNode = leftChildNode;
    this.rightChildNode = rightChildNode;
    this.value = value;
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
