package addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoNewContact();
    app.getContactHelper().fillinNewContact();
    app.getContactHelper().submitNewContact();
    app.getNavigationHelper().returntoHomePage();
  }
}
