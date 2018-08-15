package org.maxwellhaley.mct;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import adts.binarytree.BinaryTree;
import adts.binarytree.BinaryTreeNode;
import adts.binarytree.LinkedBinaryTree;
import adts.binarytree.Visitor;

public class MorseCodeTree
{
	private BinaryTree<String> morseTree;
	private Visitor<String> visitor;

	MorseCodeTree() throws FileNotFoundException
	{
		// char aSize = 'a';
		// int size = (int) aSize;
		String englishChar = null;
		String morseChar = null;
		String[] temp;
		File file = new File("./morseCodeTable.txt");
		Scanner input = new Scanner(file);
		BinaryTreeNode<String> lastNode = null;
		visitor = new CodeVisitor<String>();
		morseTree = new LinkedBinaryTree<String>(" ");

		while (input.hasNextLine())
		{
			temp = input.nextLine().split(" ");
			englishChar = temp[0];
			morseChar = temp[1];
			lastNode = morseTree.root();

			for (int k = 0; k < morseChar.length(); k++)
			{
				if (morseChar.length() - 1 == k)
				{
					if (morseChar.charAt(k) == '.')
					{
						morseTree.makeLeftChild(lastNode, englishChar);
					}
					else
					{
						morseTree.makeRightChild(lastNode, englishChar);
					}
				}
				else
				{
					if (morseChar.charAt(k) == '.')
					{
						lastNode = lastNode.leftChild();
					}
					else
					{
						lastNode = lastNode.rightChild();
					}
				}
			}
		}

		input.close();
	}

	protected String encode(String toEncode)
	{
		/*
		 * Uses CodeVisitor to talk to the array of Morse code symbols. Returns them
		 * all into an String that is then shown to the user.
		 */
		String[] morseArray = ((CodeVisitor<String>) visitor).getMorseArray();
		String morseString = "";
		String encodeThis = toEncode.trim();
		morseTree.levelOrderTraversal(visitor);
		char singleChar;
		int index;

		// for (int j = 0; j < morseArray.length; j++)
		// {
		// System.out.println(morseArray[j]);
		// }

		for (int k = 0; k < encodeThis.length(); k++)
		{
			singleChar = encodeThis.toLowerCase().charAt(k);
			if (singleChar == ' ')
			{
				morseString = morseString.trim();
				morseString += "  ";
			}
			else
				if (Character.isLetter(singleChar))
				{
					index = (int) singleChar;
					morseString += morseArray[index - 97] + " ";
				}
		}

		return morseString.trim();
	} // encode()

	protected String decode(String toDecode)
	{
		/*
		 * Using the Morse code tree, and the fact that a '.' is a left branch and
		 * '-' is a right branch, determine the letter that should be returned.
		 */
		BinaryTreeNode<String> currNode = morseTree.root();
		String[] decodeThis = toDecode.split(" ");
		String singleMorse;
		char singleChar;
		String alphaString = "";

		for (int i = 0; i < decodeThis.length; i++)
		{
			currNode = morseTree.root();
			singleMorse = decodeThis[i];

			if (singleMorse.equals(""))
			{
				alphaString += " ";
			}

			for (int o = 0; o < singleMorse.length(); o++)
			{
				singleChar = singleMorse.charAt(o);

				if (currNode.leftChild() == null
						&& currNode.rightChild() == null)
				{
					break;
				}
				else
					if (singleChar == '.')
					{
						currNode = currNode.leftChild();
					}
					else
					{
						currNode = currNode.rightChild();
					}
				if (o == singleMorse.length() - 1)
				{
					alphaString += currNode.element();
				}
			}
		}
		return alphaString;
	}// decode()

}
