package ru.stqa.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    public WebDriver wd;



    private String browser;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;
    private MailHelper mailHelper;
    private DbHelper dbHelper;
    private NavigationHelper navigationHelper;
    private AdminHelper adminHelper;
    private SessionHelper sessionHelper;
    private UserHelper userHelper;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }



  // public void init() throws IOException {
   //     String target = System.getProperty("target", "local");
  //      properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
  public WebDriver getDriver() {
      if (wd == null) {
          if (browser.equals(BrowserType.FIREFOX)) {
              wd = new FirefoxDriver();
          } else if (browser.equals(BrowserType.CHROME)) {
              wd = new ChromeDriver();
          } else if (browser.equals(BrowserType.IE)) {
              wd = new InternetExplorerDriver();
          }
          wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
          wd.get(properties.getProperty("web.baseUrl"));
      }
      return wd;
  }


    public void stop() {
             wd.quit();
        }


    public FtpHelper ftp(){
        if(ftp == null){
            ftp = new FtpHelper(this);
        }
        return ftp;
    }

    public UserHelper user(){
        if(userHelper == null){
            userHelper = new UserHelper(this);
        }
        return userHelper;
    }

    public MailHelper mail(){
        if(mailHelper == null){
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public DbHelper db() {
        dbHelper = new DbHelper();
        return  dbHelper;
    }

    public NavigationHelper goTo() {
        navigationHelper = new NavigationHelper(this);
        return navigationHelper;
    }

    public AdminHelper admin() {
        adminHelper = new AdminHelper(this);
        return adminHelper;
    }

         public SessionHelper session() {
            sessionHelper = new SessionHelper(this.getDriver());
            return sessionHelper;
        }



    public HttpSession newSession(){
        return new HttpSession(this);
    }

    public String getProperty(String key) {
       return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
            }
            return registrationHelper;
    }
    public void timeout(int seconds) {
        wd.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}



