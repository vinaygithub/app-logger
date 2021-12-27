package com.support.community.applogger

/**
 * @Author: 20.Vinaygupta@gmail.com
 * @Date: 27.12.2021
 */
internal class LoggerCollection : Logger {

    private val loggerList = mutableListOf<Logger>()

    fun setLogger(logger: Logger?) {
        if(logger == null){
            loggerList.clear()
        } else {
            //Add only one event logger, because we are removing the items
//            if(loggerList.filterIsInstance<EventLogger>().isNotEmpty() && logger is EventLogger) {
//                throw Exception("One event logger already exists, no additional logger can be added ${logger::class.java}")
//            }
            loggerList.add(logger)
        }
    }
    override fun i(tag: String?, message: String) {
        loggerList.forEach { it.i(tag, message) }
    }

    override fun e(tag: String?, message: String) {
        loggerList.forEach { it.e(tag, message) }
    }

    override fun e(tag: String?, message: String?, throwable: Throwable) {
        loggerList.forEach { it.e(tag, message, throwable) }
    }

    override fun d(tag: String?, message: String) {
        loggerList.forEach { it.d(tag, message) }
    }

    override fun d(tag: String?, message: String?, throwable: Throwable) {
        loggerList.forEach { it.d(tag, message, throwable) }
    }

    override fun v(tag: String?, message: String) {
        loggerList.forEach { it.v(tag, message) }
    }

    override fun w(tag: String?, message: String) {
        loggerList.forEach { it.w(tag, message) }
    }


}
