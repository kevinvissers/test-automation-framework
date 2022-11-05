package be.taf.web.driver

import org.openqa.selenium.chrome.ChromeOptions

sealed class DriverSettings

data class ChromeDriverSettings(
    val chromeDriverPath: String,
    val chromeOptions: ChromeOptions = ChromeOptions().addArguments("--disable-gpu"),
) : DriverSettings()
