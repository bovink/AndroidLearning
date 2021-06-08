package com.bovink.androidlearning

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

/**
 * @author bovink
 * @since 2021/2/16
 */
class WordDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_detail)
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment2) as NavHostFragment
        fragment.navController.setGraph(R.navigation.nav_detail, intent.extras)

    }
}