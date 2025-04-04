package com.example.batterymonitor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.widget.TextView

class BatteryReceiver(private val batteryTextView: TextView) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)

        val chargingStatus = if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            "Charging"
        } else {
            "Not Charging"
        }

        batteryTextView.text = "Battery: $level% - $chargingStatus"
    }

    companion object {
        fun getBatteryIntentFilter(): IntentFilter {
            return IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        }
    }
}
