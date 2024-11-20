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
   * The main entry point for the fridge management application.
   *
   * <p>This method creates an instance of the {@link UserInterface} class and starts the user interface.
   * After starting the UI, it prints the fridge contents. If any {@link IllegalArgumentException}
   * is thrown, the error message is displayed.</p>
   *
   * @param args command-line arguments (not used in this method)
   */
  //TODO update this
  public static void main(String[] args){
    try{
      new UserInterface();
    }
    catch(IllegalArgumentException illegalArgument) {
      System.out.println(illegalArgument.getMessage());
    }
  }
}
