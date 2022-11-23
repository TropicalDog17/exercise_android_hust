package com.example.myconverter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText editFrom, editTo;
    TextView textFrom, textTo;
    Resources res;
    double rate;
    String fromCurrency = "USD";
    String toCurrency = "VND";
    Double fromWeight, toWeight;
    static HashMap<String, Double> currencyWeight = ConstantValues.currencyWeight;
    int CHANGE_CURRENCY_REQUEST_CODE = 123456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();

        //Default currency

        updateCurrencyText();
        updateCurrencyWeight();
        editFrom = findViewById(R.id.edit_from);
        editTo = findViewById(R.id.edit_to);

        findViewById(R.id.button_convert).setOnClickListener(view -> {
            String fromStr = editFrom.getText().toString();
            if(fromStr.isEmpty()){
                return ;
            }
            double from = Double.parseDouble(fromStr);
            editTo.setText(convertTo(from, rate));
        });
        findViewById(R.id.button_clear).setOnClickListener(view -> {
            clearInput();
        });
        findViewById(R.id.button_change_currency).setOnClickListener(view -> {
            Intent intent = new Intent(this, Conversion.class);
            intent.putExtra("fromCurrency", fromCurrency);
            intent.putExtra("toCurrency", toCurrency);
            startActivityForResult(intent, CHANGE_CURRENCY_REQUEST_CODE);

        });
        editFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String fromStr = editable.toString();
                if (fromStr.length() == 0) {
                    return;
                }
                Double from = Double.parseDouble(fromStr);
                editTo.setText(convertTo(from, rate));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CHANGE_CURRENCY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                fromCurrency = data.getStringExtra("fromCurrency");
                toCurrency = data.getStringExtra("toCurrency");
                updateCurrencyText();
                updateCurrencyWeight();
                clearInput();
            }
        }

    }


    private String convertTo(double from, double rate){
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(10);
        df.setMinimumIntegerDigits(1);
        return df.format(from * rate);
    }
    private void updateCurrencyText(){
        textFrom = findViewById(R.id.text_from);
        textTo = findViewById(R.id.text_to);

        textFrom.setText(res.getString(R.string.from," " + fromCurrency ));
        textTo.setText(res.getString(R.string.to, " "+ toCurrency));
    }
    private void updateCurrencyWeight(){

        fromWeight = currencyWeight.get(fromCurrency);
        toWeight = currencyWeight.get(toCurrency);

        rate = fromWeight / toWeight;
    }
    private void clearInput(){
        editFrom.setText("");
        editTo.setText("");
    }
}