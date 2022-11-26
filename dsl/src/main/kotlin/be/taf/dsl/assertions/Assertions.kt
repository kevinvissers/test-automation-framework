package be.taf.dsl.assertions

import be.taf.dsl.chains.AssertionChain
import be.taf.dsl.chains.AssertionType
import be.taf.dsl.chains.ShouldType
import be.taf.dsl.chains.TextAssertionChain
import be.taf.dsl.core.BDD
import be.taf.dsl.core.BaseScreen
import be.taf.web.driver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

infix fun <T : RemoteWebDriver> BDD<T>.element(element: By) = AssertionChain(element, elementAssertions)
infix fun <T : RemoteWebDriver> BDD<T>.`text of element`(element: By) =
    TextAssertionChain<T>(element, elementAssertions)

infix fun <T : RemoteWebDriver> TextAssertionChain<T>.`should be`(text: String) =
    elementAssertions.verifyText(element, text, true)

infix fun <U : RemoteWebDriver, T : BaseScreen<U>> BDD<U>.`I expect the screen`(screen: (driver: Driver<U>) -> T) =
    screen(driver).verify()

infix fun <T : RemoteWebDriver> AssertionChain<T>.`should be`(assertion: AssertionType) {
    when (assertion) {
        AssertionType.visible -> elementAssertions.verifyDisplayed(element, true)
        AssertionType.enabled -> TODO()
        AssertionType.selected -> TODO()
    }
}

infix fun <T : RemoteWebDriver> AssertionChain<T>.`should not be`(assertion: AssertionType) {
    when (assertion) {
        AssertionType.visible -> elementAssertions.verifyDisplayed(element, false)
        AssertionType.enabled -> TODO()
        AssertionType.selected -> TODO()
    }
}

infix fun <T : RemoteWebDriver> AssertionChain<T>.should(assertion: ShouldType) {
    when (assertion) {
        ShouldType.exist -> elementAssertions.verifyExistence(element, true)
    }
}

infix fun <T : RemoteWebDriver> AssertionChain<T>.`should not`(assertion: ShouldType) {
    when (assertion) {
        ShouldType.exist -> elementAssertions.verifyExistence(element, false)
    }
}
