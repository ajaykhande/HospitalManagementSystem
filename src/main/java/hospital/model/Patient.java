package hospital.model;

// Patient entity class
public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String problem;

    // Constructor [without id - for new patients before saving in DB]
    public Patient(String name,int age,String gender,String problem){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.problem = problem;
    }

    // Constructor [with id - for existing patients from DB]
    public Patient(int id,String name,int age,String gender,String problem){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.problem = problem;
    }

    //Gatters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getProblem() { return problem; }

    // toString for easy printing
    @Override
    public String toString() {
        return String.format("Patient [ID=%d, Name=%s, Age=%d, Gender=%s, Problem=%s]",
                id,name,age,gender,problem);
    }

}
