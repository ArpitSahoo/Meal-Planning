package edu.ntnu.idi.bidata;
/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 *
 * @author Arpit Sahoo
 * @version 0.0.1
 */
public class FridgeApp {

  /**
   * Main method to initialize and run the fridge management application.
   *
   * <p>This method creates an instance of {@link UserInterface} and
   * calls its {@code printFridge} method to display all food items in the fridge.
   * It handles potential {@link IllegalArgumentException} exceptions by
   * displaying an error message if an argument is invalid.
   * </p>
   *
   * @param args command-line arguments (not used in this application)
   */
  public static void main(String[] args){
    try{
      UserInterface ui = new UserInterface();
      ui.printFridge();
    }
    catch(IllegalArgumentException illegalArgument) {
      System.out.println(illegalArgument.getMessage());
    }
  }
}
