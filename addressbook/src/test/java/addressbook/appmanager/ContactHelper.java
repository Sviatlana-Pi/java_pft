package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContact() {
        click(By.xpath("//input[@name='submit']"));
    }

    public void fillinNewContact() {
        type(By.name("firstname"), "first name");
        type(By.name("middlename"), "middle name");
        type(By.name("lastname"), "last name");
        type(By.name("nickname"), "nick name");
        type(By.name("title"), "Mr");
        type(By.name("company"), "Company");
        type(By.name("address"), "address 50");
        type(By.name("home"),"city");
        type(By.name("work"), "tester");
        type(By.name("fax"), "54654(78)");
        type(By.name("email"), "test@mail.com");
        type(By.name("email2"), "test2@mail.com");
        type(By.name("email3"), "test3@mail.com");
        type(By.name("homepage"), "www.tut.by");
        type(By.name("address2"), "address new 2");
        type(By.name("notes"),"note");
        type(By.name("mobile"), "067876768");
        //addContactToGroup("new_group", "group1");
        //uploadPhoto("photo", "C:\\fakepath\\1.jpg");
        type(By.name("mobile"), "067876768");
        //fillinBirthday();
        //fillinAnniversary("aday", "amonth", "ayear", "1990", "new_group");
    }

    public void updateContact() {
        type(By.name("firstname"), "first name1");
        type(By.name("middlename"), "middle name1");
        type(By.name("lastname"), "last name1");
        type(By.name("nickname"), "nick name");
        type(By.name("title"), "Mr");
        type(By.name("company"), "Company");
        type(By.name("address"), "address 50");
        type(By.name("home"),"city");
        type(By.name("work"), "tester");
        type(By.name("fax"), "54654(78)");
        type(By.name("email"), "test@mail.com");
        type(By.name("email2"), "test2@mail.com");
        type(By.name("email3"), "test3@mail.com");
        type(By.name("homepage"), "www.tut.by");
        type(By.name("address2"), "address new 2");
        type(By.name("notes"),"note");
        type(By.name("mobile"), "067876768");
        //addContactToGroup("new_group", "group1");
        //uploadPhoto("photo", "C:\\fakepath\\1.jpg");
        type(By.name("mobile"), "067876768");
        //fillinBirthday();
        //fillinAnniversary("aday", "amonth", "ayear", "1990", "new_group");
    }

    private void addContactToGroup(String new_group, String group1) {
      new Select(wd.findElement(By.name(new_group))).selectByVisibleText(group1);
      wd.findElement(By.name(new_group)).click();
    }

    private void fillinAnniversary(String aday, String amonth, String ayear, String s, String new_group) {
      new Select(wd.findElement(By.name(aday))).selectByVisibleText("18");
      wd.findElement(By.name(aday)).click();
      wd.findElement(By.name(amonth)).click();
      new Select(wd.findElement(By.name(amonth))).selectByVisibleText("January");
      wd.findElement(By.name(amonth)).click();
      wd.findElement(By.name(ayear)).click();
      wd.findElement(By.name(ayear)).clear();
      wd.findElement(By.name(ayear)).sendKeys(s);
      wd.findElement(By.name(new_group)).click();
    }

    private void fillinBirthday() {
      wd.findElement(By.name("bday")).click();
      new Select(wd.findElement(By.name("bday"))).selectByVisibleText("18");
      wd.findElement(By.name("bday")).click();
      wd.findElement(By.name("bmonth")).click();
      new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("January");
      wd.findElement(By.name("bmonth")).click();
      wd.findElement(By.name("byear")).click();
      wd.findElement(By.name("byear")).clear();
      wd.findElement(By.name("byear")).sendKeys("1980");
      wd.findElement(By.name("aday")).click();
    }

    private void uploadPhoto(String photo, String s) {
      wd.findElement(By.name(photo)).click();
      wd.findElement(By.name(photo)).clear();
      wd.findElement(By.name(photo)).sendKeys(s);
    }

    public void selectforEditContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    private String closeAlertAndGetItsText() {
        return null;
    }

    public void selectforDeleteContact() {
        click(By.name("selected[]"));
    }

    public void confirmContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void clickdeleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }
}
