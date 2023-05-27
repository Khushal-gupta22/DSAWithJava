package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {

        JButton button = new JButton();
        button.setBounds(200, 100, 100, 50);

       // this.setTitle("JFrame title goes here"); // sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setLayout(null);
        // this.setResizable(false); // prevent frame from being resized
        this.setSize(500,500); // sets the x-dimension, and y-dimension
        this.setVisible(true); //  makes frame visible
        this.add(button);

//        ImageIcon image = new ImageIcon("kitty.jpg"); // create an imageicon //works with both png and jpg files
//        this.setIconImage(image.getImage()); //change icon of frame
//        this.getContentPane().setBackground(new Color(123, 53, 250)); //change color of background
    }
}
