
package ClassData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BrandManagement{
    static List<Brand> brandList = new ArrayList<>();
    public void addBrand(Brand b){
        brandList.add(b);
    }
    
    public static boolean existBrandId(String brandId){
        for (Brand b : brandList) {
            if(b.getId().equals(brandId))
                return true;
        }
        return false;
    }
    
//    public void loadBrandFromFileOld(String fileName) {
//        List<Object> objects = FileTools.readObjectFromFile(fileName);
//        if (objects != null) {
//            for (Object obj : objects) {
//                if (obj instanceof Brand) {
//                    brandList.add((Brand) obj); // Chỉ thêm nếu đối tượng là Brand
//                } else {
//                    System.out.println("Skipped non-Brand object: " + obj);
//                }
//            }
//        }
//    }
    
    public void loadBrandFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            brandList.removeAll(brandList);
            while ((line = reader.readLine()) != null) {
                String str[] = line.split("\\s*,\\s*");
                if (str.length == 3) {
                    String id = str[0];
                    String name = str[1];
                    String country = str[2];
                    Brand b = new Brand(id, name, country);
                    brandList.add(b);
                } else {
                    System.out.println("Invalid date format in line: " + line);
                }
            }   System.out.println("Load successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//    public void loadBrandToFileOld(String fileName){
//        FileTools.writeObjectToFile(fileName, brandList);
//    }
    
    public void loadBrandToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Brand b : brandList) {
                writer.write(b.printValue());
                writer.newLine();
            }
            System.out.println("Save successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
