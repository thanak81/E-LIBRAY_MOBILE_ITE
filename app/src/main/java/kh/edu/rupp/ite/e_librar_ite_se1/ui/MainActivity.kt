package kh.edu.rupp.ite.e_librar_ite_se1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kh.edu.rupp.ite.e_librar_ite_se1.R
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment);
        val bottomNav = binding.bottomNavigationView;

        bottomNav.setupWithNavController(navController);
    }
}