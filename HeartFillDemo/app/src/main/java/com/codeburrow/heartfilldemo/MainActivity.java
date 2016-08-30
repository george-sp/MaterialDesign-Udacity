package com.codeburrow.heartfilldemo;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimatedVectorDrawable emptyHeart;
    private AnimatedVectorDrawable fillHeart;
    private boolean full = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image_view);
        emptyHeart = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_heart_empty);
        fillHeart = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_heart_fill);
    }

    public void animate(View view) {
        AnimatedVectorDrawable drawable = full ? emptyHeart : fillHeart;
        imageView.setImageDrawable(drawable);
        drawable.start();
        full = !full;
    }
}
