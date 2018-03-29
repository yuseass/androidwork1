package com.example.myproject1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class MyService extends Service {
    public MyService() {

    }

    private Thread workThread;

    public void onCreate(){
        super.onCreate();
        workThread=new Thread(null,backgroundWork,"WorkThread");

    }

    public void onStart(Intent intent,int starid){
        super.onStart(intent, starid);
        if(!workThread.isAlive()){

            workThread.start();
        }

    }


    public void onDestroy(){
        super.onDestroy();
        workThread.interrupt();
    }




    @Override
    public IBinder onBind(Intent intent) {

        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //private static int seconds=0;

    private Runnable backgroundWork=new Runnable() {
        @Override
        public void run() {
            try {
            while (!Thread.interrupted()) {
                Thread.sleep(1000);
                int seconds = MainActivity.seconds + 1;
                MainActivity.UpdateGUI(seconds);



            }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



        }
    };


}
