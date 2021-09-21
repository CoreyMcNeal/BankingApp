import userinterface.BankGUI;

import javax.swing.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        BankGUI gui = new BankGUI();
        Scanner reader = new Scanner(System.in);

        String databaseName = JOptionPane.showInputDialog("Enter the database directory: ");
        String databaseUsername = JOptionPane.showInputDialog("Enter database username: ");
        String databasePassword = JOptionPane.showInputDialog("Enter database password: ");

        gui.start(databaseName, databaseUsername, databasePassword);
    }
}
