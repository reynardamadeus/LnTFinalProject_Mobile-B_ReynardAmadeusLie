package com.example.lntfinalproject_reynard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {
    EditText register_id, register_name, register_email, register_password, register_confirmpass;
    Button button_register;
    SharedPreferences sharedPreferences;

    TextView signin_link;

    private static final String SHARED_PREF_NAME = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        register_id= findViewById(R.id.register_id);
        register_email = findViewById(R.id.register_email);
        register_name = findViewById(R.id.register_name);
        register_password = findViewById(R.id.register_password);
        register_confirmpass = findViewById(R.id.register_confirmpass);
        button_register = findViewById(R.id.button_register);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        signin_link = findViewById(R.id.tosignin);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String new_id = register_id.getText().toString();
                String new_name = register_name.getText().toString();
                String new_email = register_email.getText().toString();
                String new_password = register_password.getText().toString();
                String new_confimpass = register_confirmpass.getText().toString();

                if(new_id.isEmpty() && new_name.isEmpty() && new_email.isEmpty() && new_password.isEmpty()
                && new_confimpass.isEmpty())
                {

                    Toast.makeText(Register.this, "Please Fill The Form", Toast.LENGTH_SHORT).show();
                }else if(new_email.contains("@") == false && new_email.endsWith(".com") == false)
                {
                    Toast.makeText(Register.this, "Please Fill The Email Correctly", Toast.LENGTH_SHORT).show();
                }else if(new_name.length() < 5)
                {
                    Toast.makeText(Register.this, "Name Should be no less than 5", Toast.LENGTH_SHORT).show();
                }else if(new_confimpass.compareTo(new_password) != 0)
                {
                    Toast.makeText(Register.this, "Confirm Password is not the same", Toast.LENGTH_SHORT).show();
                }else
                {
                    editor.putString("id", new_id);
                    editor.putString("email", new_email);
                    editor.putString("name", new_name);
                    editor.putString("password", new_password);
                    editor.commit();
                    Toast.makeText(Register.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        signin_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Register.this, Login.class);
            startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}