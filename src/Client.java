import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String ip = (String) JOptionPane.showInputDialog(null, "IP?", "Connect to...", JOptionPane.QUESTION_MESSAGE);
        int port = Integer.parseInt(JOptionPane.showInputDialog(null, "port", "Connect to..", JOptionPane.QUESTION_MESSAGE));
        Socket socket = null;

        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(JOptionPane.showInputDialog(null, "Name?" ,"Identify yourself"));

            String msg = in.readLine();
            JOptionPane.showMessageDialog(null, msg, "Server said", JOptionPane.INFORMATION_MESSAGE);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
