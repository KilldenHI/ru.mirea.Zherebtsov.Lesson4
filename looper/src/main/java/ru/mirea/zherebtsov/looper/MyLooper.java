package ru.mirea.zherebtsov.looper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends	Thread{
    private Handler mainHandler;
    public Handler mHandler;
    public	MyLooper(Handler	mainThreadHandler)	{
        mainHandler	=mainThreadHandler;
    }

    public	void	run()	{
        Log.d("MyLooper",	"run");
        Looper.prepare();
        mHandler = new	Handler(Looper.myLooper()) {
            public void handleMessage(Message msg)	{
                String	data = msg.getData().getString("KEY");
                Log.d("MyLooper	get	message: ", data);

                int age = msg.getData().getInt("age");
                String occupation = msg.getData().getString("occupation");
                try {
                    Thread.sleep(age * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("Work", "Твой возрост: " + age +" Твоя работа: " + occupation);

                int	count	=	data.length();
                Message	message	=	new Message();
                Bundle bundle	=	new Bundle();
                bundle.putString("result",	String.format("The	number	of	letters	in	the	word	%s	is	%d	",data,count));
                message.setData(bundle);
                mainHandler.sendMessage(message);
            }
        };
        Looper.loop();
    }
}
