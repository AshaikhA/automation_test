# automation_test

===============================================
Mobile app testing automation with Appium and Android Studio.
===============================================

=========================================================================================================
# This document provides information on how to run the project and the stack requirements for running it.
=========================================================================================================

## Technology stack.
=======================
The environments I worked on for test automation of mobile app testing are:

S.No	Platform / Tool / Software	                          Version / Measure
 1	    Operating System	                                     Windows 10
 2	    Appium	                                                 1.7.1
 3	    Android Studio	                                         3.2.1
 4	    JDK – Java	                                             8.0.1810.13
 5	    Selenium – WebDriver – Java Libraries                    3.14.0
 6      Selenium – Standalone Server                             selenium-server-standalone 3.14.0.jar
 7	    Mobile Emulator - Pixel 2 XL API 25	                     Android Version(Android 7.1.1,API 25).
 
 
## Step to Step instructions for How to execute the " Mobile Testing automation script". 
======================================================================================= 
 Step 1: Manually create virtual device or emulator in android studio.
 Step 2: launch and Start Appium.
 Step 3: Launch emulator & execute test script.
 
 
## Steps to start mobile emulator or Android Virtual Device.
============================================================ 
Open android studio.
Open your project.
Click on AVD Manager.
Verify if device is being detected properly or not.
install apk in emulator.
Open command prompt and give following command c:\{folderpath} adb devices.
You should be seeing one virtual device running along with the port, which means the emulator had successfully started.


## Step to execute test script.
============================
Select the project view in android studio
Right click on the java file or double click the java file node, and on the right side of the android studio editor right click to open the context menu and select the menu option Run {TestClass.java}
The test execution starts, you may want to keep the emulator on the front to see the execution happening.
In order to see any debug messages you could see the log that gets printed on the appium server or in the event logger of Android Studio
Once execution is complete you can see the results in Android Studio console saying script execution complete and passed.
 