package edu.ntnu.idi.bidata.userinterfaces;

import static java.lang.System.out;

public class UserinterFase {
    public void choiseScreen(){
        out.println("\n--- Fridge Management ---");
        out.println("1. Add food");
        out.println("2. Remove food");
        out.println("3. Take out an item");
        out.println("4. Display fridge contents");
        out.println("5. Check for expired food");
        out.println("6. Exit");
        out.println("Choose a following number: ");
    }

    public void choiseOfUnits(){
        out.println("Choose an unit (1, 2, 3 or 4):");
        out.println("1. kg");
        out.println("2. liter");
        out.println("3. gram");
        out.println("4. pieces");
    }
}
