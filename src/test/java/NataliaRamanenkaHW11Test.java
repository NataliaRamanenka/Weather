import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class NataliaRamanenkaHW11Test {
    //    TC_1_lesson  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"
    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(2000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*    TC_11_01_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Нажать на пункт меню Guide
     * 3. Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
     * что title этой страницы OpenWeatherMap API guide - OpenWeatherMap
     */
//    @Test
//    public void testGuideLinkAndTitle() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        String url = "https://openweathermap.org/";
//        String expectedResult1 = "https://openweathermap.org/guide";
//        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";
//
//        driver.get(url);
//        Thread.sleep(5000);
//
//        WebElement searchMenu = driver.findElement(
//                By.xpath("//li[@id ='hamburger']")
//        );
//        searchMenu.click();
//        WebElement searchGuide = driver.findElement(
//                By.xpath("//ul[@id = 'mobile-menu']//a[text() = 'Guide']")
//        );
//        searchGuide.click();
//
//        String actualResult1 = driver.getCurrentUrl();
//        String actualResult2 = driver.getTitle();
//
//        Assert.assertEquals(actualResult1, expectedResult1);
//        Assert.assertEquals(actualResult2, expectedResult2);
//
//        driver.quit();
//    }
    @Test
    public void testGuideLinkAndTitle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchGuide = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']/ul/li/a[@href = '/guide']")
        );
        searchGuide.click();
        Thread.sleep(2000);

        String actualResult1 = driver.getCurrentUrl();
        String actualResult2 = driver.getTitle();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    /*    TC_11_02_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Нажать на единицы измерения Imperial: °F, mph
     * 3. Подтвердить, что температура для города показана в Фарингейтах
     */
    @Test
    public void testUnitsOfMeasurementIsFaringates() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String measure = "F";
        boolean expectedResult = true;

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchImperialF = driver.findElement(
                By.xpath("//div[text() = 'Imperial: °F, mph']")
        );
        searchImperialF.click();
        Thread.sleep(2000);

        WebElement searchF = driver.findElement(
                By.xpath("//span[@class = 'heading']")
        );
        boolean actualResult = searchF.getText().contains(measure);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*    TC_11_03_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site
     * to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
     * You can allow all cookies or manage them individually.”
     * 3. Подтвердить, что температура для города показана в Фарингейтах Подтвердить, что на панели внизу страницы
     * есть 2 кнопки “Allow all” и “Manage cookies”
     */
    @Test
    public void testCookiesPanelWithButtonsIs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResult1 = "We use cookies which are essential for the site to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies or manage them individually.";
        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);
        driver.manage().window().maximize();  // можно не разворачивать
        Thread.sleep(5000);

        WebElement searchCookiesPanel = driver.findElement(
                By.xpath("//p[@class ='stick-footer-panel__description']")
        );
        Thread.sleep(2000);
        String actualResult1 = searchCookiesPanel.getText();

        WebElement searchButtonAllowAll = driver.findElement(
                By.xpath("//button[@class ='stick-footer-panel__link']")
        );
        Thread.sleep(2000);
        String actualResult2 = searchButtonAllowAll.getText();

        WebElement searchButtonManageCookies = driver.findElement(
                By.xpath("//a[@href ='/cookies-settings']")
        );
        Thread.sleep(2000);
        String actualResult3 = searchButtonManageCookies.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

    /*    TC_11_04_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
     */
    @Test
    public void testSupportWithSubmenuIs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResult1 = "FAQ";
        String expectedResult2 = "How to start";
        String expectedResult3 = "Ask a question";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchSupport = driver.findElement(
                By.xpath("//div[@id= 'support-dropdown']")
        );
        searchSupport.click();
        Thread.sleep(2000);

        WebElement searchSupportFAQ = driver.findElement(
                By.xpath("//ul[@id= 'support-dropdown-menu'] /li/a[@href = '/faq']")
        );
        Thread.sleep(2000);
        String actualResult1 = searchSupportFAQ.getText();

        WebElement searchSupportHowToStart = driver.findElement(
                By.xpath("//ul[@id= 'support-dropdown-menu']/li/a[@href = '/appid']")
        );
        Thread.sleep(2000);
        String actualResult2 = searchSupportHowToStart.getText();

        WebElement searchSupportAskAQuestion = driver.findElement(
                By.xpath("//ul[@id= 'support-dropdown-menu']/li/a[@href = 'https://home.openweathermap.org/questions']")
        );
        Thread.sleep(2000);
        String actualResult3 = searchSupportAskAQuestion.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }


    /*    TC_11_05_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Нажать пункт меню Support → Ask a question
     * 3. Заполнить поля Email, Subject, Message
     * 4. Не подтвердив CAPTCHA, нажать кнопку Submit
     * 5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
     */
//    @Test
//    public void testErrorMessageReCAPTCHA_WhenCaptchaIsEmpty() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        String url = "https://openweathermap.org/";
//        String email = "tester@test.com";
//        String message = "How can I see the weather forecast for tomorrow in Paris";
//        String expectedResult = "reCAPTCHA verification failed, please try again.";
//
//        driver.get(url);
//        Thread.sleep(5000);
//
//        WebElement searchMenu = driver.findElement(
//                By.xpath("//li[@id ='hamburger']")
//        );
//        searchMenu.click();
//        WebElement searchSupportAskAQuestion = driver.findElement(
//                By.xpath("//ul[@id = 'mobile-menu']//a[text() = 'Ask a question']")
//        );
//        searchSupportAskAQuestion.click();
//
//        WebElement searchEmailField = driver.findElement(
//                By.xpath("//input[@class = 'form-control string email required']")
//        );
//        searchEmailField.click();
//        Thread.sleep(1000);
//        searchEmailField.sendKeys(email);
//
//        WebElement searchSubjectField = driver.findElement(
//                By.xpath("//select[@class = 'form-control select required']")
//        );
//        searchSubjectField.click();
//        Thread.sleep(1000);
//        WebElement searchSubjectOther = driver.findElement(
//                By.xpath("//select[@class = 'form-control select required']/option[@value = 'Other']")
//        );
//        searchSubjectOther.click();
//
//        WebElement searchMessageField = driver.findElement(
//                By.xpath("//textarea[@class = 'form-control text required']")
//        );
//        searchMessageField.click();
//        Thread.sleep(1000);
//        searchMessageField.sendKeys(message);
//
//        WebElement searchSubmit = driver.findElement(
//                By.xpath("//input[@class = 'btn btn-default']")
//        );
//        searchSubmit.click();
//
//        WebElement searchErrorMessage = driver.findElement(
//                By.xpath("//div[@class = 'help-block']")
//        );
//        Thread.sleep(1000);
//        String actualResult = searchErrorMessage.getText();
//
//        Assert.assertEquals(actualResult, expectedResult);
//
//        driver.quit();
//    }
    @Test
    public void textDisplayCaptureError() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String email = "tester@test.com";
        String message = "How can I see the weather forecast for tomorrow in Paris";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);
        driver.manage().window().maximize();
        String originalWindow = driver.getWindowHandle();
        Thread.sleep(10000);
        WebElement searchSupport = driver.findElement(
                By.xpath("//div[@id= 'support-dropdown']"));
        searchSupport.click();
        Thread.sleep(3000);
        WebElement searchSupportAskAQuestion = driver.findElement(
                By.xpath("//ul[@id= 'support-dropdown-menu']/li/a[@href = 'https://home.openweathermap.org/questions']")
        );
        searchSupportAskAQuestion.click();
        Thread.sleep(3000);
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        for(int i = 1; i < tabs.size(); i++) {
            if (!tabs.get(i).equals(originalWindow)) {
                driver.switchTo().window((String) tabs.get(i));
            }
        }
        Thread.sleep(10000);
        WebElement searchEmailField = driver.findElement(
                By.xpath("//input[@id = 'question_form_email']"));
        searchEmailField.click();
        Thread.sleep(3000);
        searchEmailField.sendKeys(email);
        WebElement searchMessageField = driver.findElement(
                By.xpath("//textarea[@class = 'form-control text required']"));
        searchMessageField.click();
        Thread.sleep(3000);
        searchMessageField.sendKeys(message);
        WebElement searchSubjectField = driver.findElement(
                By.xpath("//select[@class = 'form-control select required']"));
        searchSubjectField.click();
        Thread.sleep(3000);
        WebElement searchSubjectOther = driver.findElement(
                By.xpath("//select[@class = 'form-control select required']/option[@value = 'Other']"));
        searchSubjectOther.click();
        WebElement emptySpase = driver.findElement(
                By.xpath("//body[@onclick]"));
        emptySpase.click();
        Thread.sleep(3000);
        WebElement searchSubmit = driver.findElement(By.xpath("//input[@class = 'btn btn-default']"));
        searchSubmit.click();
        WebElement searchErrorMessage = driver.findElement(By.xpath("//div[@class = 'help-block']"));
        Thread.sleep(3000);
        String actualResult = searchErrorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    /*    TC_11_06_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Нажать пункт меню Support → Ask a question
     * 3. Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
     * 4. Оставить пустым поле Email
     * 5. Заполнить поля  Subject, Message
     * 6. Подтвердить CAPTCHA
     * 7. Нажать кнопку Submit
     * 8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”
     */
    @Test
    public void testErrorMessageEmail_WhenEmailIsEmpty() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String message = "How can I see the weather forecast for tomorrow in Paris";
        String expectedResult = "can't be blank";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchSupport = driver.findElement(
                By.xpath("//div[@id= 'support-dropdown']")
        );
        searchSupport.click();
        Thread.sleep(2000);

        WebElement searchSupportAskAQuestion = driver.findElement(
                By.xpath("//ul[@id= 'support-dropdown-menu']/li/a[@href = 'https://home.openweathermap.org/questions']")
        );
//        searchSupportAskAQuestion.click();
//        Thread.sleep(5000);
        driver.get("https://home.openweathermap.org/questions");
        Thread.sleep(5000);

        WebElement searchSubjectField = driver.findElement(
                By.xpath("//select[@class = 'form-control select required']")
        );
        searchSubjectField.click();
        Thread.sleep(2000);
        WebElement searchSubjectOther = driver.findElement(
                By.xpath("//select[@class = 'form-control select required']/option[@value = 'Other']")
        );
        searchSubjectOther.click();

        WebElement searchMessageField = driver.findElement(
                By.xpath("//textarea[@class = 'form-control text required']")
        );
        searchMessageField.click();
        Thread.sleep(2000);
        searchMessageField.sendKeys(message);

////div[@class='recaptcha-checkbox-checkmark']
        WebElement searchCAPTCHA = driver.findElement(
                By.xpath("//div[@class = 'recaptcha-checkbox-spinner-overlay']")
        );
        searchCAPTCHA.click();

        WebElement searchSubmit = driver.findElement(
                By.xpath("//input[@class = 'btn btn-default']")
        );
        searchSubmit.click();

        WebElement searchErrorMessage = driver.findElement(
                By.xpath("//span[@class = 'help-block']")
        );
        String actualResult = searchErrorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    @Test
    public void testErrorEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String subject = "Other";
        String message = "Hi Lilu we are waiting for you";

        String expectedResult = "can't be blank";


        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement clickOnSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        clickOnSupport.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(4000);
        WebElement selectSubmenu_AskAQuestion = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"));
        selectSubmenu_AskAQuestion.click();

        Thread.sleep(4500);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
//        List<String> set = new ArrayList<>(getDriver().getWindowHandles());
//        for (int i = 0; i < getDriver().getWindowHandles().size(); i++) {
//            if (!originalWindow.contentEquals(set.get(i))) {
//                driver.switchTo().window(set.get(i));
//                break;
//            }
//        }
        Thread.sleep(3000);

        WebElement enterSubject = driver.findElement(By.xpath(
                "//select[@class='form-control select required']"));

        enterSubject.click();

        enterSubject.sendKeys(subject);

        Thread.sleep(4000);

        WebElement enterMessage = driver.findElement(By.xpath(
                "//textarea[@class='form-control text required']"));
        enterMessage.click();
        enterMessage.sendKeys(message);

        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));

        WebElement enterCaptcha = driver.findElement(By.xpath(
                "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked "
                        + "rc-anchor-checkbox']"));
        enterCaptcha.click();

        Thread.sleep(10000);

        driver.switchTo().window(window2);

        WebElement pressSubmit = driver.findElement(By.xpath(
                "//input[@data-disable-with='Create Question form']"));
        pressSubmit.click();

        WebElement confirmErrorEmail = driver.findElement(By.xpath("//span[@class='help-block']"));

        String actualResult = confirmErrorEmail.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*    TC_11_07_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Нажать на единицы измерения Imperial: °F, mph
     * 3. Нажать на единицы измерения Metric: °C, m/s
     * 4. Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С
     */
    @Test
    public void testUnitsOfMeasurementIsCelsius() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String measure1 = "F";
        String measure2 = "C";
        boolean expectedResult1 = true;
        boolean expectedResult2 = true;

        driver.get(url);
        driver.manage().window().maximize(); // можно не разворачивать
        Thread.sleep(5000);

        WebElement searchImperialF = driver.findElement(
                By.xpath("//div[text() = 'Imperial: °F, mph']")
        );
        searchImperialF.click();
        Thread.sleep(2000);

        WebElement searchF = driver.findElement(
                By.xpath("//span[@class = 'heading']")
        );
        boolean actualResult1 = searchF.getText().contains(measure1);

        Assert.assertEquals(actualResult1, expectedResult1);

        WebElement searchImperialC = driver.findElement(
                By.xpath("//div[text() = 'Metric: °C, m/s']")
        );
        searchImperialC.click();
        Thread.sleep(2000);

        WebElement searchC = driver.findElement(
                By.xpath("//span[@class = 'heading']")
        );
        boolean actualResult2 = searchF.getText().contains(measure2);

        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    /*    TC_11_08_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Нажать на лого компании
     * 3. Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась
     */
    @Test
    public void testLogoLink() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/";

        driver.get(url);
        driver.manage().window().maximize(); // можно не разворачивать
        Thread.sleep(5000);

        WebElement searchLogo = driver.findElement(
                By.xpath("//li[@class = 'logo']")
        );
        searchLogo.click();
        Thread.sleep(5000);

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*    TC_11_09_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. В строке поиска в навигационной панели набрать “Rome”
     * 3. Нажать клавишу Enter
     * 4. Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
     * 5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”
     */
//    @Test
//    public void testFindCity() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        String url = "https://openweathermap.org/";
//        String cityName = "Rome";
//        String action = "find";
//
//        boolean expectedResult1 = true;
//        String expectedResult2 = "Rome";
//
//        driver.get(url);
//        Thread.sleep(5000);
//
//        WebElement searchMenu = driver.findElement(
//                By.xpath("//li[@id ='hamburger']")
//        );
//        searchMenu.click();
//
//        WebElement searchCityWeather = driver.findElement(
//                By.xpath("//ul[@id = 'mobile-menu']//input[@placeholder = 'Weather in your city']")
//        );
//        searchCityWeather.click();
//        searchCityWeather.sendKeys(cityName);
//
//        searchCityWeather.submit();
//        Thread.sleep(2000);
//
//        if (driver.getCurrentUrl().contains(cityName) && driver.getCurrentUrl().contains(action)){
//            boolean actualResult1 = true;
//            Assert.assertEquals(actualResult1, expectedResult1);
//        } else {
//            boolean actualResult1 = false;
//            Assert.assertEquals(actualResult1, expectedResult1);
//
//        }
//
//        WebElement searchRome = driver.findElement(By.xpath("//input[@id = 'search_str']"));
//        String actualResult2 = searchRome.getAttribute("value");
//
//
//        Assert.assertEquals(actualResult2, expectedResult2);
//
//        driver.quit();
//    }
    @Test
    public void testFindCity() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String cityName = "Rome";
        String action = "find";

        boolean expectedResult1 = true;
        String expectedResult2 = "Rome";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchCityWeather = driver.findElement(
                By.xpath("//div//input[@placeholder = 'Weather in your city']")
        );
        searchCityWeather.click();
        searchCityWeather.sendKeys(cityName);

        searchCityWeather.submit();
        Thread.sleep(2000);

        if (driver.getCurrentUrl().contains(cityName) && driver.getCurrentUrl().contains(action)){
            boolean actualResult1 = true;
            Assert.assertEquals(actualResult1, expectedResult1);
        } else {
            boolean actualResult1 = false;
            Assert.assertEquals(actualResult1, expectedResult1);

        }

        WebElement searchRome = driver.findElement(By.xpath("//input[@id = 'search_str']"));
        String actualResult2 = searchRome.getAttribute("value");


        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }


    /*    TC_11_10_HW11  :
     * 1. Открыть страницу https://openweathermap.org/
     * 2. Нажать на пункт меню API
     * 3. Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок
     */
//    @Test
//    public void testFindOrangeButtons() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        String url = "https://openweathermap.org/";
//        int expectedResult = 30;
//
//        driver.get(url);
//        Thread.sleep(5000);
//
//        WebElement searchMenu = driver.findElement(
//                By.xpath("//li[@id ='hamburger']")
//        );
//        searchMenu.click();
//
//        WebElement searchAPI = driver.findElement(
//        By.xpath("//ul[@id = 'mobile-menu']//a[ text() = 'API']")
//        );
//        searchAPI.click();
//        Thread.sleep(2000);
//
//        List<WebElement> searchBtnOrange = driver.findElements(
//        By.xpath("//a[contains(@class, 'orange')]")
//        );
//        int actualResult = searchBtnOrange.size();
//
//
//        Assert.assertEquals(actualResult, expectedResult);
//
//        driver.quit();
//    }
    @Test
    public void testFindOrangeButtons() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        int expectedResult = 30;

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchAPI = driver.findElement(
                By.xpath("//div[@id ='desktop-menu']//a[@href = '/api']")
        );
        searchAPI.click();
        Thread.sleep(2000);

        List<WebElement> searchBtnOrange = driver.findElements(
                By.xpath("//a[contains(@class, 'orange')]")
        );
        int actualResult = searchBtnOrange.size();


        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
//    @Test
//    public void test_name() {
//        System.setProperty("webdriver.chrome.driver", "/home/nata/IdeaProjects/chromedriver/chromedriver_linux64/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//
//        driver.quit();
//    }

}