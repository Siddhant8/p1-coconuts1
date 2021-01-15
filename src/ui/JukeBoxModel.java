package ui;


import java.io.*;
import java.util.ArrayList;

public class JukeBoxModel {

    String youtubeUrl = "";

    ArrayList<String> collectUrls = new ArrayList<String>();

    File storedUrls = new File("storedUrls.txt");
    //Remember to add the file type at the end!111!111!1111
    Writer typer;

    public void setUrl(String url) throws IOException {
        youtubeUrl = url;
        System.out.println("This is the gathered URL " + youtubeUrl);

        //java.awt.Desktop.getDesktop().browse(java.net.URI.create(youtubeUrl));
        //Open the youtube URL <-- add to later (in model section)


        if (!(storedUrls.exists())) {
            System.out.println("Creating new file");
            storedUrls.createNewFile();
        }


        typer = new BufferedWriter(new FileWriter(storedUrls, true));
        //The true is for the append boolean. By setting it to true, we'll only ever append strings to new lines
        /**ADD a control flow statement to prevent the addition of multiple URLS of the same thing**/

        if (collectUrls.contains(youtubeUrl)){ //To prevent same thing from being added multiple times
            typer.write(youtubeUrl);
            collectUrls.add(youtubeUrl); //Adding this here outside arrangeUrls in case they add multiple Urls BEFORE pressing "build casettes"
        }
        else {
            System.out.println("URL already added");
        }
        typer.write("\n");
        //The above is necessary to add a line break between urls, which is critical to reading the whole.txt file
        typer.close();

        //Need to fix how the file continues to clear each tie time this runs

        arrangeUrls();
    }

    public void arrangeUrls() throws IOException{ //To be triggered upon pressing "build casettes"
        BufferedReader br = new BufferedReader(new FileReader("storedUrls.txt"));
        String currentLine;
        collectUrls.clear(); //MUST clear arrayList in order to prevent duplicate URL's
        /**
         * Need to delete any buttons made with old URL
         * For button name if not in list, delete
         * */
        while ((currentLine = br.readLine()) != null) {
            collectUrls.add(currentLine);
        }//Fills out the array list


        System.out.println("This is the list " + collectUrls);

    }
}
