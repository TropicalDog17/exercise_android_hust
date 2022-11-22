package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    EditText edFirstName, edLastName, edBirthday, edAddress, edEmail;
    boolean isAllChecked = false;

    RadioGroup rgGender;
    RadioButton rgLastChild;
    CheckBox cbTerm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.submit_button);

        edFirstName = findViewById(R.id.first_name_input);
        edLastName = findViewById(R.id.last_name_input);
        edAddress = findViewById(R.id.address_input);
        edEmail = findViewById(R.id.email_input);
        edBirthday = findViewById(R.id.birthday_input);
        rgGender = findViewById(R.id.gender_radio);
        rgLastChild = findViewById(R.id.radioButton5); //HARDCODE!
        cbTerm = findViewById(R.id.checkBox);
        submitButton.setOnClickListener(view -> {
            isAllChecked = checkAll();
            if (isAllChecked) {
                Context context = getApplicationContext();
                CharSequence text = "Form is valid!";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, text, duration).show();
            }

        });

    }
    private boolean checkAll(){
        boolean temp = true;
        if (edFirstName.length() == 0){
            edFirstName.setError("This field is required");
            temp = false;
        }
        if (edLastName.length() == 0){
            edLastName.setError("This field is required");
            temp = false;
        }
        if (edBirthday.length() == 0){
            edBirthday.setError("This field is required");
            temp = false;
        }
        if (edAddress.length() == 0){
            edAddress.setError("This field is required");
            temp = false;
        }
        if(edEmail.length() == 0){
            edEmail.setError("This field is required");
            temp = false;
        }
        if(rgGender.getCheckedRadioButtonId() == -1){
            rgLastChild.setError("This field is required");
            temp = false;
        }
        if(!cbTerm.isChecked()){
            cbTerm.requestFocus();
            cbTerm.setError("this field is required");
            temp = false;
        }
        if(cbTerm.isChecked()){
            cbTerm.setError(null);
        }
        return temp;
    }
}