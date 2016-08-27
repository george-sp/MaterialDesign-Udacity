package com.codeburrow.interpolationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.interpolator_spinner)
    Spinner interpolatorSpinner;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.duration_spinner)
    Spinner duratorSpinner;
    @Bind(R.id.textView)
    TextView textView;

    private int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnItemSelected({R.id.duration_spinner})
    void durationSelected(Spinner spinner, int position) {
        String durationString = (String) spinner.getAdapter().getItem(position);
        switch (durationString) {
            case "100ms":
                duration = 100;
            case "900ms":
                duration = 900;
                break;
            case "1500ms":
                duration = 1500;
                break;
            case "3000ms":
                duration = 3000;
                break;
            default:
                duration = 300;
                break;
        }
    }
}
