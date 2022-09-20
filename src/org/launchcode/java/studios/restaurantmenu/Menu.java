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

    public boolean addItem(MenuItem item) {
        if(getItemByShortName(item.getShortName()) != null) return false;
        items.add(item);return true;
    }

    public MenuItem removeItem(String shortName) {
        MenuItem item = getItemByShortName(shortName);
        if(item != null)items.remove(item);
        return item;
    }

    public MenuItem getItemByShortName(String shortName) {
        return items.stream()
                .filter(listItem -> shortName.equals(listItem.getShortName()))
                .findAny()
                .orElse(null);
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
