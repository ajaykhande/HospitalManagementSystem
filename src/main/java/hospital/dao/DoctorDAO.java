package hospital.dao;

import hospital.model.Doctor;
import hospital.util.DatabaseConnection;

import javax.lang.model.element.NestingKind;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    // Add a new doctor
    public boolean addDoctor(Doctor doctor){
        String query = "INSERT INTO doctors(name,specialization) VALUES(?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, doctor.getName());
            stmt.setString(2,doctor.getSpecialization());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    // Get all doctors
    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctors";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                Doctor doctor = new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization")
                );
                doctors.add(doctor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return doctors;
    }

    // check if doctor exists by ID
    public boolean existsById(int id){
        boolean exist = false;
        String query = "SELECT 1 FROM doctors WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1,id);

            try(ResultSet rs = stmt.executeQuery()){
                exist = rs.next();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return exist;
    }

}
