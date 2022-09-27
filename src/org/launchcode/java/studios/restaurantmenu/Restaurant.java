package org.launchcode.java.studios.restaurantmenu;

public class Restaurant {

    public static void main(String []args) {
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Burger", 14.5f, "Half pound burger", MenuItemCategoryEnum.MAIN_COURSE));
        menu.addMenuItem(new MenuItem("Wings", 12.99f, "Dozen fried chicken wings", MenuItemCategoryEnum.APPETIZER));
        menu.addMenuItem(new MenuItem("Fries", 3.99f, "French fries", MenuItemCategoryEnum.APPETIZER));

        System.out.println(menu);
        System.out.println(menu.getItemByShortName("Burger"));

        menu.removeItem("Wings");
        System.out.println(menu);
    }
}
