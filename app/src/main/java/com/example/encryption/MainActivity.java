package com.example.encryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    Button b1,b2;
    EditText editText;
    TextView textView;
    String s,e="";
    int key=1,i,n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encrypt();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrypt();
            }
        });


    }



    public void encrypt(){

        s=editText.getText().toString();

        for(i=0;i<s.length();i++){

            n=s.charAt(i);
            n=n-32;
            n=((n+key)%95)+32;
            char c=(char)n;
            e=e+c;



        }

        textView.setText(e);
        e="";




    }

    public void decrypt(){
        s=editText.getText().toString();
        for(i=0;i<s.length();i++){

            n=s.charAt(i);
            n=n-32;
            n=((n+(key*-1))%95)+32;
            char c=(char)n;

            e=e+c;

        }
       textView.setText(e);
        e="";//to empty the text view unless string will concatenate again



    }








}
