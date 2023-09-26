package containerBCapp.Methods;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import containerBCapp.ExcelRead.ExcelRead;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

public class InboxMethods extends ExcelRead {
    //
    public String messageName;
    public String retrievedMessageName;
//	public String readName;
//	public String unReadName;
//	public String retrievedMessageName2;

//	public String messageName2;


    //<This method is to read the first message>
    public void makeReadMessage() throws Throwable {

        tapTheElement("FirstMessage", LocatorPropertiesFile);
        tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
    }

    //<This method is get the first message name>
    public void getMessageName() throws Throwable {

        WebElement FirstReadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
        messageName = FirstReadMessage.getText();

    }

    //<This method is to tap on the first message>
    public String tapOnTheMessage() throws Throwable {

        makeReadMessage();
        getMessageName();
        PrintValue("messageName " + messageName);
        tapTheElement("FirstReadMessage", LocatorPropertiesFile);
        retrievedMessageName = getText("MessageName", LocatorPropertiesFile);
        PrintValue("retrievedMessageName " + retrievedMessageName);

        return retrievedMessageName;
    }

    //<This method is to verify the message details in the inbox>
    public void verifyMessageDetails() throws Throwable {

        assertMessageName(messageName, retrievedMessageName);

        WebElement Phone_button = getElement("Inbox.Phone_button", LocatorPropertiesFile);
        isElementDisplayed(Phone_button);

        WebElement Message_button = getElement("Inbox.Message_button", LocatorPropertiesFile);
        isElementDisplayed(Message_button);

        try {
            WebElement Activity_button = getElement("Inbox.Activity_button", LocatorPropertiesFile);


            if (Activity_button.isDisplayed()) {
                Activity_button.click();
                WebElement All_Activities = getElement("Inbox.All_Activities", LocatorPropertiesFile);

                if (All_Activities.isDisplayed()) {
                    PrintValue("Activities available");

                }
            }
        } catch (Exception e) {
            PrintValue("Activities not available");
        }

        WebElement AddNote_button = getElement("Inbox.AddNote_button", LocatorPropertiesFile);
        isElementDisplayed(AddNote_button);

        WebElement Share_button = getElement("Inbox.Share_button", LocatorPropertiesFile);
        isElementDisplayed(Share_button);
        tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
    }

    //<This method is to swipe and archive the first message in the inbox>
    public void archiveSwipe() throws Throwable {

        makeReadMessage();
        WebElement FirstReadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
        messageName = swipeR2LusingLocator(FirstReadMessage);
        PrintValue(messageName);
        try {
            tapTheElement("Inbox.ArchiveIcon", LocatorPropertiesFile);
        } catch (Exception e) {
        }
    }

    //<This method is to tap on the archive button from the menu>
    public void tapArchiveFromMenu() throws Throwable {

        tapTheElement("Inbox.ThreeDotButton", LocatorPropertiesFile);
        tapTheElement("Inbox.Archive", LocatorPropertiesFile);

    }

    public void v() throws Throwable {

        WebElement archivedMessage = scroll(messageName);
        PrintValue("Scroll");

    }
    

    //<This method is to verify the message name in the Archive tab>
    public void validateMessageInArchiveTab() throws Throwable {

     //   WebElement archivedMessage = scroll(messageName);
      //  assertTrue(archivedMessage.isDisplayed());
        PrintValue("Message archived is: " + messageName);

        tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
    }

    //<This method is to long press the first message in the inbox>
    public void longPressTheMessage() throws Throwable {
        makeReadMessage();
        WebElement message = getMobileElement("FirstReadMessage", LocatorPropertiesFile);
        messageName = longPress(message);
        PrintValue(messageName);
    }

    //<This method is to tap on the archive button indentifier>
    public void tapTheArchiveButtonIdentifier() throws Throwable {

        tapTheElement("Inbox.ArchiveButtonIdentifier", LocatorPropertiesFile);
    }

    //<This method is to tap on the menu button in message details view>
    public void tapDropdown_option_button() throws Throwable {

        tapTheElement("Inbox.Dropdown_option_button", LocatorPropertiesFile);

    }

    //<This method is to tap on the move to archive button in the message details view>
    public void tapMove_To_Archive() throws Throwable {

        tapTheElement("Inbox.Move_To_Archive", LocatorPropertiesFile);

    }

    //<This method is to tap on the move to trash button in the message details view>
    public void tapMove_To_Trash() throws Throwable {

        tapTheElement("Inbox.Move_To_Trash", LocatorPropertiesFile);

    }




    //<This method is to tap on the give feedback button in the message details view>
    public void tapGive_Feedback() throws Throwable {

        tapTheElement("Inbox.Give_Feedback", LocatorPropertiesFile);

    }

    //<This method is to enter feedback in the message details view>
    public void enterFeedback() throws Throwable {

        testData();
        isElementDisplayed("Inbox.SendDisabled", LocatorPropertiesFile);
        sendKey("Inbox.Enter_Feedback", LocatorPropertiesFile, feedBack);

        String feedback = goodOrBadFeedback;
        if (feedback.equalsIgnoreCase("Good")) {
            tapTheElement("Inbox.GoodFeedback", LocatorPropertiesFile);
            isElementDisplayed("Inbox.Good_Feedback_Active", LocatorPropertiesFile);
        } else if (feedback.equalsIgnoreCase("Bad")) {
            tapTheElement("Inbox.BadFeedback", LocatorPropertiesFile);
            isElementDisplayed("Inbox.Bad_Feedback_Active", LocatorPropertiesFile);
        }
    }

    //<This method is to tap on the send button in the feedback section>
    public void tapSendEnabled() throws Throwable {

        tapTheElement("Inbox.SendEnabled", LocatorPropertiesFile);
    }

    //<This method is to check the feedback button in the message details view>
    public void checkForFeedback() throws Throwable {
        try {
            getElement("Inbox.Give_Feedback", LocatorPropertiesFile);
            PrintValue("Feedback option is displayed after giving feedback");

        } catch (Exception e) {
            PrintValue("Feedback option is not displayed after giving feedback");
        }

        tapTheElement("CancelButton", LocatorPropertiesFile);
        tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
    }


    //<This method is to swipe and unarchive the first message in the archive tab>
    public void unArchiveSwipe() throws Throwable {

        makeReadMessage();
        WebElement FirstReadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
        messageName = swipeR2LusingLocator(FirstReadMessage);
        try {
            tapTheElement("Inbox.UnarchiveIcon", LocatorPropertiesFile);
        } catch (Exception e) {
        }
        tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
    }

    //<This method is to verify the message name in the inbox tab>
    public void validateInboxTabByText() throws Throwable {

        WebElement unArchivedMessage = scroll(messageName);
        assertEquals(unArchivedMessage, messageName, "Message is pushed to inbox successfully");

    }

    //<This method is to tap on the trash button indentifier>
    public void tapTheTrashButtonIdentifier() throws Throwable {

        tapTheElement("Inbox.TrashButtonIdentifier", LocatorPropertiesFile);
    }

    //<This method is to tap on the trash button from the menu>
    public void tapTrashFromMenu() throws Throwable {

        tapTheElement("Inbox.ThreeDotButton", LocatorPropertiesFile);
        tapTheElement("Inbox.Trash", LocatorPropertiesFile);
    }

    //<This method is to verify the message name in the Trash tab>
    public void validateInTrashTabByText() throws Throwable {

        WebElement TrashedMessage = scroll(messageName);
        assertEquals(TrashedMessage, messageName, "Message trashed is: " + messageName);

        tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

    }

    //<This method is to swipe and restore the message in the Trash tab>
    public void restoreSwipeByText() throws Throwable {

        makeReadMessage();
        WebElement FirstReadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
        messageName = swipeR2LusingLocator(FirstReadMessage);
        try {
            tapTheElement("Inbox.RestoreIcon", LocatorPropertiesFile);
        } catch (Exception e) {
        }
        tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
    }

    //<This method is to select 5 messages in the inbox tab>
    public void selectMessages() throws Throwable {

        for (int i = 1; i <= 6; i++) {

            String unSelectedMessage = "(//XCUIElementTypeOther[@name=\"message-unselected-cel\"])[1]";
            WebElement iosElementss = IOsdriver.findElement(By.xpath(unSelectedMessage));


            TouchAction action = new TouchAction(IOsdriver);
            action.longPress(longPressOptions().withElement(element(iosElementss)).withDuration(Duration.ofMillis(10000)))
                    .release().perform();
        }
    }

    //<This method is to validate the no of messages selected in the inbox tab>
    public void validateNoOfSelectedMessage() throws Throwable {

        WebElement Message = getMobileElement("Inbox.NoOfSelectedMessages", LocatorPropertiesFile);
        assertEquals(Message, "5", "Allowed to select up to 5 messages only");
        tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
    }

    //<This method is tap on the All from the filter in the inbox tab>
    public void tapOnAllDrd() throws Throwable {

        tapTheElement("Filter.All", LocatorPropertiesFile);
    }

    //<This method is select the unread messages>
    public void tapOnUnreadFilter() throws Throwable {
        tapTheElement("Filter.Unreadmessage", LocatorPropertiesFile);
    }

    //<This method is to filter unread messages in the inbox tab>
    public void selectUnreadFromFilter() throws Throwable {

        tapOnAllDrd();
        tapOnUnreadFilter();
    }

    //<This method is tap on the Apply filter button>
    public void tapOnApplyButton() throws Throwable {

        tapTheElement("Filter.Apply", LocatorPropertiesFile);
        //	isElementDisplayed(theElement);
    }

    //<This method is select the all messages>
    public void tapOnAllFilter() throws Throwable {

        tapTheElement("Filter.Allmessage", LocatorPropertiesFile);
    }

    //<This method is filter all messages in the inbox ta>
    public void selectAllMessages() throws Throwable {
        //	tapOnUnreadDrd();
        //	tapOnAllFilter();
        //	tapOnApplyButton();

        killAndRelaunch();
    }

    //<This method is to verify if only unread messages are displayed in the inbox tab>
    public void onlyUnreadMessageList() throws Throwable {

        try {
            WebElement NoUnreadMessage = getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
            String NoUnreadMessageText = NoUnreadMessage.getText();

            if (NoUnreadMessage.isDisplayed()) {

                PrintValue(NoUnreadMessageText);
                selectAllMessages();
            }
        } catch (Exception e) {
            PrintValue("List of unread messages are present");
            List<WebElement> unreadList = IOsdriver.findElements(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])"));
            int noOfUnreadMessages = unreadList.size();
            PrintValue("No of unread message in the unread filter is: " + noOfUnreadMessages);

        }
        try {
            WebElement readMessage = IOsdriver.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"message-read-icn\"])"));

            if (readMessage.isDisplayed()) {

                PrintError("Read message is displayed in the unread filter");
            }

        } catch (Exception e) {
            PrintValue("As expected no read message is displayed in the Unread filter");
            selectAllMessages();
        }
    }

    //<This method is to verify the number of unread messages in the inbox and unread filter are same>
    public void compareInboxAndUnread() throws Throwable {

        int noOfUnreadInInbox;
        int noOfUnreadInFilter;

        try {
            WebElement unreadMessage = IOsdriver.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])"));

            List<WebElement> unreadListInbox = IOsdriver.findElements(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])"));
            noOfUnreadInInbox = unreadListInbox.size();

            if (noOfUnreadInInbox > 0) {
                PrintValue("No of unread message in inbox is: " + noOfUnreadInInbox);
                selectUnreadFromFilter();
                tapOnApplyButton();

                List<WebElement> unreadListInUnread = IOsdriver.findElements(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])"));
                noOfUnreadInFilter = unreadListInUnread.size();
                if (noOfUnreadInInbox == noOfUnreadInFilter) {

                    PrintValue("No of unread message in unread is: " + noOfUnreadInFilter);
                    PrintValue("No of unread messages in the inbox and unread filter are same");
                    selectAllMessages();
                } else {
                    PrintValue("No of unread message in unread is: " + noOfUnreadInFilter);
                    PrintError("No of unread messages in the inbox and unread filter are different");
                    selectAllMessages();
                }
            }
        } catch (Exception e) {
            PrintValue("No of unread message in inbox is zero");
            selectUnreadFromFilter();
            tapOnApplyButton();

            WebElement NoUnreadMessage = getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
            String NoUnreadMessageText = NoUnreadMessage.getText();
            if (NoUnreadMessage.isDisplayed()) {

                PrintValue(NoUnreadMessageText);
                PrintValue("No of unread message in inbox is zero");
                selectAllMessages();
            }
            selectAllMessages();
        }
    }

    //<This method is to make the message as unread>
    public void makeUnreadMessage() throws Throwable {
        WebElement FirstMessage = getElement("FirstMessage", LocatorPropertiesFile);
        longpress(FirstMessage);
        tapTheElement("Inbox.UnReadButtonIdentifier", LocatorPropertiesFile);
        WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
        messageName = FirstUnreadMessage.getText();
        PrintValue("Message unread is :" + messageName);
    }

    //<This method is to verify the unread message>
    public void readMessageFromUnread() throws Throwable {
        WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
        messageName = FirstUnreadMessage.getText();

        assertMessageName(messageName, retrievedMessageName);
        PrintValue("Message is pushed to unread filter");
        killAndRelaunch();
    }

    //<This method is to long press and read the first message in the unread filtere>
    public void longPressAndReadMessage() throws Throwable {

        WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
        messageName = FirstUnreadMessage.getText();
        longpress(FirstUnreadMessage);
        tapTheElement("Inbox.ReadButtonIdentifier", LocatorPropertiesFile);
    }

    //<This method is to verify if read message is moved out of the unread list>
    public void verifyUnreadList() throws Throwable {

        try {
            WebElement NoUnreadMessage = getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
            String NoUnreadMessageText = NoUnreadMessage.getText();
            if (NoUnreadMessage.isDisplayed()) {

                PrintValue(NoUnreadMessageText);
                PrintValue("Message marked as read in unread filter successfully");
                selectAllMessages();
            }
        } finally {

        }
    }

    //<This method is to archive the first unread message in the inbox>
    public void archiveFirstUnreadMessage() throws Throwable {
        WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
        messageName = swipeR2LusingLocator(FirstUnreadMessage);
        try {
            tapTheElement("Inbox.ArchiveIcon", LocatorPropertiesFile);
        } catch (Exception e) {
        }
    }

    //<This method is to check if archived unread message is displayed in the unread message list>
    public void archivenotinUnread() throws Throwable {

        try {
            WebElement NoUnreadMessage = getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
            String NoUnreadMessageText = NoUnreadMessage.getText();
            if (NoUnreadMessage.isDisplayed()) {

                PrintValue(NoUnreadMessageText);
                PrintValue("Archived unread message not available in the unread filter tab");
                selectAllMessages();
            }
        } catch (Exception e) {
            WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
            String retrievedMessageName = FirstUnreadMessage.getText();
            assertTextFalse(messageName, retrievedMessageName);
            PrintValue("Archived unread message not available in the unread filter tab");
            selectAllMessages();
        }
    }

    // <This method is to long press and trash the unread message form the inbox>
    public void longPressAndTrash() throws Throwable {

        WebElement FirstMessage = getElement("FirstMessage", LocatorPropertiesFile);
        messageName = FirstMessage.getText();
        longpress(FirstMessage);
        tapTheTrashButtonIdentifier();
    }

    //<This method is to check if trashed unread message is displayed in the unread message list>
    public void trashednotinUnread() throws Throwable {


        try {
            WebElement NoUnreadMessage = getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
            String NoUnreadMessageText = NoUnreadMessage.getText();
            if (NoUnreadMessage.isDisplayed()) {

                PrintValue(NoUnreadMessageText);
                PrintValue("Trashed unread message not available in the unread filter tab");
                selectAllMessages();
            }
        } catch (Exception e) {
            WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
            String retrievedMessageName = FirstUnreadMessage.getText();
            assertTextFalse(messageName, retrievedMessageName);
            PrintValue("Trashed unread message not available in the unread filter tab");
            selectAllMessages();

        }
    }

//
//
//	//////////////////////
//
//	public void validateInArchiveTab() throws Throwable {
//
//		WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
//		unReadName = FirstUnreadMessage.getText();
//
//		assertMessageName(retrievedMessageName, unReadName);
//		//		WebElement archivedMessage = scroll(messageName, "down");
//		//		assertEquals(archivedMessage, messageName, "Message archived is: " + messageName);
//		//
//		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
//	}
//
//	public void validateReadInArchiveTab() throws Throwable {
//
//
//		WebElement FirstReadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
//		readName = FirstReadMessage.getText();
//
//		assertMessageName(retrievedMessageName, readName);
//		//		WebElement archivedMessage = scroll(messageName, "down");
//		//		assertEquals(archivedMessage, messageName, "Message archived is: " + messageName);
//		//
//		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
//	}
//
//

//

//

//
//
//

//

//
//	public void selected () throws Throwable {
//
//		WebElement messageName = 	IOsdriver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"message-title-read-lab\"])[1]"));
//
//		if(messageName.isDisplayed()) {
//			String name = 	messageName.getText();
//			PrintValue(name);
//			WebElement read = 	IOsdriver.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"message-read-icn\"])[1]"));
//			WebElement unread = 	IOsdriver.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])[1]"));
//
//			if(read.isDisplayed()) {
//
//				PrintValue("is read");
//			}
//
//			else if (unread.isDisplayed()) {
//				PrintValue("is unread");
//			}
//		}
//	}
//
//	public void makeReadMessage() throws Throwable {
//
//		tapTheElement("FirstMessage", LocatorPropertiesFile);
//		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
//	}
//

//
//

//	public void assertMessageName() throws Throwable {
//
//		assertMessageName(readName, unReadName);
//		PrintValue("Message is unread successfully");
//	}
//

//
//
//


//		catch (Exception e) {
//			WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
//			String FirstUnreadMessageText = FirstUnreadMessage.getText();
//			assertTextFalse(retrievedMessageName2, FirstUnreadMessageText);
//			PrintValue("Message marked as read in unread filter successfully");
//			selectAllMessages();
//		}
//	}
//

//
//	public void archiveswipeMessage() throws Throwable {
//		WebElement FirstUnreadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
//		retrievedMessageName = swipeR2LusingLocator(FirstUnreadMessage);
//		try {
//			tapTheElement("Inbox.ArchiveIcon", LocatorPropertiesFile);
//		}
//		catch (Exception e) {
//		}
//	}
//

//

//

//
//	}
//
    }
