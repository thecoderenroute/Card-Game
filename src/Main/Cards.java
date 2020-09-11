package Main;

import UI.GUI;
import UI.UserInterface;

import java.util.Scanner;

public class Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);
        GUI gui = new GUI();
        gui.start();
        // ui.start();
    }
}
