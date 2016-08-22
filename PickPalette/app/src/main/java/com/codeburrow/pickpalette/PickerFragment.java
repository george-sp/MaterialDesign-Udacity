package com.codeburrow.pickpalette;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PickerFragment extends DialogFragment {

    private static final String LOG_TAG = PickerFragment.class.getSimpleName();

    private static final int PICK_PHOTO = 100;
    private static final int TAKE_PHOTO = 101;

    @InjectView(R.id.pickImage)
    Button pickImage;
    @InjectView(R.id.takeImage)
    Button takeImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picker, container, false);
        ButterKnife.inject(this, view);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @OnClick(R.id.pickImage)
    public void pickImage(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, PICK_PHOTO);
    }

    @OnClick(R.id.takeImage)
    void takeImage(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(cameraIntent, TAKE_PHOTO);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case PICK_PHOTO:
                if (resultCode == Activity.RESULT_OK) {
                    Log.e(LOG_TAG, "Picked a photo.");
                    Uri selectedImage = data.getData();
                    getDialog().dismiss();
                }
                break;
            case TAKE_PHOTO:
                if (resultCode == Activity.RESULT_OK) {
                    Log.e(LOG_TAG, "Took a photo.");
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    getDialog().dismiss();
                }
        }
    }
}