package be.taf.demo.screens

import be.taf.dsl.core.BaseScreen
import be.taf.dsl.core.TestBase
import be.taf.web.driver.Driver
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Screen which represents the home screen of the web browser.
 * This screen is visible before navigating to the AUT
 */
class BrowserHome<T : RemoteWebDriver>(driver: Driver<T>) : BaseScreen<T>(driver) {

    override fun verify() {
        // No verification required
    }
}

fun TestBase.browserHome(f: BrowserHome<RemoteWebDriver>.() -> Unit) = f(BrowserHome(driver))

fun <T : RemoteWebDriver> Driver<T>.browserHome(f: BrowserHome<T>.() -> Unit) = f(BrowserHome(this))

