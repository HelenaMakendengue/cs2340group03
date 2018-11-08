package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private FirebaseAuth mAuth;
    // --Commented out by Inspection (11/8/18, 5:18 PM):public static String username;

    //firebase auth login
    private void logIn(String user, String pass) {
        mAuth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user1 = mAuth.getCurrentUser();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                    // [START_EXCLUDE]
                    if (!task.isSuccessful()) {
                        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button submit = findViewById(R.id.button_login2);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        Button cancel = findViewById(R.id.button_cancel);
        mAuth = FirebaseAuth.getInstance();


        submit.setOnClickListener(v -> {

            String userName = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

//                if (RegistrationActivity.userDatabase.containsKey(userName)
//                        && RegistrationActivity.userDatabase.get(userName).getPassword().equals(password)) {
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                } else {
//                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
//                }
            logIn(userName, password);
        });

        cancel.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, WelcomeActivity.class)));
    }
}
