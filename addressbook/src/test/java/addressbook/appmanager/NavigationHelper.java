package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
       click(By.linkText("groups"));
    }

    public void returntoHomePage() {
        click(By.linkText("home page"));
    }

    public void gotoNewContact() {
        click(By.linkText("add new"));
    }
}
