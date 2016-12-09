package model;


import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lamar
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("test_file.txt");
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter(file));
        writer.append("this is some text");
        writer.close();
    }
}
