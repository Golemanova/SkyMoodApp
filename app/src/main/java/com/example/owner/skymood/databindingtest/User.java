package com.example.owner.skymood.databindingtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.owner.skymood.BR;

/**
 * Created by Ivelina.Golemanova on 14.3.2017 г..
 */

public class User extends BaseObservable {

    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    @Bindable
    public int getAge() {

        return age;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void setAge(int age) {

        this.age += 1;
        notifyPropertyChanged(BR.age);
    }

    public void setNewAge(View view) {

        this.age += 5;
        notifyPropertyChanged(BR.age);
    }
}
