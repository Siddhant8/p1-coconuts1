package ui;

import java.io.*;
import java.lang.Math;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;

public class PracticeModel {
    public int numPeople = 0;
    public int numMaskers = 0;
    public int numInitCases = 0;
    public int numDays = 0;
    public int casesToday = 0;

    public String numCase = "";
    public String state = "";

    File storedCases = new File("covidCases.txt");


    Writer typer;

    public void setNumPeople(int population){
        numPeople = population;
        System.out.println(numPeople);

    }

    public void setNumMaskers(int maskers){
        numMaskers = maskers;
        System.out.println(numMaskers);
    }

    public void setNumInitCases(int cases){
        numInitCases = cases;
        System.out.println(numInitCases);
    }

    public void setNumDays(int days){
        numDays = days;
        System.out.println(numDays);
    }



    public int getNumPeople(){
        return numPeople;
    }

    public int getNumMaskers(){
        return numMaskers;
    }

    public int getNumInitCases(){
        return numInitCases;
    }

    public int getNumDays(){
        return numDays;
    }

    public void setCasesToday() throws IOException{
        {
            getNumPeople();
            getNumMaskers();
            getNumInitCases();
            getNumDays();
        }

        int nonMaskWearers = numPeople - numMaskers;
        double doubleNonMaskWearers = nonMaskWearers;
        System.out.println(nonMaskWearers);
        double calculationProportion = nonMaskWearers / numPeople;
        double dubNumMaskers = numMaskers;
        //double calculationProportion = dubNumMaskers/numPeople ;
        //double calculationProportion = 0.2;
        System.out.println(calculationProportion);
        System.out.println(numDays);
        double doubleNumberOfDays = (double) numDays;
        System.out.println(doubleNumberOfDays);
        double exponent = calculationProportion * doubleNumberOfDays;
        System.out.println(exponent);
        double rate = Math.pow(2.72, exponent);
        System.out.println(rate);
        double newCases = rate * numInitCases;
        casesToday = (int)newCases;
        System.out.println(newCases);
        System.out.println(casesToday);
        storedCases.createNewFile();
        typer = new BufferedWriter(new FileWriter(storedCases, true));
        if(casesToday >= numPeople){
            typer.write("Everyone has coronavirus. Stay at Home Order");
            typer.close();
        }else{

            numCase = String.valueOf(casesToday);
            //storedCases.createNewFile();
            //typer = new BufferedWriter(new FileWriter(storedCases, true));
            typer.write(numCase);
            typer.write("/n");
            typer.close();

        }

    }

    public int getCasesToday(){
        return casesToday;
    }

    /*public void setNumCase(){
        {
            getCasesToday();
        }
        numCase = String.valueOf(casesToday);
    }

    public String getNumCase(){
        return numCase;
    }*/




    public static void main(String[] args){

    }

}
