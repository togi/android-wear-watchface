Android Wear Watchface Sample
=============================

This is a small sample to show what the current watchface API in Android Wear looks like. Currently,
you can make a watchface show up in the the watchface picker, and pick it as your watchface.

Unfortunately, the API to actually configure how your watchface should interact with the rest of the
system isn't public. To use it, you need to sign your APK with either the system certificate, or
with the same certificate as the launcher (package:com.google.android.wearable.app) on your device.

This sample application is only provided as a reference of how the Watchface API currently is
implemented on Android Wear. I don't know if or when this will become a public API, but you should
probably assume it will change by the time they do make it public.

Screenshots
-----------

![Watchface in the picker](https://github.com/togi/android-wear-watchface/raw/master/picker.png)
![Watchface on the home screen](https://github.com/togi/android-wear-watchface/raw/master/screen.png)


License
-------

       Copyright 2014 Marcus Forsell Stahre

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.
