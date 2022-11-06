package be.taf.demo.screens

import be.taf.dsl.core.BaseScreen
import be.taf.dsl.core.TestBase
import be.taf.web.driver.Driver

/**
 * Screen which represents the home screen of the web browser.
 * This screen is visible before navigating to the AUT
 */
class BrowserHome(driver: Driver) : BaseScreen(driver) {

    override fun verify() {
        // No verification required
    }
}

fun TestBase.browserHome(f: BrowserHome.() -> Unit) = f(BrowserHome(driver))

fun Driver.browserHome(f: BrowserHome.() -> Unit) = f(BrowserHome(this))

