package com.example.owner.skymood.base;

import android.view.View;

/**
 * Helper class for extracting annotations.
 * <p>
 * Created by Ivelina.Golemanova on 3.9.2017 г..
 */

public class AnnotationUtil {

    private static final String MISSING_LAYOUT_RES_ID_ANNOTATION_MESSAGE =
            "Missing %s annotation for view class %s";

    private AnnotationUtil() {
        //empty
    }

    /**
     * Extract the value from {@link LayoutResId} annotation.
     *
     * @param view the view where the annotation is set
     * @return the layout identifier for the given view
     */
    public static int extractLayoutIdFromAnnotation(IView view) {

        int layoutId;

        Class<?> viewClass = view.getClass();
        LayoutResId layoutAnnotation = viewClass.getAnnotation(LayoutResId.class);

        if (layoutAnnotation == null || layoutAnnotation.layoutId() == 0) {
            String errorMessage = String.format(
                    MISSING_LAYOUT_RES_ID_ANNOTATION_MESSAGE,
                    LayoutResId.class.getName(),
                    viewClass.getName());
            throw new RuntimeException(errorMessage);
        } else {
            layoutId = layoutAnnotation.layoutId();
        }

        return layoutId;
    }
}
