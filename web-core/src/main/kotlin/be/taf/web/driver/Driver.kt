package be.taf.web.driver

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.RemoteWebDriver
import java.time.Duration

class Driver(driverSettings: DriverSettings) : AutoCloseable {
    val driver: RemoteWebDriver =
        createDriver(driverSettings)

    private fun createDriver(driverSettings: DriverSettings): RemoteWebDriver {
        if (driverSettings !is ChromeDriverSettings) {
            throw IllegalArgumentException("Invalid driver settings")
        }

        System.setProperty("webdriver.chrome.driver", driverSettings.chromeDriverPath)
        return ChromeDriver(driverSettings.chromeOptions).apply {
            this.manage().window().maximize()

            //Specifying pageLoadTimeout and Implicit wait
            this.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40L))
            this.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L))
        }
    }

    fun asChromeDriver(): ChromeDriver = driver as ChromeDriver

    override fun close() {
        driver.quit()
    }
}
