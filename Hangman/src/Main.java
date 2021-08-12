import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


class Main extends WindowAdapter implements ActionListener {

    JFrame frame;
    public final JRadioButton r1;
    private final JRadioButton r2;
    private final JRadioButton r3;
    private final JRadioButton r4;
    private final JRadioButton r5;
    ButtonGroup bg;
    JPanel panel;
    JLabel label;
    JButton b1;

    public Main()
    {
        frame = new JFrame("Hangman");
        panel = new JPanel();
        bg = new ButtonGroup();
        b1 = new JButton("Next");
        label = new JLabel("Pick the Category to play from:");
        panel.add(label);
        panel.setBackground(Color.pink);

        r1 = new JRadioButton("Sports");
        r2 = new JRadioButton("Music");
        r3 = new JRadioButton("Food");
        r4 = new JRadioButton("Technology");
        r5 = new JRadioButton("Misc");

        JRadioButton[] radioButtons = new JRadioButton[]{r1, r2, r3, r4, r5};

        for (JRadioButton radioButton : radioButtons) {
            bg.add(radioButton);
            panel.add(radioButton);
            radioButton.addActionListener(this);

        }
        b1.addActionListener(this);
        panel.add(b1);
        r1.setSelected(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,170);
        frame.setVisible(true);
        frame.addWindowListener(this);
        frame.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == r1){
        b1.addActionListener(e1 -> {
            new HangmanSetup();
            frame.setVisible(false);
        });}
        else if(e.getSource() == r2) {
            b1.addActionListener(e1 -> {
                frame.dispose();
            });
        }
    }

    public void windowClosing(WindowEvent e)
    {
        frame.dispose();
        Runtime.getRuntime().exit(1);
    }

    public static void main(String[] args) {
        new Main();
    }
}