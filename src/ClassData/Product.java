package ClassData;


public class Product {
//    private static int idCounter = 1;
    private String id;
    private String name;
    private String brandId;
    private String categoryID;
    private int modelYear;
    private int price;
    
//    Cach trien khai UID cu~
//    public String generateUniqueId(){
//        return "P" + (idCounter++);
//    }
//    public Product(String name, String brandId, String categoryID, int modelYear, int price) {
//        this.id = generateUniqueId();
//        this.name = name;
//        this.brandId = brandId;
//        this.categoryID = categoryID;
//        this.modelYear = modelYear;
//        this.price = price;
//    }

    public Product(String id, String name, String brandId, String categoryID, int modelYear, int price) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
        this.categoryID = categoryID;
        this.modelYear = modelYear;
        this.price = price;
    }
    

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "(id=" + id + ", name=" + name + ", brandId=" + brandId + ", categoryID=" + categoryID + ", modelYear=" + modelYear + ", price=" + price + ")";
    }
    
    public String printValue() {
        return id + ", " + name + ", " + brandId + ", " + categoryID + ", " + modelYear + ", " + price;
    }
    
    
    
    
}
