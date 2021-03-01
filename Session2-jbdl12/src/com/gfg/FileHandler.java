package com.gfg;

import java.io.*;

public class FileHandler {

    public void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while(line != null){
            System.out.println(line);
            line = bufferedReader.readLine();
        }

    }

    public void writeFile(String fileName , String content) throws IOException {
        File file = new File(fileName);
        if(file.exists()){
            System.out.println("file exists ");
        }else{
            System.out.println("file doesn't exist");
        }
        FileWriter fileWriter = new FileWriter(fileName,
                true);
        fileWriter.append(content);
        fileWriter.close();
    }
    public void clearFile(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("");
        fileWriter.close();
    }
    public void deleteFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.delete();
    }
}
