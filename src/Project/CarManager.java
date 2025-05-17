package Project;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CarManager {
    public ArrayList<Car> cars = new ArrayList<>();
    private final String DB_URL = "jdbc:mysql://localhost:3306/car_rental";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    // Fetch cars from the database
    public void fetchCarsFromDatabase() {
        cars.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String query = "SELECT * FROM cars";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Car car = new Car(
                    rs.getInt("id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getInt("year"),
                    rs.getString("colour"),
                    rs.getDouble("price"),
                    rs.getString("availability")
                );
                cars.add(car);
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching cars: " + e.getMessage());
        }
    }

    // Add a new car
    public void addCar(String make, String model, int year, String colour, double price, String availability) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String query = "INSERT INTO cars (make, model, year, colour, price, availability) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, make);
            ps.setString(2, model);
            ps.setInt(3, year);
            ps.setString(4, colour);
            ps.setDouble(5, price);
            ps.setString(6, availability);

            ps.executeUpdate();
            ps.close();
            con.close();

            fetchCarsFromDatabase(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding car: " + e.getMessage());
        }
    }

    // Edit a car's details
    public void editCar(int id, String make, String model, int year, String colour, double price, String availability) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String query = "UPDATE cars SET make = ?, model = ?, year = ?, colour = ?, price = ?, availability = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, make);
            ps.setString(2, model);
            ps.setInt(3, year);
            ps.setString(4, colour);
            ps.setDouble(5, price);
            ps.setString(6, availability);
            ps.setInt(7, id);

            ps.executeUpdate();
            ps.close();
            con.close();

            fetchCarsFromDatabase(); // Refresh local list
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error editing car: " + e.getMessage());
        }
    }

    // Delete a car by ID
    public void deleteCar(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String query = "DELETE FROM cars WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
            con.close();

            fetchCarsFromDatabase(); // Refresh local list
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error deleting car: " + e.getMessage());
        }
    }

    // Get the list of cars
    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars); // Return a copy to prevent external modification
    }

    // Sort cars by price (ascending order)
    // Sort cars by price (ascending order)
    public void sortCarsByPrice() {
        cars.sort((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice()));
    }

    // Search for a car by make
    public ArrayList<Car> searchCarByModel(String model) {
    ArrayList<Car> result = new ArrayList<>();
    for (Car car : cars) {
        if (car.getModel().equalsIgnoreCase(model)) {
            result.add(car);  // Add cars that match the model
        }
    }
    return result;  // Return the list of matching cars
}
}
