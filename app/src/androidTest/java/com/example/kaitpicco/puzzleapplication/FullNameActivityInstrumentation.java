package com.example.kaitpicco.puzzleapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

public class FullNameActivityInstrumentation extends ActivityInstrumentationTestCase2<FullNameActivity> {

    public FullNameActivityInstrumentation() {
        super(FullNameActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);

    }

    @SmallTest
    public void testtextview()
    {
        TextView tv=(TextView)getActivity().findViewById(R.id.full_name);
        assertNotNull(tv);
        final ViewGroup.LayoutParams layoutParams = tv.getLayoutParams();
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
        assertTrue(View.VISIBLE == tv.getVisibility());
    }

    @SmallTest
    public void testtextview1()
    {
        TextView tv=(TextView)getActivity().findViewById(R.id.textView2);
        assertNotNull(tv);
        final ViewGroup.LayoutParams layoutParams = tv.getLayoutParams();
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
        assertTrue(View.VISIBLE == tv.getVisibility());
    }



    @SmallTest
    public void testtextview2()
    {
        TextView tv=(TextView)getActivity().findViewById(R.id.textView3);
        assertNotNull(tv);
        final ViewGroup.LayoutParams layoutParams = tv.getLayoutParams();
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
        assertTrue(View.VISIBLE == tv.getVisibility());

    }

    @SmallTest
    public void testgetter()
    {
        TextView tv=(TextView)getActivity().findViewById(R.id.textView2);
        String s=getActivity().getString(R.string.share_friends);
        assertEquals(s, tv.getText());

    }

    @SmallTest
    public void testgetter2()
    {
        TextView tv=(TextView)getActivity().findViewById(R.id.textView3);
        String s=getActivity().getString(R.string.your_name_is);
        assertEquals(s,tv.getText());

    }

    @SmallTest
    public void testgetter3()
    {
        TextView tv=(TextView)getActivity().findViewById(R.id.full_name);
        String s=getActivity().getString(R.string.blank);
        assertEquals(s, tv.getText());

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
