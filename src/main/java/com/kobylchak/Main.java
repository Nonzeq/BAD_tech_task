package com.kobylchak;

import java.io.*;


public class Main {
    public static void main(String[] args) {


        String path = null;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("Enter absolute path to file with text: ");
            path = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(path);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line = bufferedReader.readLine();
            while(line != null){

                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Answer is: "+Solution.getChar(stringBuilder.toString()));


    }
}
