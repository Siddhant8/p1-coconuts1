package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Cassette extends JButton { //MUST extend JButton so that we can automatically initialize a JButton AND define all the
    //Necessary stuff in the constructor

    String link;
    public Cassette (String url){

        //NOTE: the JFrame uses a box layout so don't worry about defining x, y positions

        link = url; //Saving this here in case the parameter disappears after object is created
        this.setText(url);

        /*

        ImageIcon iconA = new ImageIcon("cassette.png");

        Dimension d = new Dimension(iconA.getIconWidth(), iconA.getIconHeight());

        //this.setPreferredSize(d);//Set to size of the imported image

        this.setSize(iconA.getIconWidth(), iconA.getIconHeight());
        this.setIcon(iconA);*/
        /*
        * The above is dead, but will be revisited in the future
        *
        * It's for setting the button to an image background rather than a plain old button
        *
        * */


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(link));
                    //Open the youtube URL
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }


        });

    }
}
