package be.taf.dsl.core

import be.taf.web.driver.Driver
import org.openqa.selenium.remote.RemoteWebDriver

abstract class BaseScreen<T : RemoteWebDriver>(private val driver: Driver<T>) {
    val `when`: BDD<T> by lazy { BDD.When(driver) }
    val then: BDD<T> by lazy { BDD.Then(driver) }
    val and: BDD<T> by lazy { BDD.And(driver) }
    val verify: BDD<T> by lazy { BDD.Verify(driver) }

    abstract fun verify()
}
