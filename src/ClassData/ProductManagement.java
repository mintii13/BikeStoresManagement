package ClassData;

import static ClassData.BrandManagement.brandList;
import static ClassData.CategoryManagement.categoryList;
import MyTools.Inputter;
import static MyTools.Inputter.sc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManagement extends ArrayList<Product> {

//    Function1: ADD A PRODUCT
    public boolean checkUniqueId(String id) {
        for (Product p : this) {
            if (p.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public void addProduct() {
        System.out.println("Input ID (MUST be unique): ");
        String id = Inputter.inputNonEmptyString().trim();
        while (checkUniqueId(id) != true) {
            System.out.println(id + " is used, ID MUST be unique, try again! ");
            id = Inputter.inputNonEmptyString();
        }
        System.out.println("Input Name:");
        String name = Inputter.inputNonEmptyString().trim();

        System.out.println("Here is Brand List: ");
        for (Brand b : brandList) {
            System.out.println(b.printValue());
        }
        System.out.println("Input Brand id (in Brand.txt):");
        String brandId = Inputter.inputNonEmptyString().trim();
        while (!BrandManagement.existBrandId(brandId)) {
            System.out.println("Must be in Brand.txt, try again! ");
            brandId = Inputter.inputNonEmptyString();
        }
        
        System.out.println("Here is Category List: ");
        for (Category c : categoryList) {
            System.out.println(c.printValue());
        }
        System.out.println("Input Category id:");
        String categoryId = Inputter.inputNonEmptyString().trim();
        while (!CategoryManagement.existCategoryId(categoryId)) {
            System.out.println("Must be in Category.txt, try again! ");
            categoryId = Inputter.inputNonEmptyString();
        }

        System.out.println("Input Model year from 2005 to 2024:");
        int modelYear = Inputter.inputIntRange(2005, 2024);

        System.out.println("Input Price:");
        int price = Inputter.inputIntMin(0);

        Product newProduct = new Product(id, name, brandId, categoryId, modelYear, price);
        this.add(newProduct);
    }

//    Function2: SEARCH BY NAME
    public void searchProductByName() {
        System.out.println("Input Product Name wanna search");
        String name = Inputter.inputNonEmptyString();
        List<Product> result = new ArrayList<>();
        for (Product p : this) {
            if (p.getName().contains(name)) {
                result.add(p);
            }
        }
        if (result.size() == 0) {
            System.out.println("Have no any product");
        } else {
            result.sort(Comparator.comparingInt(Product::getModelYear));
            for (Product product : result) {
                System.out.println(product.toString());
            }
        }
    }

//    Function 3: UPDATE BY ID
    public void updateProductInf() {
        System.out.println("Input Product ID wanna update");
        String id = Inputter.inputNonEmptyString();
        for (Product p : this) {
            if (p.getId().equalsIgnoreCase(id)) {
                if (Inputter.readBoolean("You want to update Name?")) {
                    System.out.println("Input new Name");
                    String temp = Inputter.inputString();
                    if (!temp.isEmpty()) {
                        if (p.getName().equals(temp)) {
                            System.out.println("Name still be " + temp);
                        } else {
                            p.setName(temp);
                            System.out.println("Updated");
                        }
                    } else if (temp.isEmpty()) {
                        System.out.println("Empty infomation...Fail to update");
                    }

                }

                if (Inputter.readBoolean("You want to update Brand id?")) {
                    System.out.println("Input new Brand id(in Brand.txt):");
                    String brandId = Inputter.inputString();
                    while (!BrandManagement.existBrandId(brandId)) {
                        if (brandId.isEmpty()) {
                            break;
                        }
                        System.out.println("Input new Brand id(MUST BE in Brand.txt):");
                        brandId = Inputter.inputString();
                    }
                    if (!brandId.isEmpty()) {
                        if (p.getBrandId().equals(brandId)) {
                            System.out.println("Brand ID still be " + brandId);
                        } else {
                            p.setBrandId(brandId);
                            System.out.println("Updated");
                        }
                    } else if (brandId.isEmpty()) {
                        System.out.println("Empty infomation...Fail to update");
                    }
                }

                if (Inputter.readBoolean("You want to update Category id?")) {
                    System.out.println("Input new Category id(in Category.txt):");
                    String categoryId = Inputter.inputString();
                    while (!CategoryManagement.existCategoryId(categoryId)) {
                        if (categoryId.isEmpty()) {
                            break;
                        }
                        System.out.println("Input new Category id(MUST BE in Category.txt):");
                        categoryId = Inputter.inputString();
                    }
                    if (!categoryId.isEmpty()) {
                        if (p.getCategoryID().equals(categoryId)) {
                            System.out.println("Category ID still be " + categoryId);
                        } else {
                            p.setBrandId(categoryId);
                            System.out.println("Updated");
                        }
                    } else if (categoryId.isEmpty()) {
                        System.out.println("Empty infomation...Fail to update");
                    }
                }

                if (Inputter.readBoolean("You want to update Model Year?")) {
                    System.out.println("Input new Model Year");
                    String temp = sc.nextLine();
                    if (!temp.isEmpty()) {
                        try {
                            int newModelYear = Integer.parseInt(temp);
                            if (p.getModelYear() == (newModelYear)) {
                                System.out.println("Model Year still be " + temp);
                            } else {
                                p.setName(temp);
                                System.out.println("Updated");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid model year, try again");
                            temp = sc.nextLine();
                        }
                    } else if (temp.isEmpty()) {
                        System.out.println("Empty infomation...Fail to update");
                    }
                }

                if (Inputter.readBoolean("You want to update Price?")) {
                    System.out.println("Input new Price");
                    String temp = sc.nextLine();
                    if (!temp.isEmpty()) {
                        try {
                            int newPrice = Integer.parseInt(temp);
                            if (p.getPrice() == (newPrice)) {
                                System.out.println("Price still be " + temp);
                            } else {
                                p.setName(temp);
                                System.out.println("Updated");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price, try again");
                            temp = sc.nextLine();
                        }
                    } else if (temp.isEmpty()) {
                        System.out.println("Empty infomation...Fail to update");
                    }
                }
            }
        }
    }

//    Function 4: DELETE BY ID
    public boolean deleteProductInf() {
        System.out.println("Input Product ID wanna delete");
        String id = Inputter.inputNonEmptyString();
        for (Product p : this) {
            if (p.getId().equalsIgnoreCase(id)) {
                this.remove(p);
                return true;
            }
        }
        System.out.println("Product does not exist");
        return false;
    }

//    Function 5: SAVE TO FILE 
    public void writeProductListToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product p : this) {
                writer.write(p.printValue());
                writer.newLine();
            }
            System.out.println("Save successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Function 6:READ FILE & PRINT ALL
    public void readFromFileToProductList(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            this.removeAll(this);
            while ((line = reader.readLine()) != null) {
                String str[] = line.split("\\s*,\\s*");
                if (str.length == 6) {
                    String id = str[0];
                    String name = str[1];
                    String brandId = str[2];
                    String cateId = str[3];
                    int modelY = Integer.parseInt(str[4]);
                    int price = Integer.parseInt(str[5]);
                    if (checkUniqueId(id)) {
                        Product p = new Product(id, name, brandId, cateId, modelY, price);
                        this.add(p);
                    } else {
                        System.out.println(id + " is not unique, check file Product.txt line: " + line);
                    }
                } else {
                    System.out.println("Invalid date format in line: " + line);
                }
            }
            System.out.println("Load successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayList() {
        this.sort(Comparator.comparingInt(Product::getPrice).reversed()
                .thenComparing(Product::getName));
        for (Product p : this) {
            System.out.println(p.printValue());
        }
        if (this.isEmpty()) {
            System.out.println("The List is empty!");
        }
    }

}
