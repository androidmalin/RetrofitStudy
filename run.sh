#!/bin/bash
adb shell am force-stop com.malin.retrofit
gradle -q installDebug -x lint  --build-cache --daemon --parallel --offline --continue
adb shell am start com.malin.retrofit/.MainActivity
