package edu.bu.met.cs665;

import java.io.BufferedReader;
import java.io.FileReader;
import org.eclipse.jdt.core;


public class Main {


  public static void main(String[] args) {
    String codeFragment = readFromFile("/media/jarvis/DATA/BOSTON UNIVERSITY/BU RESEARCH ASSISTANT/Projects/professorkiaT/Maven Template/JavaProjectTemplate/src/TestFiles/Test.java");
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
class VariablePrinter {
  // ! ERROR IN THIS METHOD || Import error **********************************
   public static ASTNode getASTNode(String codeFragment) {
    ASTParser parser = ASTParser.newParser(AST.JLS8);
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setSource(codeFragment.toCharArray());
    parser.setResolveBindings(false);

    ASTNode node = null;
    try {
      node = (CompilationUnit) parser.createAST(null);
    } catch (Exception e) {
      return null;
    }
    return node;

  }

//asd

    public static void test() {

    }
  public static void printVariables(String codeFragment) {
    ASTNode node = getASTNode(codeFragment);
    node.accept(new ASTVisitor() {

      int varCount = 0;

      @Override
      public boolean visit(VariableDeclarationFragment node) {
        System.out.println(node.getName().toString());
        return super.visit(node);
      }

      ;
    });
  }
} // * Variable Printer Class