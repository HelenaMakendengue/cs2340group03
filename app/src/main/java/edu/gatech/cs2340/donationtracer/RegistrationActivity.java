package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.*;

import java.util.EnumMap;

public class RegistrationActivity extends AppCompatActivity {

    private Button submit;
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText emailInput;
    private Button cancel;
    private Spinner accountType;
    public static HashMap<String, String> userDatabase = new HashMap<String,String>();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        submit = (Button) findViewById(R.id.button_submit);
        usernameInput = (EditText) findViewById(R.id.username_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        emailInput = (EditText) findViewById(R.id.email_input);
        accountType = (Spinner) findViewById(R.id.spinner);
        cancel = (Button) findViewById(R.id.button_cancel);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                //note, whoever is implementing creating the user from this info
                // still has to get the account type working

                userDatabase.put(username, password);
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, WelcomeActivity.class));
            }
        });
    }
}
