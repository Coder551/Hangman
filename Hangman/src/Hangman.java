import javax.swing.*;
import java.util.*;
import java.io.*;


public class Hangman {
    public static ArrayList<String> words = new ArrayList<>();
    static String word = words.get((int) (Math.random() * words.size()));
    static String dash;
    static int count = 0;

    public static String getWords() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Sports.txt"));
        try {
            String line = br.readLine();
            while (line != null)
            {
                words.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        word = words.get((int) (Math.random() * words.size()));
        br.close();
        return word;
    }

    public static void Guess() throws IOException {
        HangmanSetup hm = new HangmanSetup();
        word = words.get((int) (Math.random() * words.size()));
        dash = new String(new char[word.length()]).replace("\0", "-");

        while(count < 7 && dash.contains("-"))
        {
            hm.label.setText("Guess any letter in the word");
            hm.text.setText(dash);
            String guess = hm.input;
            hang(guess);
        }
    }

    public static void hang(String guess) {


        try {
            getWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String newDash = "";
        for(int i = 0; i < word.length(); i++)
        {
            if(".*\\d.*".matches(word))
            JOptionPane.showMessageDialog(HangmanSetup.frame, "Error");

            if(word.charAt(i) == guess.charAt(0))
            {
                newDash += guess.charAt(0);
            }
            else if (dash.charAt(i) != '-')
            {
                newDash += word.charAt(i);
            }
            else
            {
                newDash += "-";
            }
        }
        if(dash.equals(newDash)) {
            count++;
            hangmanImage();
        }
        else {
            dash = newDash;
        }
        if(dash.equals(word)){
            HangmanSetup hm = new HangmanSetup();
            hm.label.setText("Correct! You win, the word was " + word);
        }
    }

    public static void hangmanImage(){
        // create and call hangmanImage starting with count == 1 from the Hangman_Setup Class
    }



}
