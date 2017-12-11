package edu.niu.cs.skiles.burgers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    //instance vars
    private RadioGroup pattyRG;
    private CheckBox baconCB;
    private RadioGroup cheeseRG;
    private SeekBar sauceSB;
    private TextView calorieTV;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the burger object
        burger = new Burger();

        //connect var and screen items
        pattyRG = (RadioGroup) findViewById(R.id.pattyType);
        baconCB = (CheckBox) findViewById(R.id.baconButton);
        cheeseRG = (RadioGroup) findViewById(R.id.cheeseType);
        sauceSB = (SeekBar) findViewById(R.id.sauceSeekBar);
        calorieTV = (TextView) findViewById(R.id.calorieView);

        //display the initial calorie count
        displayCalories();

        //set up the listeners
        pattyRG.setOnCheckedChangeListener(burgerListener);

        cheeseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.noCheeseButton:
                        burger.setCheeseCalories(0);
                        break;

                    case R.id.cheddarButton:
                        burger.setCheeseCalories(Burger.CHEDDAR);
                        break;

                    case R.id.mozzButton:
                        burger.setCheeseCalories(Burger.MOZZ);
                        break;
                }

                displayCalories();
            } //end OnCheckedChange
        }); //end  of setOnCheckedChangeListener for cheese

        baconCB.setOnClickListener(baconListener);
        sauceSB.setOnSeekBarChangeListener(sauceListener);
    } //end onCreate

    private RadioGroup.OnCheckedChangeListener burgerListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.beefButton:
                    burger.setPattyCalories(Burger.BEEF);
                    break;

                case R.id.turkeyButton:
                    burger.setPattyCalories(Burger.TURKEY);
                    break;

                case R.id.veggieButton:
                    burger.setPattyCalories(Burger.VEGGIE);
                    break;
            }

            displayCalories();
        } //end onCheckedChange
    }; //end burgerListener

    //handle the checkbox
    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (((CheckBox)v).isChecked())
                burger.setBaconCalories(true);

            else
                burger.setBaconCalories(false);

            displayCalories();
        }
    }; //end baconListener

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCalories(seekBar.getProgress());

            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    }; //end sauceListener

    private void displayCalories() {
        calorieTV.setText("Calories: " + burger.getTotalCalories());
    }
} //end MainActivity
