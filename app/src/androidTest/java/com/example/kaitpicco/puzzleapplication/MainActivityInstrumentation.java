package com.example.kaitpicco.puzzleapplication;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
        final ViewGroup.LayoutParams layoutParams = et.getLayoutParams();
        assertNotNull(et);
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
        assertTrue(View.VISIBLE == et.getVisibility());
    }

    @SmallTest
    public void testchecklastname()
    {
        EditText et=(EditText)getActivity().findViewById(R.id.Last_Name);
        assertNotNull(et);
        final ViewGroup.LayoutParams layoutParams = et.getLayoutParams();
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
        assertTrue(View.VISIBLE == et.getVisibility());
    }



    @SmallTest
    public void testcheckbutton()
    {
        ImageButton b=(ImageButton)getActivity().findViewById(R.id.imageButton);
        assertNotNull(b);
        final ViewGroup.LayoutParams layoutParams = b.getLayoutParams();
        assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
        assertTrue(View.VISIBLE == b.getVisibility());
    }

    @SmallTest
    public void testspinner()
    {
        Spinner sp=(Spinner)getActivity().findViewById(R.id.spinner);
        assertNotNull(sp);
        final ViewGroup.LayoutParams layoutParams = sp.getLayoutParams();
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
        assertTrue(View.VISIBLE ==sp.getVisibility());
    }

    public void testkeyboardedittext()
    {
        final EditText et=(EditText)getActivity().findViewById(R.id.First_Name);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                et.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Hello There!");
        getInstrumentation().waitForIdleSync();
    }

    public void testkeyboardedittext2()
    {
        final EditText et=(EditText)getActivity().findViewById(R.id.Last_Name);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                et.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Hello There!");
        getInstrumentation().waitForIdleSync();
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
