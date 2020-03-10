package com.demo.mvilivedatacoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.host_activity)
        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, MovieFragment.newInstance())
//                    .commitNow()
        }
    }
}
