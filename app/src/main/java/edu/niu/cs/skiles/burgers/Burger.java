package edu.niu.cs.skiles.burgers;

/**
 * Created by z1638506 on 2/9/2016.
 */
public class Burger {
    //constants
    static final int BEEF = 90, TURKEY = 170, VEGGIE = 150,
                     CHEDDAR = 113, MOZZ = 78,
                     BACON = 86;

    //instance variables
    private int pattyCalories, cheeseCalories, baconCalories, sauceCalories;

    public Burger () {
        pattyCalories = BEEF;
        cheeseCalories = 0;
        baconCalories = 0;
        sauceCalories = 0;
    }//end Constructor

    public void setPattyCalories (int newCalories) {
        pattyCalories = newCalories;
    }

    public void setCheeseCalories (int newCalories) {
        cheeseCalories = newCalories;
    }

    public void setSauceCalories (int newCalories) {
        sauceCalories = newCalories;
    }

    public void setBaconCalories (boolean hasBacon) {
        baconCalories = hasBacon? BACON : 0;
    }

    public int getTotalCalories () {
        return pattyCalories + cheeseCalories + sauceCalories + baconCalories;
    }
} //end Burger class
