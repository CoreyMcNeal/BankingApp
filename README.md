# BankingApp
Bank ATM Application with full GUI (Swing). The application connects to and communicates with a local SQL database (seet up using MySQLWorkbench), allowing non volatile storage, and manipulation of account balances. 

The User must set up a local database using MySQL. To run the application correctly, the user must provide the database directory (commonly "jdbc:mysql://localhost:3306/<DatabaseNameHere>", database user name, and database password as arguments on the command line at execution (Three total args). 

# How to Run
  - TODO

# How to Use
  - On entry, the user is notified if a successful connection has been made
  - The user may login with a registered username and PIN (Integers) from the database, or optionally exit from the same screen
  
  - Upon login, user is greeted and shown the current balances of the checking and savings accounts
  - User can then enter a number to which they can Withdraw, deposit, or transfer from either accounts depending on the button chosen
  - Once the user is ready to exit, the Exit button will terminate the program, and close the connection

# What I Learned
  - SQL setup through MySQLWorkbench
  - SQL manipulation using the Java.SQL library
