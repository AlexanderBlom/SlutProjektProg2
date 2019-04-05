import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String ip = JOptionPane.showInputDialog(null, "IP?", "Connect to...", JOptionPane.QUESTION_MESSAGE);
        int port = Integer.parseInt(JOptionPane.showInputDialog(null, "port", "Connect to..", JOptionPane.QUESTION_MESSAGE));
        Socket socket = null;

        try {
            socket = new Socket(ip, port);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Client failed to connect");
        }

        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(JOptionPane.showInputDialog(null, "Vad är ditt meddelande?"));
            out.println(JOptionPane.showInputDialog(null, "Vilken nyckel vill du använda??"));


            String msg = in.readLine();
            System.out.println(msg);
            JOptionPane.showMessageDialog(null, msg, "Server said", JOptionPane.INFORMATION_MESSAGE);

            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Client has failed to communicate");
        }
    }
}
