AndroJNCryptor
=========

JNCryptor for Android 

This is a fork of the code found at https://code.google.com/p/jncryptor by dun...@worthread.com (https://code.google.com/u/109998297732361046449/)

The code is modified to work on Android earlier than Gingerbread and compatible upwards, starting from Android SDK 7 with the aid of using SpongyCastle.

The project is Eclipse compatible and compilable, the modified sources can be found within AndroJNCryptor directory, in which the earliest SDK is 7 (Eclair) right up to 17 (JellyBean)

The following libraries are required:

 - sc-light-jdk15on-1.47.02 (http://rtyley.github.io/spongycastle/)
 - scprov-jdk15on-1.47.02 (http://rtyley.github.io/spongycastle/)

 
 Removed Defunct SLF4J Logger, and replaced with custom Logger class.
 Removed dependencies on commons-io-2.4.jar and commons-lang3-3.1.jar libraries
 
# Motive

To enable cross-encryption/decryption between Android and iPhone via way of RNCryptor (https://github.com/t0mm13b/RNCryptor) targetting iPhone iOS 4.2+ and also for supporting older Android versions.

# Simple example

To Encrypt:

```java
JNCryptor crypt = JNCryptorFactory.getCryptor();
JNCryptorSettings jnCryptSettings = new JNCryptorSettings(1000);
byte[] cipher = null;
try {
	cipher = crypt.encryptData(
		"If you can read this, then JNCryptor (Android SDK 7+/Eclair) has worked. The quick brown fox jumped over the lazy dog and ran away".getBytes(), 
		"f00b4r".toCharArray(),
		jnCryptSettings);
} catch (CryptorException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
if (cipher != null){
	// Using Base64 utility help to encode the cipher-text!
	String sCipher64 = Base64.encodeToString(cipher, Base64.NO_WRAP);
	Log.d(TAG, "JNCryptor encoded: " + sCipher64);
}
```

To Decrypt:

```java
JNCryptor crypt = JNCryptorFactory.getCryptor();
JNCryptorSettings jnCryptSettings = new JNCryptorSettings(1000);
String jncryptdData = "AgHKqnNEbURnihKZ3ixaHeMH9LmOFcyE+RBPXKXSV0ur1VgD+hdyMIeVfB1c3qksK8DOMFkKNRbP1aClavcCTUlQVGC1xphb0hisTJBsBQM9ppmBJcRx7tVwg9Q4Z+tjMvM+M8wGAkyrK0EKDF1yKLKZlIwTAd8TES7LR8Ww1FfuxuBrZMQqio8F2rzFJ4Ekn/vsB7mDL8UpYhu9ocUNqtJpEiL1ReW2Z4fNBpoZkkdEgoMzb5AAU0Ci3yJf2mAsCug=";
// Using Base64 utility help to encode the cipher-text!
byte[] b = Base64.decode(jncryptdData, Base64.NO_WRAP);
Log.d(TAG, "Encrypted+Base64'd via JNCryptor: " + jncryptdData);
try {
	cipher = crypt.decryptData(b, "f00b4r".toCharArray(), jnCryptSettings);
} catch (InvalidHMACException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (CryptorException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
if (cipher != null){
	String sCipher = new String(cipher);
	Log.d(TAG, "Decryption via JNCryptor: " + sCipher);
}
```

# Note

Base64.java is taken from the AOSP source project (found in frameworks/base/core/java/android/util).
