package Project;
public class PaymentRecord {
    public int id;
    public String name;
    public String contact;
    public int carId;
    public String dueDate;
    public double dueAmount;
    
    public PaymentRecord(int id, String name, String contact, int carId, String dueDate, double dueAmount) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.carId = carId;
        this.dueDate = dueDate;
        this.dueAmount = dueAmount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public int getCarId() {
        return carId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public double getDueAmount() {
        return dueAmount;
    }
}
