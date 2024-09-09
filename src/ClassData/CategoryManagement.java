package ClassData;

import MyTools.FileTools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryManagement {

    static List<Category> categoryList = new ArrayList<>();

    public void addCategory(Category b) {
        categoryList.add(b);
    }

    public static boolean existCategoryId(String categoryId) {
        for (Category c : categoryList) {
            if (c.getId().equals(categoryId)) {
                return true;
            }
        }
        return false;
    }

//    public void loadCategoryFromFileOld(String fileName) {
//        List<Object> objects = FileTools.readObjectFromFile(fileName);
//        if (objects != null) {
//            for (Object obj : objects) {
//                if (obj instanceof Category) {
//                    categoryList.add((Category) obj); // Chỉ thêm nếu đối tượng là Category
//                } else {
//                    System.out.println("Skipped non-Category object: " + obj);
//                }
//            }
//        }
//    }
    
    public void loadCategoryFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            categoryList.removeAll(categoryList);
            while ((line = reader.readLine()) != null) {
                String str[] = line.split("\\s*,\\s*");
                if (str.length == 2) {
                    String id = str[0];
                    String name = str[1];
                    Category c = new Category(id, name);
                    categoryList.add(c);
                } else {
                    System.out.println("Invalid date format in line: " + line);
                }
            }   System.out.println("Load successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void loadCategoryToFileOld(String fileName) {
//        FileTools.writeObjectToFile(fileName, categoryList);
//    }
    
    public void loadCategoryToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Category c : categoryList) {
                writer.write(c.printValue());
                writer.newLine();
            }
            System.out.println("Save successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
