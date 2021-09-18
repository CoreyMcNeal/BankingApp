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
    private JButton regExitButton;


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

    private void buildLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        loginPanel.setLayout(new GridBagLayout());
        loginConstraints = new GridBagConstraints();

        loginWelcomeLabel = new JLabel("Welcome to the Java Bank ATM", SwingConstants.CENTER);
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 0;
        loginPanel.add(loginWelcomeLabel, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 0, 1, 55);

        loginUsernameLabel = new JLabel("Username: ");
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 2;
        loginPanel.add(loginUsernameLabel, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 0, 3, 10);

        loginUsernameEntry = new JTextField();
        loginUsernameEntry.setPreferredSize(new Dimension(200, 20));
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 4;
        loginPanel.add(loginUsernameEntry, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 0, 5, 15);

        loginPasswordLabel = new JLabel("PIN");
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 6;
        loginPanel.add(loginPasswordLabel, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 0, 7, 10);

        loginPasswordEntry = new JPasswordField();
        loginPasswordEntry.setPreferredSize(new Dimension(200, 20));
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 8;
        loginPanel.add(loginPasswordEntry, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 0, 9, 20);

        loginConnectButton = new JButton("Login");
        loginConnectButton.setPreferredSize(new Dimension(200, 50));
        loginConnectButton.addActionListener(this);
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 10;
        loginPanel.add(loginConnectButton, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 0, 11, 20);

        loginRegisterButton = new JButton("Create a new Account");
        loginRegisterButton.setPreferredSize(new Dimension(200, 50));
        loginRegisterButton.addActionListener(this);
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 12;
        loginPanel.add(loginRegisterButton, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 0 , 13, 20);

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

        spaceMaker(infoConstraints, infoPanel, 0, 1, 40);

        infoCheckingLabel = new JLabel("Checking Account Amount: ");
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 2;
        infoPanel.add(infoCheckingLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 3, 15);

        //Enter received balance here
        infoCheckingAmountLabel = new JLabel("");
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 4;
        infoPanel.add(infoCheckingAmountLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 5, 25);

        infoSavingsLabel = new JLabel("Savings Account Amount: ");
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 6;
        infoPanel.add(infoSavingsLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 7, 15);

        //Enter received savings balanced here
        infoSavingsAmountLabel = new JLabel("");
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 8;
        infoPanel.add(infoSavingsAmountLabel, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 9, 25);

        infoNumberEntry = new JTextField();
        infoNumberEntry.setPreferredSize(new Dimension(200, 20));
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 10;
        infoPanel.add(infoNumberEntry, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 11, 10);

        infoWithdrawButton = new JButton("Withdraw amount in dollars");
        infoWithdrawButton.setPreferredSize(new Dimension(225, 75));
        infoWithdrawButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 12;
        infoPanel.add(infoWithdrawButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 15, 10);

        infoDepositButton = new JButton("Deposit amount in dollars");
        infoDepositButton.setPreferredSize(new Dimension(225, 75));
        infoDepositButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 16;
        infoPanel.add(infoDepositButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 17, 30);

        infoCheckToSaveButton = new JButton("Transfer From Checking to Savings");
        infoCheckToSaveButton.setPreferredSize(new Dimension(270, 50));
        infoCheckToSaveButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 18;
        infoPanel.add(infoCheckToSaveButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 19, 15);

        infoSaveToCheckButton = new JButton("Transfer From Savings to Checking");
        infoSaveToCheckButton.setPreferredSize(new Dimension(270, 50));
        infoSaveToCheckButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 20;
        infoPanel.add(infoSaveToCheckButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 21, 20);

        infoExitButton = new JButton("Exit");
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

        spaceMaker(regConstraints, registrationPanel, 0, 1, 10);

        regEmailEntry = new JTextField();
        regEmailEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 2;
        registrationPanel.add(regEmailEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 3, 20);

        regPinLabel = new JLabel("PIN Number (4 digits): ");
        regConstraints.gridx = 0;
        regConstraints.gridy = 4;
        registrationPanel.add(regPinLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 5, 10);

        regPinEntry = new JPasswordField();
        regPinEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 6;
        registrationPanel.add(regPinEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 7, 20);

        regPinConfirmLabel = new JLabel("Confirm PIN: ");
        regConstraints.gridx = 0;
        regConstraints.gridy = 8;
        registrationPanel.add(regPinConfirmLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 9, 10);

        regPinConfirmEntry = new JPasswordField();
        regPinConfirmEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 10;
        registrationPanel.add(regPinConfirmEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 11, 20);

        regFullNameLabel = new JLabel("Enter Full Name: ");
        regConstraints.gridx = 0;
        regConstraints.gridy = 12;
        registrationPanel.add(regFullNameLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 13, 10);

        regFullNameEntry = new JTextField();
        regFullNameEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 14;
        registrationPanel.add(regFullNameEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 15, 20);

        regAddressLabel = new JLabel("Street Address:");
        regConstraints.gridx = 0;
        regConstraints.gridy = 16;
        registrationPanel.add(regAddressLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 17, 10);

        regAddressEntry = new JTextField();
        regAddressEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 18;
        registrationPanel.add(regAddressEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 19, 20);

        regPhoneLabel = new JLabel("Phone Number (Format: XXX-XXX-XXXX):");
        regConstraints.gridx = 0;
        regConstraints.gridy = 20;
        registrationPanel.add(regPhoneLabel, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 21, 10);

        regPhoneEntry = new JTextField();
        regPhoneEntry.setPreferredSize(new Dimension(300, 20));
        regConstraints.gridx = 0;
        regConstraints.gridy = 22;
        registrationPanel.add(regPhoneEntry, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 23, 20);

        regSubmitButton = new JButton("Submit");
        regSubmitButton.addActionListener(this);
        regSubmitButton.setPreferredSize(new Dimension(200, 100));
        regConstraints.gridx = 0;
        regConstraints.gridy = 24;
        registrationPanel.add(regSubmitButton, regConstraints);

        spaceMaker(regConstraints, registrationPanel, 0, 25, 20);

        regExitButton = new JButton("Exit");
        regExitButton.addActionListener(this);
        regExitButton.setPreferredSize(new Dimension(200, 100));
        regConstraints.gridx = 0;
        regConstraints.gridy = 26;
        registrationPanel.add(regExitButton, regConstraints);
    }

    private void spaceMaker(GridBagConstraints constraints, JPanel panel,
                            int gridx, int gridy, int space) {                             //Method to help space out the components
        JLabel spacerTest = new JLabel("");
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        spacerTest.setPreferredSize(new Dimension(0, space));
        panel.add(spacerTest, constraints);
    }

    private void refreshFrame() {
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent click) {

        if (click.getSource() == loginConnectButton) {
            loginConnectButtonClicked();

        } else if (click.getSource() == loginRegisterButton) {
            switchToReg();

        } else if (click.getSource() == loginExitButton) {
            bankHandler.closeConnection();
            System.exit(0);

        } else if (click.getSource() == infoExitButton) {
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
            if (!checkAllEntries(regEmailEntry.getText(),
                                 String.valueOf(regPinEntry.getPassword()),
                                 String.valueOf(regPinConfirmEntry.getPassword()),
                                 regPhoneEntry.getText())) {
                return;
            }

            JOptionPane.showMessageDialog(null, "Valid");
            //Code to create user goes here
        } else if (click.getSource() == regExitButton) {
            bankHandler.closeConnection();
            System.exit(0);
        }
    }

    private void loginConnectButtonClicked() {

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

    private void switchToInfo() {
        frame.remove(loginPanel);
        frame.setSize(550, 700);
        frame.add(infoPanel);
        infoNumberEntry.requestFocus();
        refreshFrame();
    }

    private void loginRegisterButtonClicked() {
        String email = loginUsernameEntry.getText();
        String pin = String.valueOf(loginPasswordEntry.getPassword());

        if (email.isBlank() || pin.isBlank()) {
            JOptionPane.showMessageDialog(null, "Entries cannot be empty.");
        }

        if (!validateEmail(email)) {
            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return;
        }

        bankHandler.registerUser(email, pin);
    }

    private void switchToReg() {
        frame.remove(loginPanel);
        frame.setSize(550, 700);
        frame.add(registrationPanel);
        regEmailEntry.setText(loginUsernameEntry.getText());
        regPinEntry.setText(String.valueOf(loginPasswordEntry.getPassword()));
        if (loginUsernameEntry.getText().length() > 0) {
            regPinConfirmEntry.requestFocus();
        } else if (loginUsernameEntry.getText().length() == 0) {
            regEmailEntry.requestFocus();
        }

        refreshFrame();
    }

    private boolean validateEmail(String email) {
        return email.matches("[a-zA-Z1-9!@#$%^&*()-]*@[a-zA-Z]*(.com|.org|.net)");
    }

    private boolean validatePIN(String pin, String confirmPin) {
        return pin.matches("[0-4]{4}") &&
                confirmPin.matches("[0-4]{4}") &&
                pin.length() == 4 &&
                confirmPin.length() == 4 &&
                pin.equals(confirmPin);
    }

    private boolean validateName(String name) {     //Regex needs work
        return name.matches("[a-zA-Z]");
    }

    private boolean validateAddress(String address) { //Regex needs work
        return address.matches("[0-9a-zA-Z. ]");
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}");
    }

    private void withdrawButtonClicked() {
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

    private void depositButtonClicked() {
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
    }

    private void saveToCheckButtonClicked() {
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
    }

    private boolean checkAllEntries(String email, String pin, String confirmPin, String phoneNumber) {

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
}