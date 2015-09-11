package com.example.kaitpicco.puzzleapplication;

import android.animation.Animator;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    private ArrayAdapter<CharSequence> adapter;
    private long pos=0;
    private ImageButton button;
    private MediaPlayer mp;
    private Behaviour comm;
    private EditText first_name,last_name;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setBackgroundDrawableResource(R.drawable.wallpaper);


    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {View v=getActivity().findViewById(R.id.scrollviewanim);
            animateview(v);}
        buttoninit();
        edittextinit();
        spinnerinit();
        comm=(Behaviour)getActivity(); //Interface
        if(Constants.type==Constants.Type.Free)
        {
            Log.v("MainActivity","Free");
            AdView mAdView = (AdView) getActivity().findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
        else
        {
            Log.v("MainActivity","Paid");
        }



    }

    private void spinnerinit() {
        Spinner spinner = (Spinner)getActivity().findViewById(R.id.spinner);
        String[] nameArray = getResources().getStringArray(R.array.name_order);
        adapter = new ArrayAdapter<CharSequence>(getActivity(),R.layout.spinneritem,nameArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    private void edittextinit() {
        first_name=(EditText)getActivity().findViewById(R.id.First_Name);
        last_name=(EditText)getActivity().findViewById(R.id.Last_Name);
        Typeface typeFace= Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Medium.ttf");
        first_name.setTypeface(typeFace);
        last_name.setTypeface(typeFace);

    }

    private void buttoninit() {
        button=(ImageButton)getActivity().findViewById(R.id.imageButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mp=MediaPlayer.create(getActivity(), R.raw.button_click);
        button.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.buttons));
    }

    @Override
    public void onClick(View v) {
        String first_nametext,last_nametext,final_name="";
        mp.start();
        button.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.buttons));
        first_nametext=first_name.getText().toString();
        last_nametext=last_name.getText().toString();
        if(((first_nametext).equals("")) || ((last_nametext).equals(""))) {
          blankchecker(first_nametext,last_nametext);
            button.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.buttons));
        }
        else{
        final_name=stringjoiner(first_nametext,last_nametext);}
        if(!final_name.equals(""))
        comm.paneData(final_name);




    }

    private void blankchecker(String first_nametext, String last_nametext) {
        if(first_nametext.equals(""))
        {first_name.setError("You Didn't Enter First Name");}
        if(last_nametext.equals(""))
        {last_name.setError("You Didn't Enter Last Name");}
    }

    public String stringjoiner(String first_nametext,String last_nametext) {
        String final_name;
            if (pos == 0) {
                final_name = first_nametext + " " +last_nametext ;
            } else {
                final_name = last_nametext + " " + first_nametext;
            }
        return final_name;


    }

    public void setVar()
    {
        pos= 1;
    }


    public void animateview(View view1) {
        final View view=view1;
        view.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                         {
                            int finalHeight = view.getMeasuredHeight();
                            int finalWidth = view.getMeasuredWidth();
                            view.getViewTreeObserver().removeOnPreDrawListener(this);

                            int cx = finalHeight / 2;
                            int cy = finalWidth / 2;


                            int finalRadius = Math.max(finalHeight, finalWidth);
                            Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
                            view.setVisibility(View.VISIBLE);
                            anim.setDuration(1500);

                            anim.start();

                        }
                        return true;
                    }
                });
    }


    @Override
    public void onStop() {
        super.onStop();
        mp.stop();
        mp.release();
        Log.v("MainActivity","Stopped");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        pos=adapter.getItemId(position);
        Log.v("MainActivity",pos+"");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
