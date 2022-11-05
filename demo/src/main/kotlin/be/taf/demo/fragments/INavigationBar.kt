package be.taf.demo.fragments

import be.taf.dsl.core.BDD
import be.taf.dsl.core.Label

interface INavigationBar {
    val solutionsLabel: Label
    val academyLabel: Label
    val careersLabel: Label
    val casesLabel: Label

    infix fun BDD.`I select item`(element: Label)
}
