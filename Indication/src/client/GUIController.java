import java.util.Observer;

/**
* This class controls all windows throughout the game screen and
* pre-game menus. It extends the Observer class.
*
* @author Mark
* @version 5/10/2014
*/

public class GUIController extends Observer {
	/**
	* Constructor initializes new GUIController for a ClientController.
	*/
	public GUIController() {

	}
	/**
	* Returns the ClientController using the GUIController. 
	*/
	public ClientController getClientController() {

	}
	/**
	* Opens the appropriate window.
	* @param GUIWindow to open.
	*/
	public void openGUIWindow(GUIWindow w) {

	}
	/**
	* Closes the appropriate window.
	* @param GUIWindow to close.
	*/
	public void closeGUIWindow(GUIWindow w) {

	}
	/**
	* Returns the Window object of specified window.
	* @param GUIWindow to return.
	* @return Appropriate GUIWindow.
	*/
	public GUIWindow getGUIWindow(GUIWindow w) {

	}
	/** 
	* Updates all observer-relevant information for GUIController 
	* about the ClientController.
	* @param Observable object.
	*/
	public void update(Object obj) {

	}
}