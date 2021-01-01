package ui;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

//Remember, this is for VIEW
public class JukeBoxUI extends JFrame {

    Image image;

    public JukeBoxUI(){
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(null);

        image = new ImageIcon("src/jukebox.jpg").getImage();

        setContentPane(new DrawPane());

        JButton playMusic = new JButton("Click me to play the music");
        playMusic.setBounds(0, 0, 150, 50);


        getContentPane().add(playMusic);

        setVisible(true);
    }

    class DrawPane extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            //add draw image to paint
            g.drawImage(image,0, 0, null);


        }
    }

    public static void main(String args[]) { }


}

