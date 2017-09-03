package com.example.owner.skymood.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ivelina.Golemanova on 3.9.2017 г..
 */

public class AbstractActivity<B extends ViewDataBinding> extends AppCompatActivity implements IView {

    protected B binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //get layout id
        int layoutId = AnnotationUtil.extractLayoutIdFromAnnotation(this);

        //set up data binding
        binding = DataBindingUtil.setContentView(this, layoutId);
    }
}
