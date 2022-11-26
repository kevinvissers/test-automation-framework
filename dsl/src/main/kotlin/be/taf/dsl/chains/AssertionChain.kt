package be.taf.dsl.chains

import be.taf.web.assertions.ElementAssertions
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

data class AssertionChain<T : RemoteWebDriver>(val element: By, val elementAssertions: ElementAssertions<T>)
