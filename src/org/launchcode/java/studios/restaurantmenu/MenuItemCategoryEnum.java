package org.launchcode.java.studios.restaurantmenu;

public enum MenuItemCategoryEnum {
    APPETIZER("Appetizer"),
    MAIN_COURSE("Main course"),
    DESSERT("Dessert");

    private String category;

    MenuItemCategoryEnum(String category) {
        this.category = category;
    }

    public String getValue() {
        return category;
    }
}
