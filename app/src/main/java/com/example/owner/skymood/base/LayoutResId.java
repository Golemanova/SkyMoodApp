package com.example.owner.skymood.base;

import android.support.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used for providing the id for the layout file.
 * <p>
 * Created by Ivelina.Golemanova on 3.9.2017 г..
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LayoutResId {

    /**
     * Sets the layout id.
     *
     * @return the layout id
     */
    @LayoutRes
    int layoutId();
}
