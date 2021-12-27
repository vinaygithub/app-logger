package com.support.community.logger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.support.community.applogger.Log

/**
 * @Author: 20.Vinaygupta@gmail.com
 * @Date: 27.12.2021
 */
class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btnAddLog).setOnClickListener {
            counter++
            Log.d(TAG, "My Tag Message : $counter")
        }
    }
}