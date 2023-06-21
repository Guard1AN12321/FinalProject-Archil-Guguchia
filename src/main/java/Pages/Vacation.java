package Pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
public class Vacation {

    private ElementsCollection minPriceField = $$("#minprice"),
            maxPriceField = $$("#maxprice"),
            searchButton = $$(".submit-button");
    private SelenideElement vacationButton = $("#body > header > div.HeaderMenu > div > div.Menus > ul > li:nth-child(3) > a");
    public void OpenVacation() {
        Selenide.open("");
        vacationButton.click();
    }


    public SelenideElement GetMinPriceField(){
        return minPriceField.last();
    }

    public void FillPriceFilter(String minPrice, String maxPrice){
        minPriceField.last().setValue(minPrice);
        maxPriceField.last().setValue(maxPrice);
    }

    public void Search(){
        searchButton.last().click();
    }
}
