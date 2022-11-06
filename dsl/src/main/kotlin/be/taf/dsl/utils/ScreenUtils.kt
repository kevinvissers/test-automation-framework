package be.taf.dsl.utils

import be.taf.web.driver.Driver
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Only execute actions when the screen width is larger than 500px
 */
fun <T : RemoteWebDriver> Driver<T>.onLargeScreens(actions: () -> Unit) {
    if (driver.manage().window().size.width > 500) {
        actions()
    }
}

/**
 * Only execute actions when the screen width is smaller than 500px
 */
fun <T : RemoteWebDriver> Driver<T>.onSmallScreens(actions: () -> Unit) {
    if (driver.manage().window().size.width < 500) {
        actions()
    }
}
