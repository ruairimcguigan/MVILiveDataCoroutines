package com.demo.mvilivedatacoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.mvilivedatacoroutines.ui.main.movie.MovieFragment

class HostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MovieFragment.newInstance())
                    .commitNow()
        }
    }
}
