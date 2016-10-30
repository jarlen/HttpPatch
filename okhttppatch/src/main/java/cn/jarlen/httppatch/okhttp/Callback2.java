package cn.jarlen.httppatch.okhttp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.Call;
import okhttp3.Response;

/**
 * DESCRIBE:
 * Created by jarlen on 2016/9/6.
 */
public abstract class Callback2 implements okhttp3.Callback {

    @Override
    public void onFailure(Call call, IOException e) {
        Message message = Message.obtain();
        message.what = CALLBACK_FAILED;
        message.obj = e;
        mHandler.sendMessage(message);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
            Message message = Message.obtain();
            message.what = CALLBACK_SUCCESSFUL;
            message.obj = response;
            mHandler.sendMessage(message);
        } else {
            Message message = Message.obtain();
            message.what = CALLBACK_FAILED;
            mHandler.sendMessage(message);
        }
    }

    private static final int CALLBACK_SUCCESSFUL = 0x01;
    private static final int CALLBACK_FAILED = 0x02;
    private Handler mHandler = new UIHandler(this);

    public static class UIHandler<T> extends Handler {
        private WeakReference mWeakReference;

        public UIHandler(Callback2 callback) {
            super(Looper.getMainLooper());
            mWeakReference = new WeakReference(callback);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CALLBACK_SUCCESSFUL: {
                    Response response = (Response) msg.obj;
                    Callback2 callback = (Callback2) mWeakReference.get();
                    if (callback != null) {
                        callback.onResponse(response);
                    }
                }
                break;
                case CALLBACK_FAILED: {
                    IOException e = (IOException) msg.obj;
                    Callback2 callback = (Callback2) mWeakReference.get();
                    if (callback != null) {
                        callback.onFailure(e);
                    }
                }
                break;
            }
        }
    }

    public abstract void onResponse(Response response);

    public abstract void onFailure(IOException e);
}
