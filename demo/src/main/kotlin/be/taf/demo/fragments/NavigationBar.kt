package be.taf.demo.fragments

import be.taf.dsl.actions.`I click`
import be.taf.dsl.core.BDD
import be.taf.dsl.core.Label
import be.taf.web.driver.Driver
import org.openqa.selenium.By

class NavigationBar(private val driver: Driver) : INavigationBar {
    override val solutionsLabel: Label
        get() = By.id("menu-item-11458")

    override val academyLabel: Label
        get() = By.id("menu-item-15341")

    override val careersLabel: Label
        get() = TODO("Not yet implemented")

    override val casesLabel: Label
        get() = TODO("Not yet implemented")

    override infix fun BDD.`I select item`(element: Label) {
        this `I click` element
    }
}
