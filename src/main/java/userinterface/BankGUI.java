package userinterface;

import logic.BankHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI implements ActionListener {

    private JFrame frame;
    private BankHandler bankHandler;

    private JPanel loginPanel;
    private GridBagConstraints loginConstraints;

    private JLabel loginWelcomeLabel;
    private JLabel loginUsernameLabel;
    private JTextField loginUsernameEntry;
    private JLabel loginPasswordLabel;
    private JPasswordField loginPasswordEntry;
    private JButton loginConnectButton;
    private JButton loginRegisterButton;
    private JButton loginExitButton;

    private JPanel infoPanel;
    private GridBagConstraints infoConstraints;

    private JLabel infoWelcomeUserLabel;
    private JLabel infoCheckingLabel;
    private JLabel infoCheckingAmountLabel;
    private JLabel infoSavingsLabel;
    private JLabel infoSavingsAmountLabel;
    private JTextField infoNumberEntry;
    private JButton infoWithdrawButton;
    private JButton infoDepositButton;
    private JButton infoCheckToSaveButton;
    private JButton infoSaveToCheckButton;
    private JButton infoExitButton;

    private JPanel registrationPanel;
    private GridBagConstraints regConstraints;

    private JLabel regEmailLabel;
    private JTextField regEmailEntry;
    private JLabel regPinLabel;
    private JPasswordField regPinEntry;
    private JLabel regPinConfirmLabel;
    private JPasswordField regPinConfirmEntry;
    private JLabel regFullNameLabel;
    private JTextField regFullNameEntry;
    private JLabel regAddressLabel;
    private JTextField regAddressEntry;
    private JLabel regPhoneLabel;
    private JTextField regPhoneEntry;
    private JButton regSubmitButton;
    private JButton regReturnButton;


    public void start(String DBDirectory, String DBUser, String DBPassword) {
        bankHandler = new BankHandler(DBDirectory, DBUser, DBPassword);
        buildFrameAndPanels();
    }

    private void buildFrameAndPanels() {
        buildLoginPanel();
        buildInfoPanel();
        buildRegisterPanel();

        frame = new JFrame();
        frame.setTitle("Java Bank ATM");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(550, 500);
        frame.add(loginPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
                                                            // initializing all the variables needed for each panel
    private void buildLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        loginPanel.setLayout(new GridBagLayout());
        loginConstraints = new GridBagConstraints();

        loginWelcomeLabel = new JLabel("Welcome to the Java Bank ATM", SwingConstants.CENTER);
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 0;
        loginPanel.add(loginWelcomeLabel, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 1, 55);

        loginUsernameLabel = new JLabel("Username: ");
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 2;
        loginPanel.add(loginUsernameLabel, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 3, 10);

        loginUsernameEntry = new JTextField();
        loginUsernameEntry.setPreferredSize(new Dimension(200, 20));
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 4;
        loginPanel.add(loginUsernameEntry, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 5, 15);

        loginPasswordLabel = new JLabel("PIN");
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 6;
        loginPanel.add(loginPasswordLabel, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 7, 10);

        loginPasswordEntry = new JPasswordField();
        loginPasswordEntry.setPreferredSize(new Dimension(200, 20));
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 8;
        loginPanel.add(loginPasswordEntry, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 9, 20);

        loginConnectButton = new JButton("Login");
        loginConnectButton.setPreferredSize(new Dimension(200, 50));
        loginConnectButton.addActionListener(this);
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 10;
        loginPanel.add(loginConnectButton, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 11, 20);

        loginRegisterButton = new JButton("Create a new Account");
        loginRegisterButton.setPreferredSize(new Dimension(200, 50));
        loginRegisterButton.addActionListener(this);
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 12;
        loginPanel.add(loginRegisterButton, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 13, 20);

        loginExitButton = new JButton("Exit");
        loginExitButton.setPreferredSize(new Dimension(150, 50));
        loginExitButton.addActionListener(this);
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 14;
        loginPanel.add(loginExitButton, loginConstraints);
    }

    private void buildInfoPanel() {
        infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        infoPanel.setLayout(new GridBagLayout());
        infoConstraints = new GridBagConstraints();

        infoWelcomeUserLabel = new JLabel();
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 0;
        infoPanel.add(infoWelcomeUserLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 1, 40);

        infoCheckingLabel = new JLabel("Checking Account Amount: ");
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 2;
        infoPanel.add(infoCheckingLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 3, 15);

        //Enter received balance here
        infoCheckingAmountLabel = new JLabel("");
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 4;
        infoPanel.add(infoCheckingAmountLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 5, 25);

        infoSavingsLabel = new JLabel("Savings Account Amount: ");
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 6;
        infoPanel.add(infoSavingsLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 7, 15);

        //Enter received savings balanced here
        infoSavingsAmountLabel = new JLabel("");
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 8;
        infoPanel.add(infoSavingsAmountLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 9, 25);

        infoNumberEntry = new JTextField();
        infoNumberEntry.setPreferredSize(new Dimension(200, 20));
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 10;
        infoPanel.add(infoNumberEntry, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 11, 10);

        infoWithdrawButton = new JButton("Withdraw amount in dollars");
        infoWithdrawButton.setPreferredSize(new Dimension(225, 75));
        infoWithdrawButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 12;
        infoPanel.add(infoWithdrawButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 15, 10);

        infoDepositButton = new JButton("Deposit amount in dollars");
        infoDepositButton.setPreferredSize(new Dimension(225, 75));
        infoDepositButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 16;
        infoPanel.add(infoDepositButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 17, 30);

        infoCheckToSaveButton = new JButton("Transfer From Checking to Savings");
        infoCheckToSaveButton.setPreferredSize(new Dimension(270, 50));
        infoCheckToSaveButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 18;
        infoPanel.add(infoCheckToSaveButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 19, 15);

        infoSaveToCheckButton = new JButton("Transfer From Savings to Checking");
        infoSaveToCheckButton.setPreferredSize(new Dimension(270, 50));
        infoSaveToCheckButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 20;
        infoPanel.add(infoSaveToCheckButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 21, 20);

        infoExitButton = new JButton("Logout and Exit");
        infoExitButton.setPreferredSize(new Dimension(125, 75));
        infoExitButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 22;
        infoPanel.add(infoExitButton, infoConstraints);

    }

    private void buildRegisterPanel() {
        registrationPanel = new JPanel();
        registrationPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        registrationPanel.setLayout(new GridBagLayout());
        regConstraints = new GridBagConstraints();

        regEmailLabel = new JLabel("Email:");
        regConstraints.gridx = 0;
        regConstraints.gridy = 0;
        registrationPanel.add(regEmailLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 1, 10);

        regEmailEntry = new JTextField();
        regEmailEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 2;
        registrationPanel.add(regEmailEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 3, 20);

        regPinLabel = new JLabel("PIN Number (4 digits): ");
        regConstraints.gridx = 0;
        regConstraints.gridy = 4;
        registrationPanel.add(regPinLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 5, 10);

        regPinEntry = new JPasswordField();
        regPinEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 6;
        registrationPanel.add(regPinEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 7, 20);

        regPinConfirmLabel = new JLabel("Confirm PIN: ");
        regConstraints.gridx = 0;
        regConstraints.gridy = 8;
        registrationPanel.add(regPinConfirmLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 9, 10);

        regPinConfirmEntry = new JPasswordField();
        regPinConfirmEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 10;
        registrationPanel.add(regPinConfirmEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 11, 20);

        regFullNameLabel = new JLabel("Enter Full Name: ");
        regConstraints.gridx = 0;
        regConstraints.gridy = 12;
        registrationPanel.add(regFullNameLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 13, 10);

        regFullNameEntry = new JTextField();
        regFullNameEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 14;
        registrationPanel.add(regFullNameEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 15, 20);

        regAddressLabel = new JLabel("Street Address:");
        regConstraints.gridx = 0;
        regConstraints.gridy = 16;
        registrationPanel.add(regAddressLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 17, 10);

        regAddressEntry = new JTextField();
        regAddressEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 18;
        registrationPanel.add(regAddressEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 19, 20);

        regPhoneLabel = new JLabel("Phone Number (Format: XXX-XXX-XXXX):");
        regConstraints.gridx = 0;
        regConstraints.gridy = 20;
        registrationPanel.add(regPhoneLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 21, 10);

        regPhoneEntry = new JTextField();
        regPhoneEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 22;
        registrationPanel.add(regPhoneEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 23, 20);

        regSubmitButton = new JButton("Submit");
        regSubmitButton.addActionListener(this);
        regSubmitButton.setPreferredSize(new Dimension(200, 100));
        regConstraints.gridx = 0;
        regConstraints.gridy = 24;
        registrationPanel.add(regSubmitButton, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 25, 20);

        regReturnButton = new JButton("Exit to Menu");
        regReturnButton.addActionListener(this);
        regReturnButton.setPreferredSize(new Dimension(200, 100));
        regConstraints.gridx = 0;
        regConstraints.gridy = 26;
        registrationPanel.add(regReturnButton, regConstraints);
    }

    private void spaceMaker(GridBagConstraints constraints, JPanel panel,
                            int gridy, int space) {                             //Method to help space out the components
        JLabel spacerTest = new JLabel("");
        constraints.gridx = 0;
        constraints.gridy = gridy;
        spacerTest.setPreferredSize(new Dimension(0, space));
        panel.add(spacerTest, constraints);
    }

    private void refreshFrame() {        //refreshes the UI for any changes
        frame.revalidate();
        frame.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent click) {            // Click events for all the UI buttons

        if (click.getSource() == loginConnectButton) {
            loginConnectButtonClicked();

        } else if (click.getSource() == loginRegisterButton) {
            loginRegisterButtonClicked();

        } else if (click.getSource() == loginExitButton || click.getSource() == infoExitButton) {
            bankHandler.closeConnection();
            System.exit(0);


        } else if (click.getSource() == infoWithdrawButton) {
            withdrawButtonClicked();

        } else if (click.getSource() == infoDepositButton) {
            depositButtonClicked();

        } else if (click.getSource() == infoCheckToSaveButton) {
            checkToSaveButtonClicked();

        } else if (click.getSource() == infoSaveToCheckButton) {
            saveToCheckButtonClicked();


        } else if (click.getSource() == regSubmitButton) {
            regCreateButtonClicked();

        } else if (click.getSource() == regReturnButton) {
            regReturnButtonClicked();
        }
    }


    //Login screen methods
    private void loginConnectButtonClicked() {  //Attempts to login to the server with the given user and pin

        String email = loginUsernameEntry.getText();
        String pin = String.valueOf(loginPasswordEntry.getPassword());
        if (!bankHandler.attemptLogin(email, pin)) {
            JOptionPane.showMessageDialog(null, "Login credentials invalid.");
            return;
        }
        switchToInfo();
        infoCheckingAmountLabel.setText("$" + bankHandler.getCheckingAmount(email));
        infoSavingsAmountLabel.setText("$" + bankHandler.getSavingsAmount(email));
        infoWelcomeUserLabel.setText("Welcome, " + bankHandler.getName(email) + "!");
    }

    private void loginRegisterButtonClicked() { // calls the panel switch to registrationPanel
        switchToReg();
    }

    //Panel switch methods
    private void switchToInfo() {               // Switches to the infoPanel, which houses all the bank information
        frame.remove(loginPanel);
        frame.setSize(550, 700);
        frame.add(infoPanel);
        infoNumberEntry.requestFocus();
        refreshFrame();
    }

    private void switchToLogin(JPanel currentPanel) {          // Switches to the login panel, and clears the registration
        frame.remove(currentPanel);                            // panel boxes
        frame.setSize(550, 500);
        frame.add(loginPanel);

        clearRegBoxes();
        refreshFrame();
    }

    private void switchToReg() {                          // Switches to the Registration panel, and carries over
        frame.remove(loginPanel);                       // username and pin if already entered
        frame.setSize(550, 700);
        frame.add(registrationPanel);
        regEmailEntry.setText(loginUsernameEntry.getText());
        regPinEntry.setText(String.valueOf(loginPasswordEntry.getPassword()));
        if (loginUsernameEntry.getText().length() > 0 && String.valueOf(loginPasswordEntry.getPassword()).length() > 0){

            regPinConfirmEntry.requestFocus();

        } else {
            regEmailEntry.requestFocus();
        }

        refreshFrame();
    }

    private void clearRegBoxes() {              // Clears the registrationPanel entry boxes
        regEmailEntry.setText("");
        regPinEntry.setText("");
        regPinConfirmEntry.setText("");
        regFullNameEntry.setText("");
        regAddressEntry.setText("");
        regPhoneEntry.setText("");
        loginConnectButton.requestFocus();
    }

    //Bank info screen methods
    private void withdrawButtonClicked() {      // Communicates with database to remove entry amount from checkingAccount

        if (infoNumberEntry.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Entry cannot be empty");
            return;
        }

        String email = loginUsernameEntry.getText();
        try {
            int requestedAmount = Integer.parseInt(infoNumberEntry.getText());
            if (!bankHandler.withdrawBank(requestedAmount, loginUsernameEntry.getText())){
                return;
            }
            JOptionPane.showMessageDialog(null, "Amount entered has successfully been withdrawn.");

            infoCheckingAmountLabel.setText("$" + bankHandler.getCheckingAmount(email));
            refreshFrame();
        } catch (Exception exc) {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please enter a whole dollar amount.");
        } finally {
            infoNumberEntry.requestFocus();
        }

    }

    private void depositButtonClicked() {          // Communicates with database to add entry amount to checkingAccount

        if (infoNumberEntry.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Entry cannot be empty");
            return;
        }

        String email = loginUsernameEntry.getText();
        try {
            int requestedAmount = Integer.parseInt(infoNumberEntry.getText());
            bankHandler.depositBank(requestedAmount, loginUsernameEntry.getText());
            JOptionPane.showMessageDialog(null, "Amount entered has been deposited.");

            infoCheckingAmountLabel.setText("$" + bankHandler.getCheckingAmount(email));
            refreshFrame();
        } catch (Exception exc) {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please enter a whole dollar amount.");
        } finally {
            infoNumberEntry.requestFocus();
        }
    }

    private void checkToSaveButtonClicked() {
                                                // Communicates with database to remove entry amount from checkAccount
                                                // and add the same amount to savingsAccount

        if (infoNumberEntry.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Entry cannot be empty");
            return;
        }

        String email = loginUsernameEntry.getText();
        try {
            bankHandler.checkingToSavings(Integer.parseInt(infoNumberEntry.getText()), email);

            infoCheckingAmountLabel.setText("$" + bankHandler.getCheckingAmount(email));
            infoSavingsAmountLabel.setText("$" + bankHandler.getSavingsAmount(email));
            refreshFrame();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    } // info

    private void saveToCheckButtonClicked() {
                                                    // Communicates with database to remove entry amount from savingsAccount
                                                    // and add the same amount to checkingAccount

        if (infoNumberEntry.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Entry cannot be empty");
            return;
        }

        String email = loginUsernameEntry.getText();
        try {
            bankHandler.savingsToChecking(Integer.parseInt(infoNumberEntry.getText()), email);

            infoCheckingAmountLabel.setText("$" + bankHandler.getCheckingAmount(email));
            infoSavingsAmountLabel.setText("$" + bankHandler.getSavingsAmount(email));
            refreshFrame();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    } // info


    //register account screen methods

    private void regCreateButtonClicked() {
                                                    // Creates user if all entries pass checks, and then switches
                                                    // to login page with user and pin pre-filled
        String email = regEmailEntry.getText();
        String name = regFullNameEntry.getText();
        String pin = String.valueOf(regPinEntry.getPassword());
        String confirmPin = String.valueOf(regPinConfirmEntry.getPassword());
        String address = regAddressEntry.getText();
        String phone = regPhoneEntry.getText();

        if (!checkAllEntries(email, pin, confirmPin, phone)) {
            return;
        }

        bankHandler.registerUser(email, pin, name, address, phone);

        loginUsernameEntry.setText(regEmailEntry.getText());
        switchToLogin(registrationPanel);
    }

    private void regReturnButtonClicked() {     // Calls switch to login page, fills login page with username
        loginUsernameEntry.setText(regEmailEntry.getText());
        switchToLogin(registrationPanel);
    }

    private boolean checkAllEntries(String email, String pin, String confirmPin, String phoneNumber) {
                                                                            //Checks each entry for valid input

        if (email.isBlank() || pin.isBlank()) {
            JOptionPane.showMessageDialog(null, "Entries cannot be empty.");
            return false;
        }

        if (!validateEmail(email)) {
            JOptionPane.showMessageDialog(null, "Email in incorrect format.");
            return false;
        }

        if (!validatePIN(pin, confirmPin)) {
            JOptionPane.showMessageDialog(null, "PIN in incorrect format. Please use 4 numbers.");
            return false;
        }

        if (!validatePhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(null, "Phone number in incorrect format.");
            return false;
        }


        return true;
    }

    private boolean validateEmail(String email) {    // ensures input is a .com/org/net domain
        return email.matches("[a-zA-Z1-9!@#$%^&*()-]*@[a-zA-Z]*(.com|.org|.net)");
    }

    private boolean validatePIN(String pin, String confirmPin) {
                                                                // ensures pins are numbers, the same, and 4 numbers long
        return pin.matches("[0-9]{4}") &&
                confirmPin.matches("[0-9]{4}") &&
                pin.length() == 4 &&
                confirmPin.length() == 4 &&
                pin.equals(confirmPin);
    }

    private boolean validatePhoneNumber(String phoneNumber) {            //Ensures the XXX-XXX-XXXX format
        return phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}");
    }




    //Methods that need fixing/tuning. These are inactive, not being used.
    private boolean validateName(String name) {     //Regex needs work
        return name.matches("[a-zA-Z]");
    }

    private boolean validateAddress(String address) { //Regex needs work
        return address.matches("[0-9a-zA-Z. ]");
    }
}