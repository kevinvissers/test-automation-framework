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

/**
 * Brightest solutions screen
 */
class SolutionsScreen(driver: Driver) : BaseScreen(driver) {

    val headerText: Label
        get() = By.cssSelector(".stm_titlebox__inner > h1")

    val sendMessageButton: Button
        get() = By.xpath("(//*[text()='Send Message'])[1]")

    override fun verify() {
        verify element headerText should exist
    }
}

fun TestBase.solutionsScreen(f: SolutionsScreen.() -> Unit) = f(SolutionsScreen(driver))

fun Driver.solutionsScreen(f: SolutionsScreen.() -> Unit) = f(SolutionsScreen(this))
