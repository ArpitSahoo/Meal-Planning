package edu.ntnu.idi.bidata.userinterface;


import static java.lang.System.in;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 * Represents the scanner.
 *
 * <p>This class had the responsibility to handle the users
 * prompt amd supports {@link UserInterface} to start operations and set values
 * in different situations. It handles the prompts and makes sure that all the
 * prompts are valid.
 * </p>
 *
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.3
 */
public class InputReader {
  private final Scanner scanner;
  private final UiPrintHandler print;


  /**
   * A constructor that initializes the {@link Scanner} and {@link UiPrintHandler}.
   */
  public InputReader() {
    scanner = new Scanner(in);
    print = new UiPrintHandler();
  }

  /**
   * Takes inn the users input as a string.
   *
   * @return String that the user prompts to lowercase.
   */
  public String scannerString() {
    String stringInput = scanner.nextLine();
    return stringInput.toLowerCase();

  }

  /**
   *Prompts the user to enter an expiration date and validates its format.
   *
   *<p>This method continually prompts the user to enter a date until a valid
   *expiration date is provided in the format yyyy-MM-dd. If the date format is invalid,
   *an error message is displayed, and the user is prompted to try again.
   *
   * @return a valid {@link LocalDate} object representing the expiration date
   */
  public LocalDate getValidExpirationDate() {
    LocalDate expirationDate = null; // (OpenAI, 2024)
    boolean validDate = false;
    while (!validDate) {
      print.expirationDateOutput();
      String expiration = scannerString();
      try { // // tries the scanner input
        expirationDate = LocalDate.parse(expiration,
            DateTimeFormatter.ofPattern("yyyy-MM-dd")); // (OpenAI, 2024)
        //converts the String to a LocalDate and formats it.
        validDate = true;
      } catch (Exception e) { //catches illegal argument if it is not correct format
        print.invalidExpirationDateOutput();
      }
    }
    return expirationDate;
  }

  /**
   * Allows the user to input the price.
   *
   *<p>User prompts the price of food item. Checks if the price is valid.
   *If price is not a valid {@code false}, the user is informed
   *to re-enter the information.</p>
   *
   * @return Price if price is valid {@code true}.
   */
  public Double getValidPrice() {
    double price = 0.0;
    boolean validPrice = false;
    while (!validPrice) {
      print.pricePerUnitOutput();
      String priceInput = scannerString();
      try { // tries the scanner method
        price = Double.parseDouble(priceInput); // converts the string to a float
        validPrice = true;
      } catch (Exception e) { // catches an exception if the number is 0 or under or not a number.
        print.invalidPriceOutput();
      }
    }
    return price;
  }

  /**
   * Allows the user to input the amount.
   *
   *<p>User prompts the amount of food item. Checks if the price is valid.
   *If amount is not a valid {@code false}, the user is informed
   *to re-enter the information.</p>
   *
   * @return amount if price is valid {@code true}.
   */
  public Float getValidAmount() {
    float amount = 0f; // amount is 0
    boolean validAmount = false;
    while (!validAmount) {
      print.foodAmountOutput();
      String priceInput = scannerString();
      try { // tries the scanner method
        amount = Float.parseFloat(priceInput); // converts the string to a float
        validAmount = true;
      } catch (Exception e) { // catches an exception if the number is 0 or under or not a number.
        print.invalidFoodAmountOutput();
      }
    }
    return amount;
  }

  /**
   * Allows the user to input the quantity of ingredient.
   *
   *<p>User prompts the quantity of ingredients. Checks if the quantity is valid.
   *If quantity is not a valid {@code false}, the user is informed
   *to re-enter the information.</p>
   *
   * @return quantity if price is valid {@code true}.
   */
  public int amountOfIngredients() { //int because this method is for
    // the quantity of recipes, not FoodItem.
    int quantity = 0; // quantity is 0
    boolean validInt = false;
    while (!validInt) {
      String priceInput = scannerString();
      try { // tries the scanner method.
        quantity = Integer.parseInt(priceInput); // converts the string to a float
        validInt = true;
      } catch (Exception e) { // catches an exception if the number is 0 or under or not a number.
        print.invalidFoodAmountOutput();
      }
    }
    return quantity;
  }


}
