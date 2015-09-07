package com.example.kaitpicco.puzzleapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

/**
 * Created by kaitpicco on 9/7/15.
 */
public class MainActivityInstrumentation extends ActivityInstrumentationTestCase2<MainActivity> {
    MainActivity mainActivity;
    public MainActivityInstrumentation() {
        super(MainActivity.class);
    }


    //Always set up the test environments with setup() and teardown()


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity=this.getActivity();

    }

    @SmallTest
    public void testcheckfirstname()
    {
        EditText et=(EditText)getActivity().findViewById(R.id.First_Name);
        assertNotNull(et);
    }

    @SmallTest
    public void testchecklastname()
    {
        EditText et=(EditText)getActivity().findViewById(R.id.Last_Name);
        assertNotNull(et);
    }

    @SmallTest
    public void testcheckbutton()
    {
        ImageButton b=(ImageButton)getActivity().findViewById(R.id.imageButton);
        assertNotNull(b);
    }

    @SmallTest
    public void testspinner()
    {
        Spinner sp=(Spinner)getActivity().findViewById(R.id.spinner);
        assertNotNull(sp);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
