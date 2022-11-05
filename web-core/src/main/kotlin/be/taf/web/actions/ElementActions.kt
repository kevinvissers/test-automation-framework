package be.taf.web.actions

import be.taf.web.common.ElementFetcher
import be.taf.web.driver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class ElementActions(private val driver: Driver) {
    private val elementFetcher = ElementFetcher(driver)

    fun click(locator: By) = elementFetcher.waitForElement(locator).click()
    fun click(element: WebElement) = element.click()

    fun enterText(locator: By, text: String) = elementFetcher.waitForElement(locator).sendKeys(text)
    fun enterText(element: WebElement, text: String) = element.sendKeys(text)

    fun clearText(locator: By) = elementFetcher.waitForElement(locator).clear()
    fun clearText(element: WebElement) = element.clear()

    fun scrollIntoView(locator: By) =
        scrollIntoView(elementFetcher.waitForElement(locator))

    fun scrollIntoView(element: WebElement) {
        val actions = Actions(driver.driver)
        actions.moveToElement(element)
        actions.perform()
    }
}