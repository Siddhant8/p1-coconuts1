package ui;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        image = new ImageIcon("src/ui/jukebox.jpg").getImage();
        doneSign = new ImageIcon("src/ui/done.png").getImage();


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

                getContentPane().add(Cassetes.get(0));
                System.out.println("Added first cassete");


                for (int i = 0; i < Cassetes.size(); i++){
                    getContentPane().add(Cassetes.get(i)); //Displays the buttons
                }


            }


        });




        //Cassette firstCas = new Cassette("https://www.youtube.com/watch?v=TCFabT7arA4");

        //getContentPane().add(firstCas);

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

        /*TimerTask animateSign = new TimerTask(){

                    int counter = 13;

                    @Override
                    public void run() {
                        if (counter > 0) {
                            if (paintSign == 0) {
                                paintSign = 1;
                                System.out.println("1");

                            } else if (paintSign == 1) {
                                paintSign = 0;
                                System.out.println("0");
                            }
                            repaint();
                            counter --;
                        }
                        else {
                            System.out.println("Animation complete");
                            paintSign = 0;
                            repaint();
                            this.cancel();

                       }
                    }
                };*/


        /*

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (paintSign == 0) {
                    paintSign = 1;
                    System.out.println("1");

                } else if (paintSign == 1) {
                    paintSign = 0;
                    System.out.println("0");
                }
                repaint();
            }

        });*/


        playMusic.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {


                try {
                    control.setUrl(urlInput);

                    //Insert event-based animation here 1!!11!!1111


                    //timer.setRepeats(false);
                    //Note: including this here because using timer.stop after the for loop was not working. Maybe I need to use 5 .stops() because 5 timers are started?
                    Timer nu = new Timer();
                    MakeTask animateSign = new MakeTask();
                    nu.schedule(animateSign,0,1000);
                    //nu.cancel();
                    //nu.purge();

                    /*
                    for (int i = 0; i < 5; i++){
                        timer.start();
                        System.out.println("This is iteration " + i);

                    }*/

                    /**NOTE: a for loop will not work because a timers timing is not influenced by the iterations of the for loop*/
                    //timer.stop() <-- save this for future editions
                    //Alternate algorithms: Use even/odd in for loop. Use alternate painting method. Use a while loop. Recursion? Timer with action listener. Timerhelper
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                //String youtubeUrl = urlInput.getText();

            }
        });

        setVisible(true);
    }

    public void createCassetes(){

    }



    class DrawPane extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            //add draw image to paint
            g.drawImage(image,0, 0, null);
            if (paintSign == 1){
            g.drawImage(doneSign, 50, 50, null);
            }


        }
    }

    /**NEED a new class to paint a different image because it must be it's own object */

    public static void main(String args[]) { } //Dead code


}

