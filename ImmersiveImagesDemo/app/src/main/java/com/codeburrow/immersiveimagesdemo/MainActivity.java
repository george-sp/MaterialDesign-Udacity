package com.codeburrow.immersiveimagesdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Radio Buttons
    @InjectView(R.id.noneBtn)
    RadioButton noneBtn;
    @InjectView(R.id.centerBtn)
    RadioButton centerBtn;
    @InjectView(R.id.centerCropBtn)
    RadioButton centerCropBtn;
    @InjectView(R.id.centerInsideBtn)
    RadioButton centerInsideBtn;
    @InjectView(R.id.fitCenterBtn)
    RadioButton fitCenterBtn;
    @InjectView(R.id.fitEndBtn)
    RadioButton fitEndBtn;
    @InjectView(R.id.fitStartBtn)
    RadioButton fitStartBtn;
    @InjectView(R.id.fitXYBtn)
    RadioButton fitXYBtn;
    @InjectView(R.id.matrixBtn)
    RadioButton matrixBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        // The default scale type for an image is FIT_CENTER.
        fitCenterBtn.setChecked(true);
    }
}
