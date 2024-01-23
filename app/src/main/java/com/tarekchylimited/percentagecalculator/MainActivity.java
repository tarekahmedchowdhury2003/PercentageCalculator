package com.tarekchylimited.percentagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText editTextBillAmount;

    private SeekBar seekBarTipPercentage;

    private TextView textViewPercentage, textViewResult;

    private Button buttonCalculateTip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);

        seekBarTipPercentage = findViewById(R.id.seekBarTipPercentage);

        textViewPercentage = findViewById(R.id.textViewPercentage);
        buttonCalculateTip = findViewById(R.id.buttonCalculateTip);
        textViewResult = findViewById(R.id.textViewResult);

        seekBarTipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean formUser) {
                textViewPercentage.setText("Tip Percentage: "+ progress +"%" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calculateTip(View view) {

        String billAmountString = editTextBillAmount.getText().toString();

        if (billAmountString.isEmpty()) {


            return;
        }

        double billAmount = Double.parseDouble(billAmountString);

        int tipPercentage = seekBarTipPercentage.getProgress();

        double tip = (billAmount * tipPercentage) /100;

        textViewResult.setText(String.format("Tip: $%.2f",tip));
    }
}