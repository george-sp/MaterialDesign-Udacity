package com.codeburrow.typographicaldemo;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivityFragment extends Fragment {

    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    @InjectView(R.id.display4)
    TextView display4View;
    @InjectView(R.id.headline)
    TextView headlineView;

    Typeface courgette;

    /* Empty constructor per the documentation. */
    public MainActivityFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        courgette = Typeface.createFromAsset(getActivity().getAssets(), "Courgette-Regular.ttf");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, view);
        /*
            display4View = (TextView)getActivity().findViewById(R.id.display4);
            headlineView = (TextView)getActivity().findViewById(R.id.headline);
         */
        display4View.setTypeface(courgette);
        headlineView.setTypeface(courgette);

        return view;
    }
}