package be.taf.dsl.core

import be.taf.web.driver.Driver
import org.openqa.selenium.By

typealias Button = By
typealias Image = By
typealias Field = By
typealias Label = By

open class TestBase {
    lateinit var driver: Driver
}
