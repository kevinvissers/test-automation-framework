package be.taf.dsl.chains

import be.taf.web.actions.ElementActions

sealed class TextChain {
    data class DefaultTextChain(val text: String, val elementActions: ElementActions) : TextChain()
    data class PasswordTextChain(val password: CharArray, val elementActions: ElementActions) : TextChain()
}
