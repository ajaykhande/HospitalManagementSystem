package hospital.service;

import hospital.dao.PatientDAO;
import hospital.model.Patient;

import java.util.List;

public class PatientService {
    private final PatientDAO patientDAO;

    public PatientService(PatientDAO patientDAO){
        this.patientDAO = patientDAO;
    }

    public boolean addPatient(String name, int age, String gender, String problem){
        if(name == null || name.trim().isEmpty()){
            System.out.println("Patient name cannot be empty!");
            return false;
        }
        if(age <= 0 || age > 120){
            System.out.println("Invalid age entered!");
            return false;
        }
        if(!(gender.trim().equalsIgnoreCase("Male")||
            gender.trim().equalsIgnoreCase("Female")||
            gender.trim().equalsIgnoreCase("Other"))){
            System.out.println("Gender must be Male/Female/Other!");
            return false;
        }
        if(problem == null || problem.trim().isEmpty()){
            System.out.println("Patient problem cannot be empty!");
            return false;
        }
        Patient patient = new Patient(name.trim(),age,gender.trim(),problem.trim());
        return patientDAO.addPatient(patient);
    }

    public List<Patient> getAllPatients(){
        return patientDAO.getAllPatients();
    }

    public boolean existsById(int id){
        return patientDAO.existsById(id);
    }

}
