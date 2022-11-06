package be.taf.dsl.core

import be.taf.web.driver.ChromeDriverSettings
import be.taf.web.driver.Driver
import be.taf.web.driver.DriverSettings

open class TestBaseV2 {
    companion object Defaults {
        private val chromeDriverSettings =
            ChromeDriverSettings(chromeDriverPath = "D:\\chromedriver\\107\\chromedriver.exe")
    }

    /**
     * Initiate a driver for a new web browser test
     * @param settings Settings for initiating the driver
     * @param actions Actions which should be performed on the driver instance
     */
    fun usingWebBrowser(settings: DriverSettings = chromeDriverSettings, actions: Driver.() -> Unit) {
        val driver = Driver(settings)

        driver.use {
            actions(it)
        }
    }
}