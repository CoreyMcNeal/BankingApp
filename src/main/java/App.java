import userinterface.BankGUI;

public class App {

    public static void main(String[] args) {
        BankGUI gui = new BankGUI();

        //gui.start(args[0], args[1], args[2]);
        gui.start("jdbc:mysql://localhost:3306/bankDB", "root", "cm117670");

        //To-Do-List
        // -Add database file template to Github
        // -Make a back button for the registration page
    }
}
