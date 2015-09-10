package com.example.kaitpicco.puzzleapplication;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;

public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {
    private Intent mLaunchIntent;
    public MainActivityUnitTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();





    }


    @SmallTest
    public void testmainact()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
    }

    @SmallTest
    public void teststringchecker()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
        MainActivityFragment ma=new MainActivityFragment();
        String s=ma.stringjoiner("Hello","There");
        assertEquals("Hello There", s);
    }

    @SmallTest
    public void teststringchecker2()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
        MainActivityFragment ma=new MainActivityFragment();
        String s=ma.stringjoiner("","There");
        assertEquals(" There", s);
    }

    @SmallTest
      public void teststringchecker3()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
        MainActivityFragment ma=new MainActivityFragment();
        String s=ma.stringjoiner("Hello","");
        assertEquals("Hello ", s);
    }

    @SmallTest
    public void teststringchecker4()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
        MainActivityFragment ma=new MainActivityFragment();
        String s=ma.stringjoiner("","");
        assertEquals(" ", s);
    }



    @SmallTest
    public void teststringchecker5()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
        MainActivityFragment ma=new MainActivityFragment();
        ma.setVar(1);
        String s=ma.stringjoiner("Hello","There");
        assertEquals("There Hello", s);
    }

    @SmallTest
    public void teststringchecker6()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
        MainActivityFragment ma=new MainActivityFragment();
        ma.setVar(1);
        String s=ma.stringjoiner("","There");
        assertEquals("There ", s);
    }

    @SmallTest
    public void teststringchecker7()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
        MainActivityFragment ma=new MainActivityFragment();
        ma.setVar(1);
        String s=ma.stringjoiner("Hello","");
        assertEquals(" Hello", s);
    }

    @SmallTest
    public void teststringchecker8()
    {
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(mLaunchIntent, null, null);
        MainActivityFragment ma=new MainActivityFragment();
        ma.setVar(1);
        String s=ma.stringjoiner("", "");
        assertEquals(" ", s);
    }









    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
