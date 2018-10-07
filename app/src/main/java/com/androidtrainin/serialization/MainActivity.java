package com.androidtrainin.serialization;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameET;
    private EditText lastET;
    private EditText ageET;
    private Button registerBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        nameET = findViewById(R.id.userName);
        lastET = findViewById(R.id.userLast);
        ageET = findViewById(R.id.userAge);
        registerBT = findViewById(R.id.registerBtn);
        registerBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.registerBtn:
                startDetailActivity();
                break;
        }
    }

    private void startDetailActivity() {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(DetailActivity.DETAIL_EXTRA, getUser());
        startActivity(detailIntent);
    }

    @NonNull
    private User getUser() {
        String firstName = nameET.getText().toString();
        String lastName = lastET.getText().toString();
        int age = Integer.parseInt(ageET.getText().toString()); // can throw NFE
        return new User(firstName, lastName, age);
    }
}
