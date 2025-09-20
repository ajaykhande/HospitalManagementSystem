package hospital.app;
import hospital.dao.AppointmentDAO;
import hospital.dao.DoctorDAO;
import hospital.dao.PatientDAO;
import hospital.model.Appointment;
import hospital.model.Doctor;
import hospital.model.Patient;
import hospital.service.AppointmentService;
import hospital.service.DoctorService;
import hospital.service.PatientService;
import hospital.util.InputUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        PatientService patientService = new PatientService(patientDAO);
        DoctorService doctorService = new DoctorService(doctorDAO);
        AppointmentService appointmentService = new AppointmentService(patientDAO,doctorDAO,appointmentDAO);


        boolean running = true;

        while (running){
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Book Appointment");
            System.out.println("3. View All Patients");
            System.out.println("4. View All Doctors");
            System.out.println("5. View Appointments");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Add Doctor: ");
            System.out.println("0. Exit");

            int choice = InputUtil.readInt("Enter your choice");

            switch (choice){
                case 1 -> {
                    String name = InputUtil.readString("Enter patient name: ");
                    int age = InputUtil.readInt("Enter patient age: ");
                    String gender = InputUtil.readString("Enter gender (Male/Female/Other): ");
                    String problem = InputUtil.readString("Please describe your problem: ");
                    System.out.println();
                    boolean added = patientService.addPatient(name,age,gender,problem);
                    if (added){
                        System.out.println("Patient "+name+" successfully added.");
                    }else {
                        System.out.println("Failed!!! to add patient.");
                    }
                }
                case 2 -> {
                   // System.out.println("If you have not patient ID please register first enter 1: ");
                    int known = InputUtil.readInt("Enter 1 if you have a patient ID, otherwise Enter 2: ");
                    if (known==2){
                        String name = InputUtil.readString("Enter patient name: ");
                        int age = InputUtil.readInt("Enter patient age: ");
                        String gender = InputUtil.readString("Enter gender (Male/Female/Other): ");
                        String problem = InputUtil.readString("Please describe your problem: ");
                        System.out.println();
                        boolean added = patientService.addPatient(name,age,gender,problem);
                        if (added){
                            System.out.println("Patient "+name+" successfully added.");
                        }else {
                            System.out.println("Failed!!! to add patient.");
                        }

                    } else if (known==1){
                    int patientId = InputUtil.readInt("Enter patient ID: ");
                   // String ask = InputUtil.readString("");
                    int doctorID = InputUtil.readInt("Enter doctor ID: ");
                    String appointmentDate = InputUtil.readDate("Enter appointment date: ");
                    System.out.println();
                    boolean booked = appointmentService.addAppointment(patientId,doctorID, LocalDate.parse(appointmentDate));
                    if(booked){
                        System.out.println("Appointment successfully booked!");
                    } else{
                        System.out.println("Failed!!! to book appointment.");
                    }
                    }
                }
                case 3 ->{
                    System.out.println("--- Patient List ---");
                    patientService.getAllPatients().forEach(System.out::println);
                }

                case 4 ->{
                    System.out.println("--- Doctors List ---");
                    for (Doctor dl :  doctorService.getAllDoctors()){
                        System.out.println(dl);
                    }
                }
                case 5 ->{
                    System.out.println("--- Appointments List ---");
                    for (Appointment al :  appointmentService.getAllAppointments()){
                        System.out.println(al);
                    }
                }
                case 6 -> {
                    int appointmentId = InputUtil.readInt("Enter appointment ID to cancel appointment: ");
                    System.out.println();
                    boolean cancel = appointmentService.cancelAppointment(appointmentId);
                    if (cancel){
                        System.out.println("Appointment has canceled!!");
                    }else {
                        System.out.println("Invalid appointment ID "+appointmentId);
                    }
                }
                case 7 -> {
                    String name = InputUtil.readString("Enter doctor name: ");
                    String specialization = InputUtil.readString("Enter specialization: ");
                    boolean added = doctorService.addDoctor(name, specialization);
                    if (added) {
                        System.out.println("Doctor " + name + " successfully added.");
                    } else {
                        System.out.println("Failed!!! to add doctor.");
                    }
                }

                case 0 -> {
                    running = false;
                    System.out.println("Exiting... Goodbye!");

                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
}
