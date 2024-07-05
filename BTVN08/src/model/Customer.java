package model;

public class Customer extends Person {
    private String country;

    public Customer(String name, String age, String sex, String country) {
        super(name, age, sex);
        this.country = country;
    }

    @Override
    public String language(String country) {
       switch (country) {
        case "vn":
            return "Việt Nôm";
        case "jp":
            return "Nhật Bẻn";
        case "usa":
            return "Mẽo";
        default:
        throw new AssertionError();
       }
    
    }

    @Override
    public String toString() {
        return "Customer [" + super.toString() +  "country=" + language(country) + "]";
    }

    
    
    

}
