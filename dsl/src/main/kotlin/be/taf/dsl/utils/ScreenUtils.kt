package be.taf.dsl.utils

import be.taf.web.driver.Driver

/**
 * Only execute actions when the screen width is larger than 500px
 */
fun Driver.onLargeScreens(actions: () -> Unit) {
    if (driver.manage().window().size.width > 500) {
        actions()
    }
}

/**
 * Only execute actions when the screen width is smaller than 500px
 */
fun Driver.onSmallScreens(actions: () -> Unit) {
    if (driver.manage().window().size.width < 500) {
        actions()
    }
}
