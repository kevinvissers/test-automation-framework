import be.taf.demo.screens.*
import be.taf.dsl.actions.`I navigate to`
import be.taf.dsl.actions.`I scroll into view`
import be.taf.dsl.actions.`I wait milliseconds`
import be.taf.dsl.assertions.`I expect the screen`
import be.taf.dsl.assertions.element
import be.taf.dsl.assertions.`should be`
import be.taf.dsl.assertions.`text of element`
import be.taf.dsl.chains.AssertionType.visible
import be.taf.dsl.core.TestBase
import be.taf.web.driver.ChromeDriverSettings
import be.taf.web.driver.Driver
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OpenHomepageTest : TestBase() {

    @BeforeEach
    fun setup() {
        driver = Driver(
            driverSettings = ChromeDriverSettings(
                chromeDriverPath = "D:\\chromedriver\\107\\chromedriver.exe"
            )
        )
    }

    @Test
    fun `Open solutions page`() {

        browserHome {
            `when` `I navigate to` "https://www.brightest.be/"
            then `I expect the screen` ::HomeScreen
        }

        homeScreen {
            then element brightestLogo `should be` visible
            `when` `I select item` solutionsLabel
            then `I expect the screen` ::SolutionsScreen
        }

        solutionsScreen {
            and `text of element` headerText `should be` "Solutions"

            `when` `I scroll into view` sendMessageButton
            then element sendMessageButton `should be` visible

            and `I wait milliseconds` 5000
        }
    }

    @AfterEach
    fun teardown() {
        driver.kill()
    }
}
