package edu.bu.met.cs665;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

  public static void main(String[] args) {
    Path relativePath = Paths.get("");
    String testFilePath = relativePath.toAbsolutePath().toString() + "/src/TestFiles/Test.java";
    String codeFragment = readFromFile(testFilePath);
    System.out.println(codeFragment);
  }

  public static String readFromFile(String filePath) {

    StringBuilder stringBuilder = new StringBuilder();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      String line = null;
      String ls = System.getProperty("line.separator");
      stringBuilder.append(line);
      stringBuilder.append(ls);
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line);
        stringBuilder.append(ls);
      }
      reader.close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return stringBuilder.toString();
  }
} // ** Main Class




//? *********** V A R I A B L E   P R I N T E R   C L A S S ***********



