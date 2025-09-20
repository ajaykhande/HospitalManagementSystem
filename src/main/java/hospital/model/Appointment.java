package hospital.model;

import java.time.LocalDate;

// Appointment entity class
public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private LocalDate appointmentDate;

    // constructor without id (new appointment before insert)
    public Appointment(int patientId, int doctorId, LocalDate appointmentDate ){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    // constructor with id (existing appointment from DB)
    public Appointment(int id,int patientId, int doctorId, LocalDate appointmentDate ){
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    // Getters
    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public LocalDate getAppointmentDate() { return appointmentDate; }

    // toString for easy printing
    @Override
    public String toString() {
        return String.format("Appointment [ID=%d, PatientID=%s, DoctorID=%s, Date=%s]",
                id,patientId,doctorId,appointmentDate);
    }
}
