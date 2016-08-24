package com.codeburrow.immersiveimagesdemo;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

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

    @InjectView(R.id.imageView)
    ImageView imageView;
    Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        // The default scale type for an image is FIT_CENTER.
        fitCenterBtn.setChecked(true);
        // Scale the x and y axes in half and translate 100 pixels in each direction.
        matrix = new Matrix();
        matrix.postScale(0.5f, 0.5f);
        matrix.postTranslate(100, 100);
    }

    public RadioButton getSelectedRadio(View view) {
        RadioButton[] btns = {centerBtn, centerCropBtn, centerInsideBtn, fitCenterBtn,
                fitEndBtn, fitStartBtn, fitXYBtn, matrixBtn, noneBtn};
        for (RadioButton radioButton : btns) {
            if (radioButton.isChecked() && radioButton != view) {
                return radioButton;
            }
        }
        return null;
    }

    @OnClick({R.id.centerBtn, R.id.centerCropBtn, R.id.centerInsideBtn, R.id.fitCenterBtn,
            R.id.fitEndBtn, R.id.fitStartBtn, R.id.fitXYBtn, R.id.matrixBtn, R.id.noneBtn})
    public void clickRadioButton(RadioButton view) {
        // Check to see what is clicked
        RadioButton checkedRadio = getSelectedRadio(view);
        if (checkedRadio != null && checkedRadio != view) {
            checkedRadio.setChecked(false);
        }
        // If currently checked, do nothing.
        imageView.setPadding(0, 0, 0, 0);
        switch ((String) view.getText()) {

            case "NO!!!!":
                int px = dpToPx(32);
                imageView.setPadding(px, px, px, px);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case "CENTER":
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case "CENTER_CROP":
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case "CENTER_INSIDE":
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case "FIT_CENTER":
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case "FIT_END":
                imageView.setScaleType(ImageView.ScaleType.FIT_END);
                break;
            case "FIT_START":
                imageView.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case "FIT_XY":
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case "MATRIX":
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                imageView.setImageMatrix(matrix);
                break;

        }
        // If different, alter view

    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
