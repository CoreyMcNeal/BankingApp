import userinterface.BankGUI;

public class App {

    public static void main(String[] args) {
        BankGUI gui = new BankGUI();

        //gui.start(args[0], args[1], args[2]);
        gui.start("jdbc:mysql://localhost:3306/bankDB", "root", "cm117670");

        //To-Do-List
        // -Send registration page entries to the server. Make sure to check if the username already exists in loginInfo
        // -Add database file template to Github

    }
}
