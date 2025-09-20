package hospital.model;

// Doctor entity class
public class Doctor {
    private int id;
    private String name;
    private String specialization;


    // Constructor without id (new doctor before insert)
    public Doctor(String name, String specialization){
        this.name = name;
        this.specialization = specialization;
    }

    // Constructor with id (existing doctor from DB)
    public Doctor(int id,String name,String specialization){
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Gatters
    public int getId() { return id; }
    public  String getName() { return name; }
    public String getSpecialization() { return specialization;}

    // toString for readable output
    @Override
    public String toString(){
        return String.format("Doctor [ID=%d, Name=%s, Specialization=%s]",
                id,name,specialization);
    }

}
