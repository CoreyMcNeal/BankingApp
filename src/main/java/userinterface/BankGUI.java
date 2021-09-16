package userinterface;

import logic.BankHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI implements ActionListener {

    private JFrame frame;
    private BankHandler bankHandler;

    //Add code for infoPanel

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

    private JLabel infoWelcomeUser;
    private JLabel infoCheckingLabel;
    private JLabel infoCheckingAmountLabel;
    private JLabel infoSavingsLabel;
    private JLabel infoSavingsAmountLabel;
    private JTextField infoWithdrawEntry;
    private JButton infoWithdrawButton;
    private JTextField infoDepositEntry;
    private JButton infoDepositButton;
    private JButton infoExitButton;


    public void start(String DBDirectory, String DBUser, String DBPassword) {
        bankHandler = new BankHandler(DBDirectory, DBUser, DBPassword);
        buildFrameAndPanels();
    }

    private void buildFrameAndPanels() {
        buildLoginPanel();

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
        // Add code here that builds the bank info panel
    }

    private void switchToInfo() {
        // Add code here that switches to bank information panel
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
            if (!checkUserAndPass()) {
                return;
            }

            String user = loginUsernameEntry.getText();
            String pin = String.valueOf(loginPasswordEntry.getPassword());
            if (bankHandler.attemptLogin(user, pin)) {

                //Add code here to call the transition panels method, and also grab bank info from SQL database

            }
        }
    }

    private boolean checkUserAndPass() {

        if (loginUsernameEntry.getText().isBlank() || loginPasswordEntry.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Must enter a user and password");
            return false;
        }


        return true;
    }
}