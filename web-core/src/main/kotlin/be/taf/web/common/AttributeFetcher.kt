package be.taf.web.common

import be.taf.web.driver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.remote.RemoteWebDriver

class AttributeFetcher<T : RemoteWebDriver>(driver: Driver<T>) {
    private val elementFetcher = ElementFetcher(driver)

    fun isDisplayed(locator: By) = elementFetcher.waitForElement(locator).isDisplayed
    fun getText(locator: By): String = elementFetcher.waitForElement(locator).text

    fun exists(locator: By): Boolean {
        return try {
            elementFetcher.getElement(locator)
            true
        } catch (noSuchElementException: NoSuchElementException) {
            false
        }
    }
}
