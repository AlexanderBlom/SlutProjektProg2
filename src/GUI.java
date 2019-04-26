import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {
    JPanel GUI;
    private JTextArea msg;
    private JTextArea cryptArea;
    private JButton openButton;
    private JButton saveButton;
    private JTextField key;
    private JButton cryptButton;
    private JTextField Ip;
    private JTextField Port;
    private JButton connectButton;

    public Container getGUI() {
        return GUI;
    }

    void addCryptListener(ActionListener listenForCryptButton){
        cryptButton.addActionListener(listenForCryptButton);
    }

    public String getIp() {
        return Ip.getText();
    }

    public int getPort() {
        return Integer.parseInt(Port.getText());
    }

    void addConnectListener(ActionListener listenForConnect){
        connectButton.addActionListener(listenForConnect);
    }

    public String getMsg() {
        return msg.getText();
    }

    public String getKey() {
        return key.getText();
    }

    public void setCryptArea(String crypt) {
        cryptArea.setText(crypt);
    }
}
