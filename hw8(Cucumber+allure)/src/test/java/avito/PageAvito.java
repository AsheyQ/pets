package avito;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import avito.locators.Elements;

import static com.codeborne.selenide.Selenide.*;

public class PageAvito extends BasePage {
    private final Elements elements = page(Elements.class);

    public PageAvito() {
        open("https://www.avito.ru/");
        webdriver().object().manage().window().maximize();
    }

    @DisplayName("В поле поиска ввести значение")
    public void inputTextArea(String text) {
        elements.textArea.click();
        elements.textArea.sendKeys(text);
        elements.app.click();
    }

    @DisplayName("Кликнуть по выпадающему списку региона")
    public void clickOnFieldCity() {
        elements.locationSelect.click();
    }

    @DisplayName("В поле регион ввести значение")
    public void searchForCity(String city) {
        elements.location.sendKeys(city);
        elements.location.click();

        while (true) {
            if (elements.locationField.getText().startsWith(city)) {
                elements.locationField.click();
                break;
            }
        }
    }

    @DisplayName("Нажать кнопку показать объявления")
    public void clickOnButton() {
        elements.searchOnLocationField.click();
    }

    @DisplayName("Активировать чекбокс только с фотографией")
    public void checkbox() {
        if (!elements.checkBoxStatus.isSelected())
            elements.checkBoxStatus.click();
    }

    @DisplayName("Открылась страница результаты по искомому запросу")
    public void checkOpenedPage(String word) {
        Assert.assertTrue("Значение не равны!", elements.checkOpenedPage.getText().contains(word));
    }

    @DisplayName("Вывести в консоль значение названия и цены нужного количества товаров")
    public void nameAndPrice(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(elements.printersNames.get(i).getText());
            System.out.println(elements.printersPrices.get(i).getText());
            System.out.println();
            Allure.addAttachment(String.format("Вывести в консоль значение названия и цену %s товаров", i),
                    String.format("Название: %s,\n Цена: %s", elements.printersNames.get(i).getText(), elements.printersPrices.get(i).getText()));
        }
    }

    @DisplayName("В выпадающем списке сортировка выбрать нужное значение")
    public void selectFilter(String sortValue) {
        elements.selectFilter.selectOption(sortValue);
    }

    @DisplayName("В выпадающем списке категорий выбрать категорию")
    public void selectCategory(String category) {
        elements.selectCategory.selectOption(category);
    }

    public void getScreenshot() {
        takeScreenshot(webdriver().driver().getWebDriver());
    }
}
