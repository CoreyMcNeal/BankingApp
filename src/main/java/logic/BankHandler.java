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
            JOptionPane.showMessageDialog(null, "Problem connecting to server," +
                                                                        " check the directory, user, and password");
            exc.printStackTrace();
            System.exit(0);
        }
    }



    public boolean attemptLogin(String email, String pin) {      // Checks to see if username and password combo
        try {                                                       // exists on loginInfo DB table
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT COUNT(*) " +
                                                " FROM bankDB.loginInfo " +
                                                " WHERE email = '" + email + "' " +
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

    public int getCheckingAmount(String email) {    //grabs the checkingAccount amount for a given users account
        try {
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT checkingAccount FROM bankDB.bankInfo " +
                                                "JOIN bankDB.loginInfo " +
                                                "WHERE bankDB.bankInfo.client_id = bankDB.loginInfo.client_id AND " +
                                                "bankDB.bankInfo.email = '" + email + "';" );
            myResults.next();
            int checkingAmount = myResults.getInt("checkingAccount");

            myStmt.close();
            myResults.close();
            return checkingAmount;
        } catch (Exception exc) {
            exc.printStackTrace();
            return 0;
        }
    }

    public int getSavingsAmount(String email) {            // //grabs the savingsAccount amount for a given users account
        try {
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT savingsAccount FROM bankDB.bankInfo " +
                    "JOIN bankDB.loginInfo " +
                    "WHERE bankDB.bankInfo.client_id = bankDB.loginInfo.client_id AND " +
                    "bankDB.bankInfo.email = '" + email + "';" );

            myResults.next();
            int savingsAmount = myResults.getInt("savingsAccount");


            myStmt.close();
            myResults.close();
            return savingsAmount;
        } catch (Exception exc) {
            exc.printStackTrace();
            return 0;
        }
    }

    public String getName(String email) {             // Grabs the name associated with the email given
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

    public boolean withdrawBank(int requestedAmount, String email)
    {
                                                        // Takes away the amount entered from the users checkingAccount
        try {
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery("SELECT checkingAccount FROM bankDB.bankInfo " +
                    "JOIN bankDB.loginInfo " +
                    "WHERE bankDB.bankInfo.client_id = bankDB.loginInfo.client_id AND " +
                    "bankDB.bankInfo.email = '" + email + "';");

            myResults.next();
            int checkingAmount = myResults.getInt("checkingAccount");

            closeStatementResultSet();

            myStmt = myConn.createStatement();
            if (checkingAmount < requestedAmount) {
                JOptionPane.showMessageDialog(null, "Not enough in checking account");
                closeStatementResultSet();
                return false;
            }

            myStmt.executeUpdate("UPDATE bankInfo " +
                                    "SET bankInfo.checkingAccount = bankInfo.checkingAccount - " + requestedAmount +
                                    " WHERE email = '" + email + "';");

            closeStatementResultSet();
            return true;

        } catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    public void depositBank(int requestedAmount, String email) {   // Adds the amount entered to the users checkingAccount
        try {
            myStmt = myConn.createStatement();
            myStmt.executeUpdate("UPDATE bankInfo " +
                    "SET bankInfo.checkingAccount = bankInfo.checkingAccount + " + requestedAmount +
                    " WHERE email = '" + email + "';");
            closeStatementResultSet();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void checkingToSavings(int requestedAmount, String email) {

                                                            //Subtracts the amount given from the checkingAccount,
                                                            //Adds the amount given to the savingsAccount

        int checkingAmount = getCheckingAmount(email);
        if (checkingAmount < requestedAmount) {
            JOptionPane.showMessageDialog(null, "Not enough in savings account.");
            return;
        }

        try {
            myStmt = myConn.createStatement();
            myStmt.executeUpdate(" UPDATE bankInfo " +
                                     " SET bankInfo.checkingAccount = bankInfo.checkingAccount - " + requestedAmount +
                                     " WHERE bankInfo.email = '" + email + "' " +
                                     " AND client_id > 0;");

            closeStatementResultSet();

            myStmt = myConn.createStatement();
            myStmt.executeUpdate( " UPDATE bankInfo " +
                                      " SET bankInfo.savingsAccount = bankInfo.savingsAccount + " + requestedAmount +
                                      " WHERE bankInfo.email = '" + email + "' " +
                                      " AND client_id > 0;");

            JOptionPane.showMessageDialog(null, "Transfer Complete.");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void savingsToChecking(int requestedAmount, String email) {

                                                            //Subtracts the amount given from the checkingAccount,
                                                            //Adds the amount given to the savingsAccount

        int savingsAmount = getSavingsAmount(email);
        if (savingsAmount < requestedAmount) {
            JOptionPane.showMessageDialog(null, "Not enough in checking account.");
            return;
        }

        try {
            myStmt = myConn.createStatement();
            myStmt.executeUpdate(" UPDATE bankInfo " +
                    " SET bankInfo.checkingAccount = bankInfo.checkingAccount + " + requestedAmount +
                    " WHERE bankInfo.email = '" + email + "' " +
                    " AND client_id > 0;");

            closeStatementResultSet();

            myStmt = myConn.createStatement();
            myStmt.executeUpdate( " UPDATE bankInfo " +
                    " SET bankInfo.savingsAccount = bankInfo.savingsAccount - " + requestedAmount +
                    " WHERE bankInfo.email = '" + email + "' " +
                    " AND client_id > 0;");

            JOptionPane.showMessageDialog(null, "Transfer Complete.");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void closeStatementResultSet() {       // Closes both variables when finished.
        try {
            myStmt.close();
            myResults.close();
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    public void closeConnection() {        // Closes main connection to SQL database
        try {
            myConn.close();
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }

    public void registerUser(String email, String pin, String name, String address, String phoneNumber) {

                                                    //Adds an entry to the loginInfo database and
                                                    //bankInfo database based on the information given

        try {
            myStmt = myConn.createStatement();
            myResults = myStmt.executeQuery( " SELECT COUNT(*) " +
                                                 " FROM loginInfo " +
                                                 " WHERE email = '" + email + "' " +
                                                 " AND client_id > 0;");

            myResults.next();
            String exists = myResults.getString("COUNT(*)");
            if (!exists.equals("0")) {
                JOptionPane.showMessageDialog(null, "Username already exists." +
                                                                            " Please use a different email.");
                closeStatementResultSet();
                return;
            }

            closeStatementResultSet();
            myStmt = myConn.createStatement();
            myStmt.executeUpdate(" INSERT INTO loginInfo " +
                                                 " VALUES ( NULL, '" + email + "', " + pin + ");" );

            closeStatementResultSet();
            myStmt = myConn.createStatement();
            myStmt.executeUpdate(" INSERT INTO bankInfo " +
                                     " VALUES ( NULL, '"  + email + "', '" + name
                                                + "', '" + address + "', '" + phoneNumber +
                                                "', 0, 0);");

            closeStatementResultSet();
            JOptionPane.showMessageDialog(null, "User has been registered.");

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Problem communicating with database.");
            exc.printStackTrace();
        }
    }
}