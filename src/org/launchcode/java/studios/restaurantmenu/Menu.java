package org.launchcode.java.studios.restaurantmenu;

import java.util.ArrayList;
import java.util.Date;

public class Menu {
    private ArrayList<MenuItem> items;
    private Date lastModifiedDate;
    private int version;

    public Menu() {
        this(new Date(), 1);
    }

    public Menu(Date lastModifiedDate, int version) {
        this.lastModifiedDate = lastModifiedDate;
        this.version = version;
        items = new ArrayList<>();
    }

    /**
     *  Adds new menu item to the menu if it doesn't exist in it already
     *
     * @param item      new menu item to be added
     * @return boolean  True if added | False if failed
     */
    public boolean addMenuItem(MenuItem item) {
        if(items.contains(item)) return false;
        item.setNewItem(true);  // set item as new
        this.items.add(item);   // add item
        this.setLastModifiedDate(); // set last modified date to current
        return true;
    }

    /**
     *  Remove menu item given the shortname
     *
     * @param shortName     shortName given to the menu item
     * @return  MenuItem    Item that has been removed or null if it wasn't found
     */
    public MenuItem removeItem(String shortName) {
        MenuItem item = getItemByShortName(shortName);
        if(item != null) items.remove(item);
        return item;
    }

    /**
     *  Search MenuItem by the shortname
     *
     * @param shortName     shortName given to the menu item
     * @return  MenuItem    Item found or null if it wasn't found
     */
    public MenuItem getItemByShortName(String shortName) {
        return items.stream()
                .filter(listItem -> shortName.toLowerCase().equals(listItem.getShortName().toLowerCase()))
                .findAny()
                .orElse(null);
    }

    /**
     *  Sets a date to check new item flag on menu items in the menu
     *
     * @param thresholdDate  Any item set after and on this date will be flag as new
     */
    public void setNewItemFlagToDate(Date thresholdDate) {
        for(MenuItem item: this.items) {
            item.setNewItem(!item.getCreationDate().before(thresholdDate));
        }
    }

    // when no date is provided we use the lastModifiedDate
    public void setNewItemFlagToDate() {
        setNewItemFlagToDate(lastModifiedDate);
    }

    public void setLastModifiedDate() {
        setLastModifiedDate(new Date()); // current date
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        increaseVersion();
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    private void increaseVersion() {
        version++;
    }

    @Override
    public String toString() {
        String response = "";
        response += "Menu modified on: " + lastModifiedDate + "\n";
        response += "Version:          " + version + "\n";
        response += "[Menu Items] \n";
        for(MenuItem item: items) {
            response += item.toString();
            response += "---------------------------------\n";
        }
        return response;
    }
}
