#!/bin/bash

"""Setup
brew install openjdk@17
/usr/libexec/java_home -v 17
export JAVA_HOME='/Applications/Android Studio.app/Contents/jbr/Contents/Home'
"""

# Array of keys to iterate through
KEYS=(
	"Linux"
	"BurpSuite"
	"Nmap"
	"Wireshark"
	"Nessus"
	"Metasploit"
	"Python"
	"Bash"
	"Java"
	"JavaScript"
	"C++"
)

# Ensure gradlew is executable
chmod +x gradlew

# Loop through each key and generate an APK
for KEY in "${KEYS[@]}"; do
    echo "Building APK with KEY1=$KEY"
    KEY1="$KEY" ./gradlew assembleDebug
    if [ $? -eq 0 ]; then
        echo "Successfully built APK for KEY1=$KEY"
        # Copy APK to temporary file to avoid overwrite
        cp app/build/outputs/apk/debug/app-debug.apk "app/build/outputs/apk/debug/temp-${KEY}.apk"
        if [ $? -eq 0 ]; then
            echo "Copied APK to temp-${KEY}.apk"
            # Optional: Wait 1 second to ensure file operations complete
            sleep 1
            # Rename temporary APK to final lowercase name
			KEY=$(echo $KEY | tr '[:upper:]' '[:lower:]')
            mv "app/build/outputs/apk/debug/temp-${KEY}.apk" "app/build/outputs/apk/debug/${KEY}.apk"
            if [ $? -eq 0 ]; then
                echo "Renamed APK to ${KEY}.apk"
            else
                echo "Failed to rename APK for KEY1=$KEY"
                exit 1
            fi
        else
            echo "Failed to copy APK for KEY1=$KEY"
            exit 1
        fi
    else
        echo "Failed to build APK for KEY1=$KEY"
        exit 1
    fi
done

echo "All APKs generated successfully!"
echo "APKs are located in app/build/outputs/apk/debug/"
