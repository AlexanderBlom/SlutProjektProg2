import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {
    JPanel GUI;
    private JTextArea msgArea;
    private JTextArea cryptArea;
    private JButton openButton;
    private JButton saveButton;
    private JTextField key;
    private JButton cryptButton;
    private JTextField Ip;
    private JTextField Port;
    private JButton connectButton;

    /**
     * Returns the gui.
     * @return gui.
     */
    public Container getGUI() {
        return GUI;
    }

    /**
     * Connects the actionListener to the cryptButton.
     * @param listenForCryptButton
     */
    void addCryptListener(ActionListener listenForCryptButton){
        cryptButton.addActionListener(listenForCryptButton);
    }

    /**
     * Connects the actionListener to the connectButton.
     * @param listenForConnect
     */
    void addConnectListener(ActionListener listenForConnect){
        connectButton.addActionListener(listenForConnect);
    }

    /**
     * Connects the actionListener to the openButton.
     * @param listenForOpen
     */
    void addOpenListener(ActionListener listenForOpen){
        openButton.addActionListener(listenForOpen);
    }

    public String getIp() {
        return Ip.getText();
    }

    /**
     * Returns the port from the port textField.
     * @return port used in connecting to server.
     */
    public int getPort() {
        return Integer.parseInt(Port.getText());
    }

    /**
     * Returns the message from the msgArea textArea.
     * @return message used in encryption.
     */
    public String getMsg() {
        return msgArea.getText();
    }

    /**
     * Returns the key from key textArea.
     * @return key used in encryption.
     */
    public String getKey() {
        return key.getText();
    }

    /**
     * Displays the encrypted message on the cryptArea textArea.
     * @param crypt The encrypted message.
     */
    public void setCryptArea(String crypt) {
        cryptArea.setText(crypt);
    }

    /**
     * Displays the message on the msgArea textArea.
     * @param msg The unencrypted message.
     */
    public void setMsgArea(String msg) {
        msgArea.setText(msg);
    }
}


