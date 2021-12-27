package com.support.community.logger

import android.app.Application
import com.support.community.applogger.Log
import com.support.community.applogger.SimpleLogger

/**
 * @Author: 20.Vinaygupta@gmail.com
 * @Date: 27.12.2021
 */
class LoggerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setLoggers()
    }

    private fun setLoggers(){
        //==> NOTE : Remote Logger and File Logger can not set together,
        //==> as they are inheriting Event-logger, and post processing we are clearing events
        //==> Though SimpleLogger can be used together along with RemoteLogger or FileLogger


        //==> 1 : if we are using base-url : http://localhost:8080 then make sure device is connected with usb
        //==> and adb command set as 'adb reverse tcp:8080 tcp:8080'
        //==> 2 : As we are using http command so in 'network' module network_security_config.xml must enable 'cleartextTrafficPermitted="true"'
        //==> 3 : Make sure node-server is started: 'node server.js'
        //==> 4 : Open browser : with url  'http://localhost:8080' in order to see event logs
        //    Log.setLogger(RemoteLogger())

        //==> 1 : FileLogger creates log in device application internal storage 'files/logs/<session>/<Index>.log'
        //==> 2 : When file thresh-hold size increases then another file will be created inside session directory. In every launch new session is created
        //Log.setLogger(FileLogger(this.filesDir, Format.TEXT))

        //==> 1 : Simple Logger is a Android console-logger, it can be set along with any other logger, e.g
        //==> Log.setLogger(SimpleLogger())    Log.setLogger(FileLogger(this.filesDir))
        Log.setLogger(SimpleLogger())
    }
}