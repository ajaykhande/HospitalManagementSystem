package hospital.dao;

import hospital.model.Appointment;
import hospital.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public boolean addAppointment(Appointment appointment){
        String query = "INSERT INTO appointments(patient_id,doctor_id,appointment_date) VALUES(?,?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

                stmt.setInt(1,appointment.getPatientId());
                stmt.setInt(2,appointment.getDoctorId());
                stmt.setDate(3, Date.valueOf(appointment.getAppointmentDate()));

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected>0;

        } catch (SQLException e){
                e.printStackTrace();
        }
           return false;
    }

    //
    public List<Appointment> getAllAppointments(){
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Appointment appointment = new Appointment(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getDate("appointment_date").toLocalDate()
                );
                appointments.add(appointment);
            }
        } catch(SQLException e){
                e.printStackTrace();
            }
            return appointments;
        }

        public boolean existsById(int id){
            boolean exist = false;
            String query = "SELECT 1 FROM appointments WHERE id = ?";

            try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)){

                stmt.setInt(1,id);

                try(ResultSet rs = stmt.executeQuery()) {
                    exist = rs.next();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
            return exist;
        }

        public boolean cancelAppointment(int appointmentId){
            String query = "DELETE FROM appointments WHERE id = ?";

            try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)){

                stmt.setInt(1,appointmentId);

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;

            } catch (SQLException e){
                e.printStackTrace();
            }
            return false;
        }
    }


