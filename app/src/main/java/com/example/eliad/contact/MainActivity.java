package com.example.eliad.contact;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton male;
    RadioButton female;
    EditText name;
    EditText lname;
    EditText number;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        male=(RadioButton)findViewById(R.id.rbMale);
        female=(RadioButton)findViewById(R.id.rbFemale);
        name=(EditText)findViewById(R.id.etName);
        lname=(EditText)findViewById(R.id.etLName);
        number=(EditText)findViewById(R.id.etNumber);
        SharedPreferences sharedPreferences=MainActivity.this.getSharedPreferences("saved",MODE_PRIVATE);
        name.setText(sharedPreferences.getString("1",""));
        lname.setText(sharedPreferences.getString("2",""));
        number.setText(sharedPreferences.getString("3",""));
        String saveGender=sharedPreferences.getString("4","");
        switch (saveGender){
            case "Male":
                female.setChecked(false);
                male.setChecked(true);
                break;
            case "Female":
                male.setChecked(false);
                female.setChecked(true);
                break;
        }


    }

    public void selectGender(View view){
        boolean chacked= ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rbMale:
                female.setChecked(false);
                gender="Male";
                break;
            case R.id.rbFemale:
                male.setChecked(false);
                gender="Female";
                break;
        }
    }

    public void clickToSend(View view){
        SharedPreferences sharedPreferences=MainActivity.this.getSharedPreferences("saved",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("1", String.valueOf(name.getText()));
        editor.putString("2", String.valueOf(lname.getText()));
        editor.putString("3", String.valueOf(number.getText()));
        editor.putString("4", gender);
        editor.commit();
        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context,
                "Deatails are sended",
                Toast.LENGTH_SHORT);
        toast.show();

    }




}
