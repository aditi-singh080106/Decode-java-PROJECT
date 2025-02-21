import java.util.Scanner;
import java.util.ArrayList;
class Patient{
    private static int idcounter = 0 ;
    private int id ;
    private String name;
    private String gender;
    private int age;
    public Patient(String name, String gender, int age) {
        this.id = ++idcounter;// starting from 1 ;
        this.name = name ;
        this.gender = gender ;
        this.age = age ;
    }
    public String toString(){
        return "Patient Id : "+id+" , Name : "+name+" , Gender : "+gender+" , Age : "+age ;
    }
    public int getId(){
        return id ;
    }
}
class Doctor{
    private static int idcounter = 1 ;
    private int id ;
    private String name ;
    private String speciality ;
    public Doctor(String name, String speciality) {
        this.id = idcounter++ ;
        this.name = name ;
        this.speciality = speciality ;
    }
    public int getId(){
        return id ;
    }
    public String toString(){
        return "Doctor Id : "+id+" , Name : "+name+" , Speciality : "+speciality ;
    }
}
class Appointment{
    private Patient patient;
    private Doctor doctor ;
    private String date ;
    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient ;
        this.doctor = doctor ;
        this.date = date ;
    }
    public String toString(){
        // return "Patient : "+patient.toString()+" , Doctor : "+doctor.toString()+" , Date : "+date ;
        return "Appointment [Patient : "+patient+" Doctor : "+doctor+" Date : "+date+" ]" ;
    }
}
public class HOSPITALMANAGEMENT {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patient");
            System.out.println("5. View Doctor");
            System.out.println("6. View Appointment");
            System.out.println("0. Exit");
            System.out.print("Enter your choice :");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    addDoctor(sc);
                    break;
                case 3:
                    scheduleAppointment(sc);
                    break;
                case 4:
                    viewPatient();
                    break;
                case 5:
                    viewDoctor();
                    break;
                case 6:
                    viewAppointment();
                    break;
                case 0:
                    System.out.println("Exiting...!");
                    break;
                default :
                System.out.println("Invalid choice");
            }
        }while(choice != 0);
    }
    private static void addPatient(Scanner sc){
        System.out.println("Enter Patient Name :");
        String name = sc.next();
        System.out.println("Enter Patient Age :");
        int age = sc.nextInt();
        System.out.println("Enter Patient gender :");
        String gender = sc.next();
        Patient patient = new Patient(name , gender , age);
        patients.add(patient);
        System.out.println("Patient added successfully");
    }
    private static void addDoctor(Scanner sc){
        System.out.println("Enter Doctor Name :");
        String name = sc.next();
        System.out.println("Enter speciality : ");
        String speciality = sc.next();
        Doctor doctor = new Doctor(name, speciality);
        doctors.add(doctor);
        System.out.println("Doctor added successfully");
    }
    private static void scheduleAppointment(Scanner sc){
        System.out.println("Enter Patient id : ");
        int pid = sc.nextInt();
        System.out.println("Enter Doctor id : ");
        int did = sc.nextInt();
        System.out.println("Enter date for Appointment : ");
        String date = sc.next();
        Patient patient = findPatientById(pid);
        Doctor doctor = findDoctorById(did);
        if(patient != null && doctor != null){
            Appointment appointment = new Appointment(patient, doctor, date);
            appointments.add(appointment);
        }
        else{
            System.out.println("Invalid Patient Id or Doctor Id .");
        }
    }
    private static void viewPatient(){
        System.out.println("List of Patients :");
        for(Patient patient : patients){
            System.out.println(patient.toString());
        }
    }
    private static void viewDoctor(){
        System.out.println("List of Doctors :");
        for(Doctor doctor : doctors){
            System.out.println(doctor.toString());
        }
    }
    private static void viewAppointment(){
        System.out.println("List of appointments :");
        for(Appointment appointment : appointments){
            System.out.println(appointment.toString());
        }
    }
    private static Patient findPatientById(int id){
        for(Patient patient : patients){
            if(patient.getId() == id){
                return patient;
            }
        }
        return null ;
    }
    private static Doctor findDoctorById(int id){
        for(Doctor doctor : doctors){
            if(doctor.getId() == id){
                return doctor;
            }
        }
        return null ;
    }
}
