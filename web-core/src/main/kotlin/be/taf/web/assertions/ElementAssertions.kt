package be.taf.web.assertions

import be.taf.web.common.AttributeFetcher
import be.taf.web.driver.Driver
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

class ElementAssertions<T : RemoteWebDriver>(driver: Driver<T>) {
    private val attributeFetcher = AttributeFetcher(driver)

    fun verifyExistence(locator: By, shouldExist: Boolean) {
        Assertions.assertThat(attributeFetcher.exists(locator)).isEqualTo(shouldExist)
    }

    fun verifyDisplayed(locator: By, shouldExist: Boolean) {
        Assertions.assertThat(attributeFetcher.isDisplayed(locator)).isEqualTo(shouldExist)
    }

    fun verifyText(locator: By, text: String, shouldExist: Boolean) {
        if (shouldExist) {
            Assertions.assertThat(attributeFetcher.getText(locator)).isEqualTo(text)
        } else {
            Assertions.assertThat(attributeFetcher.getText(locator)).isNotEqualTo(text)
        }
    }
}
