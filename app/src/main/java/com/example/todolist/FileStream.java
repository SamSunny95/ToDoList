package com.example.todolist;

import android.content.Context;
import android.net.IpSecAlgorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileStream {

    public static final String filename = "list.dat";

    public  static  void writeToFile(ArrayList<String> list, Context c){

        try{
            FileOutputStream fOutput = c.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream oOutput = new ObjectOutputStream(fOutput);
            oOutput.writeObject(list);
            oOutput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  static  ArrayList<String> readFromFile(Context c){

        ArrayList<String> list = null;

        try {

            FileInputStream fInput = c.openFileInput(filename);
            ObjectInputStream oInput = new ObjectInputStream(fInput);
            list = oInput.readObject();

        } catch (FileNotFoundException e) {

            list = new ArrayList<>();

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;

    }

}
