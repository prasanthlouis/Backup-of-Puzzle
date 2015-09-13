package com.example.kaitpicco.puzzleapplication;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivityIntentTest extends ActivityInstrumentationTestCase2<MainActivity> {


    public MainActivityIntentTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }




    //Checking if separate intent is firing on phones. This will fail on tablets because a new activity
    //is not being started. On tablets, its the same activity, you're adding a dynamic fragment. Make sure you turn on your screen.
    @MediumTest
    public void testSendMessageToReceiverActivity() {
        final ImageButton sendToReceiverButton = (ImageButton)getActivity().findViewById(R.id.imageButton);
        final EditText et=(EditText)getActivity().findViewById(R.id.First_Name);
        final EditText et1=(EditText)getActivity().findViewById(R.id.Last_Name);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                et.setText("hello");
                et1.setText("there");
            }
        });



        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(FullNameActivity.class.getName(), null, false);
        TouchUtils.clickView(this, sendToReceiverButton);
        FullNameActivity receiverActivity = (FullNameActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(2000);

        //Checking if separate intent is firing on phones. This WILL FAIL on tablets because a new activity
        //is not being started. On tablets, its the same activity, you're adding a dynamic fragment. Make sure you turn on your screen.
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                FullNameActivity.class, receiverActivity.getClass());
        getInstrumentation().removeMonitor(receiverActivityMonitor);



    }




    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
