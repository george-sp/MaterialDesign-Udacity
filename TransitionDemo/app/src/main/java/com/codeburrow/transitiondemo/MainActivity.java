package com.codeburrow.transitiondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void click(View view) {
        /*
         * Slide: this transition tracks changes to the visibility of target views
         *        in the start and end scenes and moves views in or out
         *        from one of the edges of the scene.
         */
        Slide slide = new Slide();
        // Change the edge that Views appear and disappear from.
        slide.setSlideEdge(Gravity.TOP);

        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        /*
         * beginDelayedTransition: Convenience method to animate to a new scene
         *                         defined by all changes within the given scene root
         *                         between calling this method and the next rendering frame.
         */
        TransitionManager.beginDelayedTransition(root, slide);
        imageView.setVisibility(View.INVISIBLE);
    }
}
