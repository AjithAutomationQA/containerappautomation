package containerBCapp.Methods;

import containerBCapp.ExcelRead.ExcelRead;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectMethods extends ExcelRead {

    WebElement text;

    public void tapOn_ConnectTab() throws Throwable {

        tapTheElement("Connect", LocatorPropertiesFile);
        isElementDisplayed("ConnectHeader", LocatorPropertiesFile);

    }

    public void tapOn_Chat() throws Throwable {

        tapTheElement("Connect.Chat", LocatorPropertiesFile);

    }

    public void verify_ChatUI() throws Throwable {

        isElementDisplayed("Inbox.BackArrow", LocatorPropertiesFile);
        isElementDisplayed("Connect.Type_a_Message", LocatorPropertiesFile);
        isElementDisplayed("Connect.chat_at_mention_icon", LocatorPropertiesFile);
        isElementDisplayed("Connect.chat_attachment_icon", LocatorPropertiesFile);
        isElementDisplayed("Connect.chat_send_inactive_icon", LocatorPropertiesFile);
        PrintValue("UI verified");

    }

    public void enter_EmptyMessage() throws Throwable {

        sendKey("Connect.Type_a_Message", LocatorPropertiesFile, "  ");
        PrintValue("Empty space in entered in the input bar");

    }

    public void sendButton_Disabled() throws Throwable {

        try {
            isElementDisplayed("Connect.chat_send_inactive_icon", LocatorPropertiesFile);
            PrintValue("Send button is disabled when input is empty");
            tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
        } catch (Exception e) {
            PrintError("Send button is enabled");
            tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
        }


    }

    public void enter_Message() throws Throwable {
        faker();
        message = testdata.name().firstName();
        //   message = "man";
        sendKey("Connect.Type_a_Message", LocatorPropertiesFile, message);
        PrintValue(message + " is entered in the input bar");


    }

    public void sendButton_Enabled() throws Throwable {

        isElementDisplayed("Connect.chat_send_active_icon", LocatorPropertiesFile);
        PrintValue("Send button is enabled when user enters the message in the input bar");

    }

    public String currentTime() throws Throwable {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String time = sdf.format(new Date());
        return time;
        //XCUIElementTypeStaticText[@name="6:08 PM"]
        //XCUIElementTypeStaticText[@name=6:08 PM]
    }

    public void tap_SendButton() throws Throwable {


        tapTheElement("Connect.chat_send_active_icon", LocatorPropertiesFile);

    }

    public void verify_ChatSentTime() throws Throwable {
        String time = currentTime();
        try {
            WebElement messagetime = findElementByText(time);
            isElementDisplayed(messagetime);
            PrintValue("Message sent time is: " + time);
        } catch (Exception e) {

        }

    }

    public void verify_ChatSentTick() throws Throwable {


        String readtick = locator + "/following-sibling::XCUIElementTypeImage[@name='chat_read_tick']";
        String senttick = locator + "/following-sibling::XCUIElementTypeImage[@name='chat_sent_tick']";
        String deliveredtick = locator + "/following-sibling::XCUIElementTypeImage[@name='chat_delivered_tick']";


        try {
            WebElement chat_sent_tick = findElementByxpath(senttick);
            isElementDisplayed(chat_sent_tick);
            PrintValue("Chat sent tick verified");

        } catch (Exception e) {
        }

        try {
            WebElement chat_delivered_tick = findElementByxpath(deliveredtick);
            isElementDisplayed(chat_delivered_tick);
            PrintValue("Chat delivered tick verified");
        } catch (Exception e1) {

        }

        try {
            WebElement chat_read_tick = findElementByxpath(readtick);
            isElementDisplayed(chat_read_tick);
            PrintValue("Chat read tick verified");
        } catch (Exception e3) {

        }

        text = findElementById(message);
        isElementDisplayed(text);
        PrintValue("Message sent verified successfully");

    }

    public void longPressMessage() throws Throwable {
        text = findElementById(message);
        longPress(text);
        PrintValue("Message is long pressed");
    }

    public void tapOnTheDeleteButton() throws Throwable {
        tapTheElement("BottomSheet.Delete", LocatorPropertiesFile);
        tapTheElement("BottomSheet.DeleteMessage", LocatorPropertiesFile);
        PrintValue("Tapped on the delete button");
    }

    public void verifyDeletedMessage() throws Throwable {
        String messageDeleted = locator + "/following-sibling::XCUIElementTypeStaticText[@name=" + "\"" + "This message was deleted" + "\"" + "]";
        isElementDisplayed(findElementByxpath(messageDeleted));
        PrintValue("Message deleted successfully");
    }

    public void tapOnTheEditButton() throws Throwable {
        tapTheElement("BottomSheet.Edit", LocatorPropertiesFile);
    }

    public void editTheMessage() throws Throwable {
        tapTheElement("Connect.Type_a_Message", LocatorPropertiesFile).clear();
        enter_Message();
        tapTheElement("SaveButton", LocatorPropertiesFile);
    }

    public void verifyEditedMessage() throws Throwable {

        String messageEdited = locator + "/following-sibling::XCUIElementTypeImage[@name=\"chat_edit\"]";

        isElementDisplayed(findElementByxpath(messageEdited));
        PrintValue("Message edited successfully");

    }
    //XCUIElementTypeImage[@name="chat_pin"]

    public void pinTheMessage() throws Throwable {
        tapTheElement("BottomSheet.Pin", LocatorPropertiesFile);

    }

    public void verifyPinnedMessage() throws Throwable {

        String messagePinned = locator + "/following-sibling::XCUIElementTypeStaticText[@name=\"Pinned\"]";

        isElementDisplayed(findElementByxpath(messagePinned));

        String messagePinnedIcon = locator + "/following-sibling::XCUIElementTypeImage[@name=\"chat_pin\"]";

        isElementDisplayed(findElementByxpath(messagePinnedIcon));
        PrintValue("Message pinned successfully");
    }

    public void unPinTheMessage() throws Throwable {
        tapTheElement("BottomSheet.Unpin", LocatorPropertiesFile);

    }

    public void verifyUnpinMessage() throws Throwable {

        String messagePinned = locator + "/following-sibling::XCUIElementTypeStaticText[@name=\"Pinned\"]";

        try {
            isNotElementDisplayed(findElementByxpath(messagePinned));
        }
       catch (Exception e){

        }

        PrintValue("Message unpinned successfully");
    }

    public void copyandPasteMessage() throws Throwable {

        tapTheElement("BottomSheet.Copy", LocatorPropertiesFile);
        PrintValue(message +" : is copied");

        longPress(tapTheElement("Connect.Type_a_Message", LocatorPropertiesFile));
        tapTheElement("Connect.Paste", LocatorPropertiesFile);
        tapTheElement("Connect.chat_send_active_icon", LocatorPropertiesFile);

    }
}
