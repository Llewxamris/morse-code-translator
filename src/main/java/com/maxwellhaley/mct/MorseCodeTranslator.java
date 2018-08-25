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

package com.maxwellhaley.mct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.maxwellhaley.mct.datastructure.MorseCodeTree;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class MorseCodeTranslator {

  private JFrame frmMorseCodeTranslator;
  private MorseCodeTree morse;
  private JTextPane textPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MorseCodeTranslator window = new MorseCodeTranslator();
          window.frmMorseCodeTranslator.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public MorseCodeTranslator() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    try {
      morse = new MorseCodeTree();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    frmMorseCodeTranslator = new JFrame();
    // frmMorseCodeTranslator.setIconImage(Toolkit.getDefaultToolkit().getImage(MorseCodeTranslator.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
    frmMorseCodeTranslator.setTitle("Morse Code Translator");
    frmMorseCodeTranslator.setBounds(100, 100, 610, 488);
    frmMorseCodeTranslator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmMorseCodeTranslator.getContentPane().setLayout(null);

    final JTextArea textArea = new JTextArea();
    textArea.setLineWrap(true);
    textArea.setFont(new Font("Dialog", Font.PLAIN, 20));
    textArea.setBounds(10, 38, 574, 170);
    frmMorseCodeTranslator.getContentPane().add(textArea);

    final JTextArea textPane = new JTextArea();
    textPane.setFont(new Font("Monospaced", Font.PLAIN, 20));
    textPane.setEditable(false);
    textPane.setBounds(10, 271, 574, 170);
    frmMorseCodeTranslator.getContentPane().add(textPane);
    textPane.setLineWrap(true);
    textPane.setWrapStyleWord(true);

    JLabel lblEnterT = new JLabel("Enter text to encode or decode:");
    lblEnterT.setBounds(10, 11, 246, 14);
    frmMorseCodeTranslator.getContentPane().add(lblEnterT);

    JButton btnEncode = new JButton("To Morse Code");
    btnEncode.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textPane.setText(morse.encode(textArea.getText()));
      }
    });
    btnEncode.setBounds(30, 226, 157, 23);
    frmMorseCodeTranslator.getContentPane().add(btnEncode);

    JButton btnDecode = new JButton("From Morse Code");
    btnDecode.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        textPane.setText(morse.decode(textArea.getText()));
      }
    });
    btnDecode.setBounds(217, 226, 157, 23);
    frmMorseCodeTranslator.getContentPane().add(btnDecode);

    JButton btnClear = new JButton("Clear");
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        textPane.setText("");
        textArea.setText("");
      }
    });
    btnClear.setBounds(404, 226, 157, 23);
    frmMorseCodeTranslator.getContentPane().add(btnClear);
  }
}
