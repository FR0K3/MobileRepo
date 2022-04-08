package com.rodriguez.a06navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.rodriguez.a06navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.actionChange.setOnClickListener() {
            //navController.navigate(R.id.action_nameFragment_to_lastNameFragment)
            //navController.navigate(R.id.lastNameFragment)
            val action = NameFragmentDirections.actionNameFragmentToLastNameFragment("Roque")
            navController.navigate(action)

        }

    }
}