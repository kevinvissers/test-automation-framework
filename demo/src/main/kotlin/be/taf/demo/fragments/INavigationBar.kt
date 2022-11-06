package be.taf.demo.fragments

import be.taf.dsl.core.BDD
import be.taf.dsl.core.Button
import be.taf.dsl.core.Label
import org.openqa.selenium.remote.RemoteWebDriver

interface INavigationBar<T : RemoteWebDriver> {
    val solutionsLabel: Label
    val academyLabel: Label
    val careersLabel: Label
    val casesLabel: Label

    val menuButton: Button

    infix fun BDD<T>.`I select item`(element: Label)
}
