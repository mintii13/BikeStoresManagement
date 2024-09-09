package MyTools;

import ClassData.ProductManagement;

public class Menu {

    private ProductManagement pm = new ProductManagement();

    public void showMenu() {
        System.out.println("========== PRODUCT MANAGEMENT SYSTEM ==========");
        System.out.println("1. Create a Product");
        System.out.println("2. Search Products by name");
        System.out.println("3. Update Product information");
        System.out.println("4. Delete a Product by ID ");
        System.out.println("5. Save Product List to file");
        System.out.println("6. Load all Products from file");
        System.out.println("7. Display all Products");
        System.out.println("0. Exit");
        System.out.println("Please choose an option: ");
    }
    
    public void askToBack(){
        System.out.println("You wanna back to menu? ");
        if (Inputter.inputBoolean()){
            menuLoop();
        } else 
            System.out.println("Exit successfully!");
    }

    public void menuLoop() {

        int choice;
        showMenu();
        choice = Inputter.inputInt();
        switch (choice) {
            case 1:
                System.out.println("1. Create a Product: ");
                pm.addProduct();
                askToBack();
                break;
            case 2:
                System.out.println("2. Search Products by name");
                pm.searchProductByName();
                askToBack();
                break;
            case 3:
                System.out.println("3. Update Product information");
                pm.updateProductInf();
                askToBack();
                break;
            case 4:
                System.out.println("4. Delete a Product by ID ");
                if(pm.deleteProductInf()){
                    System.out.println("Delete successfully!");
                } else 
                    System.out.println("Fail to delete");
                askToBack();
                break;
            case 5:
                System.out.println("5. Save Product List to file");
                pm.writeProductListToFile("Product.txt");
                askToBack();
                break;
            case 6:
                System.out.println("6. Load all Products from file");
                pm.readFromFileToProductList("Product.txt");
                askToBack();
                break;
            case 7:
                System.out.println("7. Display all Products");
                pm.displayList();
                askToBack();
                break;
            case 0:
                System.out.println("Exit successfully!");
                break;
            default:
                System.out.println("Invalid option. Try again!");
                menuLoop();
        }
    }
}
