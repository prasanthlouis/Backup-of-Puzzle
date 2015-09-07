package com.example.kaitpicco.puzzleapplication;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    private ArrayAdapter<CharSequence> adapter;
    private long pos=0;
    private ImageButton button;
    private MediaPlayer mp;
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
        button=(ImageButton)getActivity().findViewById(R.id.imageButton);
        Spinner spinner = (Spinner)getActivity().findViewById(R.id.spinner);
         first_name=(EditText)getActivity().findViewById(R.id.First_Name);
         last_name=(EditText)getActivity().findViewById(R.id.Last_Name);
        String[] nameArray = getResources().getStringArray(R.array.name_order);
        adapter = new ArrayAdapter<CharSequence>(getActivity(),R.layout.spinneritem,nameArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mp=MediaPlayer.create(getActivity(),R.raw.button_click);
        button.setImageResource(R.drawable.abc);
    }

    @Override
    public void onClick(View v) {
        mp.start();
        button.setImageResource(R.drawable.abcd);
        String final_name,first_nametext="",last_nametext="";
        if(((first_nametext=first_name.getText().toString()).equals("")) || ((last_nametext=last_name.getText().toString()).equals(""))) {
            if(first_nametext.equals(""))
            {first_name.setError("You Didn't Enter First Name");}
            if(last_nametext.equals(""))
            {last_name.setError("You Didn't Enter Last Name");}
            button.setImageResource(R.drawable.abc);
        }
        else {
            if (pos == 0) {
                final_name = first_nametext + " " +last_nametext ;
            } else {
                final_name = last_nametext + " " + first_nametext;
            }
            Intent intent = new Intent(getActivity(), FullNameActivity.class);
            intent.putExtra("final_name", final_name);
            startActivity(intent);
        }



    }

    @Override
    public void onStop() {
        super.onStop();
        mp.stop();
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
