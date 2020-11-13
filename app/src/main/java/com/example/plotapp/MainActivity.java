package com.example.plotapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtFunction=null;
    TextView txtStr=null;
    CustomView customView=null;
    String strFunction="";
    String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Largenbt=(Button)findViewById(R.id.Largen);
        Button Lessenbt=(Button)findViewById(R.id.Lessen);
        Button Clearbt=(Button)findViewById(R.id.Clear);
        txtFunction=(TextView)findViewById(R.id.txtFunction);
        txtStr=(TextView)findViewById(R.id.txtStr);
        customView=(CustomView)findViewById(R.id.plotview);
        Button buttonPlot=(Button)findViewById(R.id.buttonPlot);
        customView.setStrFunction("");
        customView.setStr("");
        customView.invalidate();
        buttonPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    str = txtStr.getText().toString();
                    strFunction = txtFunction.getText().toString();
                    customView.setStrFunction(strFunction);
                    customView.setStr(str);
                    customView.invalidate();
                }
            }
        });
     Largenbt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(customView!=null){
                 if(customView.getLargen()<=1 && customView.getLargen()-0.2>=0.2) {
                     customView.setLargen(customView.getLargen()-0.2);
                     if(customView.getLargen()<=0.5)
                         customView.setChange(2);
                     customView.invalidate();
                 }
                 else {
                     customView.setLargen(0.2);
                     customView.invalidate();
                     Toast.makeText(MainActivity.this, "不能再放大", Toast.LENGTH_LONG).show();

                 }
             }
         }
     });
     Lessenbt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(customView!=null){
                 if(customView.getLessen()>=1 && customView.getLessen()+0.2<=1.2) {
                     customView.setLessen(customView.getLessen()+0.2);
                     customView.invalidate();
                 }
                 else if(customView.getLargen()<1){
                     customView.setLargen(customView.getLargen()+0.2);
                     customView.invalidate();
                 }
                 else {
                     customView.setLessen(1.2);
                     customView.setChange(0.9);
                     customView.invalidate();
                     Toast.makeText(MainActivity.this, "不能再缩小", Toast.LENGTH_LONG).show();
                 }
             }
         }
     });
     Clearbt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(customView!=null){
                 str="";
                 strFunction="";
                 customView.setStrFunction("");
                 customView.setStr("");
                 customView.invalidate();
             }
         }
     });
     }
}