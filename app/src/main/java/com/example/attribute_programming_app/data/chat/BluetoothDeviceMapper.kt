package com.example.attribute_programming_app.data.chat

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.example.attribute_programming_app.bluetooth.chat.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}