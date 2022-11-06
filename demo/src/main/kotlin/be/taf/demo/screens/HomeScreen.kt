package be.taf.demo.screens

import be.taf.demo.fragments.INavigationBar
import be.taf.demo.fragments.NavigationBar
import be.taf.dsl.core.BaseScreen
import be.taf.dsl.core.Image
import be.taf.dsl.core.TestBase
import be.taf.web.driver.Driver
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * The Brightest homepage
 */
class HomeScreen<T : RemoteWebDriver>(private val driver: Driver<T>) : BaseScreen<T>(driver),
    INavigationBar<T> by NavigationBar(driver) {

    val brightestLogo: Image = By.xpath("//img[@alt='Brightest Logo']")

    override fun verify() {
        Assertions.assertThat(driver.driver.currentUrl).contains("brightest.be")
    }
}

fun TestBase.homeScreen(f: HomeScreen<RemoteWebDriver>.() -> Unit) = f(HomeScreen(driver))

fun <T : RemoteWebDriver> Driver<T>.homeScreen(f: HomeScreen<T>.() -> Unit) = f(HomeScreen(this))
