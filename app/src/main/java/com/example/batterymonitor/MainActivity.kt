package com.example.batterymonitor

import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var batteryReceiver: BatteryReceiver
    private lateinit var batteryStatusText: TextView
    private lateinit var lowBatteryInput: EditText
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batteryStatusText = findViewById(R.id.batteryStatus)
        lowBatteryInput = findViewById(R.id.lowBatteryInput)
        val saveThreshold = findViewById<Button>(R.id.saveThreshold)
        val startServiceBtn = findViewById<Button>(R.id.startService)

        prefs = getSharedPreferences("battery_prefs", MODE_PRIVATE)

        val savedThreshold = prefs.getInt("low_battery_threshold", 15)
        lowBatteryInput.setText(savedThreshold.toString())

        saveThreshold.setOnClickListener {
            val input = lowBatteryInput.text.toString()
            if (input.isNotEmpty()) {
                val threshold = input.toInt()
                prefs.edit().putInt("low_battery_threshold", threshold).apply()
            }
        }

        startServiceBtn.setOnClickListener {
            val serviceIntent = Intent(this, BatteryService::class.java)
            startService(serviceIntent)
        }

        batteryReceiver = BatteryReceiver(batteryStatusText)
        registerReceiver(batteryReceiver, BatteryReceiver.getBatteryIntentFilter())
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(batteryReceiver)
    }
}
