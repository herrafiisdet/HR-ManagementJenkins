package dockerTest;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class dockerTest {


    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static void main(String[]args) throws MalformedURLException, InterruptedException {

        String remote_url_chrome="http://localhost:4444/wd/hub";
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver.set(new RemoteWebDriver(new URL(remote_url_chrome),options));
        driver.get().navigate().to("https://www.google.com");
                String url = driver.get().getCurrentUrl();
        System.out.println(url);
        String title = driver.get().getTitle();
        System.out.println(title);
        Thread.sleep(2000);

        driver.get().quit();
    }
}

// steps to setup selenium grid with dockers containers
//download the below links from the CMD
//1   docker pull selenium/hub
//2   docker pull selenium/node-chrome
//3   docker pull selenium/node-firefox
//4   docker run -d -p 4444:4444 --name selenium-hub selenium/hub
//5   docker run -d --link selenium-hub:hub selenium/node-chrome
//6   docker run -d --link selenium-hub:hub selenium/node-firefox

