package cn.jarlen.httppatch.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.jarlen.httppatch.okhttp.Callback2;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = (TextView) findViewById(R.id.resultTv);
        findViewById(R.id.testBtn).setOnClickListener(this);
    }

    OkHttpClient mOkHttpClient = null;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.testBtn:

                if(mOkHttpClient == null){
                    mOkHttpClient = new OkHttpClient();
                }

                RequestBody requestBody = new FormBody.Builder().add("a","test").build();
                Request.Builder builder = new Request.Builder();
                builder.url("http://192.168.18.100/waiterserver/api.php");
                builder.post(requestBody);
                Request request = builder.build();
                Call mCall= mOkHttpClient.newCall(request);

                mCall.enqueue(callback2);




                break;
            default:

                break;
        }
    }

    private Callback2 callback2 = new Callback2() {

        @Override
        public void onResponse(String body) {
            String string = body;
            resultTv.setText(string);
        }

        @Override
        public void onFailure(Exception e) {

        }
    };
}
