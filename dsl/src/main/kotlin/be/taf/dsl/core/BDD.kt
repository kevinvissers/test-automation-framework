package be.taf.dsl.core

import be.taf.web.actions.ElementActions
import be.taf.web.assertions.ElementAssertions
import be.taf.web.driver.Driver

sealed class BDD(internal val driver: Driver) {
    internal val elementActions = ElementActions(driver)
    internal val elementAssertions = ElementAssertions(driver)

    class When(driver: Driver) : BDD(driver)

    class Then(driver: Driver) : BDD(driver)

    class And(driver: Driver) : BDD(driver)

    class Verify(driver: Driver) : BDD(driver)
}
