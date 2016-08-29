package com.codeburrow.coordinatedmotiondemo;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.view.View;

public class CurvedMotionDetails extends AppCompatActivity {

    public static final String EXTRA_COLOR = "EXTRA_COLOR";
    public static final String EXTRA_CURVE = "EXTRA_CURVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curved_motion_details);

        // Tint the circle to match the launching activity.
        View avatar = findViewById(R.id.avatar);
        avatar.setBackgroundTintList(ColorStateList.valueOf(getIntent().getIntExtra(EXTRA_COLOR, 0xffff00ff)));

        // Check if we should used curved motion and load an appropriate transition.
        boolean curve = getIntent().getBooleanExtra(EXTRA_CURVE, false);
        getWindow().setSharedElementEnterTransition(TransitionInflater.from(this)
                .inflateTransition(curve ? R.transition.curve : R.transition.move));
    }
}
