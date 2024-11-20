package edu.ntnu.idi.bidata;
import java.util.Scanner;
import static java.lang.System.in;

public class InputReader {
  private final Scanner scanner;


  public InputReader() {
    scanner = new Scanner(in);
  }

  public String scannerString(){
    String nameOfFood = scanner.nextLine();
    return nameOfFood.toLowerCase();
  }

  public Double scannerPriceOfFood(){
    Double price = scanner.nextDouble();
    scanner.nextLine();
    return price;
  }

  public Float scannerAmountOfFood(){
     Float amount = scanner.nextFloat();
     scanner.nextLine();
     return amount;
  }






}
