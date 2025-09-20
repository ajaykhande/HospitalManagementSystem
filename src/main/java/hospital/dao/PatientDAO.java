package hospital.dao;

import hospital.model.Patient;
import hospital.util.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // Add a new patient to database
    public  boolean addPatient(Patient patient){
        String query = "INSERT INTO patients(name, age, gender,problem) VALUES(?,?,?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, patient.getName());
            stmt.setInt(2,patient.getAge());
            stmt.setString(3,patient.getGender());
            stmt.setString(4, patient.getProblem());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Get all patients from database
    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("problem")
                );
                patients.add(patient);
            }

            } catch(SQLException e){
            e.printStackTrace();
        }

        return patients;
    }

    public boolean existsById(int id){
        String query = "SELECT * FROM patients WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1,id);

            try(ResultSet rs = stmt.executeQuery()){
            return rs.next();
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

}
