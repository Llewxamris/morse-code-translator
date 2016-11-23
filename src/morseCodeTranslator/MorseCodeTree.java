package morseCodeTranslator;

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
		// TODO
		/*
		 * Uses CodeVisitor to talk to the array of Morse code symbols. Returns them
		 * all into an String that is then shown to the user.
		 */

		morseTree.levelOrderTraversal(visitor);
		String[] fuck = ((CodeVisitor<String>) visitor).getMorseArray();
		for (int j = 0; j < fuck.length; j++)
		{
			System.out.println(fuck[j]);
		}
		return null;
	} // encode()

	protected String decode()
	{
		// TODO
		/*
		 * Using the Morse code tree, and the fact that a '.' is a left branch and
		 * '-' is a right branch, determine the letter that should be returned.
		 */

		return null;
	}// decode()

}
