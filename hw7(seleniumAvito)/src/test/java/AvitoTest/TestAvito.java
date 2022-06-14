package AvitoTest;

import base.BaseSeleniumTest;
import org.testng.annotations.Test;

public class TestAvito extends BaseSeleniumTest {
    @Test
    public void avitoTest() {
        SearchPage searchPage = new MainPage().doSearch("Принтер", "Владивосток")
                .doFilters();
        searchPage.getResults();
    }
}
