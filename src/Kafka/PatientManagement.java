package Kafka;

import java.util.List;

/*
Patient management
Define relationship:
    Patient, doctor, caregiver
 */
public class PatientManagement {

    public static class Patient {
        int patientId;
        String firstName;
        String lastName;
        String gender;
        String dob;
        Doctor doctor;
        List<CareGiver> careGivers;
    }

    public static class Doctor {
        int doctorId;
        DoctorType type;
        String firstName;
        String lastName;
        String gender;
        String dob;
        List<Patient> patients;
    }

    public static class CareGiver {
        int careGiverId;
        String careGiverName;
        String careGiverAddress;
        List<Patient> patients;
    }
}

