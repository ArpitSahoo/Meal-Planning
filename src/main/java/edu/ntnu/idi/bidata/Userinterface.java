package edu.ntnu.idi.bidata;

import java.util.Scanner;

import static java.lang.System.in;

public class Userinterface {
  private FridgeStorage fridgeRegister;
  private Scanner scanner;
  private UIPrintHandler uiFridgeApp;

  public Userinterface(){
    fridgeRegister = new FridgeStorage();
    scanner = new Scanner(in);
    uiFridgeApp = new UIPrintHandler();
  }
}
