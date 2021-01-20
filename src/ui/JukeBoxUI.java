package ui;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

//Remember, this is for VIEW
public class JukeBoxUI extends JFrame {

    Image image;
    Image doneSign; //Need this image to paint the "done" symbol
    int paintSign = 0;

    ArrayList<Cassette> Cassetes = new ArrayList<Cassette>();


    public JukeBoxUI(JukeBoxControl control) throws IOException {
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBounds(100, 100, 500, 500);
        setSize(500,500);


        image = new ImageIcon("src/ui/jukebox.jpg").getImage();
        doneSign = new ImageIcon("src/ui/done.png").getImage();

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setContentPane(new DrawPane());


        JButton playMusic = new JButton("Click me to store some music!");

        JButton cassetteMaker = new JButton("Click me to create your cassettes!");


        JTextField urlInput = new JTextField("Type a Youtube URL in me!", 30);



        getContentPane().add(urlInput);
        getContentPane().add(playMusic);
        getContentPane().add(cassetteMaker);

        cassetteMaker.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {
                int iterationLimit = 0;//Use this to get number of items equal to text file
                try {
                    iterationLimit = control.getCassetteLength(); //Calls to control with an accessor
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("This is the iteration limit: " + iterationLimit);
                for (int i = 0; i < iterationLimit; i++){
                    try {
                        Cassetes.add(new Cassette(control.getCassette(i))); //Adds to the arrayList
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }//Fills out the Cassetes list. Can now add multiple buttons



                for (int i = 0; i < Cassetes.size(); i++){
                    getContentPane().add(Cassetes.get(i)); //Displays the buttons
                    repaint();
                    System.out.println("Repainted");
                }


            }


        });


        class MakeTask extends TimerTask{

            int counter = 3;

            @Override
            public void run() {
                if (counter > 0) {
                    if (paintSign == 0) {
                        paintSign = 1;
                        System.out.println("1");

                    } else if (paintSign == 1) {
                        paintSign = 0;
                    }
                    repaint();
                    counter --;
                }
                else {
                    paintSign = 0;
                    repaint();
                    this.cancel();

                }
            }
        }


        playMusic.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {


                try {
                    control.setUrl(urlInput);


                    Timer nu = new Timer();
                    MakeTask animateSign = new MakeTask();
                    nu.schedule(animateSign,0,1000);
                    /**NOTE: a for loop will not work because a timers timing is not influenced by the iterations of the for loop*/
                    //timer.stop() <-- save this for future editions
                    //Alternate algorithms: Use even/odd in for loop. Use alternate painting method. Use a while loop. Recursion? Timer with action listener. Timerhelper
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
        });

        setVisible(true);
    }




    class DrawPane extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            //add draw image to paint
            g.drawImage(image,0, 0, null);
            if (paintSign == 1){ //Use 0101 pattern to render and erase the sign
            g.drawImage(doneSign, 50, 50, null);
            }


        }
    }

    /**NEED a new class to paint a different image because it must be it's own object */

    public static void main(String args[]) { }


}

