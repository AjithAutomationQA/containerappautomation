package containerBCapp.Methods;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
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
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class InboxMethods extends ExcelRead {

	public String messageName ;
	public String readName;
	public String unReadName;
	public String retrievedMessageName2;
	public String retrievedMessageName;
	public String messageName2= "Message Five";
	public String swipeMessageName= "Message Four";
	


	public String tapOnTheMessage() throws Throwable {

		makeReadMessage();
		WebElement message =	tapTheElement("FirstReadMessage", LocatorPropertiesFile);
		messageName = message.getText();
		return messageName;
	}

	public void verifyMessageDetails() throws Throwable {


		WebElement findElementByName = findElementByName(readName);
		String text2 = findElementByName.getText();
		assertTextValue(readName, text2);

		WebElement Phone_button = getElement("Inbox.Phone_button", LocatorPropertiesFile);
		isElementDisplayed(Phone_button);

		WebElement Message_button = getElement("Inbox.Message_button", LocatorPropertiesFile);
		isElementDisplayed(Message_button);

		try {
			WebElement Activity_button = getElement("Inbox.Activity_button", LocatorPropertiesFile);


			if(Activity_button.isDisplayed()) {
				Activity_button.click();
				WebElement All_Activities = getElement("Inbox.All_Activities", LocatorPropertiesFile);

				if(All_Activities.isDisplayed()) {
					PrintValue("Activities available");

				}
			}
		}
		catch (Exception e) {
			PrintValue("Activities not available");
		}

		WebElement AddNote_button = getElement("Inbox.AddNote_button", LocatorPropertiesFile);
		isElementDisplayed(AddNote_button);

		WebElement Share_button = getElement("Inbox.Share_button", LocatorPropertiesFile);
		isElementDisplayed(Share_button);
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}

	public void archiveSwipeByText() throws Throwable {

		//WebElement FirstMessage = getMobileElement("Inbox.FirstMessage", LocatorPropertiesFile);
		messageName = swipeRightToLeft(swipeMessageName,"down");
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

	public void tapDropdown_option_button() throws Throwable {

		tapTheElement("Inbox.Dropdown_option_button", LocatorPropertiesFile);

	}

	public void tapMove_To_Archive() throws Throwable {

		tapTheElement("Inbox.Move_To_Archive", LocatorPropertiesFile);

	}

	public void tapMove_To_Trash() throws Throwable {

		tapTheElement("Inbox.Move_To_Trash", LocatorPropertiesFile);

	}

	public void tapGive_Feedback() throws Throwable {

		tapTheElement("Inbox.Give_Feedback", LocatorPropertiesFile);

	}

	public void enterFeedback() throws Throwable {

		testData();
		isElementDisplayed("Inbox.SendDisabled", LocatorPropertiesFile);
		sendKey("Inbox.Enter_Feedback", LocatorPropertiesFile, feedBack);

		String feedback = goodOrBadFeedback;
		if(feedback.equalsIgnoreCase("Good")) {
			tapTheElement("Inbox.GoodFeedback", LocatorPropertiesFile);
			isElementDisplayed("Inbox.Good_Feedback_Active", LocatorPropertiesFile);
		}
		else if(feedback.equalsIgnoreCase("Bad")) {
			tapTheElement("Inbox.BadFeedback", LocatorPropertiesFile);
			isElementDisplayed("Inbox.Bad_Feedback_Active", LocatorPropertiesFile);
		}

	}

	public void tapSendEnabled() throws Throwable {

		tapTheElement("Inbox.SendEnabled", LocatorPropertiesFile);

	}

	public void checkForFeedback() throws Throwable {
		try {
			getElement("Inbox.Give_Feedback", LocatorPropertiesFile);
			PrintValue("Feedback option is displayed after giving feedback");
			
		}
		catch (Exception e) {
			PrintValue("Feedback option is not displayed after giving feedback");
		}

		tapTheElement("CancelButton", LocatorPropertiesFile);
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}

	public void toastMessage(String Text) throws Throwable {

		//		MobileElement toastElement = IOsdriver.findElement(By.xpath(
		//				"//XCUIElementTypeStaticText[@name='Invalid credentials']"));

		MobileElement 	toastElement = IOsdriver
				.findElement(MobileBy.iOSClassChain(("**/XCUIElementTypeStaticText[`label == \"" + Text + "\"`]")));
		isElementDisplayed(toastElement);

		String toastText = toastElement.getText();
		assertTextValue(toastText, Text);
		reportLog("Toast Message: " + toastText);
		PrintValue("Toast Message: " + toastText);
	}

	public void validateByTextInArchiveTab() throws Throwable {

		//WebElement FirstMessage = getMobileElement("Inbox.FirstMessage", LocatorPropertiesFile);
		WebElement archivedMessage = scroll(messageName, "down");
		assertEquals(archivedMessage, messageName, "Message archived is: " + messageName);

		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}


	public void longPressTheMessageByText() throws Throwable {

		messageName = longPress(messageName2 ,"down"); 
	}

	public void unArchiveSwipeByText() throws Throwable {

		//WebElement FirstMessage = getMobileElement("Inbox.FirstMessage", LocatorPropertiesFile);
		messageName = swipeRightToLeft(messageName2 ,"down");

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
		messageName = swipeRightToLeft(messageName2 ,"down");

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
				selectAllMessages();

			}
			selectAllMessages();

		}

	}


	//////////////////////

	public void validateInArchiveTab() throws Throwable {


		WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
		unReadName = FirstUnreadMessage.getText();

		assertTextValue(retrievedMessageName, unReadName);
		//		WebElement archivedMessage = scroll(messageName, "down");
		//		assertEquals(archivedMessage, messageName, "Message archived is: " + messageName);
		//
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

	}

	public void validateReadInArchiveTab() throws Throwable {


		WebElement FirstReadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
		readName = FirstReadMessage.getText();

		assertTextValue(retrievedMessageName, readName);
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

			String unSelectedMessage  = "(//XCUIElementTypeOther[@name=\"message-unselected-cel\"])[1]";
			WebElement iosElementss = IOsdriver.findElement(By.xpath(unSelectedMessage));


			TouchAction action = new TouchAction(IOsdriver);
			action.longPress(longPressOptions().withElement(element(iosElementss)).withDuration(Duration.ofMillis(10000)))
			.release().perform();
		}
	}

	public void validateNoOfSelectedMessage() throws Throwable {

		WebElement Message = getMobileElement("Inbox.NoOfSelectedMessages", LocatorPropertiesFile);
		assertEquals( Message, "5", "Allowed to select upto 5 messages only");
		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);

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
		retrievedMessageName2 = FirstUnreadMessage.getText();
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
			assertTextFalse(retrievedMessageName2, FirstUnreadMessageText);
			PrintValue("Message marked as read in unread filter successfully");
			selectAllMessages();
		}

	}

	public void archiveFirstUnreadMessage() throws Throwable {
		WebElement FirstUnreadMessage = getElement("FirstUnreadMessage", LocatorPropertiesFile);
		retrievedMessageName = swipeR2LusingLocator(FirstUnreadMessage);
		try {
			tapTheElement("Inbox.ArchiveIcon", LocatorPropertiesFile);
		}
		catch (Exception e) {

		}

	}

	public void archiveFirstreadMessage() throws Throwable {
		WebElement FirstUnreadMessage = getElement("FirstReadMessage", LocatorPropertiesFile);
		retrievedMessageName = swipeR2LusingLocator(FirstUnreadMessage);
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
			assertTextFalse(retrievedMessageName, FirstUnreadMessageText);
			PrintValue("Archived unread message not available in the unread filter tab");
			selectAllMessages();

		}

	}

	public void longPressAndTrash () throws Throwable {

		WebElement FirstMessage = getElement("FirstMessage", LocatorPropertiesFile);
		retrievedMessageName  = FirstMessage.getText();
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
			assertTextFalse(retrievedMessageName, FirstUnreadMessageText);
			PrintValue("Trashed unread message not available in the unread filter tab");
			selectAllMessages();

		}

	}















}
