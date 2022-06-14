package AvitoTest;

import base.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseSeleniumPage {
    @FindBy(xpath = "//span[@data-marker='delivery-filter/text']")
    private WebElement checkbox;
    @FindBy(xpath = "//button[@data-marker='search-filters/submit-button']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='index-topPanel-McfCA']//select")
    private WebElement filterButton;
    @FindBy(xpath = "//select[@class='select-select-IdfiC']//option[text()='Дороже']")
    private WebElement targetFilter;
    @FindBy(xpath = "//div[@id='i2446055199']//h3[@itemprop='name']")
    private WebElement firstElem;
    @FindBy(xpath = "//div[@id='i2324175814']//h3[@itemprop='name']")
    private WebElement secondElem;
    @FindBy(xpath = "//div[@id='i2309869160']//h3[@itemprop='name']")
    private WebElement thirdElem;
    @FindBy(xpath = "//div[@id='i2446055199']//span[@class='price-price-JP7qe']//span")
    private WebElement firstCost;
    @FindBy(xpath = "//div[@id='i2324175814']//span[@class='price-price-JP7qe']//span")
    private WebElement secondCost;
    @FindBy(xpath = "//div[@id='i2309869160']//span[@class='price-price-JP7qe']//span")
    private WebElement thirdCost;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public SearchPage doFilters() {
        if (!checkbox.isSelected()) {
            checkbox.click();
            submitButton.click();
        }
        filterButton.click();
        targetFilter.click();
        return new SearchPage();
    }

    public void getResults() {
        String s1 = firstCost.getText().substring(0, firstCost.getText().length() - 1);
        String s2 = secondCost.getText().substring(0, secondCost.getText().length() - 1);
        String s3 = thirdCost.getText().substring(0, thirdCost.getText().length() - 1);
        System.out.println("Name = " + firstElem.getText() + " || Cost = " + s1 + "Rub");
        System.out.println("Name = " + secondElem.getText() + " || Cost = " + s2 + "Rub");
        System.out.println("Name = " + thirdElem.getText() + " || Cost = " + s3 + "Rub");
    }
}
