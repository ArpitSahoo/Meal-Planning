package edu.ntnu.idi.bidata;




/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 *
 * @author Arpit Sahoo
 * @version 3.0.0
 */


public class FridgeApp {
  private static UserInterface ui;

  public static void main(String[] args){
    try{
      ui = new UserInterface();
      ui.printFridge();
    }
    catch(IllegalArgumentException illegalArgument) {
      System.out.println(illegalArgument.getMessage());
    }
  }
}
