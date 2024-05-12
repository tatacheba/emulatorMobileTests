# Test automation project for Wikipedia mobile application

## 📃 Content:

-   [Technologies and tools](#tehnologist)
-   [Verified checks](#verified)
-   [Run tests from the terminal](#computer)
-   [Running Tests in Jenkins](#running_tests)
-   [Report on test results in Allure Report](#report_allure_report)
-   [Notifications in Telegram using a bot](#notifications_telegram_bot)
-   [Testvideo](#testvideo)

## <a name="technologist"> Technologies and tools</a>

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="image/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="image/logo/Java.svg">
<img width="6%" title="Selenide" src="image/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="image/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="image/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="image/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="image/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="image/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="image/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="image/logo/Telegram.svg">
<img width="6%" title="Appium" src="image/logo/Appium.svg">
<img width="6%" title="Browserstack" src="image/logo/Browserstack.svg">
</p>

## <a name="verified">Verified checks</a>

-   Check launch screens and search in the app

## <a name="computer">Run tests from the terminal</a>

Local start on emulator:

```
gradle clean test -Ddevice=emulator
```

Local startup on a real device:

```
gradle clean test -Ddevice=real
```

Running in Browserstack:

```
gradle clean test -Ddevice=browserstack
```

## <a name="running_tests">Running Tests in Jenkins</a>

<p align="center">
<a href="https://jenkins.autotests.cloud/job/tatacheba_qaguru_11_22_mobileTestEmulation/"><img src="image/screenshots/jenkins-dashboard.png" alt="Jenkins"/></a>
</p>

### Build features in Jenkins:

-   The assembly can be run through Browserstack, Appium, and a real connected phone.

## <a name="report_allure_report"> Report on test results in Allure report</a>

### Main

<p align="center">
<img title="Allure Overview Dashboard" src="image/screenshots/allure-main-page.png">
</p>

### Tests

<p align="center">
<img title="Allure Tests" src="image/screenshots/allure-test-page.png">
</p>

## <a name="notifications_telegram_bot">Notifications in Telegram using a bot</a>

<p align="center">
<img title="Telegram bot" src="image/screenshots/telegram_bot.png" >
</p>

## <a name="testvideo"> Video example of passing the test

<p align="center">
<img title="Selenoid Video" src="image/gif/testvideo.gif" alt="video"> 
</p>
