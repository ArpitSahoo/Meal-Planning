package edu.ntnu.idi.bidata.utility;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static java.lang.System.in;

/**
 * Represents the scanner.
 *<p>Handles the users input to application and supports
 * {@link UserInterface} to start an operation and set values.
 *</p>
 * @version 0.0.2
 * @author Arpit Sahoo
 */
public class InputReader {
  private final Scanner scanner;
  private final UIPrintHandler print;



  public InputReader() {
    scanner = new Scanner(in);
    print = new UIPrintHandler();
  }

  public String scannerString(){
    String nameOfFood = scanner.nextLine();
    return nameOfFood.toLowerCase();
  }

  public Double getValidPrice(){
    double price = 0.0;
    boolean validPrice = false;
    while (!validPrice) {
      print.pricePerUnitOutput();
      String priceInput = scannerString();
      try{ // tries the scanner method
        price = Double.parseDouble(priceInput); // converts the string to a float
        validPrice = true;
      }
      catch (Exception e){ // catches an exception if the number is 0 or under or not a number.
        print.invalidPriceOutput();
      }
    }
    return price;
  }

  /**
   * Prompts the user to enter an expiration date and validates its format.
   *
   * <p>This method continually prompts the user to enter a date until a valid
   * expiration date is provided in the format yyyy-MM-dd. If the date format is invalid,
   * an error message is displayed, and the user is prompted to try again.
   * </p>
   *
   * @return a valid {@link LocalDate} object representing the expiration date
   */
  public LocalDate getValidExpirationDate() {
    LocalDate expirationDate = null; // (OpenAI, 2024)
    boolean validDate = false;
    while (!validDate) {
      print.expirationDateOutput();
      String expiration = scannerString();
      try { // // tries the scanner method
        expirationDate = LocalDate.parse(expiration, DateTimeFormatter.ofPattern("yyyy-MM-dd")); // (OpenAI, 2024)
        validDate = true;
      } catch (Exception e) { //catches illegal argument if it is not correct format
        print.invalidExpirationDateOutput();
      }
    }
    return expirationDate;
  }

  public Float getValidAmount(){
    float amount = 0f; // amount is 0
    boolean validAmount = false;
    while (!validAmount) {
      print.foodAmountOutput();
      String priceInput = scannerString();
      try { // tries the scanner method
        amount = Float.parseFloat(priceInput); // converts the string to a float
        validAmount = true;
      } catch (Exception e){ // catches an exception if the number is 0 or under or not a number.
        print.invalidFoodAmountOutput();
      }
    }
    return amount;
  }

  public int amountOfIngredients(){
    int amount = 0; // amount is 0
    boolean validInt = false;
    while (!validInt) {
      String priceInput = scannerString();
      try { // tries the scanner method
        amount = Integer.parseInt(priceInput); // converts the string to a float
        validInt = true;
      } catch (Exception e){ // catches an exception if the number is 0 or under or not a number.
        print.invalidFoodAmountOutput();
      }
    }
    return amount;
  }


}
