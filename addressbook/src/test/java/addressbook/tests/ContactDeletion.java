package addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletion extends TestBase{

    @Test
    public void testContactDeletion(){
        //app.getContactHelper().selectforEditContact();
        app.getContactHelper().selectforDeleteContact();
        app.getContactHelper().clickdeleteContact();
        //app.getContactHelper().deleteContact();
        app.getContactHelper().confirmContactDeletion();
    }

}
