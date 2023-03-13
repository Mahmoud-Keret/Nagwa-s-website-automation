package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
    public static PageObjectModel pom = new PageObjectModel();
    public static WebDriver driver;
    public static Integer requiredLanguage = 1 ;           //1-English  2-Español  3-Français  4-Português  5-العربية
    public static String searchKeyWord = "addition";       // The word required to search for
    public static Integer searchResultNumber = 2 ;         // second lesson in search result
    public static Integer questionCount;                   // Number of questions in selected lesson


    public static void main(String[] args) throws InterruptedException {
        // Configure web driver
        System.setProperty("web-driver.chrome.driver",chromePath);

        // I used this method to fix an issue related to chrome v111
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        //Creating object from Chrome driver
        driver = new ChromeDriver(co);

        // Maximize Chrome window and navigate to required website
        driver.manage().window().maximize();
        driver.navigate().to("https://www.nagwa.com/en");

        // Click on language to see available languages
        pom.languageButton().click();

        //Choose Arabic language
        pom.languageSelect().get(4).click();

        // Click on language to see available languages
        pom.languageButton().click();

        //Choose English language again to continue automation
        pom.languageSelect().get(requiredLanguage-1).click();

        //Accept Cookies message
        pom.acceptCookies().click();

        //Click Search button and type a word to search for
        pom.searchButton().click();
        pom.searchField().sendKeys(searchKeyWord, Keys.ENTER);

        //Click on the second search result
        pom.searchResult().get(searchResultNumber-1).click();

        //Click on to worksheet section
        pom.lessonWorkSheet().click();

        //Print the count of questions
        questionCount = pom.questionCount().size() ;
        System.out.println("The count of the questions is " + questionCount);

        //Close the browser
        driver.quit();
    }
}