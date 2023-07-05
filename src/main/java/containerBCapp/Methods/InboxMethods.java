package containerBCapp.Methods;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import containerBCapp.ExcelRead.ExcelRead;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class InboxMethods extends ExcelRead {

	public String messageName ;
	public	WebElement theElement;
	public String readName;
	public String unReadName;
	public String name1;
	public String text;


	public void archiveSwipeByText() throws Throwable {

		//WebElement FirstMessage = getMobileElement("Inbox.FirstMessage", LocatorPropertiesFile);
		messageName = swipeRightToLeft("Point Message","down");
		try {
			tapTheElement("Inbox.ArchiveIcon", LocatorPropertiesFile);
		}

		catch (Exception e) {
		}

	}

	public void tapArchiveFromMenu() throws Throwable {

		tapTheElement("Inbox.ThreeDotButton", LocatorPropertiesFile);
		tapTheElement("Inbox.Archive", LocatorPropertiesFile);

	}

	public void validateByTextInArchiveTab() throws Throwable {

		//WebElement FirstMessage = getMobileElement("Inbox.FirstMessage", LocatorPropertiesFile);
		WebElement archivedMessage = scroll(messageName, "down");
		assertEquals(archivedMessage, messageName, "Message archived is: " + messageName);

		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}
	
	
	public void longPressTheMessageByText() throws Throwable {

		messageName = longPress("Test 3S","down"); 
	}
	
	public void unArchiveSwipeByText() throws Throwable {

		//WebElement FirstMessage = getMobileElement("Inbox.FirstMessage", LocatorPropertiesFile);
		messageName = swipeRightToLeft("Test 3S","down");
		
		try {
			tapTheElement("Inbox.UnarchiveIcon", LocatorPropertiesFile);
		}
		catch (Exception e) {
		}
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
	}
	
	public void validateInboxTabByText() throws Throwable {

		WebElement unArchivedMessage = scroll(messageName, "down");
		assertEquals(unArchivedMessage, messageName, "Message in inbox tab is: " + messageName);

	}
	
	public void validateInTrashTabByText() throws Throwable {

		WebElement TrashedMessage = scroll(messageName, "down");
		assertEquals(TrashedMessage, messageName, "Message trashed is: " + messageName);

		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}
	
	public void restoreSwipeByText() throws Throwable {

		//WebElement FirstMessage = getMobileElement("Inbox.FirstMessage", LocatorPropertiesFile);
		messageName = swipeRightToLeft("Test 3S","down");
		
		try {
		
			tapTheElement("Inbox.RestoreIcon", LocatorPropertiesFile);
		}
		catch (Exception e) {
		}
		
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}
	
	public void tapOnAllDrd () throws Throwable {

		tapTheElement("Filter.All", LocatorPropertiesFile);
	}

	public void tapOnAllFilter () throws Throwable {

		tapTheElement("Filter.Allmessage", LocatorPropertiesFile);
	}


	public void tapOnUnreadDrd () throws Throwable {

		tapTheElement("Filter.Unread", LocatorPropertiesFile);

	}

	public void tapOnUnreadFilter () throws Throwable {

		tapTheElement("Filter.Unreadmessage", LocatorPropertiesFile);

	}

	public void tapOnApplyButton () throws Throwable {

		tapTheElement("Filter.Apply", LocatorPropertiesFile);
		//	isElementDisplayed(theElement);
	}
	
	public void selectAllMessages() throws Throwable {

		//		tapOnUnreadDrd();
		//		tapOnAllFilter();
		//		tapOnApplyButton();

		killAndRelaunch();
	}

	public void selectUnreadFromFilter() throws Throwable {

		tapOnAllDrd();
		tapOnUnreadFilter();
	}

	public void onlyUnreadMessageList () throws Throwable {

		try {

			WebElement NoUnreadMessage = getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
			String NoUnreadMessageText = NoUnreadMessage.getText();

			if(NoUnreadMessage.isDisplayed()) {

				PrintValue(NoUnreadMessageText);
				selectAllMessages();
			}


		}
		catch (Exception e) {
			PrintValue("List of unread messages are present");
			List<IOSElement> unreadList = IOsdriver.findElements(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])"));
			int noOfUnreadMessages =	unreadList.size();
			PrintValue("No of unread message in the unread filter is: "+ noOfUnreadMessages);

		}
		try {
			WebElement readMessage = 	IOsdriver.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"message-read-icn\"])"));

			if(readMessage.isDisplayed()) {

				PrintError("Read message is displayed in the unread filter");
			}

		}catch (Exception e) {
			PrintValue("As expected no read message is displayed in the Unread filter");
			selectAllMessages();
		}
	}


	public void compareInboxAndUnread () throws Throwable {

		int noOfUnreadInInbox ;
		int noOfUnreadInFilter;
		try {
			WebElement unreadMessage = IOsdriver.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])"));

			List<IOSElement> unreadListInbox = IOsdriver.findElements(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])"));
			noOfUnreadInInbox =	unreadListInbox.size();

			if(noOfUnreadInInbox>0) {
				PrintValue("No of unread message in inbox is: "+ noOfUnreadInInbox);
				selectUnreadFromFilter();
				tapOnApplyButton();


				List<IOSElement> unreadListInUnread = IOsdriver.findElements(By.xpath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])"));
				noOfUnreadInFilter =	unreadListInUnread.size();
				if(noOfUnreadInInbox==noOfUnreadInFilter) {

					PrintValue("No of unread message in unread is: "+ noOfUnreadInFilter);
					PrintValue("No of unread messages in the inbox and unread filter are same");
					selectAllMessages();
				}
				else {
					PrintValue("No of unread message in unread is: "+ noOfUnreadInFilter);
					PrintError("No of unread messages in the inbox and unread filter are different");
					selectAllMessages();
				}

			}

		}
		catch (Exception e) {
			PrintValue("No of unread message in inbox is zero");
			selectUnreadFromFilter();
			tapOnApplyButton();

			WebElement NoUnreadMessage = getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
			String NoUnreadMessageText = NoUnreadMessage.getText();
			if(NoUnreadMessage.isDisplayed()) {

				PrintValue(NoUnreadMessageText);
				PrintValue("No of unread message in inbox is zero");

			}

		}

	}


//////////////////////

	public void validateInArchiveTab() throws Throwable {


		WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
		unReadName = FirstUnreadMessage.getText();

		assertTextValue(text, unReadName);
		//		WebElement archivedMessage = scroll(messageName, "down");
		//		assertEquals(archivedMessage, messageName, "Message archived is: " + messageName);
		//
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}

	public void validateReadInArchiveTab() throws Throwable {


		WebElement FirstReadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
		readName = FirstReadMessage.getText();

		assertTextValue(text, readName);
		//		WebElement archivedMessage = scroll(messageName, "down");
		//		assertEquals(archivedMessage, messageName, "Message archived is: " + messageName);
		//
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}


	public void tapTheArchiveButtonIdentifier() throws Throwable {

		tapTheElement("Inbox.ArchiveButtonIdentifier", LocatorPropertiesFile);
	}

	public void tapTheTrashButtonIdentifier() throws Throwable {

		tapTheElement("Inbox.TrashButtonIdentifier", LocatorPropertiesFile);
	}

	public void tapTrashFromMenu() throws Throwable {

		tapTheElement("Inbox.ThreeDotButton", LocatorPropertiesFile);
		tapTheElement("Inbox.Trash", LocatorPropertiesFile);

	}



	public void selectMessages() throws Throwable {


		for(int i=1; i<=6; i++) {

			WebElement iosElementss = IOsdriver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"message-title-read-lab”])"+i+"]"));

			//(//XCUIElementTypeOther[3]/XCUIElementTypeOther)
			//	for (IOSElement iosElement : mess) {

			TouchAction action = new TouchAction(IOsdriver);
			action.longPress(longPressOptions().withElement(element(iosElementss)).withDuration(Duration.ofMillis(10000)))
			.release().perform();

			//}
		}
	}

	public void validateNoOfSelectedMessage() throws Throwable {

		WebElement Message = getMobileElement("Inbox.NoOfSelectedMessages", LocatorPropertiesFile);
		assertEquals( Message, "6", "Allowed to select upto 6 messages only");

	}


	public void messagescript () throws Throwable {

		WebElement messageName = 	IOsdriver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"message-title-read-lab\"])[1]");


		if(messageName.isDisplayed()) {
			String name = 	messageName.getText();
			PrintValue(name);
			WebElement read = 	IOsdriver.findElementByXPath("(//XCUIElementTypeImage[@name=\"message-read-icn\"])[1]");
			WebElement unread = 	IOsdriver.findElementByXPath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])[1]");

			if(read.isDisplayed()) {

				PrintValue("is read");
			}

			else if (unread.isDisplayed()) {
				PrintValue("is unread");
			}

		}

	}


	public void selected () throws Throwable {

		WebElement messageName = 	IOsdriver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"message-title-read-lab\"])[1]");


		if(messageName.isDisplayed()) {
			String name = 	messageName.getText();
			PrintValue(name);
			WebElement read = 	IOsdriver.findElementByXPath("(//XCUIElementTypeImage[@name=\"message-read-icn\"])[1]");
			WebElement unread = 	IOsdriver.findElementByXPath("(//XCUIElementTypeImage[@name=\"message-unread-icn\"])[1]");

			if(read.isDisplayed()) {

				PrintValue("is read");
			}

			else if (unread.isDisplayed()) {
				PrintValue("is unread");
			}

		}


	}


	
	
	
	public void makeReadMessage() throws Throwable {

		tapTheElement("FirstMessage", LocatorPropertiesFile);
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
		WebElement FirstReadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
		readName = FirstReadMessage.getText();
		PrintValue("Message read is :"+ readName);

	}


	public void makeUnreadMessage() throws Throwable {
		WebElement FirstMessage = getElement("FirstMessage", LocatorPropertiesFile);
		longpress(FirstMessage);
		tapTheElement("Inbox.UnReadButtonIdentifier", LocatorPropertiesFile);
		WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
		unReadName = FirstUnreadMessage.getText();
		PrintValue("Message unread is :"+ unReadName);

	}
	public void assertMessageName() throws Throwable {

		assertTextValue(readName, unReadName);
		PrintValue("Message is unread successfully");

	}

	public void readMessageFromUnread() throws Throwable {
		WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
		unReadName = FirstUnreadMessage.getText();

		assertTextValue(readName, unReadName);
		PrintValue("Message is pushed to unread filter");
		killAndRelaunch();
	}



	public void longPressAndReadMessage() throws Throwable {

		WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
		name1 = FirstUnreadMessage.getText();
		longpress(FirstUnreadMessage);
		tapTheElement("Inbox.ReadButtonIdentifier", LocatorPropertiesFile);

	}
	public void verifyUnreadList() throws Throwable {

		try {
			WebElement NoUnreadMessage = getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
			String NoUnreadMessageText = NoUnreadMessage.getText();
			if(NoUnreadMessage.isDisplayed()) {

				PrintValue(NoUnreadMessageText);
				PrintValue("Message marked as read in unread filter successfully");
				selectAllMessages();
			}
		}
		catch (Exception e) {
			WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
			String FirstUnreadMessageText = FirstUnreadMessage.getText();
			assertTextFalse(name1, FirstUnreadMessageText);
			PrintValue("Message marked as read in unread filter successfully");
			selectAllMessages();
		}

	}

	public void archiveFirstUnreadMessage() throws Throwable {
		WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
		text = swipeR2LusingLocator(FirstUnreadMessage);
		try {
			tapTheElement("Inbox.ArchiveIcon", LocatorPropertiesFile);
		}
		catch (Exception e) {

		}

	}

	public void archiveFirstreadMessage() throws Throwable {
		WebElement FirstUnreadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
		text = swipeR2LusingLocator(FirstUnreadMessage);
		try {
			tapTheElement("Inbox.ArchiveIcon", LocatorPropertiesFile);
		}
		catch (Exception e) {

		}

	}

	public void archivenotinUnread() throws Throwable {


		try {
			WebElement NoUnreadMessage = 		getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
			String NoUnreadMessageText = NoUnreadMessage.getText();
			if(NoUnreadMessage.isDisplayed()) {

				PrintValue(NoUnreadMessageText);
				PrintValue("Archived unread message not available in the unread filter tab");
				selectAllMessages();
			}
		}
		catch (Exception e) {
			WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
			String FirstUnreadMessageText = FirstUnreadMessage.getText();
			assertTextFalse(text, FirstUnreadMessageText);
			PrintValue("Archived unread message not available in the unread filter tab");
			selectAllMessages();

		}

	}

	public void longPressAndTrash () throws Throwable {

		WebElement FirstMessage = getElement("FirstMessage", LocatorPropertiesFile);
		text  = FirstMessage.getText();
		longpress(FirstMessage);
		tapTheTrashButtonIdentifier();


	}

	public void trashednotinUnread() throws Throwable {


		try {
			WebElement NoUnreadMessage = 		getElement("Filter.NoUnreadMessage", LocatorPropertiesFile);
			String NoUnreadMessageText = NoUnreadMessage.getText();
			if(NoUnreadMessage.isDisplayed()) {

				PrintValue(NoUnreadMessageText);
				PrintValue("Trashed unread message not available in the unread filter tab");
				selectAllMessages();
			}
		}
		catch (Exception e) {
			WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
			String FirstUnreadMessageText = FirstUnreadMessage.getText();
			assertTextFalse(text, FirstUnreadMessageText);
			PrintValue("Trashed unread message not available in the unread filter tab");
			selectAllMessages();

		}

	}















}
