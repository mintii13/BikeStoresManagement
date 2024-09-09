package ClassData;


public class Brand{
    private String id;
    private String name;
    private String country;

    public Brand(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
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
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // toString method for displaying Brand information
    @Override
    public String toString() {
        return "Brand (id=" + id + ", name=" + name + ")";
    }
    
    public String printValue(){
        return id + ", " + name;
    }
}

