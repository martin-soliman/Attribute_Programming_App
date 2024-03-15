package com.example.attribute_programming_app.presentation

import com.example.attribute_programming_app.bluetooth.chat.BluetoothDeviceDomain

data class BluetoothUiState (
    val scannedDevices: List<BluetoothDeviceDomain> = emptyList(),
    val pairedDevices: List<BluetoothDeviceDomain> = emptyList()
)