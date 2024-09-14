package com.Elife.StepDefinitions;

import com.Elife.PageComponent.QuotesPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class QuotesPageSteps {
      @Then("Verify the title of the quote page as {string}")
      public void verifyTheTitleOfTheQuotePageAs(String title) {
            Assert.assertEquals(QuotesPage.getInstance().getTitle(), title);
      }

      @Then("Verify the sub title of the quote page as {string}")
      public void verifyTheSubTitleOfTheQuotePageAs(String subtitle) {
            Assert.assertEquals(QuotesPage.getInstance().getSubTitle(), subtitle);
      }
}
