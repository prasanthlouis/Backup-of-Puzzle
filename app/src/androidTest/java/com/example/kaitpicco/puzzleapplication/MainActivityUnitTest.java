package com.example.kaitpicco.puzzleapplication;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

public class MainActivityUnitTest extends TestCase {


    @Override
    protected void setUp() throws Exception {
        super.setUp();





    }




    @SmallTest
    public void teststringchecker()
    {
        MainActivityFragment ma=new MainActivityFragment();
        String s=ma.stringjoiner("Hello","There");
        assertEquals("Hello There", s);
    }

    @SmallTest
    public void teststringchecker2()
    {

        MainActivityFragment ma=new MainActivityFragment();
        String s=ma.stringjoiner("","There");
        assertEquals(" There", s);
    }

    @SmallTest
      public void teststringchecker3()
    {
        MainActivityFragment ma=new MainActivityFragment();
        String s=ma.stringjoiner("Hello","");
        assertEquals("Hello ", s);
    }

    @SmallTest
    public void teststringchecker4()
    {

        MainActivityFragment ma=new MainActivityFragment();
        String s=ma.stringjoiner("","");
        assertEquals(" ", s);
    }



    @SmallTest
    public void teststringchecker5()
    {

        MainActivityFragment ma=new MainActivityFragment();
        ma.setVar();
        String s=ma.stringjoiner("Hello","There");
        assertEquals("There Hello", s);
    }

    @SmallTest
    public void teststringchecker6()
    {

        MainActivityFragment ma=new MainActivityFragment();
        ma.setVar();
        String s=ma.stringjoiner("","There");
        assertEquals("There ", s);
    }

    @SmallTest
    public void teststringchecker7()
    {

        MainActivityFragment ma=new MainActivityFragment();
        ma.setVar();
        String s=ma.stringjoiner("Hello","");
        assertEquals(" Hello", s);
    }

    @SmallTest
    public void teststringchecker8()
    {

        MainActivityFragment ma=new MainActivityFragment();
        ma.setVar();
        String s=ma.stringjoiner("", "");
        assertEquals(" ", s);
    }









    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
