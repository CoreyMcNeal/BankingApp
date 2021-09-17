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


    public void start(String DBDirectory, String DBUser, String DBPassword) {
        bankHandler = new BankHandler(DBDirectory, DBUser, DBPassword);
        buildFrameAndPanels();
    }

    private void buildFrameAndPanels() {
        buildLoginPanel();
        buildInfoPanel();

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

        loginConnectButton = new JButton("Login with Credentials");
        loginConnectButton.setPreferredSize(new Dimension(200, 50));
        loginConnectButton.addActionListener(this);
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 10;
        loginPanel.add(loginConnectButton, loginConstraints);

        spaceMaker(loginConstraints, loginPanel, 0, 11, 20);

        loginRegisterButton = new JButton("Register with Credentials");
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

    private void switchToInfo() {
        frame.remove(loginPanel);
        frame.setSize(550, 700);
        frame.add(infoPanel);
        infoNumberEntry.requestFocus();
        refreshFrame();
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
            loginButtonClicked();

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

        }
    }

    private void loginButtonClicked() {

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
}