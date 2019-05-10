import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {

    PrintWriter out;
    BufferedReader in;
       /* try {
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
        }*/

    public void connect(String ip, int port) {
        Socket socket = null;
        try {
            socket = new Socket(ip, port);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Client failed to connect");
        }

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Du är nu ansluten till servern");
    }
    

    public String crypt(String msg, String key) {
        String crypt = null;

            out.println(msg);
            out.println(key);

            try {
                crypt = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return crypt;
        }

    public String openFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        String fileName = chooser.getSelectedFile().getAbsolutePath();

        System.out.println(fileName);

        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader inFil = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();

        String i = "";

        try {
            i = inFil.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(i != null) {
            sb.append(i + "\n");
            try {
                i = inFil.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String file = sb.toString();
        return file;
    }
}
