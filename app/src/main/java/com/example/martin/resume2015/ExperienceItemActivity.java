package com.example.martin.resume2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExperienceItemActivity extends ActionBarActivity {

    Toolbar toolbar;

    String expName, expDates, expLocation;
    String expPic;
    int exprID;

    ImageView exprPic;
    TextView exprName,exprLoc,exprDate;
    TextView exprTitle;
    TextView exprDetail1,exprDetail2,exprDetail3,exprDetail4;
    TableRow row1,row2,row3,row4;



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
         /* Assinging the toolbar object ot the view
        and setting the the Action bar to our toolbar*/
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        exprPic = (ImageView) findViewById(R.id.exp_pic);
        exprName = (TextView) findViewById(R.id.exp_name);
        exprLoc = (TextView) findViewById(R.id.exp_location);
        exprDate = (TextView) findViewById(R.id.exp_dates);
        exprTitle = (TextView) findViewById(R.id.exp_title);
        row1 = (TableRow) findViewById(R.id.row1);
        row2 = (TableRow) findViewById(R.id.row2);
        row3 = (TableRow) findViewById(R.id.row3);
        row4 = (TableRow) findViewById(R.id.row4);
        exprDetail1 = (TextView) findViewById(R.id.exSum);
        exprDetail2 = (TextView) findViewById(R.id.exSum2);
        exprDetail3 = (TextView) findViewById(R.id.exSum3);
        exprDetail4 = (TextView) findViewById(R.id.exSum4);
        setExperienceFields();


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
        //as you specify a parent activity in AndroidManifest.xml.
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        } else {
            super.onOptionsItemSelected(item);
        }
        return true;
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

    public void setExperienceFields(){
        exprName.setText(expName);
        exprLoc.setText(expLocation);
        exprDate.setText(expDates);

        if(exprID==0){
            exprPic.setImageResource(Integer.parseInt(expPic));
            exprTitle.setText(getString(R.string.expr1_title));
            exprDetail1.setText(getString(R.string.expr1_summary));
            exprDetail2.setText(getString(R.string.expr1_summary2));
            exprDetail3.setText(getString(R.string.expr1_summary3));
            exprDetail4.setText(getString(R.string.expr1_summary4));
        } else if (exprID==1){
            exprPic.setImageResource(Integer.parseInt(expPic));
            exprTitle.setText(getString(R.string.expr2_title));
            exprDetail1.setText(getString(R.string.expr2_summary));
            exprDetail2.setText(getString(R.string.expr2_summary2));
            exprDetail3.setText(getString(R.string.expr2_summary3));
            row4.setVisibility(View.INVISIBLE);
        }
    }
}
