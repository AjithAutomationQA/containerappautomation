package containerBCapp.Methods;


import containerBCapp.Baseclass.CommonUtilities;

public class AddNoteMethods extends CommonUtilities {

    public void tapAddNote() throws Throwable {

        tapTheElement("Inbox.AddNote_button");
    }

    public void enterAddNotes() throws Throwable {
        sendKey("Inbox.AddNote", "Test note added");
        tapTheElement("Inbox.SendEnabled");
        toastMessage("Notes added successfully");
    }

}

