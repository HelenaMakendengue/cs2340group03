package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    public static List<String> accountTypes = Arrays.asList("Customer", "Admin", "Manager", "Location Employee");

    private Button submit;
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText emailInput;
    private Button cancel;
    private Spinner accountType;
    public static HashMap<String, String> userDatabase = new HashMap<>();


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

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, accountTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountType.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();


                //note, whoever is implementing creating the user from this info
                // still has to get the account type working

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Username or Password are empty", Toast.LENGTH_SHORT).show();
                } else if (accountType.getSelectedItem().toString().equals("Admin") && password.contains("Ez7R")) {
                    userDatabase.put(username, password);
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Admin")) {
                    Toast.makeText(getApplicationContext(), "Admin Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else if (accountType.getSelectedItem().toString().equals("Manager") && password.contains("QffJ")) {
                    userDatabase.put(username, password);
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Manager")) {
                    Toast.makeText(getApplicationContext(), "Manager Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else if (accountType.getSelectedItem().toString().equals("Location Employee") && password.contains("OIU8")) {
                    userDatabase.put(username, password);
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Location Employee")) {
                    Toast.makeText(getApplicationContext(), "Location Employee Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else {
                    userDatabase.put(username, password);
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                }

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
