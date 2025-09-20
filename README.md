

# 🏥 Hospital Management System

A simple **Hospital Management System** built using **Core Java**, **JDBC**, and **MySQL**.
This project demonstrates how to manage patients, doctors, and appointments with a database backend.

---

## 🚀 Features

* Add new patients
* View all patients
* View all doctors
* Book an appointment with a doctor
* Store and retrieve data from **MySQL database**

---

## 🗂️ Project Structure

```
HospitalManagementSystem/
│
├── HospitalManagementSystem.java   # Main entry point
├── Patient.java                    # Patient model
├── Doctor.java                     # Doctor model
├── README.md                       # Project documentation
```

---

## 🛠️ Tech Stack

* **Java (Core + OOPs)**
* **JDBC** (Java Database Connectivity)
* **MySQL**

---

## 🗄️ Database Schema

### Table: `patients`

| Column      | Type     |
| ----------- | -------- |
| patient\_id | INT (PK) |
| name        | VARCHAR  |
| age         | INT      |
| gender      | VARCHAR  |

### Table: `doctors`

| Column         | Type     |
| -------------- | -------- |
| doctor\_id     | INT (PK) |
| name           | VARCHAR  |
| specialization | VARCHAR  |

### Table: `appointments`

| Column            | Type     |
| ----------------- | -------- |
| appointment\_id   | INT (PK) |
| patient\_id       | INT (FK) |
| doctor\_id        | INT (FK) |
| appointment\_date | DATE     |

---

## ⚙️ Setup Instructions

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/hospital-management-system.git
   cd hospital-management-system
   ```

2. **Setup MySQL database**

   ```sql
   CREATE DATABASE hospital_db;
   USE hospital_db;

   CREATE TABLE patients (
       patient_id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       age INT,
       gender VARCHAR(10)
       problem VARCHAR(100)
   );

   CREATE TABLE doctors (
       doctor_id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       specialization VARCHAR(100)
   );

   CREATE TABLE appointments (
       appointment_id INT PRIMARY KEY AUTO_INCREMENT,
       patient_id INT,
       doctor_id INT,
       appointment_date DATE,
       FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
       FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
   );
   ```

3. **Update Database Credentials in Java Code**

   ```java
   String url = "jdbc:mysql://localhost:3306/hospital_db";
   String username = "root";   // your MySQL username
   String password = "1234";   // your MySQL password
   ```

4. **Compile & Run**

   ```bash
   javac HospitalManagementSystem.java
   java HospitalManagementSystem
   ```

---

## 📌 Future Improvements

* Add login system (Admin/Doctor/Patient)
* Add search and update functionality
* Upgrade project with **Spring Boot + REST APIs**

---

## 👨‍💻 Author

**Your Name**

* GitHub: [Ajaykhande](https://github.com/ajaykhande)
* 


