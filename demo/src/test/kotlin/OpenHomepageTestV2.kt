import be.taf.demo.screens.*
import be.taf.dsl.actions.`I click`
import be.taf.dsl.actions.`I navigate to`
import be.taf.dsl.actions.`I scroll into view`
import be.taf.dsl.actions.`I wait milliseconds`
import be.taf.dsl.assertions.`I expect the screen`
import be.taf.dsl.assertions.element
import be.taf.dsl.assertions.`should be`
import be.taf.dsl.assertions.`text of element`
import be.taf.dsl.chains.AssertionType.visible
import be.taf.dsl.core.TestBaseV2
import be.taf.dsl.utils.onSmallScreens
import org.junit.jupiter.api.Test

class OpenHomepageTestV2 : TestBaseV2() {

    @Test
    fun `Open solutions page`() {

        usingWebBrowser {

            browserHome {
                `when` `I navigate to` "https://www.brightest.be/"
                then `I expect the screen` ::HomeScreen
            }

            homeScreen {
                then element brightestLogo `should be` visible

                onSmallScreens {
                    `when` `I click` menuButton
                }

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
    }
}
