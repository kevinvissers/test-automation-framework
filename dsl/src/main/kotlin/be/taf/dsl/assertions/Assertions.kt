package be.taf.dsl.assertions

import be.taf.dsl.chains.AssertionChain
import be.taf.dsl.chains.AssertionType
import be.taf.dsl.chains.ShouldType
import be.taf.dsl.chains.TextAssertionChain
import be.taf.dsl.core.BDD
import be.taf.dsl.core.BaseScreen
import be.taf.web.driver.Driver
import org.openqa.selenium.By

infix fun BDD.element(element: By) = AssertionChain(element, elementAssertions)
infix fun BDD.`text of element`(element: By) = TextAssertionChain(element, elementAssertions)

infix fun TextAssertionChain.`should be`(text: String) = elementAssertions.verifyText(element, text, true)

infix fun <T : BaseScreen> BDD.`I expect the screen`(screen: (driver: Driver) -> T) = screen(driver).verify()

infix fun AssertionChain.`should be`(assertion: AssertionType) {
    when (assertion) {
        AssertionType.visible -> elementAssertions.verifyDisplayed(element, true)
        AssertionType.enabled -> TODO()
        AssertionType.selected -> TODO()
    }
}

infix fun AssertionChain.`should not be`(assertion: AssertionType) {
    when (assertion) {
        AssertionType.visible -> elementAssertions.verifyDisplayed(element, false)
        AssertionType.enabled -> TODO()
        AssertionType.selected -> TODO()
    }
}

infix fun AssertionChain.should(assertion: ShouldType) {
    when (assertion) {
        ShouldType.exist -> elementAssertions.verifyExistence(element, true)
    }
}

infix fun AssertionChain.`should not`(assertion: ShouldType) {
    when (assertion) {
        ShouldType.exist -> elementAssertions.verifyExistence(element, false)
    }
}
