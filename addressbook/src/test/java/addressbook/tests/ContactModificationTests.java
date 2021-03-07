package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().click(By.xpath("//img[@alt='Edit']"));
        app.getContactHelper().updateContact();
        app.getNavigationHelper().click(By.xpath("(//input[@name='update'])[2]"));
        app.getNavigationHelper().returntoHomePage();
    }
}
