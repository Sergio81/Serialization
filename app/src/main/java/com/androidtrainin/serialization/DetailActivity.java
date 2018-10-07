package com.androidtrainin.serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String DETAIL_EXTRA = "com.androidtrainin.serialization.DETAIL_EXTRA";

    private TextView firstName;
    private TextView lastName;
    private TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();

        User user = (User) getIntent().getParcelableExtra(DETAIL_EXTRA);

        updateDetails(user);
    }

    private void updateDetails(User user) {
        if(user != null){
            firstName.setText(user.getFirstName());
            lastName.setText(user.getLastName());
            age.setText(String.valueOf(user.getAge()));
        }
    }

    private void initView() {
        firstName = findViewById(R.id.nameTV);
        lastName = findViewById(R.id.lastTV);
        age = findViewById(R.id.ageTV);
    }
}
