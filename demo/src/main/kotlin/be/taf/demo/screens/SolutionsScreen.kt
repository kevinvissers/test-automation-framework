package be.taf.demo.screens

import be.taf.dsl.assertions.element
import be.taf.dsl.assertions.should
import be.taf.dsl.chains.ShouldType.exist
import be.taf.dsl.core.BaseScreen
import be.taf.dsl.core.Button
import be.taf.dsl.core.Label
import be.taf.dsl.core.TestBase
import be.taf.web.driver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Brightest solutions screen
 */
class SolutionsScreen<T : RemoteWebDriver>(driver: Driver<T>) : BaseScreen<T>(driver) {

    val headerText: Label
        get() = By.cssSelector(".stm_titlebox__inner > h1")

    val sendMessageButton: Button
        get() = By.xpath("(//*[text()='Send Message'])[1]")

    override fun verify() {
        verify element headerText should exist
    }
}

fun TestBase.solutionsScreen(f: SolutionsScreen<RemoteWebDriver>.() -> Unit) = f(SolutionsScreen(driver))

fun <T : RemoteWebDriver> Driver<T>.solutionsScreen(f: SolutionsScreen<T>.() -> Unit) = f(SolutionsScreen(this))
