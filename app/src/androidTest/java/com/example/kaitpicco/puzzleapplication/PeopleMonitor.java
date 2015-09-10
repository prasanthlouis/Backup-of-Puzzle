package com.example.kaitpicco.puzzleapplication;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;

public class PeopleMonitor extends ActivityInstrumentationTestCase2<MainActivity> {
    public PeopleMonitor(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    @MediumTest
    public void testSendMessageToReceiverActivity2() {

        final View view = getActivity().findViewById(R.id.See_People);


        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(People.class.getName(), null, false);
        TouchUtils.clickView(this, view);
        People receiverActivity = (People)
                receiverActivityMonitor.waitForActivityWithTimeout(2000);

        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                People.class, receiverActivity.getClass());
        getInstrumentation().removeMonitor(receiverActivityMonitor);

    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
