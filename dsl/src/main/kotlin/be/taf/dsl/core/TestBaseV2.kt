package be.taf.dsl.core

import be.taf.web.driver.ChromeDriverSettings
import be.taf.web.driver.Driver
import be.taf.web.driver.DriverSettings
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.RemoteWebDriver

open class TestBaseV2 {

    /**
     * Get default driver settings based on the driver type
     */
    inline fun <reified T : RemoteWebDriver> defaultDriverSettings(): DriverSettings {
        println(T::class)

        return when (T::class) {
            ChromeDriver::class -> ChromeDriverSettings(chromeDriverPath = "D:\\chromedriver\\107\\chromedriver.exe")
            // Use Chrome as default browser if no specific browser is specified
            RemoteWebDriver::class -> ChromeDriverSettings(chromeDriverPath = "D:\\chromedriver\\107\\chromedriver.exe")
            else -> {
                println(T::class)
                throw IllegalArgumentException("Driver type ${T::class} not implemented")
            }
        }
    }


    /**
     * Initiate a driver for a new web browser test
     * @param settings Settings for initiating the driver
     * @param actions Actions which should be performed on the driver instance
     */
    inline fun <reified T : RemoteWebDriver> usingWebBrowser(
        settings: DriverSettings = defaultDriverSettings<T>(),
        actions: Driver<T>.() -> Unit
    ) {
        val driver = Driver<T>(settings)

        driver.use {
            actions(it)
        }
    }
}
