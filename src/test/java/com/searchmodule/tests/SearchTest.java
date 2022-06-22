package com.searchmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({ "keyword" })
    public void search(@Optional String keyword) {
	SearchPage searchPage = new SearchPage(driver);
	searchPage.goTo();
	searchPage.doSearch(keyword);
	searchPage.goToVideos();
	int size = searchPage.getResult();

	Assert.assertTrue(size > 0);
    }

}