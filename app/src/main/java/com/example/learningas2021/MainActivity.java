package com.example.learningas2021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int num1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } // end OnCreate

    public void topClick (View v) // all event handlers will have this parameter
    {
        num1++;
        updateTV();
        Toast.makeText(this, "You clicked the top button", Toast.LENGTH_SHORT).show();
        Log.i("info", "The user clicked the top button");
        Log.e("error", "Oh no! An error occurred!!!");
    }

    public void bottomClick (View v) // all event handlers will have this parameter
    {
        num1--;
        updateTV();
        Toast.makeText(this, "You clicked the bottom button", Toast.LENGTH_LONG).show();
        // Log.i("info", "The user clicked the top button");
        Log.e("error", "Warning! This user like to be argumentative!");
    }

    public void reset (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you really want to reset the count?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
           @Override
           public void onClick (DialogInterface dialogInterface, int i) {
               num1 = 0;
               updateTV();
           }
        });
        builder.setNegativeButton("No!", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // do nothing because you don't want if the person said not to tamper with count
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    } // end reset method

    public void updateTV ()
    {
        TextView outputTextView = (TextView) findViewById(R.id.output);
        outputTextView.setText("You have now counted " + num1 + " stars!");
    } // end updateTV method

} // end class