package com.example.kaitpicco.puzzleapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class FullNameActivityFragment extends Fragment {

    public FullNameActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_full_name, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setBackgroundDrawableResource(R.drawable.wallpaper);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent i=getActivity().getIntent();
        String full_name=i.getStringExtra("final_name");
        TextView tv=(TextView)getActivity().findViewById(R.id.full_name);
        tv.setText(full_name);
    }
}
