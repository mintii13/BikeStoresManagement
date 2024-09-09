
package ClassData;


public class Category{
    private String id;
    private String name;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter and Setter methods
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

    // toString method for displaying Category information
    @Override
    public String toString() {
        return "Category (id=" + id + ", name=" + name + ")";
    }
    
    public String printValue(){
        return id + ", " + name;
    }
}

