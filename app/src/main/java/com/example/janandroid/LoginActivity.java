package com.example.janandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText edtMobileNo,edPassword;
    Button btnLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edtMobileNo=findViewById(R.id.edphone);
        edPassword=findViewById(R.id.edpassword);
        btnLogin=findViewById(R.id.btnlogin);

        SharedPreferences sharedPreferences=getSharedPreferences("my_pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobileNo=edtMobileNo.getText().toString();
                String password=edPassword.getText().toString();

                if (mobileNo.isEmpty() || password.isEmpty())
                {
                   Toast.makeText(LoginActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                }else if (mobileNo.length()!=10)
                {
                    Toast.makeText(LoginActivity.this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else if (mobileNo.equals("9876543210") && password.equals("12345"))
                {
                    editor.putString("islogin","true");
                    editor.commit();
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                    //Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

              //  Toast.makeText(LoginActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}