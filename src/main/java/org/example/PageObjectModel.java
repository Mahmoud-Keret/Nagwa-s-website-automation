package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectModel {
    public WebElement languageButton(){return Main.driver.findElement(By.cssSelector("body > header:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > span:nth-child(1)"));}
    public WebElement arabicLanguageSelect(){return Main.driver.findElement(By.className("arabic"));}
    public WebElement englishLanguageSelect(){return Main.driver.findElement(By.cssSelector("li[class='dropdown open'] li:nth-child(1) a:nth-child(1)"));}
    public List<WebElement> languageSelect(){return Main.driver.findElements(By.cssSelector("li[class='dropdown open'] li"));}

    public WebElement searchButton(){return Main.driver.findElement(By.cssSelector("button[type='button'] i[class='f-icon search-icon']"));}
    public WebElement searchField(){return Main.driver.findElement(By.cssSelector("#txt_search_query"));}
    public List<WebElement> searchResult(){return Main.driver.findElements(By.cssSelector("li>div>a[href]"));}
    public WebElement acceptCookies(){return Main.driver.findElement(By.id("btn_cookie_accept"));}
    public WebElement chooseFromSearchResult(String str){return Main.driver.findElement(By.linkText(str));}
    public WebElement lessonWorkSheet(){return Main.driver.findElement(By.cssSelector("div[class=\"question-preview\"]"));}
    public List<WebElement> questionCount(){return Main.driver.findElements(By.cssSelector("div[class=\"stem\"]"));}


}
