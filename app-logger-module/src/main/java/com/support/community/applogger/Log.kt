package com.support.community.applogger

/**
 * @Author: 20.Vinaygupta@gmail.com
 * @Date: 27.12.2021
 */
object Log {

    private var loggerCollections = LoggerCollection()
    private var workerList = mutableListOf<()->Unit>()
    private val lock = Object()

    init{
        Thread {
            while(true){
                synchronized(lock){
                    if(workerList.isEmpty()){
                        lock.wait()
                    }else{
                        workerList.removeFirst().invoke()
                    }
                }
            }
        }.start()
    }

    fun setLogger(logger: Logger? = null ) {
        loggerCollections.setLogger(logger)
    }

    @JvmStatic
    fun i(tag: String?, message: String) {
        workerAction {
            loggerCollections.i(tag, message)
        }
    }

    @JvmStatic
    fun e(tag: String?, message: String) {
        workerAction {
            loggerCollections.e(tag, message)
        }
    }

    @JvmStatic
    fun e(tag: String?, message: String?, throwable: Throwable) {
        workerAction {
            loggerCollections.e(tag, message, throwable)
        }
    }

    @JvmStatic
    fun d(tag: String?, message: String) {
        workerAction {
            loggerCollections.d(tag, message)
        }
    }

    @JvmStatic
    fun d(tag: String?, message: String?, throwable: Throwable) {
        workerAction {
            loggerCollections.d(tag, message, throwable)
        }
    }

    @JvmStatic
    fun v(tag: String?, message: String) {
        workerAction {
            loggerCollections.v(tag, message)
        }
    }

    @JvmStatic
    fun w(tag: String?, message: String) {
        workerAction {
            loggerCollections.w(tag, message)
        }
    }

    private fun workerAction(execute : () -> Unit){
        synchronized(lock) {
            workerList.add(execute)
            lock.notify()
        }
    }
}