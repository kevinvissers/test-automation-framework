package be.taf.dsl.actions

import be.taf.dsl.chains.TextChain
import be.taf.dsl.core.BDD
import org.openqa.selenium.By

infix fun BDD.`I click`(element: By) = elementActions.click(element)

infix fun BDD.`I navigate to`(url: String) = driver.driver.get(url)

infix fun BDD.`I enter text`(text: String): TextChain = TextChain.DefaultTextChain(text, elementActions)
infix fun BDD.`I enter password`(password: CharArray): TextChain = TextChain.PasswordTextChain(password, elementActions)

infix fun BDD.`I wait milliseconds`(milliseconds: Int) = Thread.sleep(milliseconds.toLong())

infix fun BDD.`I clear the text of`(element: By) = elementActions.clearText(element)

infix fun BDD.`I scroll into view`(element: By) = elementActions.scrollIntoView(element)

infix fun TextChain.into(element: By) {
    when (this) {
        is TextChain.DefaultTextChain -> elementActions.enterText(element, text)
        is TextChain.PasswordTextChain -> elementActions.enterText(element, password.toString())
    }
}
