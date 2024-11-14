package edu.ntnu.idi.bidata;
import java.util.Scanner;
import static java.lang.System.in;

public class InputReader {
  private final Scanner scanner;


  public InputReader() {
    scanner = new Scanner(in);
  }


  public void scannerNameOfFood(){
    String nameOfFood = scanner.nextLine();
  }



}
