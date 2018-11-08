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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.support.annotation.NonNull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    DatabaseReference databaseUsers;
    private FirebaseAuth mAuth;

    private EditText usernameInput;
    private EditText passwordInput;
    private EditText emailInput;
    private Spinner accountType;
    public static Map<String, User> userDatabase = new HashMap<>();
    public static List<String> accountTypes = Arrays.asList("Customer", "Admin", "Manager", "Location Employee");


    // String loginName, String password, boolean accountState, String contactInfo, AccountType accountType
    private User createUser(String name, String pass, String email, AccountType type) {

        String id = databaseUsers.push().getKey();
        User newUser = new User(name, pass, true, email, type);
        databaseUsers.child(id).setValue(newUser);
        return newUser;
    }

    private void createAuth(String user, String pass, String email, AccountType type) {
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(RegistrationActivity.this, ":)", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        userDatabase.put(email, createUser(user, pass, email, type));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button submit = (Button) findViewById(R.id.button_submit);
        usernameInput = (EditText) findViewById(R.id.username_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        emailInput = (EditText) findViewById(R.id.email_input);
        accountType = (Spinner) findViewById(R.id.spinner);
        Button cancel = (Button) findViewById(R.id.button_cancel);

        mAuth = FirebaseAuth.getInstance();

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, accountTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountType.setAdapter(adapter);

        //Database References
        databaseUsers = FirebaseDatabase.getInstance().getReference("users");


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
                    createAuth(username, password, email, AccountType.ADMIN);
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Admin")) {
                    Toast.makeText(getApplicationContext(), "Admin Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else if (accountType.getSelectedItem().toString().equals("Manager") && password.contains("QffJ")) {
                    // manager pass case
                    createAuth(username, password, email, AccountType.MANAGER);
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Manager")) {
                    Toast.makeText(getApplicationContext(), "Manager Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else if (accountType.getSelectedItem().toString().equals("Location Employee") && password.contains("OIU8")) {
                    // location employee pass case
                    createAuth(username, password, email, AccountType.LOCATION_EMPLOYEE);
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else if (accountType.getSelectedItem().toString().equals("Location Employee")) {
                    Toast.makeText(getApplicationContext(), "Location Employee Permissions Not Granted", Toast.LENGTH_SHORT).show();
                } else {
                    // default - customer
                    createAuth(username, password, email, AccountType.CUSTOMER);
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
