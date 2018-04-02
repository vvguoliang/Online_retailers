package net.wexpt.com.wexpt.kotlinpermissions


interface PermissionCallBack {

    fun permissionGranted() {
    }

    fun permissionDenied() {
    }
}