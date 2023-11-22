import java.util.*;

public class Hospital {
    private HashSet<Patient> patients;

    public Hospital() {
        createEmptySetOfPatients();
    }

    public void createEmptySetOfPatients() {
        patients = new HashSet<>();
    }

    public void displayPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void filterPatientsByDiagnose(String diagnose) {
        for (Patient patient : patients) {
            if (patient.getDiagnose().equals(diagnose)) {
                System.out.println(patient);
            }
        }
    }

    public void filterPatientsByMedicineCardNumber(int minCardNumber, int maxCardNumber) {
        for (Patient patient : patients) {
            if (patient.getMedicineCardNumber() >= minCardNumber && patient.getMedicineCardNumber() <= maxCardNumber) {
                System.out.println(patient);
            }
        }
    }

    public void filterPatientsByInsurance(boolean hasInsurance) {
        for (Patient patient : patients) {
            if (patient.getHasInsurance() == hasInsurance) {
                System.out.println(patient);
            }
        }
    }

    public void addPatient(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter patient's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter patient's last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter patient's middle name: ");
        String middleName = scanner.nextLine();

        System.out.print("Enter patient's address: ");
        String address = scanner.nextLine();

        System.out.print("Enter patient's phone number: ");
        String phoneNumber = scanner.nextLine();

        Person person = new Person(id, firstName, lastName, middleName, address, phoneNumber);

        System.out.print("Enter medicine card number: ");
        int medicineCardNumber = scanner.nextInt();

        System.out.print("Does the patient have insurance? (y/n): ");
        boolean hasInsurance = scanner.next().equalsIgnoreCase("y");

        scanner.nextLine();

        System.out.print("Enter diagnosis: ");
        String diagnose = scanner.nextLine();

        Patient patient = new Patient(id, person, medicineCardNumber, hasInsurance, diagnose);

        patients.add(patient);
    }

    public void savePatientsInFile(String fileName) {
        PatientFileManager.writePatientsToFile(fileName, patients);
    }

    public void loadPatientsFromFile(String fileName) {
        patients = PatientFileManager.readPatientsFromFile(fileName);
        if (patients == null) {
            patients = new HashSet<Patient>();
        }
    }
}