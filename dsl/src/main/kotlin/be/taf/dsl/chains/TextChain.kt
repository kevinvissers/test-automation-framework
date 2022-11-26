package be.taf.dsl.chains

import be.taf.web.actions.ElementActions
import org.openqa.selenium.remote.RemoteWebDriver

sealed class TextChain {
    data class DefaultTextChain<T : RemoteWebDriver>(val text: String, val elementActions: ElementActions<T>) :
        TextChain()

    data class PasswordTextChain<T : RemoteWebDriver>(val password: CharArray, val elementActions: ElementActions<T>) :
        TextChain()
}
