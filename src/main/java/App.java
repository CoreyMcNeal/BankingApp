import userinterface.BankGUI;

public class App {

    public static void main(String[] args) {
        BankGUI gui = new BankGUI();
        gui.start("jdbc:mysql://localhost:3306/bankDB", "root", "cm117670");

    }
}