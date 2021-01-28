package com.example.homeworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etId,etName,etPhone;
    Button btnInsert,btnView;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId=findViewById(R.id.et_id);
        etName=findViewById(R.id.et_name);
        etPhone=findViewById(R.id.et_phone);


        btnInsert=findViewById(R.id.btn_insert);
        btnView=findViewById(R.id.btn_view);

        dbHelper=new DBHelper(MainActivity.this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String id=etId.getText().toString();
                String name=etName.getText().toString();
                String phone=etPhone.getText().toString();

                if (id.isEmpty())
                {
                    etId.setError("Please input your id");
                    etId.requestFocus();
                }

                else if(name.isEmpty())
                {
                    etName.setError("Please input your name");
                    etName.requestFocus();
                }
                else if(phone.isEmpty() || phone.length() != 11 || !phone.startsWith("01"))
                {
                    etPhone.setError("Please input valid email");
                    etPhone.requestFocus();
                }
                else
                {
                    boolean check =dbHelper.insertData(id,name,phone);
                    if(check==true)
                    {
                        Toast.makeText(MainActivity.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Data insert fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);

            }
        });


    }
}
