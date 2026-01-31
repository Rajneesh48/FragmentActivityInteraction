package com.example.fragmentactivityinteraction

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragmentactivityinteraction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding
   lateinit var NumChanger: NumChanger
   var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnAdd.setOnClickListener {
//            count = count + 1
            NumChanger.Increment(++count)
        }
        binding.btnSub.setOnClickListener {
            if(count>0){
//                count = count -1
            NumChanger.Decrement(--count)
        }}
    }
    fun radioColorChange(color: Int){
        binding.main.setBackgroundColor(getColor(color))
    }

}