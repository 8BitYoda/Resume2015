package com.example.martin.resume2015;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExperienceItemActivity extends ActionBarActivity {

    String expName, expDates, expLocation;
    String expPic;
    int exprID;

    ImageView exprPic;
    TextView exprName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_item);
        Bundle extras = this.getIntent().getExtras();
        if(extras!=null){
            String temp=extras.getString("list");
            setExperienceData(temp);
            exprID = extras.getInt("expID");
        }

        exprPic = (ImageView) findViewById(R.id.exp_pic);
        exprPic.setImageResource(Integer.parseInt(expPic));
        exprName = (TextView) findViewById(R.id.exp_name);
        exprName.setText(expName);
        //Toast.makeText(ExperienceItemActivity.this, expDates,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setExperienceData(String temp){
        Pattern pattern = Pattern.compile("([a-zA-z]+\\s[a-zA-Z]+)\\|([a-zA-z]{0,}\\s?[a-zA-z]+,\\s[a-zA-z]+)\\|([a-zA-z]{0,}\\s?\\d+\\s\\-\\s[a-zA-z]+)\\|(\\d+)");
        Matcher matcher = pattern.matcher(temp);
        Log.d("regex", "string: "+temp);
        if(matcher.find()){
            expName=matcher.group(1);       //sets the name of experience
            expLocation=matcher.group(2);   //sets the location of experience
            expDates=matcher.group(3);      //sets the dates at experience took place
            expPic=matcher.group(4);        //sets the picture Id for the experience
//            Log.d("regex", "title: "+matcher.group(1));
//            Log.d("regex", "location: "+matcher.group(2));
//            Log.d("regex", "dates: "+matcher.group(3));
//            Log.d("regex", "picID: "+matcher.group(4));
        }
    }
}
