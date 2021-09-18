import userinterface.BankGUI;

public class App {

    public static void main(String[] args) {
        BankGUI gui = new BankGUI();


        //gui.start(args[0], args[1], args[2]);
        gui.start("jdbc:mysql://localhost:3306/bankDB", "root", "cm117670");

        //To-Do-List
        // -Expand Registration to a whole panel, to enter in extra information like phone number and address
        // -Add database file template to Github


    }
}
