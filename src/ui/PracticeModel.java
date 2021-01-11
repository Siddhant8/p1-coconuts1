package ui;

import java.io.*;

public class PracticeModel {
    int numPeople = 0;
    int numMaskers = 0;
    int numInitCases = 0;
    int numDays = 0;
    int casesToday = 0;

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

    public void calculateCases(){
        {
            getNumPeople();
            getNumMaskers();
            getNumInitCases();
            getNumDays();
        }

        int nonMaskWearers = numPeople - numMaskers;
        double doubleNonMaskWearers = nonMaskWearers;
        System.out.println(nonMaskWearers);
        double calculationProportion = doubleNonMaskWearers / numPeople;
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

    }

    public int getCasesToday(){
        return casesToday;
    }


}
