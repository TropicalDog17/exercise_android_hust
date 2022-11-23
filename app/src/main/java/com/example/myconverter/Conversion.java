package com.example.myconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Conversion extends AppCompatActivity {
    RadioGroup fromCurrencyGroup, toCurrencyGroup;

    //State
    String fromCurrency;
    String toCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        Intent intent = getIntent();
        fromCurrency = intent.getStringExtra("fromCurrency");
        toCurrency = intent.getStringExtra("toCurrency");
        fromCurrencyGroup = findViewById(R.id.from_currency_group);
        toCurrencyGroup = findViewById(R.id.to_currency_group);
        int count = fromCurrencyGroup.getChildCount();
        int index = 0;
        for(int i = 0; i < count; i++) {
            View v1 = fromCurrencyGroup.getChildAt(i);
            View v2 = toCurrencyGroup.getChildAt(i);


            if (v1 instanceof RadioButton) {
                String temp = ConstantValues.currency.get(index);


                if(temp.equals(fromCurrency)){
                    ((RadioButton) v1).setEnabled(true);
                    fromCurrencyGroup.check(v1.getId());
                }
                if(temp.equals(toCurrency)){
                    ((RadioButton) v2).setEnabled(true);
                    toCurrencyGroup.check(v2.getId());
                }

                ((RadioButton) v1).setText(ConstantValues.currency.get(index));
                ((RadioButton) v2).setText(ConstantValues.currency.get(index));
                index++;
            }

        }

        findViewById(R.id.button_ok).setOnClickListener(view -> {
            intent.putExtra("fromCurrency", fromCurrency);
            intent.putExtra("toCurrency", toCurrency);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
    }


    public void onFromRadioButtonClicked(View view) {
        if(((RadioButton) view).isChecked()){
            fromCurrency = ((RadioButton) view).getText().toString();
        }
    }

    public void onToRadioButtonClicked(View view) {
        if(((RadioButton) view).isChecked()){
            toCurrency = ((RadioButton) view).getText().toString();
        }
    }
}