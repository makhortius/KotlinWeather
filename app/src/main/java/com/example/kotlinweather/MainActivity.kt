package com.example.kotlinweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinweather.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ThreadsFragment.newInstance())
            .commitNow()
        return true
    }
}
