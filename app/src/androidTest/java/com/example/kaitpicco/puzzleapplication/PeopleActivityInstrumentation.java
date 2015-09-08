package com.example.kaitpicco.puzzleapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TableLayout;

/**
 * Created by kaitpicco on 9/7/15.
 */
public class PeopleActivityInstrumentation extends ActivityInstrumentationTestCase2<People> {
    public PeopleActivityInstrumentation() {
        super(People.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testtable()
    {
        TableLayout tl=(TableLayout)getActivity().findViewById(R.id.table);
        assertNotNull(tl);
        final ViewGroup.LayoutParams layoutParams = tl.getLayoutParams();
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.MATCH_PARENT);
        assertTrue(View.VISIBLE == tl.getVisibility());
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
