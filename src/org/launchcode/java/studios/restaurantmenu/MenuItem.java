package org.launchcode.java.studios.restaurantmenu;

import java.util.Date;
import java.util.Objects;

public class MenuItem {
    private String shortName;
    private Date creationDate;
    private float price;
    private String description;
    private MenuItemCategoryEnum category;
    private boolean newItem;

    public MenuItem(String shortName, Date creationDate
            , float price, String description, MenuItemCategoryEnum category, boolean newItem) {
        this.shortName = shortName;
        this.creationDate = creationDate;
        this.price = price;
        this.description = description;
        this.category = category;
        this.newItem = newItem;
    }

    public MenuItem(String shortName, float price, String description, MenuItemCategoryEnum category, boolean newItem) {
        this(shortName, new Date(), price, description, category, newItem);
    }

    public MenuItem(String shortName, float price, String description, MenuItemCategoryEnum category) {
        this(shortName, new Date(), price, description, category, true);
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MenuItemCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(MenuItemCategoryEnum category) {
        this.category = category;
    }

    public boolean isNewItem() {
        return newItem;
    }

    public void setNewItem(boolean newItem) {
        this.newItem = newItem;
    }

    @Override
    public String toString() {
        return  "Shortname:     " + shortName + "\n" +
                "Creation date: " + creationDate + "\n" +
                "Price:         " + price + "\n" +
                "Description:   " + description + "\n" +
                "Category:      " + category.getValue() + "\n" +
                "Is a new item: " + newItem + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortName, price, description);
    }
}
