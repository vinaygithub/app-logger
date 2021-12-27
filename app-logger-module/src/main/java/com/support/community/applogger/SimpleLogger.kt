package com.support.community.applogger

/**
 * @Author: 20.Vinaygupta@gmail.com
 * @Date: 27.12.2021
 */

class SimpleLogger : Logger {

    override fun i(tag: String?, message: String) {
        android.util.Log.i(tag, message)
    }

    override fun e(tag: String?, message: String) {
        android.util.Log.e(tag, message)
    }

    override fun e(tag: String?, message: String?, throwable: Throwable) {
        android.util.Log.e(tag, message, throwable)
    }

    override fun d(tag: String?, message: String) {
        android.util.Log.d(tag, message)
    }

    override fun d(tag: String?, message: String?, throwable: Throwable) {
        android.util.Log.d(tag, message, throwable)
    }

    override fun v(tag: String?, message: String) {
        android.util.Log.v(tag, message)
    }

    override fun w(tag: String?, message: String) {
        android.util.Log.w(tag, message)
    }
}