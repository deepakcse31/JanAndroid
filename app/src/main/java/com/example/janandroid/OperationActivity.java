package com.example.janandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OperationActivity extends AppCompatActivity {
    EditText edtFirstNo,edtSecondNo;
    Button btnAdd;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operation);

        edtFirstNo=findViewById(R.id.edtfirstno);
        edtSecondNo=findViewById(R.id.edtSecondno);
        btnAdd=findViewById(R.id.btnadd);
        txtResult=findViewById(R.id.txtresult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNo=edtFirstNo.getText().toString();
                String secondNo=edtSecondNo.getText().toString();

                String result=add(firstNo,secondNo);
                txtResult.setText(result);

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public String add(String firstNo,String secondNo)
    {
        int a=Integer.parseInt(firstNo);
        int b=Integer.parseInt(secondNo);
        int c=a+b;
        return String.valueOf(c);
    }
}
