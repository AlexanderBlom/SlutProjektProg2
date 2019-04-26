public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        Client client = new Client();
        Controller controller = new Controller(gui, client);
    }
}
