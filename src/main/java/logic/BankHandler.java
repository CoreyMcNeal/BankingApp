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

    public boolean attemptLogin(String email, String pin) {      // Checks to see if username and password combo
        try {                                                       // exists on loginInfo DB table
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT COUNT(*) FROM bankDB.loginInfo " +
                                                 "WHERE email = '" + email + "' " +
                                                 " AND pin_number = '" + pin + "';");

            myResults.next();
            String exists = myResults.getString("COUNT(*)");

            myStmt.close();
            myResults.close();
            return exists.equals("1");

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Error sending to SQL server");
            exc.printStackTrace();

            return false;
        } finally {
            try {
                myStmt.close();
                myResults.close();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    public Double getCheckingAmount(String email) {
        try {
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT checkingAccount FROM bankDB.bankInfo " +
                                                "JOIN bankDB.loginInfo " +
                                                "WHERE bankDB.bankInfo.client_id = bankDB.loginInfo.client_id AND " +
                                                "bankDB.bankInfo.email = '" + email + "';" );
            myResults.next();
            double checkingAmount = Double.parseDouble(myResults.getString("checkingAccount"));

            myStmt.close();
            myResults.close();
            return checkingAmount;
        } catch (Exception exc) {
            exc.printStackTrace();
            return 0.0;
        }
    }

    public Double getSavingsAmount(String email) {
        try {
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT savingsAccount FROM bankDB.bankInfo " +
                    "JOIN bankDB.loginInfo " +
                    "WHERE bankDB.bankInfo.client_id = bankDB.loginInfo.client_id AND " +
                    "bankDB.bankInfo.email = '" + email + "';" );
            myResults.next();
            double savingsAmount = Double.parseDouble(myResults.getString("savingsAccount"));

            myStmt.close();
            myResults.close();
            return savingsAmount;
        } catch (Exception exc) {
            exc.printStackTrace();
            return 0.0;
        }
    }

    public String getName(String email) {
        try {
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT name FROM bankDB.bankInfo " +
                    "JOIN bankDB.loginInfo " +
                    "WHERE bankDB.bankInfo.client_id = bankDB.loginInfo.client_id AND " +
                    "bankDB.bankInfo.email = '" + email + "';" );
            myResults.next();
            String name = myResults.getString("name");

            myStmt.close();
            myResults.close();
            return name;
        } catch (Exception exc) {
            exc.printStackTrace();
            return "";
        }
    }

    public void closeConnection() {
        try {
            myConn.close();
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }

}