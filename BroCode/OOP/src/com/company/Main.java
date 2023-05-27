package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
//	// file = an abstract representation of file and directory pathnames
//
//        File file = new File("Secret_message.txt");
//
//        if (file.exists()){
//            System.out.println("The file does exist! :O ");
//            System.out.println(file.getAbsolutePath());
//        }
//        else{
//            System.out.println("The file doesn't exist");
//        }

//        try {
//            FileWriter writer = new FileWriter("poem.txt");
//            writer.write("Roses are red \n Violets are blue \n Booty Booty Booty Booty \n rockin' everywhere");
//            writer.append("\n (A poem by me");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            FileReader reader = new FileReader("art.txt");
            try {
                int data = reader.read();
                while (data != -1){
                    System.out.print((char)data);
                    data = reader.read();

                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
