package com.support.community.applogger
/**
 * @Author: 20.Vinaygupta@gmail.com
 * @Date: 27.12.2021
 */
interface Logger {
    fun i(tag: String?, message: String)
    fun e(tag: String?, message: String)
    fun e(tag: String?, message: String?, throwable: Throwable)
    fun d(tag: String?, message: String)
    fun d(tag: String?, message: String?, throwable: Throwable)
    fun v(tag: String?, message: String)
    fun w(tag: String?, message: String)
}
