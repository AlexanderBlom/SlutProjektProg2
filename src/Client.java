import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 *
 */
public class Client {
    PrintWriter out;
    BufferedReader in;

    /**
     * Connects the client to the server.
     * @param ip the ip address used to connect to the server.
     * @param port the port used to connect to the server.
     */
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

    /**
     * Send the message and key used in encryption to the server.
     * @param msg the message used in encryption.
     * @param key the key used in encryption.
     * @return the encrypted message.
     */
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

    /**
     * Uses JFileChooser to get the path for the file used in encryption.
     * @return the content of the file as a string with line breaks.
     */
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
