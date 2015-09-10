package com.example.kaitpicco.puzzleapplication;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.EditText;
import android.widget.ImageButton;

public class Intenttest2 extends ActivityInstrumentationTestCase2<MainActivity> {
    public Intenttest2() {
        super(MainActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    @MediumTest
    public void testSendMessageToReceiverActivity3() {
        final ImageButton sendToReceiverButton = (ImageButton)getActivity().findViewById(R.id.imageButton);
        final EditText et=(EditText)getActivity().findViewById(R.id.First_Name);
        final EditText et1=(EditText)getActivity().findViewById(R.id.Last_Name);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                et.setText("hello");

            }
        });



        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(FullNameActivity.class.getName(), null, false);
        TouchUtils.clickView(this, sendToReceiverButton);
        FullNameActivity receiverActivity = (FullNameActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(2000);

        assertNull("ReceiverActivity is null", receiverActivity);

        getInstrumentation().removeMonitor(receiverActivityMonitor);



    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
