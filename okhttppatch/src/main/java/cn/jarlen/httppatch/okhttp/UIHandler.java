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

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 * DESCRIBE: message handler
 * Created by jarlen on 2016/10/31.
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
