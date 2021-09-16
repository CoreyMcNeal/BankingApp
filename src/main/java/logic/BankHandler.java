package logic;

import javax.swing.*;
import java.sql.*;

public class BankHandler {

    private Connection myConn;
    private Statement myStmt;
    private ResultSet myResults;

    public BankHandler(String DBDirectory, String DBUser, String DBPass) {
        try {
            myConn = DriverManager.getConnection(DBDirectory, DBUser, DBPass);
            JOptionPane.showMessageDialog(null, "Connected successfully");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public boolean attemptLogin(String username, String pin) {      // Checks to see if username and password combo
        try {                                                       // exists on loginInfo DB table
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT COUNT(*) FROM bankDB.loginInfo " +
                                                 "WHERE username = '" + username + "' " +
                                                 " AND pin_number = '" + pin + "';");

            myResults.next();
            String exists = myResults.getString("COUNT(*)");
            return exists.equals("1");

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Error sending to SQL server");
            exc.printStackTrace();

            return false;
        }
    }
}