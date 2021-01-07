package ui;


import java.io.*;

public class JukeBoxModel {

    String youtubeUrl = "";

    File storedUrls = new File("storedUrls.txt");
    //Remember to add the file type at the end!111!111!1111
    Writer typer;

    public void setUrl(String url) throws IOException {
        youtubeUrl = url;
        System.out.println("This is the gathered URL " + youtubeUrl);

        if (!(storedUrls.exists())) {
            System.out.println("Creating new file");
            storedUrls.createNewFile();
        }


        typer = new BufferedWriter(new FileWriter(storedUrls, true));
        //The true is for the append boolean. By setting it to true, we'll only ever append strings to new lines
        typer.write(youtubeUrl);
        typer.write("\n");
        //The above is necessary to add a line break between urls, which is critical to reading the whole.txt file
        typer.close();

        //Need to fix how the file continues to clear each tie time this runs
    }
}
