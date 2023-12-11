import java.util.Scanner;

public class Hospital {
    private Patient[] patients;
    private int currentIndex;

    public Hospital(){
        createEmptyArrayOfPatients();
    }

    public void createEmptyArrayOfPatients(){
        patients = new Patient[100];
        currentIndex = 0;
    }

    public void displayPatients(){
        for(int i = 0; i < currentIndex; i++){
            System.out.println(patients[i]);
        }
    }
    public void filterPatientsByDiagnose(String diagnose){
        for(int i = 0; i < currentIndex; i++){
            if(patients[i].getDiagnose().equals(diagnose)){
                System.out.println(patients[i]);
            }
        }
    }

    public void filterPatientsByMedicineCardNumber(int minCardNumber, int maxCardNumber){
        for(int i = 0; i < currentIndex; i++){
            if(patients[i].getMedicineCardNumber() >= minCardNumber && patients[i].getMedicineCardNumber() <= maxCardNumber){
                System.out.println(patients[i]);
            }
        }
    }

    public void filterPatientsByInsurance(boolean hasInsurance){
        for(int i = 0; i < currentIndex; i++){
            if(patients[i].getHasInsurance() == hasInsurance){
                System.out.println(patients[i]);
            }
        }
    }

    public void addPatient(Scanner scanner){
        if(currentIndex == patients.length){
            System.out.println("Out of memory for adding a new patient");
            return;
        }

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
        boolean hasInsurance = scanner.nextLine().equals("y");

        scanner.nextLine();

        System.out.print("Enter diagnosis: ");
        String diagnose = scanner.nextLine();

        Patient patient = new Patient(id, person, medicineCardNumber, hasInsurance, diagnose);

        patients[currentIndex++] = patient;
    }

    public void savePatientsInFile(String fileName){
        PatientFileManager.writePatientsToFile(fileName, patients);
    }

    public void loadPatientsFromFile(String fileName){
        Patient[] patientsFromFile = PatientFileManager.readPatientsFromFile(fileName);
        if(patientsFromFile == null) {
            return;
        }

        for(int i = 0; i < patientsFromFile.length; i++){
            if(patientsFromFile[i] == null) {
                break;
            }

            patients[i] = patientsFromFile[i];
            currentIndex++;
        }
    }
}
