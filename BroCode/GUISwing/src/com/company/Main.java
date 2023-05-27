package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // JFrame = a GUI window to add components to

        /* JFrame frame = new JFrame(); // creates new frame
        frame.setTitle("JFrame title goes here"); // sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        frame.setResizable(false); // prevent frame from being resized
        frame.setSize(420,420); // sets the x-dimension, and y-dimension
        frame.setVisible(true); //  makes frame visible

        ImageIcon image = new ImageIcon("kitty.jpg"); // create an imageicon //works with both png and jpg files
        frame.setIconImage(image.getImage()); //change icon of frame
        frame.getContentPane().setBackground(new Color(123, 53, 250)); //change color of background

        */



        MyFrame myFrame = new MyFrame(); // or can use only new MyFrame
    }
}
