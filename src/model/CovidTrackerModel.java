package model;

public class CovidTrackerModel {
    private int numberOfPeople = 0;
    private int maskWearers = 0;
    private int numberOfCases = 0;
    private int numberOfDays = 0;
    private double newCases = 0;
    private int casesToday = 0;
    private String state = "";

    private int population = 0;
    private int maskers = 0;
    private int casesAlready = 0;
    private int dayToday = 0;

    private int min1 = 25;
    private int max1= 70;
    private int min2 = 0;
    private int max2 = 25;
    private int min3 = 0;
    private int max3 = 25;
    private int min4 = 1;
    private int max4 = 10;


    public CovidTrackerModel(){
        numberOfPeople = 0;
        maskWearers = 0;
        numberOfCases = 0;
        numberOfDays = 0;
        newCases = 0;
        state = "";

    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public int getMaskers() {
        return maskers;
    }

    public int getNumberOfCases() {
        return numberOfCases;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void calculateTotal(){
        double doubleMaskWearers = maskWearers;

        double calculationProportion = doubleMaskWearers / numberOfPeople;

        double doubleNumberOfDays = (double) numberOfDays;

        double exponent = calculationProportion * doubleNumberOfDays;

        double rate = Math.pow(2.72, exponent);

        newCases = rate * numberOfCases;
        int casesToday = (int)newCases;

    }

    public int getCasesToday(){
        return casesToday;
    }


}
