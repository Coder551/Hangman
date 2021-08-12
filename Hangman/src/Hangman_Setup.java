import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class HangmanSetup implements ActionListener {

    JButton b1;
    JPanel panel;
    static JFrame frame;
    JLabel label;
    String input;
    JTextField text;

    public HangmanSetup()
    {
         b1 = new JButton("Enter");
         panel = new JPanel();
         label = new JLabel("Please enter your guess: ");
         frame = new JFrame("Hangman");
         text = new JTextField("Here");
         panel.add(label);
         panel.add(text);
         panel.add(b1);
         text.addActionListener(this);
         b1.addActionListener(this);
         frame.add(panel);
         panel.setBackground(Color.pink);
         frame.setSize(500,500);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1)
        {
            try {
                Hangman.Guess();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}