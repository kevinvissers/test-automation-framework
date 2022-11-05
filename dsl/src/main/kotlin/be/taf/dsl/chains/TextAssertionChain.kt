package be.taf.dsl.chains

import be.taf.web.assertions.ElementAssertions
import org.openqa.selenium.By

data class TextAssertionChain(val element: By, val elementAssertions: ElementAssertions)
