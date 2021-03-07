package addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.gotoNewContact();
    app.fillinNewContact();
    app.submitNewContact();
    app.returntoHomePage();
  }
}
