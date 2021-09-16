package logic;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class BankHandler {

    private Connection myConn;


    public BankHandler(String DBDirectory, String DBUser, String DBPass) {
        try {
            System.out.println("First");
            myConn = DriverManager.getConnection(DBDirectory, DBUser, DBPass);
            JOptionPane.showMessageDialog(null, "Connected successfully");
            System.out.println("Second");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void readDB(String username, String password) {

    }


}