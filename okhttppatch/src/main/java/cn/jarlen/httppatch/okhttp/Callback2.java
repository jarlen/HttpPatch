/*
 *          Copyright (C) 2016 jarlen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package cn.jarlen.httppatch.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * DESCRIBE: main thread callback
 * (for okhttp)
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
        try {
            final String body = response.body().string();
            UIHandler.newInstance().post(new Runnable() {
                @Override
                public void run() {
                    onResponse(body);
                }
            });
        } catch (final IOException e) {
            UIHandler.newInstance().post(new Runnable() {
                @Override
                public void run() {
                    onFailure(e);
                }
            });
        } catch (final Exception e2) {
            UIHandler.newInstance().post(new Runnable() {
                @Override
                public void run() {
                    onFailure(e2);
                }
            });
        }
    }

    public abstract void onResponse(String body);

    public abstract void onFailure(Exception e);
}
