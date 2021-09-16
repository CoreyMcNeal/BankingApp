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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(550, 350);
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
    }


    private void buildInfoPanel() {
        infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        infoPanel.setLayout(new GridBagLayout());
        infoConstraints = new GridBagConstraints();

        infoWelcomeUserLabel = new JLabel("Welcome, " + loginUsernameEntry.getText() + "!");
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

        infoWithdrawButton = new JButton("Withdraw amount Entered");
        infoWithdrawButton.setPreferredSize(new Dimension(225, 100));
        infoWithdrawButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 12;
        infoPanel.add(infoWithdrawButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 15, 10);

        infoDepositButton = new JButton("Deposit amount entered");
        infoDepositButton.setPreferredSize(new Dimension(225, 100));
        infoDepositButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 16;
        infoPanel.add(infoDepositButton, infoConstraints);

        spaceMaker(infoConstraints, infoPanel, 0, 17, 30);

        infoExitButton = new JButton("Exit");
        infoExitButton.setPreferredSize(new Dimension(125, 75));
        infoExitButton.addActionListener(this);
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 18;
        infoPanel.add(infoExitButton, infoConstraints);

    }

    private void switchToInfo() {
        frame.remove(loginPanel);
        frame.setSize(550, 650);
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
        } else if (click.getSource() == infoExitButton) {
            System.exit(0);
        }
    }

    private void loginButtonClicked() {
        if (!checkUserAndPass()) {
            return;
        }

        String user = loginUsernameEntry.getText();
        String pin = String.valueOf(loginPasswordEntry.getPassword());
        if (!bankHandler.attemptLogin(user, pin)) {
            JOptionPane.showMessageDialog(null, "Login credentials invalid.");
            return;
        }
        switchToInfo();
    }

    private boolean checkUserAndPass() {

        if (loginUsernameEntry.getText().isBlank() || loginPasswordEntry.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Must enter a user and password");
            return false;
        }


        return true;
    }
}