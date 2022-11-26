package be.taf.web.common

import be.taf.web.driver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class ElementFetcher<T : RemoteWebDriver>(private val driver: Driver<T>) {
    companion object {
        private const val TIMEOUT_IN_SECONDS = 15L
    }

    fun waitForElement(locator: By): WebElement {
        val wait = WebDriverWait(driver.driver, Duration.ofSeconds(TIMEOUT_IN_SECONDS))
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) as WebElement
    }

    fun getElement(locator: By): WebElement {
        return driver.driver.findElement(locator)
    }

    fun getElements(locator: By): List<WebElement> {
        return driver.driver.findElements(locator)
    }
}
