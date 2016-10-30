package cn.jarlen.httppatch.okhttp;

import okhttp3.MediaType;

/**
 * DESCRIBE:
 * Created by jarlen on 2016/10/28.
 */

public class ContentType {

    public static final MediaType JSON = MediaType.parse("application/json; chartset=utf-8");
    public static final MediaType TEXT = MediaType.parse("Content-Type:text/html;charset=utf-8");

}
