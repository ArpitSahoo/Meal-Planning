package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.userinterface.UserInterface;

/**
 * The main starting point of the application. This class creates an instance
 * of {@link UserInterface} to start the whole application.
 *
 * @author Arpit Sahoo
 * @version 0.0.1
 */
public class FridgeApp {

  /**
   * The main entry point for the fridge management application.
   *
   * <p>This method creates an instance of the {@link UserInterface} class
   * and starts the user interface(UI).
   * After starting the UI, it prints the fridge contents.
   * If any {@link IllegalArgumentException}
   * is thrown, the error message is displayed.</p>
   *
   * @param args command-line arguments (not used in this method)
   */
  public static void main(String[] args) {
    try {
      new UserInterface();
    } catch (IllegalArgumentException illegalArgument) {
      System.out.println(illegalArgument.getMessage());
    }
  }
}
