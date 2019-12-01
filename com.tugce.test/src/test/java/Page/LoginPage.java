package Page;

import Base.BasePage;
import org.junit.Assert;

public class LoginPage extends BasePage {

    String email ="testuser";
    String parola ="testpass";
    String beklenenSekmeBasligi ="Login example page to test the PHP MySQL online system";
    String beklenenSayfaBasligi = "4. Login";
    String beklenenStatüMesaji="**No login attempted**";


    String beklenenUsernameHatalıMesajı="Username too short.  The username must be at least 4 characters in length.";
    String beklenenPasswordHatalıMesajı="Password too short.  The password must be at least 4 characters in length.";

    String failedLogin="**Failed Login**";



    public void loginControls () throws InterruptedException
    {
        Thread.sleep(1000);
       String pageTitle = driver.getTitle().trim();
        System.out.println("Page title :"+ pageTitle);
        Assert.assertTrue("Sekme başlığı doğru değil",pageTitle.contains(beklenenSekmeBasligi));
        String sayfaBaslıgı= getText("p:nth-of-type(1) > big > strong").trim();
        System.out.println("Sayfa başlığı :"+ sayfaBaslıgı);
        Assert.assertTrue("Sayfa başlığı doğru değil ",sayfaBaslıgı.contains(beklenenSayfaBasligi));
        String statüMesajı = getText("blockquote > font  b").trim();
        System.out.println("Statü mesajı :"+ statüMesajı);
        Assert.assertTrue("Beklenen statü mesajı doğru değil",statüMesajı.contains(beklenenStatüMesaji));
        String sayfaBilgiMesaji = getText("blockquote > p").trim();
        System.out.println("Page title :"+ sayfaBilgiMesaji);
    }


    public void loginWithTrueData()
    {
        setObjectByCss("input[name='username']",email);
        setObjectByCss("input[name='password']",parola);
        clickObjectByCss("input[name='FormsButton2']");
      //  Assert.assertTrue("Succses login mesajı görülmedi",isElementVisible("//big/blockquote/blockquote/font//b[.='**Succsess Login**']",30));


    }

    public void loginTrueDataWithHelp()
    {
        clickObjectByCss("td:nth-of-type(3) > div a > small > small");
        acceptAlert();
        setObjectByCss("input[name='username']","abc");
        clickObjectByCss("tr:nth-of-type(2) > td:nth-of-type(3) > a > small > small");
        acceptAlert();
        setObjectByCss("input[name='password']","def");
        clickObjectByCss("tr:nth-of-type(3) > td:nth-of-type(3) > a > small > small");
        acceptAlert();
        clickObjectByCss("input[name='FormsButton2']");
      //  Assert.assertTrue("Succses login mesajı görülmedi",isElementVisible("//big/blockquote/blockquote/font//b[.='**Succsess Login**']",30));
    }
    public void loginWithWrongDataUsername()
    {
        setObjectByCss("input[name='username']","123");
        clickObjectByCss("input[name='FormsButton2']");
        String  usernameAlertMessage =getTextAlert();
        System.out.println("Alert message :"+ usernameAlertMessage);
        Assert.assertTrue("Alert mesajı doğru değil",usernameAlertMessage.contains(beklenenUsernameHatalıMesajı));
        acceptAlert();

    }
    public void loginWithWrongDataForPassword() throws InterruptedException
    {
       Thread.sleep(1000);
        setObjectByCss("input[name='username']","12345");
        setObjectByCss("input[name='password']","123");
        clickObjectByCss("input[name='FormsButton2']");
        String  passwordAlertMessage =getTextAlert();
        System.out.println("Alert message :"+ passwordAlertMessage);
        Assert.assertTrue("Alert mesajı doğru değil",passwordAlertMessage.contains(beklenenPasswordHatalıMesajı));
        acceptAlert();

    }

}
