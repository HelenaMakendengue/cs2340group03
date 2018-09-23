package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD
=======
import android.widget.EditText;
>>>>>>> ae2b28826a4d27c5ec4da58bd79c0472e5a6b7e8

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

<<<<<<< HEAD

        Button btn_login = (Button)findViewById(R.id.button_login2);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        Button btn_cancel = (Button)findViewById(R.id.button_cancel);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            }
        });

=======
        EditText userName = (EditText) findViewById(R.id.username_input);
        EditText password = (EditText) findViewById(R.id.password_input);

        String user = userName.toString().trim();
        String pass = password.toString().trim();
>>>>>>> ae2b28826a4d27c5ec4da58bd79c0472e5a6b7e8

    }
}
