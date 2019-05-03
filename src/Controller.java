import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
    private GUI view;
    private Client client;

    public Controller(GUI view, Client client){
        this.view = view;
        this.client = client;

        JFrame frame = new JFrame("KryptGUI");
        frame.setContentPane(view.getGUI());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        this.view.addCryptListener(new CryptListener());
        this.view.addConnectListener(new ConnectListener());
    }

    class CryptListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!view.getKey().isEmpty() && !view.getMsg().isEmpty())
                view.setCryptArea(client.crypt(view.getMsg(), view.getKey()));
            else JOptionPane.showMessageDialog(null, "Du måste ange en nyckel och meddelande");
        }
    }

    class ConnectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           client.connect(view.getIp(), view.getPort());
        }
    }
}
