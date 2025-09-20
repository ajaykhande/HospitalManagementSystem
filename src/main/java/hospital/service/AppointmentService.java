package hospital.service;

import hospital.dao.AppointmentDAO;
import hospital.dao.DoctorDAO;
import hospital.dao.PatientDAO;
import hospital.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public class AppointmentService {
    private final PatientDAO patientDAO;
    private final DoctorDAO doctorDAO;
    private final AppointmentDAO appointmentDAO;


public AppointmentService(PatientDAO patientDAO,DoctorDAO doctorDAO,AppointmentDAO appointmentDAO){
    this.patientDAO = patientDAO;
    this.doctorDAO = doctorDAO;
    this.appointmentDAO = appointmentDAO;
}

public boolean addAppointment(int patientId, int doctorId, LocalDate appointmentDate){

    if(!patientDAO.existsById(patientId)){
        System.out.println("Invalid Patient ID!");
        return false;
    }
    if(!doctorDAO.existsById(doctorId)){
        System.out.println("Invalid Doctor ID!");
        return false;
    }
    if(appointmentDate == null || appointmentDate.isBefore(LocalDate.now())){
        System.out.println("Invalid appointment date! Must be today or future.");
        return false;
    }
    Appointment appointment = new Appointment(
            patientId,doctorId,appointmentDate
    );
    return appointmentDAO.addAppointment(appointment);
}

public boolean cancelAppointment(int id){
    if(!appointmentDAO.existsById(id)){
        System.out.println("Invalid appointment ID!");
        return false;
    }
    return appointmentDAO.cancelAppointment(id);
}

public List<Appointment> getAllAppointments(){
    return appointmentDAO.getAllAppointments();
}

public boolean existsById(int id){
    return appointmentDAO.existsById(id);
}
}
