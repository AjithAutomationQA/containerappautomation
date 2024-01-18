package containerBCapp.Methods;

import containerBCapp.ExcelRead.ExcelRead;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectMethods extends ExcelRead {

    WebElement text;
  String  before_ChatName;
  String  after_ChatName;

  public void tapOn_Skip() throws Throwable {

      tapTheElement("Skip"); // remove it
  }

    public void tapOn_ConnectTab() throws Throwable {
       // tapOn_Skip();
        tapTheElement("Connect");
        isElementDisplayed("ConnectHeader");

    }

    public void tapOn_Chat() throws Throwable {
        String chatName =  getText("Connect.Chat");
        PrintValue("chat name" +chatName);
        tapTheElement("Connect.Chat");

    }

    public void verify_ChatUI() throws Throwable {

        isElementDisplayed("Connect.BackArrow");
        isElementDisplayed("Connect.Type_a_Message");
        isElementDisplayed("Connect.chat_at_mention_icon");
        isElementDisplayed("Connect.chat_attachment_icon");
        isElementDisplayed("Connect.chat_send_inactive_icon");
        PrintValue("UI verified");

    }

    public void enter_EmptyMessage() throws Throwable {

        sendKey("Connect.Type_a_Message", "  ");
        PrintValue("Empty space in entered in the input bar");

    }

    public void sendButton_Disabled() throws Throwable {

        try {
            isElementDisplayed("Connect.chat_send_inactive_icon");
            PrintValue("Send button is disabled when input is empty");
            tapTheElement("Connect.BackArrow");
        } catch (Exception e) {
            PrintError("Send button is enabled");
            tapTheElement("Connect.BackArrow");
        }


    }

    public void enter_Message() throws Throwable {
        faker();
        message = testdata.country().name();
        //   message = "man";0
        sendKey("Connect.Type_a_Message", message);
        PrintValue(message + " is entered in the input bar");


    }

    public void sendButton_Enabled() throws Throwable {

        isElementDisplayed("Connect.chat_send_active_icon");
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


        tapTheElement("Connect.chat_send_active_icon");

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


        String readTick = locator + "/following-sibling::XCUIElementTypeImage[@name='chat_read_tick']";


        String sentTick = locator + "/following-sibling::XCUIElementTypeImage[@name='chat_sent_tick']";

        String deliveredTick = locator + "/following-sibling::XCUIElementTypeImage[@name='chat_delivered_tick']";

        String retryIcon = locator + "/following-sibling::XCUIElementTypeImage[@name='retry_red']";


//        try {
//            WebElement chat_sent_tick = findElementByxpath(sentTick);
//            WebElement chat_delivered_tick = findElementByxpath(deliveredTick);
//            WebElement chat_read_tick = findElementByxpath(readTick);
//            WebElement retry_red = findElementByxpath(retryIcon);
//            if (chat_sent_tick.isDisplayed()) {
//                System.out.println("Element 1 is displayed.");
//                // Perform actions specific to Element 1
//            } else if (chat_delivered_tick.isDisplayed()) {
//                System.out.println("Element 2 is displayed.");
//                // Perform actions specific to Element 2
//            } else if (chat_read_tick.isDisplayed()) {
//                System.out.println("Element 3 is displayed.");
//                // Perform actions specific to Element 3
//            } else if (retry_red.isDisplayed()) {
//                System.out.println("Element 4 is displayed.");
//                // Perform actions specific to Element 4
//            } else {
//                System.out.println("None of the elements are displayed.");
//            }
//        } catch (Exception e) {
//
        //    }

        try {
            WebElement chat_sent_tick = findElementByxpath(sentTick);
            isElementDisplayed(chat_sent_tick);
            PrintValue("Chat sent tick verified");
            PrintValue(sentTick);

        } catch (Exception e) {
        }

        try {
            WebElement chat_delivered_tick = findElementByxpath(deliveredTick);
            isElementDisplayed(chat_delivered_tick);
            PrintValue("Chat delivered tick verified");
            PrintValue(deliveredTick);
        } catch (Exception e1) {

        }

        try {
            WebElement chat_read_tick = findElementByxpath(readTick);
            isElementDisplayed(chat_read_tick);
            PrintValue("Chat read tick verified");
            PrintValue(readTick);
        } catch (Exception e3) {

        }
        try {
            WebElement retry_red = findElementByxpath(retryIcon);
            isElementDisplayed(retry_red);
            PrintValue("Message failed to send");
            PrintValue(retryIcon);
            Assert.fail();
        } catch (Exception e3) {

        }

    }

    public void verifyMessgesent() throws Throwable {
        text = findElementById(message);
        isElementDisplayed(text);
        PrintValue("Message sent verified successfully");

    }

    public void longPressMessage() throws Throwable {
        text = findElementById(message);
        longPress(text);
        PrintValue("Message is long pressed");
    }

    public void bottomSheet() throws Throwable {
        isElementDisplayed("BottomSheet.Reply");
        isElementDisplayed("BottomSheet.Edit");
        isElementDisplayed("BottomSheet.Pin");
        isElementDisplayed("BottomSheet.SetReminder");
        isElementDisplayed("BottomSheet.Copy");
        isElementDisplayed("BottomSheet.Share");
        try {
            isElementDisplayed("BottomSheet.Delete");
        }
        catch (Exception e){
            PrintValue("Delete option is not available");
        }
        tapTheElement("CancelButton");
        PrintValue("Bottom sheet displayed");
    }

    public void tapOnTheDeleteButton() throws Throwable {
        tapTheElement("BottomSheet.Delete");
        tapTheElement("BottomSheet.DeleteMessage");
        PrintValue("Tapped on the delete button");
    }

    public void verifyDeletedMessage() throws Throwable {
        String messageDeleted = locator + "/following-sibling::XCUIElementTypeStaticText[@name=" + "\"" + "This message was deleted" + "\"" + "]";
        isElementDisplayed(findElementByxpath(messageDeleted));
        PrintValue("Message deleted successfully");
        PrintValue(messageDeleted);
    }

    public void tapOnTheEditButton() throws Throwable {
        tapTheElement("BottomSheet.Edit");
    }

    public void editTheMessage() throws Throwable {
        tapTheElement("Connect.Type_a_Message").clear();
        enter_Message();
        tapTheElement("SaveButton");
    }

    public void verifyEditedMessage() throws Throwable {

        String messageEdited = locator + "/following-sibling::XCUIElementTypeImage[@name=\"chat_edit\"]";
        PrintValue(messageEdited);
        isElementDisplayed(findElementByxpath(messageEdited));
        PrintValue("Message edited successfully");
    }

    public void pinTheMessage() throws Throwable {
        tapTheElement("BottomSheet.Pin");

    }

    public void verifyPinnedMessage() throws Throwable {

        String messagePinned = locator + "/following-sibling::XCUIElementTypeStaticText[@name=\"Pinned\"]";
        PrintValue("Message pinned " + messagePinned);
        isElementDisplayed(findElementByxpath(messagePinned));

        String messagePinnedIcon = locator + "/following-sibling::XCUIElementTypeImage[@name=\"chat_pin\"]";

        isElementDisplayed(findElementByxpath(messagePinnedIcon));
        PrintValue("Message pinned successfully");
    }

    public void unPinTheMessage() throws Throwable {
        tapTheElement("BottomSheet.Unpin");

    }

    public void verifyUnpinMessage() throws Throwable {

        String messagePinned = locator + "/following-sibling::XCUIElementTypeStaticText[@name=\"Pinned\"]";
        PrintValue(messagePinned);

        try {
            isNotElementDisplayed(findElementByxpath(messagePinned));
        } catch (Exception e) {

        }

        PrintValue("Message unpinned successfully");
    }

    public void copyAndPasteMessage() throws Throwable {

        tapTheElement("BottomSheet.Copy");
        PrintValue(message + " : is copied");

        longPress(tapTheElement("Connect.Type_a_Message"));
        tapTheElement("Connect.Paste");
        tapTheElement("Connect.chat_send_active_icon");

    }

    public void verifyCopyAndSendMessage() throws Throwable {

        String messageCopyPasted = "(//XCUIElementTypeStaticText[@name=" + "\"" + message + "\"" + "])[2]";
        PrintValue(messageCopyPasted);
        isElementDisplayed(findElementByxpath(messageCopyPasted));
        PrintValue("Message copied and sent successfully");

    }

    public void tapAttachmentButton() throws Throwable {
        tapTheElement("Connect.chat_attachment_icon");

    }

    public void clickPhoto() throws Throwable {
        tapTheElement("Connect.UseCamera");
        try {
            tapTheElement("OK");
        } catch (Exception e) {

        }
        tapTheElement("Connect.PhotoCapture");
        tapTheElement("Connect.UsePhoto");

    }

    public void sendAttachments() throws Throwable {
        tapTheElement("Connect.FromFiles");
        tapTheElement("Connect.Attachments");
        PrintValue("Attachment selected");
    }


    public void readTheFirstChat() throws Throwable {
        try {
            WebElement FirstRow = getElement("Connect.FirstRow");

            FirstRow.click();
            tapTheElement("Connect.BackArrow");
        }
        catch (Exception e){

        }

    }
    public void swipeTheChat() throws Throwable {


        WebElement firstChat = getElement("Connect.FirstChat");
       before_ChatName =  firstChat.getText();
         swipeR2LusingLocator(firstChat);
        try {
            tapTheElement("Connect.delete_on_swipe");
        } catch (Exception e) {
        }

    }

    public void verify_ChatName() throws Throwable {

        readTheFirstChat();
        WebElement firstChat = getElement("Connect.FirstChat");
         after_ChatName =  firstChat.getText();
         assertTextFalse(before_ChatName,after_ChatName);
    }

    public void verify_ReminderInRecentChat() throws Throwable {

        isElementDisplayed("Connect.ReminderRecent");
        PrintValue("Active reminder in recent chat is displayed");

    }


}
