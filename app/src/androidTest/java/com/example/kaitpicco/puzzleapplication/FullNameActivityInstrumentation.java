package com.example.kaitpicco.puzzleapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

/**
 * Created by kaitpicco on 9/7/15.
 */
public class FullNameActivityInstrumentation extends ActivityInstrumentationTestCase2<FullNameActivity> {
    public FullNameActivityInstrumentation() {
        super(FullNameActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testtextview()
    {
        TextView tv=(TextView)getActivity().findViewById(R.id.full_name);
        assertNotNull(tv);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
