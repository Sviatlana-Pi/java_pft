package addressbook;

import addressbook.model.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("group1", "header group1", "footer group1"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
