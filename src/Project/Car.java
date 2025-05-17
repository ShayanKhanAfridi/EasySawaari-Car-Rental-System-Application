package Project;

public class Car {
    public int ID;
    public String make;
    public String model;
    public int year;
    public String colour;
    public double price;
    public String availability;

    // Constructor
    public Car(int ID, String make, String model, int year, String colour, double price, String availability) {
        this.ID = ID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.colour = colour;
        this.price = price;
        this.availability = availability;
    }
    
    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = ID;
    }
    
    // Getter and Setter methods for Make
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    // Getter and Setter methods for Model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and Setter methods for Year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Getter and Setter methods for Colour
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    // Getter and Setter methods for Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter methods for Availability
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
