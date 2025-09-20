package hospital.service;

import hospital.dao.DoctorDAO;
import hospital.model.Doctor;

import javax.print.Doc;
import java.util.List;

public class DoctorService {
    private final DoctorDAO doctorDAO;

    public DoctorService(DoctorDAO doctorDAO){
        this.doctorDAO = doctorDAO;
    }

    public boolean addDoctor(String name, String specialization){
        if(name == null || name.trim().isEmpty()){
            System.out.println("Doctor name cannot be empty!");
            return false;
        }
        if(specialization == null || specialization.trim().isEmpty()){
            System.out.println("specialization cannot be empty!");
            return false;
        }
        Doctor doctor = new Doctor(name.trim(),specialization.trim());
        return doctorDAO.addDoctor(doctor);
    }

    public List<Doctor> getAllDoctors(){
        return doctorDAO.getAllDoctors();
    }

    public boolean existsById(int id){
        return doctorDAO.existsById(id);
    }

}
