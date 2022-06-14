package AvitoTest;

import base.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    @FindBy(id = "category")
    private WebElement menu;
    @FindBy(xpath = "//option[@value='99']")
    private WebElement target;
    @FindBy(xpath = "//div[@role='combobox']//input")
    private WebElement adBody;
    @FindBy(xpath = "//div[@class='main-text-_Thor']")
    private WebElement cityButton;
    @FindBy(xpath = "//div//input[@class='suggest-input-rORJM']")
    private WebElement cityBody;
    @FindBy(xpath = "//ul[@class='suggest-suggests-CzXfs']//strong[text()='Владивосток']")
    private WebElement cityTarget;
    @FindBy(xpath = "//button[@class='button-button-CmK9a button-size-m-LzYrF button-primary-x_x8w']")
    private WebElement submitButton;

    public MainPage() {
        driver.get("https://www.avito.ru/");
        PageFactory.initElements(driver, this);
    }

    public SearchPage doSearch(String request, String city) {
        menu.click();
        target.click();
        adBody.click();
        adBody.sendKeys(request);
        cityButton.click();
        cityBody.sendKeys(city);
        cityTarget.click();
        submitButton.click();
        return new SearchPage();
    }
}
