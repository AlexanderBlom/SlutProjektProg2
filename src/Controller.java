import javax.swing.*;
public class Controller {
    private GUI view;
    private Model model;

    public Controller(GUI view, Model model){
        this.view = view;
        this.model = model;

        JFrame frame = new JFrame("KryptGUI");
        frame.setContentPane(view.getGUI());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
