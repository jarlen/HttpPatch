package cn.jarlen.httppatch.okhttp;

/**
 * DESCRIBE: String data parser
 * Created by jarlen on 2016/11/12.
 */

public class StringParser implements Parser<String> {
    @Override
    public String parse(String body) {
        return body;
    }
}
