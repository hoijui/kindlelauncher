/**
 * Kindle Launcher
 * GUI menu launcher for Kindle Touch
 * Copyright (C) 2011  Yifan Lu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mobileread.ixtab.kindlelauncher.util;

//import javax.swing.Action;

//import com.amazon.agui.swing.MenuDialog;
//import com.amazon.kindle.util.lipc.LipcException;
//import com.amazon.kindle.util.lipc.LipcService;
//import com.mobileread.ixtab.kindlelauncher.LauncherKindlet;
import com.mobileread.ixtab.kindlelauncher.util.LauncherAction;

//import edu.emory.mathcs.backport.java.util.PriorityQueue;

/**
 * A menu item that contains a submenu.
 *
 * @author Yifan Lu
 * @version 1.0
 */
public class LauncherMenu extends LauncherAction {
//	private static final long serialVersionUID = 1L;
	
	//private MenuDialog mDialog;
   // private PriorityQueue mItems;
    private LauncherMenu mParent;

    /**
     * Creates a new submenu with its text label and priority
     *
     * @param name     The text to show
     * @param priority The order of this item in comparison to others
     */
    public LauncherMenu(String name, int priority) {
        this(name, priority, null);
    }

    /**
     * Creates a new submenu with its text label, priority, and parent menu
     *
     * @param name     The text to show
     * @param priority The order of this item in comparison to others
     * @param parent   The menu to go to when the "Previous" item is selected
     */
    public LauncherMenu(String name, int priority, LauncherMenu parent) {
        super(name, priority);
     //   mItems = new PriorityQueue();
        mParent = parent;
        setHasArrow(true);
    }

    /**
     * Renders the dialog on screen.
     *
     * @see LauncherMenu#getMenu()
     */
    public synchronized void doAction() {
    //    getMenu().postDialog(getCurrentAppId(), true);
        if (mParent != null) {
    //        mParent.putValue(Action.NAME, mParent.getValue());
        }
    }

    /**
     * The menu must be displayed in context to the current booklet on screen, this method finds it.
     *
     * @return The current app that is displayed.
    
    private String getCurrentAppId() {
        try {
     //       return LipcService.getInstance().getDefaultSource().getTarget("com.lab126.appmgrd").getStringProperty("activeApp");
     //   } catch (LipcException e) {
        	
        } catch (Throwable e) {
        	
     //       KindleLauncher.LOG.error("Cannot get current running app from lipc.");
            e.printStackTrace();
        }
        return "com.lab126.booklet.home";
    }
 */
    
    /**
     * Converts the list of menu items into a dialog containing the items.
     */
    public void initMenu() {
   //     mDialog = new MenuDialog(getCurrentAppId());
   //     mDialog.setTitle(this.getValue());
  //      PriorityQueue copy = new PriorityQueue();
   /*     while (!mItems.isEmpty()) {
            LauncherAction item = (LauncherAction) mItems.remove();
            if (item.hasArrow())
                mDialog.addActionWithIndicator(item);
            else
                mDialog.addAction(item);
            copy.add(item);
        }
        if (mParent != null) {
            mParent.putValue(Action.NAME, "« Previous");
            mDialog.addAction(mParent);
        }
        mItems = copy;
        
        */
    }

    /**
     * Adds an item to the menu.
     *
     * @param item The item to add.
     */
    public void addMenuItem(LauncherAction item) {
   //     mItems.add(item);
  //      mDialog = null;
    }

    /**
     * Removes an item from the menu.
     *
     * @param item The item to remove.
     */
    public void removeMenuItem(LauncherAction item) {
   //     mItems.remove(item);
    //    mDialog = null;
    }

    /**
     * All the menu items added.
     *
     * @return An array containing all the menu items added.
     */
    public LauncherAction[] getMenuItems() {
  //      return (LauncherAction[]) mItems.toArray(new LauncherAction[0]);
    	
    	return new LauncherAction[] {new LauncherAction("Test")};
    	
    }

    /**
     * Is the menu empty?
     *
     * @return The emptiness of the menu.
     */
    public boolean isMenuEmpty() {
  //      return mItems.isEmpty();
    	return false;
    	
    }

    /**
     * Empty the menu.
     */
    public void clearMenu() {
  //      mItems.clear();
    }

    /**
     * Gets the dialog generated by {@link com.yifanlu.Kindle.LauncherMenu#initMenu()} and calls it if the dialog
     * has not been generated yet.
     *
     * @return A dialog containing the menu items.
     * @see com.yifanlu.Kindle.LauncherMenu#initMenu()
     */
  
    /*
    
    public MenuDialog getMenu() {
   //     if (mDialog == null) {
            this.initMenu();
        }
        return mDialog;
    }


*/
    /**
     * Sets the parent menu so an option to go to the previous menu is added.
     *
     * @param parent The menu to go back to.
     */
    public void setParent(LauncherMenu parent) {
        this.mParent = parent;
    }

    /**
     * Gets the parent menu.
     *
     * @return The parent menu
     * @see LauncherMenu#setParent(LauncherMenu)
     */
    public LauncherMenu getParent() {
        return this.mParent;
    }
}
