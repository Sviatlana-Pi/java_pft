package addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletion extends TestBase{

    @Test
    public void testContactDeletion(){
        app.getContactHelper().selectforEditContact();
        app.getContactHelper().deleteContact();
    }

}
