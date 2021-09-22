# BankingApp
Bank ATM Application with full GUI (Swing). The application connects to and communicates with a local SQL database (set up using MySQLWorkbench), allowing non volatile storage, and manipulation of account balances. 

The User must set up a local database using MySQL.

**Please make sure the database is called bankDB, as that is what the schema is expecting to use to create the tables needed.**

The SQL Schema needed to make the tables in the SQL database is provided in the files, labeled "SQLSchema". This will make sure the database being written to is formatted correctly for queries and updates from the program.

Add the SQL jar file to the build path of the application. It is located in the resources folder.

# How to Run
  - Run "App.java" from within an IDE with Maven support (Such as IntelliJ, Netbeans, or Eclipse)
  - Enter the database name (ex. jdbc:mysql://localhost:3306/bankDB)
  - Enter the database admin username
  - Enter the database password
  - If credentials are correct, the interface for the application will appear.

# How to Use
  - On entry, the user is notified if a successful connection has been made
  - The user may login with a registered username and PIN (Integers) from the database, optionally create a new account, or exit from the same screen
  - Upon login, user is greeted and shown the current balances of the checking and savings accounts
  - User can then enter a number to which they can Withdraw, deposit, or transfer from either accounts depending on the button chosen
  - Once the user is ready to exit, the Exit button will terminate the program, and close the connection

# What I Learned
  - SQL setup through MySQLWorkbench
  - SQL manipulation using the Java.SQL library
  - Maven builder/dependency management
