package kh.edu.rupp.ite.e_librar_ite_se1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kh.edu.rupp.ite.e_librar_ite_se1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Intent(this,MainActivity2::class.java).also{
                startActivity(it)
            }
        }
    }
}