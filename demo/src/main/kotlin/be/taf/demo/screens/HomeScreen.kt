package be.taf.demo.screens

import be.taf.demo.fragments.INavigationBar
import be.taf.demo.fragments.NavigationBar
import be.taf.dsl.core.BaseScreen
import be.taf.dsl.core.Image
import be.taf.dsl.core.TestBase
import be.taf.web.driver.Driver
import org.assertj.core.api.Assertions
import org.openqa.selenium.By

/**
 * The Brightest homepage
 */
class HomeScreen(private val driver: Driver) : BaseScreen(driver), INavigationBar by NavigationBar(driver) {

    val brightestLogo: Image = By.xpath("//img[@alt='Brightest Logo']")

    override fun verify() {
        Assertions.assertThat(driver.driver.currentUrl).contains("brightest.be")
    }
}

fun TestBase.homeScreen(f: HomeScreen.() -> Unit) = f(HomeScreen(driver))

fun Driver.homeScreen(f: HomeScreen.() -> Unit) = f(HomeScreen(this))
