🏥 Hospital Management System

A simple Hospital Management System built using Core Java, JDBC, and MySQL.
This project demonstrates how to manage patients, doctors, and appointments with a database backend.

---

## 🚀 Features

- Add new patients  
- Add new doctors  
- Book appointments (with date validation)  
- View all patients, doctors, and appointments  
- Cancel appointments  
- Input validation (age, gender, date format)

---

## 🗂 Project Structure

```

HospitalManagementSystem/        ← root folder
│
├── README.md
├── src/
│   ├── hospital/app/Main.java
│   ├── hospital/model/Patient.java
│   ├── hospital/model/Doctor.java
│   ├── hospital/model/Appointment.java
│   ├── hospital/dao/PatientDAO.java
│   ├── hospital/dao/DoctorDAO.java
│   ├── hospital/dao/AppointmentDAO.java
│   ├── hospital/service/PatientService.java
│   ├── hospital/service/DoctorService.java
│   ├── hospital/service/AppointmentService.java
│   └── hospital/util/DatabaseConnection.java
│       └── hospital/util/InputUtil.java

````

---

## 🗄 Database Setup (MySQL)

Create a database named **hospital** and tables:

```sql
CREATE DATABASE hospital;
USE hospital;

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    problem VARCHAR(255)
);

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
````

---

## ⚙️ Configuration

Update database credentials in `DatabaseConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/hospital";
private static final String USER = "root";          // your MySQL username
private static final String PASSWORD = "your_password_here"; // your MySQL password
```

---

## 🏃 How to Run the Project

### 1️⃣ Compile

Open terminal in project folder and run:

```bash
javac -d bin src/hospital/**/*.java
```

### 2️⃣ Run

Run the main class:

```bash
java -cp bin hospital.app.Main
```

* You will see the menu:

```
=== Hospital Management System ===
1. Add Patient
2. Book Appointment
3. View All Patients
4. View All Doctors
5. View Appointments
6. Cancel Appointment
7. Add Doctor
0. Exit
```

* Enter the number corresponding to your choice and press **Enter**.

---

## 📌 Future Improvements

* Add update/delete functionality for patients and doctors
* Reschedule appointments
* Add login system (Admin / User roles)
* Upgrade to Spring Boot + REST API backend

---

## 👨‍💻 Author

* **Ajay Khande**
* GitHub: [ajaykhande](https://github.com/ajaykhande)
* 
