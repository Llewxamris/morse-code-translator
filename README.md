# Morse Code Translator
A Java GUI application that will encode a message into Morse code and decode a Morse code string into a text message.

# Design
To store the Morse code table and provide encoding and decoding of text messages, create a *MorseCodeTree* class. You will also create a *CodeVisitor* class that will be used when traversing the tree. 

The *MorseCodeTree* class will contain a *BinaryTree* object representing the Morse code table. Store each letter of the alphabet in a node of a binary tree of level 5. The root node is at level 1 and stores no letter. The left node at level 2 stores the letter e (code is .) and the right node stores the letter t (code is -). The 4 nodes at level 3 store the letters with codes (.., .-,-.--). 

To build the tree, read a data file in which each line consists of a letter followed by its code. The letters should be ordered by tree level. 

*Encoding a message*: Use a *CodeVisitor* object to create an array of Morse code symbols. Each element of the array represents the code for the letter at that position in the array.  

*Decoding a message*:  Decode the message using the Morse code tree. Make sure you use a delimiter symbol between coded letters . To find the position for a letter in the tree, scan the code and branch left for a dot and branch right for a dash.

# License
Licensed under the GNU GENERAL PUBLIC LICENSE 3.0. Please see the LICENSE file for more information.
