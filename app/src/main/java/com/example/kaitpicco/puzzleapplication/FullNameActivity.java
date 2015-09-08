package com.example.kaitpicco.puzzleapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class FullNameActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;
    private String full_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_full_name);
        Intent i=getIntent();
         full_name=i.getStringExtra("final_name");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_full_name, menu);
        MenuItem menuItem=menu.findItem(R.id.menu_item_share);
        ShareActionProvider mShareActionProvider =(ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        if(mShareActionProvider!=null)
        {
            mShareActionProvider.setShareIntent(createshareintent());
        }

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
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Intent createshareintent(){
        Intent shareintent=new Intent(Intent.ACTION_SEND);
        shareintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareintent.setType("text/plain");
        shareintent.putExtra(Intent.EXTRA_TEXT,"Hi there! I'm "+full_name+" #Brought to you by: PuzzleApplication" );
        return shareintent;
    }
    //TODO:make scrollable
}
