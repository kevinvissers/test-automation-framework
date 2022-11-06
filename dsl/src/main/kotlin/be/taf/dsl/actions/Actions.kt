package be.taf.dsl.actions

import be.taf.dsl.chains.TextChain
import be.taf.dsl.core.BDD
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

infix fun <T : RemoteWebDriver> BDD<T>.`I click`(element: By) = elementActions.click(element)

infix fun <T : RemoteWebDriver> BDD<T>.`I navigate to`(url: String) = driver.driver.get(url)

infix fun <T : RemoteWebDriver> BDD<T>.`I enter text`(text: String): TextChain =
    TextChain.DefaultTextChain(text, elementActions)

infix fun <T : RemoteWebDriver> BDD<T>.`I enter password`(password: CharArray): TextChain =
    TextChain.PasswordTextChain(password, elementActions)

infix fun <T : RemoteWebDriver> BDD<T>.`I wait milliseconds`(milliseconds: Int) = Thread.sleep(milliseconds.toLong())

infix fun <T : RemoteWebDriver> BDD<T>.`I clear the text of`(element: By) = elementActions.clearText(element)

infix fun <T : RemoteWebDriver> BDD<T>.`I scroll into view`(element: By) = elementActions.scrollIntoView(element)

infix fun <T : RemoteWebDriver> TextChain.into(element: By) {
    when (this) {
        is TextChain.DefaultTextChain<*> -> elementActions.enterText(element, text)
        is TextChain.PasswordTextChain<*> -> elementActions.enterText(element, password.toString())
    }
}
