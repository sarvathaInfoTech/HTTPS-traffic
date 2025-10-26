package com.huntdigitalmedia.tvapp

import android.app.Application
import android.util.Log
import java.net.InetSocketAddress
import java.net.Proxy

class NetworkCaptureApplication : Application() {
    
    companion object {
        const val TAG = "NetworkCapture"
        
        // Proxy settings - update these with your proxy tool's address and port
        const val PROXY_HOST = "10.0.2.2" // Default for localhost on Android emulator
        const val PROXY_PORT = 8888 // Default Charles Proxy port
        
        // Set to true to enable proxy for all network requests
        var proxyEnabled = true
        
        // Create proxy configuration
        val proxy: Proxy by lazy {
            Proxy(Proxy.Type.HTTP, InetSocketAddress(PROXY_HOST, PROXY_PORT))
        }
    }
    
    override fun onCreate() {
        super.onCreate()
        
        // Set system properties for proxy
        if (proxyEnabled) {
            try {
                System.setProperty("http.proxyHost", PROXY_HOST)
                System.setProperty("http.proxyPort", PROXY_PORT.toString())
                System.setProperty("https.proxyHost", PROXY_HOST)
                System.setProperty("https.proxyPort", PROXY_PORT.toString())
                
                Log.d(TAG, "Proxy configured: $PROXY_HOST:$PROXY_PORT")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to set proxy", e)
            }
        }
    }
}