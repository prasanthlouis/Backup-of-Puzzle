package com.example.kaitpicco.puzzleapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements Behaviour {
private static boolean mTwoPane;
    private ShareActionProvider mShareActionProvider;
    private String full_name_checker=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);


        if (findViewById(R.id.fragment_new) != null) {
            mTwoPane = true;
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_new, new FullNameActivityFragment(), "TWO_PANE")
                        .commit();
            }
        } else {
            mTwoPane = false;

        }
    }
    private boolean getvar()
    {
        return mTwoPane;

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem=menu.findItem(R.id.menu_item_share);
        mShareActionProvider =(ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id)
        {

            case R.id.See_People: Intent intent=new Intent(this,People.class);
                startActivity(intent);
                return true;
        }
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void paneData(String s) {
        full_name_checker=s;
        MainActivity ma=new MainActivity();
        boolean mTwoPane=ma.getvar();

        if(mTwoPane){
            mShareActionProvider.setShareIntent(createshareintent());
            FullNameActivityFragment f=(FullNameActivityFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_new);
            f.fragmentText(s);




        }else{
            Intent intent = new Intent(this, FullNameActivity.class);
            intent.putExtra("final_name", s);
            startActivity(intent);
        }

    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Intent createshareintent(){
            Intent shareintent = new Intent(Intent.ACTION_SEND);
            shareintent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            shareintent.setType("text/plain");
            shareintent.putExtra(Intent.EXTRA_TEXT, "Hi there! I'm " + full_name_checker + " #Brought to you by: PuzzleApplication");
            return shareintent;

    }


}
