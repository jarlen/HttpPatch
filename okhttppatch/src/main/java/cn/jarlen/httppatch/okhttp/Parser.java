package cn.jarlen.httppatch.okhttp;

import okhttp3.Response;

/**
 * DESCRIBE:
 * Created by jarlen on 2016/9/6.
 */
public interface Parser<T> {
    T parse(Response response);
}
