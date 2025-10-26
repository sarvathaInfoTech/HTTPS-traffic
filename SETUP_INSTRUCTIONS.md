# Android TV HTTPS Traffic Capture Setup Instructions

This guide will help you set up an Android TV emulator and capture HTTPS traffic from any app.

## 1. Set Up Android TV Emulator

1. Open Android Studio
2. Go to Tools > AVD Manager
3. Click "Create Virtual Device"
4. Select "TV" category and choose "Android TV (1080p)" or similar
5. Select a system image (Android 11 or newer recommended)
6. Complete the setup with default settings

## 2. Install Charles Proxy or mitmproxy

### Charles Proxy (Recommended)
1. Download and install Charles Proxy from [charlesproxy.com](https://www.charlesproxy.com/)
2. Start Charles Proxy
3. Go to Proxy > Proxy Settings and ensure it's listening on port 8888
4. Go to Help > SSL Proxying > Install Charles Root Certificate on a Mobile Device

### mitmproxy Alternative
1. Install mitmproxy: `brew install mitmproxy`
2. Run mitmproxy: `mitmproxy --listen-port 8888`

## 3. Configure Emulator for HTTPS Capture

1. Start your Android TV emulator
2. Open Settings > Network & Internet > Wi-Fi
3. Long-press on the connected network and select "Modify network"
4. Check "Advanced options"
5. Change Proxy settings to "Manual"
6. Set Proxy hostname to "10.0.2.2" (special IP that routes to host machine)
7. Set Proxy port to "8888"
8. Save the settings

## 4. Install Certificate on Emulator

1. In Charles, go to Help > SSL Proxying > Install Charles Root Certificate on a Mobile Device
2. On the emulator, open a browser and navigate to chls.pro/ssl
3. Download and install the certificate
4. Go to Settings > Security & restrictions > Encryption & credentials > Install a certificate > CA certificate
5. Follow the prompts to install the certificate

## 5. Configure Charles for SSL Proxying

1. In Charles, go to Proxy > SSL Proxying Settings
2. Check "Enable SSL Proxying"
3. Click "Add" and enter "*" for Host and "443" for Port
4. Click OK to save

## 6. Test with Sample App or Any App

1. Install the sample app or any other app on the emulator
2. Launch the app
3. All HTTPS traffic should now be visible and decoded in Charles

## 7. Troubleshooting

If you're not seeing HTTPS traffic:
1. Verify proxy settings are correct
2. Ensure the certificate is properly installed
3. Check that SSL proxying is enabled in Charles
4. Restart the app and Charles

## 8. Using with Other Apps

This setup will work with any app installed on the emulator. Simply:
1. Install the target app
2. Launch it while Charles is running
3. All HTTPS traffic will be captured and decoded