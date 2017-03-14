package com.example.owner.skymood.databindingtest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.owner.skymood.R;
import com.example.owner.skymood.databinding.ActivityTestBinding;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        User user = new User("Stefan", "Todorov", 21);
        binding.setUser(user);
    }

    public void changeAge(User user){


    }
}
