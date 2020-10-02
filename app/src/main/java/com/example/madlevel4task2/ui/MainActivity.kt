package com.example.madlevel4task2.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.madlevel4task2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "MAD Level 4 Task 2"

        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        menuToggler(menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnGameHistory -> {
                navController.navigate(R.id.action_gameFragment_to_gameHistoryFragment)
                true
            }
            android.R.id.home -> {
                navController.navigate(R.id.action_gameHistoryFragment_to_gameFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun menuToggler(menu: Menu) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(R.id.gameFragment)) {
                menu.findItem(R.id.btnGameHistory).isVisible = true
                menu.findItem(R.id.btnDelete).isVisible = false
                supportActionBar?.title = "MAD Level 4 Task 2"
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            } else {
                menu.findItem(R.id.btnGameHistory).isVisible = false
                menu.findItem(R.id.btnDelete).isVisible = true
                supportActionBar?.title = "Your Game History"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
    }
}