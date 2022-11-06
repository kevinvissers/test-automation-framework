package be.taf.dsl.core

import be.taf.web.actions.ElementActions
import be.taf.web.assertions.ElementAssertions
import be.taf.web.driver.Driver
import org.openqa.selenium.remote.RemoteWebDriver

sealed class BDD<T : RemoteWebDriver>(internal val driver: Driver<T>) {
    internal val elementActions = ElementActions(driver)
    internal val elementAssertions = ElementAssertions(driver)

    class When<T : RemoteWebDriver>(driver: Driver<T>) : BDD<T>(driver)

    class Then<T : RemoteWebDriver>(driver: Driver<T>) : BDD<T>(driver)

    class And<T : RemoteWebDriver>(driver: Driver<T>) : BDD<T>(driver)

    class Verify<T : RemoteWebDriver>(driver: Driver<T>) : BDD<T>(driver)
}
