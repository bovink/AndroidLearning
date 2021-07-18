package com.bovink.androidlearning

import android.Manifest
import android.R.id.message
import android.content.pm.PackageManager
import android.location.*
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.permissionx.guolindev.PermissionX


class MainActivity : AppCompatActivity() {
    var textview:TextView? = null
    var message = ""
    var locationListener: LocationListener = object : LocationListener {
        //当位置改变的时候调用
        override fun onLocationChanged(location: Location) {
            //经度
            val longitude: Double = location.getLongitude()
            //纬度
            val latitude: Double = location.getLatitude()

            //海拔
            val altitude: Double = location.getAltitude()
            var locationStr = longitude.toString() + "_" + latitude
//            launcher.callExternalInterface("getLocationSuccess", locationStr)
        }

        //当GPS状态发生改变的时候调用
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
            when (status) {
                LocationProvider.AVAILABLE -> message = "当前GPS为可用状态!"
                LocationProvider.OUT_OF_SERVICE -> message = "当前GPS不在服务内!"
                LocationProvider.TEMPORARILY_UNAVAILABLE -> message = "当前GPS为暂停服务状态!"
            }
//            launcher.callExternalInterface("GPSStatusChanged", message)
        }

        //GPS开启的时候调用
        override fun onProviderEnabled(provider: String) {
            message = "GPS开启了!"
//            launcher.callExternalInterface("GPSOpenSuccess", message)
        }

        //GPS关闭的时候调用
        override fun onProviderDisabled(provider: String) {
            message = "GPS关闭了!"
//            launcher.callExternalInterface("GPSClosed", message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PermissionX.init(this)
                .permissions(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .request { allGranted, grandedLIst, deniList ->
                    if (allGranted) {
                        Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "These permissions are denied: $deniList", Toast.LENGTH_LONG).show()
                    }

                }


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { getLocation() }
        textview = findViewById(R.id.textView)
    }

    private fun getLocation() {
        if (Build.VERSION.SDK_INT >= 23) { // android6 执行运行时权限
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 0)
            }
        }

        val criteria = Criteria()
        criteria.accuracy = Criteria.ACCURACY_COARSE //低精度，如果设置为高精度，依然获取不了location。

        criteria.isAltitudeRequired = false //不要求海拔

        criteria.isBearingRequired = false //不要求方位

        criteria.isCostAllowed = true //允许有花费

        criteria.powerRequirement = Criteria.POWER_LOW //低功耗

        //获取LocationManager
        //获取LocationManager
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        // 获取最好的定位方式

        // 获取最好的定位方式
        var provider = locationManager.getBestProvider(criteria, true) // true 代表从打开的设备中查找


        // 获取所有可用的位置提供器

        // 获取所有可用的位置提供器
        val providerList = locationManager.getProviders(true)
        // 测试一般都在室内，这里颠倒了书上的判断顺序
        // 测试一般都在室内，这里颠倒了书上的判断顺序
        provider = if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            LocationManager.NETWORK_PROVIDER
        } else if (providerList.contains(LocationManager.GPS_PROVIDER)) {
            LocationManager.GPS_PROVIDER
        } else {
            // 当没有可用的位置提供器时，弹出Toast提示用户
            Toast.makeText(this, "Please Open Your GPS or Location Service", Toast.LENGTH_SHORT).show()
            return
        }


        //获取上次的location
        var location = locationManager.getLastKnownLocation(provider);

        /**
         * 参1:选择定位的方式
         * 参2:定位的间隔时间
         * 参3:当位置改变多少时进行重新定位
         * 参4:位置的回调监听
         */
        locationManager.requestLocationUpdates(provider, 10000L, 0f, locationListener);
        while (location == null) {
            location = locationManager.getLastKnownLocation(provider);
        }
        //移除更新监听
        locationManager.removeUpdates(locationListener);
        //不为空,显示地理位置经纬度
        //经度
        val longitude = location.getLongitude();
        //纬度
        val latitude = location.getLatitude();
        //海拔
        val altitude = location.getAltitude();
        val locationStr = longitude.toString() + "_" + latitude.toString();
        println("location=$locationStr")
        textview?.text = locationStr
    }


    override fun onResume() {
        super.onResume()
    }
}