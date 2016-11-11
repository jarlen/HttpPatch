package cn.jarlen.httppatch.okhttp;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 * DESCRIBE:
 * Created by hjl on 2016/10/31.
 */

public class UIHandler extends Handler implements Executor{

    private static UIHandler uiHandler = null;

    public UIHandler(){
        super(Looper.getMainLooper());
    }

    public static UIHandler newInstance(){
        if(uiHandler == null){
            uiHandler = new UIHandler();
        }
        return uiHandler;
    }

    @Override
    public void execute(Runnable command) {
        post(command);
    }
}
