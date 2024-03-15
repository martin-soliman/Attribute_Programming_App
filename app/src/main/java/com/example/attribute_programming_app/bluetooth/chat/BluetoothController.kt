package com.example.attribute_programming_app.bluetooth.chat

import kotlinx.coroutines.flow.StateFlow

//interface which handles main bluetooth operations (scans, connections, etc.)
interface BluetoothController {
    val scannedDevices: StateFlow<List<BluetoothDeviceDomain>>
    val pairedDevices: StateFlow<List<BluetoothDeviceDomain>>

    fun startDiscovery()
    fun stopDiscovery()

    fun release()
}