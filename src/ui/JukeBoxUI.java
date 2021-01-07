package ui;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

//Remember, this is for VIEW
public class JukeBoxUI extends JFrame {

    Image image;

    public JukeBoxUI(JukeBoxControl control){
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        image = new ImageIcon("src/ui/jukebox.jpg").getImage();

        setContentPane(new DrawPane());

        JButton playMusic = new JButton("Click me to play the music");


        JTextField urlInput = new JTextField("Type a Youtube URL in me!", 30);



        getContentPane().add(urlInput);
        getContentPane().add(playMusic);

        playMusic.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {


                try {
                    control.setUrl(urlInput);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                //String youtubeUrl = urlInput.getText();

            }
        });

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

