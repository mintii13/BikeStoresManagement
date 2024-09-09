package ClassData;

import MyTools.Menu;


public class MainManagement {

    public static void main(String[] args) {
        BrandManagement brM = new BrandManagement();
        brM.loadBrandFromFile("Brand.txt");

        CategoryManagement caM = new CategoryManagement();
        caM.loadCategoryFromFile("Category.txt");
        
        Menu menu = new Menu();
        menu.menuLoop();
    }

}
