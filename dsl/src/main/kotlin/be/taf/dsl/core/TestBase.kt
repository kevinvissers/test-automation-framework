package be.taf.dsl.core

import be.taf.web.driver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

typealias Button = By
typealias Image = By
typealias Field = By
typealias Label = By

open class TestBase {
    lateinit var driver: Driver<RemoteWebDriver>
}
