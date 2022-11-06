package be.taf.demo.fragments

import be.taf.dsl.actions.`I click`
import be.taf.dsl.core.BDD
import be.taf.dsl.core.Button
import be.taf.dsl.core.Label
import be.taf.web.driver.Driver
import org.openqa.selenium.By

/**
 * Represents the navigation bar on top of the screen
 */
class NavigationBar(private val driver: Driver) : INavigationBar {

    override val solutionsLabel: Label
        get() = By.id("menu-item-11458")

    override val academyLabel: Label
        get() = By.id("menu-item-15341")

    override val careersLabel: Label
        get() = TODO("Not yet implemented")

    override val casesLabel: Label
        get() = TODO("Not yet implemented")

    override val menuButton: Button
        get() = By.cssSelector("div.stm_mobile__switcher span")

    override infix fun BDD.`I select item`(element: Label) {
        this `I click` element
    }
}
