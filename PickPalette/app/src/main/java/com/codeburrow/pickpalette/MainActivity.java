package com.codeburrow.pickpalette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private SwatchAdapter mSwatchAdapter;
    @InjectView(R.id.tool_bar)
    Toolbar toolbar;
    @InjectView(R.id.imageView)
    ImageView imageView;
    @InjectView(R.id.grid_view)
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        toolbar.setTitle(getString(R.string.app_name));
    }

    @OnClick(R.id.fab)
    public void click(View view) {
        Snackbar.make(findViewById(R.id.fragment), "Clicked FAB.", Snackbar.LENGTH_LONG)
                //.setAction("Action", this)
                .show();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PickerFragment pickerFragment = new PickerFragment();
        pickerFragment.show(fragmentManager, "dialog");
        fragmentTransaction.commit();
    }

    public void createPalette(Object object) {
        Bitmap bitmap;
        try {
            if (object instanceof Uri) {
                Uri imageUri = (Uri) object;
                Picasso.with(this).load(imageUri).into(imageView);
                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                bitmap = BitmapFactory.decodeStream(imageStream);
            } else {
                bitmap = (Bitmap) object;
                imageView.setImageBitmap(bitmap);
            }

            // Do this async on activity
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    HashMap hashMap = processPalette(palette);
                    mSwatchAdapter = new SwatchAdapter(getApplicationContext(), hashMap.entrySet().toArray());
                    gridView.setAdapter(mSwatchAdapter);
                }
            });
        } catch (Exception ex) {
            Log.e(LOG_TAG, "error in creating palette");
        }
    }

    HashMap<String, Palette.Swatch> processPalette(Palette palette) {
        HashMap<String, Palette.Swatch> hashMap = new HashMap<>();

        if (palette.getVibrantSwatch() != null)
            hashMap.put("Vibrant", palette.getVibrantSwatch());
        if (palette.getDarkVibrantSwatch() != null)
            hashMap.put("DarkVibrant", palette.getDarkVibrantSwatch());
        if (palette.getLightVibrantSwatch() != null)
            hashMap.put("LightVibrant", palette.getLightVibrantSwatch());

        if (palette.getMutedSwatch() != null)
            hashMap.put("Muted", palette.getMutedSwatch());
        if (palette.getDarkMutedSwatch() != null)
            hashMap.put("DarkMuted", palette.getDarkMutedSwatch());
        if (palette.getLightMutedSwatch() != null)
            hashMap.put("LightMuted", palette.getLightMutedSwatch());

        return hashMap;
    }
}