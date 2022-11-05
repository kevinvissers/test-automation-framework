package be.taf.demo.screens

import be.taf.dsl.core.BaseScreen
import be.taf.dsl.core.TestBase
import be.taf.web.driver.Driver

class BrowserHome(private val driver: Driver) : BaseScreen(driver) {
    override fun verify() {
        // No verification required
        driver.asChromeDriver().sessionId.toString()
    }
}

fun TestBase.browserHome(f: BrowserHome.() -> Unit) = f(BrowserHome(driver))
