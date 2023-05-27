package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class main_JLabel {
    public static void main(String[] args) {

        // Jlabel = a GUI display area fri a string of text, an image, or both

        ImageIcon image = new ImageIcon("bbgj6.jpg");

        Border border = BorderFactory.createLineBorder(Color.green, 3);

        JLabel label = new JLabel(); // this will create a label
        label.setText("Bro, do you even code?"); // set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT,CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP); //set text TOP, CENTEr, BOTTOM of imageicon
        label.setForeground(Color.green); // set font color of text
        label.setFont(new Font("MV Boli",Font.PLAIN,20)); //set font of text
        label.setIconTextGap(-25); //set gap of text to image
        label.setBackground(Color.black); //set background color
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within the label
       // label.setBounds(0, 0, 250, 250);




        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);

        //before using pack method, add all components before using pack

        ImageIcon image1 = new ImageIcon("kitty.jpg"); // create an imageicon //works with both png and jpg files
        frame.setIconImage(image1.getImage()); //change icon of frame
    }
}
