package addressbook.appmanager;

import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    private void login(String username, String password) {
      wd.get("http://127.0.0.1/");
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
      wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {
      wd.findElement(By.name("new")).click();
    }

    public void gotoGroupPage() {
      wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        wd.findElement(By.linkText("Logout")).click();
        wd.quit();
    }

    private boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    public void deleteSelectedGroup() {
      wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
      wd.findElement(By.name("selected[]")).click();
    }

    public void returntoHomePage() {
      wd.findElement(By.linkText("home page")).click();
    }

    public void submitNewContact() {
      wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void gotoNewContact() {
      wd.findElement(By.linkText("add new")).click();
    }

    public void fillinNewContact() {
      fillinFirstName("firstname", "first name");
      fillinMiddleName("middlename", "middle name");
      fillinLastName("lastname", "last name");
      fillinNickName("nickname", "nickname", "nick name");
      uploadPhoto("photo", "C:\\fakepath\\1.jpg");
      fillinTitle("title", "Mr");
      fillinCompany("company", "Company");
      fillinAddress("address", "address 50");
      fillinHome("theform", "home", "city");
      fillinMobile(By.xpath("//div[@id='content']/form/label[11]"), "mobile", "067876768");
      fillinWork("work", "tester");
      fillinFax("fax", "54654(78)");
      fillinEmail1("email", "test@mail.com");
      fillinEmail2("email2", "test2@mail.com");
      fillinEmail3("email3", "test3@mail.com");
      fillinHomePage("homepage", "www.tut.by");
      fillinBirthday();
      fillinAnniversary("aday", "amonth", "ayear", "1990", "new_group");
      addContactToGroup("new_group", "group1");
      fillinAddress2("address2", "address new 3");
      fillinPhone2("phone2", "home");
      fillinNotes("notes", "note");
    }

    private void fillinNotes(String notes, String note) {
      wd.findElement(By.name(notes)).click();
      wd.findElement(By.name(notes)).clear();
      wd.findElement(By.name(notes)).sendKeys(note);
    }

    private void fillinPhone2(String phone2, String home) {
      wd.findElement(By.name(phone2)).click();
      wd.findElement(By.name(phone2)).clear();
      wd.findElement(By.name(phone2)).sendKeys(home);
    }

    private void fillinAddress2(String address2, String s) {
      wd.findElement(By.name(address2)).click();
      wd.findElement(By.name(address2)).clear();
      wd.findElement(By.name(address2)).sendKeys(s);
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

    private void fillinHomePage(String homepage, String s) {
      wd.findElement(By.name(homepage)).click();
      wd.findElement(By.name(homepage)).clear();
      wd.findElement(By.name(homepage)).sendKeys(s);
    }

    private void fillinEmail3(String email3, String s) {
      wd.findElement(By.name(email3)).click();
      wd.findElement(By.name(email3)).clear();
      wd.findElement(By.name(email3)).sendKeys(s);
    }

    private void fillinEmail2(String email2, String s) {
      wd.findElement(By.name(email2)).click();
      wd.findElement(By.name(email2)).clear();
      wd.findElement(By.name(email2)).sendKeys(s);
    }

    private void fillinEmail1(String email, String s) {
      wd.findElement(By.name(email)).click();
      wd.findElement(By.name(email)).clear();
      wd.findElement(By.name(email)).sendKeys(s);
    }

    private void fillinFax(String fax, String s) {
      wd.findElement(By.name(fax)).click();
      wd.findElement(By.name(fax)).clear();
      wd.findElement(By.name(fax)).sendKeys(s);
    }

    private void fillinWork(String work, String tester) {
      wd.findElement(By.name(work)).click();
      wd.findElement(By.name(work)).clear();
      wd.findElement(By.name(work)).sendKeys(tester);
    }

    private void fillinMobile(By xpath, String mobile, String s) {
      wd.findElement(xpath).click();
      wd.findElement(By.name(mobile)).click();
      wd.findElement(By.name(mobile)).clear();
      wd.findElement(By.name(mobile)).sendKeys(s);
    }

    private void fillinHome(String theform, String home, String city) {
      wd.findElement(By.name(theform)).click();
      wd.findElement(By.name(home)).click();
      wd.findElement(By.name(home)).clear();
      wd.findElement(By.name(home)).sendKeys(city);
    }

    private void fillinAddress(String address, String s) {
      wd.findElement(By.name(address)).click();
      wd.findElement(By.name(address)).clear();
      wd.findElement(By.name(address)).sendKeys(s);
    }

    private void fillinCompany(String company, String company2) {
      wd.findElement(By.name(company)).click();
      wd.findElement(By.name(company)).clear();
      wd.findElement(By.name(company)).sendKeys(company2);
    }

    private void fillinTitle(String title, String mr) {
      wd.findElement(By.name(title)).click();
      wd.findElement(By.name(title)).clear();
      wd.findElement(By.name(title)).sendKeys(mr);
    }

    private void uploadPhoto(String photo, String s) {
      wd.findElement(By.name(photo)).click();
      wd.findElement(By.name(photo)).clear();
      wd.findElement(By.name(photo)).sendKeys(s);
    }

    private void fillinNickName(String nickname, String nickname2, String s) {
      wd.findElement(By.name(nickname)).click();
      wd.findElement(By.name(nickname2)).click();
      wd.findElement(By.name(nickname2)).clear();
      wd.findElement(By.name(nickname2)).sendKeys(s);
    }

    private void fillinLastName(String lastname, String s) {
      wd.findElement(By.name(lastname)).click();
      wd.findElement(By.name(lastname)).clear();
      wd.findElement(By.name(lastname)).sendKeys(s);
    }

    private void fillinMiddleName(String middlename, String s) {
      wd.findElement(By.name(middlename)).click();
      wd.findElement(By.name(middlename)).clear();
      wd.findElement(By.name(middlename)).sendKeys(s);
    }

    private void fillinFirstName(String firstname, String s) {
      wd.findElement(By.name(firstname)).click();
      wd.findElement(By.name(firstname)).clear();
      wd.findElement(By.name(firstname)).sendKeys(s);
    }
}
