import userinterface.BankGUI;

public class App {

    public static void main(String[] args) {
        BankGUI gui = new BankGUI();

        //Temp info for testng purposes, user will enter their database info as args in the end product
        gui.start("jdbc:mysql://localhost:3306/bankDB", "root", "cm117670");

        //Notes to self
        //- Add closing statements on closing from window X
        //- Add ability to transfer funds between Checking and Savings
    }
}
