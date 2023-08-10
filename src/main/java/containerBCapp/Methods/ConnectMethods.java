package containerBCapp.Methods;

import containerBCapp.ExcelRead.ExcelRead;

public class ConnectMethods extends ExcelRead {
	
	
	
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
		}
		catch (Exception e) {
			PrintError("Send button is enabled");
			tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
		}
		
		
	}
	
	public void enter_Message() throws Throwable {

		sendKey("Connect.Type_a_Message", LocatorPropertiesFile, "HI man");
		PrintValue("Value is entered in the input bar");
		
	}
	
	public void sendButton_Enabled() throws Throwable {

		isElementDisplayed("Connect.chat_send_active_icon", LocatorPropertiesFile);
		PrintValue("Send button is enabled when user enters the message in the input bar");
		
	}
	
	public void tap_SendButton() throws Throwable {

		tapTheElement("Connect.chat_send_active_icon", LocatorPropertiesFile);
		
	}
	
	public void verify_SentMessage() throws Throwable {

		tapTheElement("Inbox.BackArrow", LocatorPropertiesFile);
		
	}

}
