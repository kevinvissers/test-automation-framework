package be.taf.web.driver

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.RemoteWebDriver
import java.time.Duration

class Driver<T : RemoteWebDriver>(driverSettings: DriverSettings) : AutoCloseable {

    private companion object {
        private const val PAGE_LOAD_TIMEOUT_IN_SECONDS = 40L
        private const val IMPLICIT_WAIT_IN_SECONDS = 30L
    }

    val driver: T =
        createDriver(driverSettings)

    private fun createDriver(driverSettings: DriverSettings): T {
        when (driverSettings) {
            is ChromeDriverSettings -> {
                System.setProperty("webdriver.chrome.driver", driverSettings.chromeDriverPath)

                return ChromeDriver(driverSettings.chromeOptions).apply {
                    this.manage().window().maximize()

                    //Specifying pageLoadTimeout and Implicit wait
                    this.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT_IN_SECONDS))
                    this.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_IN_SECONDS))
                } as T
            }
        }
    }

    fun asChromeDriver(): ChromeDriver = driver as ChromeDriver

    override fun close() {
        driver.quit()
    }
}
