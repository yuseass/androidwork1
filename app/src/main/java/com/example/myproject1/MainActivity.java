package com.example.myproject1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button bt1;
    private Button bt2;
    private Button bt3;

    private static Handler handler=new Handler();
    private static TextView textview=null;
    public static int seconds;

    public static  void UpdateGUI(int refreshSeconds){
        seconds=refreshSeconds;
        handler.post(Refresh);

    }

    private static Runnable Refresh=new Runnable(){

        public void run(){

                textview.setText(String.valueOf(seconds)+"s");

        }

    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=(TextView)findViewById(R.id.textView2);
        bt1=(Button)findViewById(R.id.button1);//启动
        bt2=(Button)findViewById(R.id.button2);//快进
        bt3=(Button)findViewById(R.id.button3);//停止

        final Intent serviceIntent=new Intent(this,MyService.class);


        bt1.setOnClickListener(new Button.OnClickListener(){


            @Override
            public void onClick(View view) {

                startService(serviceIntent);

            }
        });


        bt2.setOnClickListener(new Button.OnClickListener(){


            @Override
            public void onClick(View view) {
                UpdateGUI(seconds+10);
            }
        });





        bt3.setOnClickListener(new Button.OnClickListener(){


            @Override
            public void onClick(View view) {
                stopService(serviceIntent);
            }
        });



    }









}
