package edu.gatech.cs2340.donationtracker;

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

    private Button submit;
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText emailInput;
    private Button cancel;
    private Spinner accountType;
    public static HashMap<String, User> userDatabase = new HashMap<>();
    public static List<String> accountTypes = Arrays.asList("Customer", "Admin", "Manager", "Location Employee");


    // String loginName, String password, boolean accountState, String contactInfo, AccountType accountType
    private User createUser(String name, String pass, String email, AccountType type) {
        User newUser = new User(name, pass, true, email, type);
        return newUser;
    }

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

                if (username.equals("") || password.equals("") || email.equals("")) {
                    Toast.makeText(getApplicationContext(), "One or more empty field(s)", Toast.LENGTH_SHORT).show();
                } else if (userDatabase.containsKey(username)) {
                    Toast.makeText(getApplicationContext(), "Username taken, please try again", Toast.LENGTH_SHORT).show();
                } else if (accountType.getSelectedItem().toString().equals("Admin") && password.contains("Ez7R")) {
                    // admin pass case
                    userDatabase.put(username, createUser(username, password, email, AccountType.ADMIN));
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Admin")) {
                    Toast.makeText(getApplicationContext(), "Admin Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else if (accountType.getSelectedItem().toString().equals("Manager") && password.contains("QffJ")) {
                    // manager pass case
                    userDatabase.put(username, createUser(username, password, email, AccountType.MANAGER));
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Manager")) {
                    Toast.makeText(getApplicationContext(), "Manager Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else if (accountType.getSelectedItem().toString().equals("Location Employee") && password.contains("OIU8")) {
                    // location employee pass case
                    userDatabase.put(username, createUser(username, password, email, AccountType.LOCATION_EMPLOYEE));
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Location Employee")) {
                    Toast.makeText(getApplicationContext(), "Location Employee Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else {
                    // default - customer
                    userDatabase.put(username, createUser(username, password, email, AccountType.CUSTOMER));
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
