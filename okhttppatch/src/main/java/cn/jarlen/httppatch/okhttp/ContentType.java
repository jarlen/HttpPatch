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

import okhttp3.MediaType;

/**
 * DESCRIBE: MediaType.class
 * Created by jarlen on 2016/10/28.
 */

public class ContentType {

    public static final MediaType JSON = MediaType.parse("application/json; chartset=utf-8");
    public static final MediaType TEXT = MediaType.parse("Content-Type:text/html;charset=utf-8");

}
