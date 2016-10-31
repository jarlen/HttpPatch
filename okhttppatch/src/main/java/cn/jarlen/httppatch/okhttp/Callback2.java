package cn.jarlen.httppatch.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * DESCRIBE:
 * Created by jarlen on 2016/9/6.
 */
public abstract class Callback2 implements okhttp3.Callback {

    @Override
    public void onFailure(Call call, final IOException e) {
        UIHandler.newInstance().post(new Runnable() {
            @Override
            public void run() {
                onFailure(e);
            }
        });
    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        UIHandler.newInstance().post(new Runnable() {
            @Override
            public void run() {
                onResponse(response);
            }
        });
    }

    public abstract void onResponse(Response response);

    public abstract void onFailure(IOException e);
}
