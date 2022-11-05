package be.taf.dsl.core

import be.taf.web.driver.Driver

abstract class BaseScreen(private val driver: Driver) {
    val `when`: BDD by lazy { BDD.When(driver) }
    val then: BDD by lazy { BDD.Then(driver) }
    val and: BDD by lazy { BDD.And(driver) }
    val verify: BDD by lazy { BDD.Verify(driver) }

    abstract fun verify()
}
