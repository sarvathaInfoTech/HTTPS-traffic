# Testing HTTPS Traffic Capture

This guide provides step-by-step instructions for testing the HTTPS traffic capture functionality.

## Prerequisites
- Android TV emulator is set up and running
- Charles Proxy or mitmproxy is installed and configured
- Sample app is installed on the emulator

## Testing Steps

1. Start Charles Proxy or mitmproxy
2. Ensure proxy settings are configured on the emulator (10.0.2.2:8888)
3. Launch the sample app on the emulator
4. Observe the HTTPS traffic in Charles/mitmproxy

## Expected Results
- You should see HTTPS requests to google.com in the proxy tool
- The request and response data should be fully decoded (not encrypted)
- Headers, parameters, and response body should be visible

## Testing with Other Apps

1. Install any other app on the emulator
2. Launch the app while the proxy is running
3. All HTTPS traffic from that app should be captured and decoded

## Common Issues and Solutions

- **No traffic showing**: Verify proxy settings and certificate installation
- **Encrypted traffic**: Check SSL proxying settings in Charles
- **App crashes**: Some apps have certificate pinning which prevents HTTPS interception