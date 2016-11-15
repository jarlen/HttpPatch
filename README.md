# HttpPatch

dependencies {
     ......
   
    compile 'cn.jarlen.maven:okhttp-patch:3.4.2'
}

##USAGE

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
