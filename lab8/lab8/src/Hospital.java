import java.util.*;
import java.util.stream.Collectors;

public class Hospital {
    private HashSet<Patient> patients;

    public Hospital() {
        createEmptySetOfPatients();
    }

    public void createEmptySetOfPatients() {
        patients = new HashSet<>();
    }

    public Set<Patient> getPatientsByDiagnoseSortedByMedicineCard(String diagnose){
        return patients.stream()
                .filter(patient -> patient.getDiagnose().equals(diagnose))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Patient::getMedicineCardNumber))));
    }

    public Set<Patient> getPatientsByMedicineCard(int min, int max){
        return patients.stream()
                .filter(patient -> patient.getMedicineCardNumber() >= min && patient.getMedicineCardNumber() <= max)
                .collect(Collectors.toSet());
    }

    public Set<Patient> getPatientsWithNoInsurance(){
        return patients.stream()
                .filter(patient -> !patient.getHasInsurance())
                .collect(Collectors.toSet());
    }

    // chat gpt трішки тут поміг, але я цей код розібрав для себе
    public HashMap<String, Long> getDiagnosesWithCountSortedByCount() {
        return patients.stream()
                .collect(Collectors.groupingBy(Patient::getDiagnose, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public HashMap<String, Integer> getDiagnosesWithCount() {
        HashMap<String, Integer> diagnosisCountMap = new HashMap<String, Integer>();

        for (Patient patient : patients) {
            String diagnosis = patient.getDiagnose();
            diagnosisCountMap.put(diagnosis, diagnosisCountMap.getOrDefault(diagnosis, 0) + 1);
        }

        return diagnosisCountMap;
    }

    public HashSet<String> getDistinctDiagnoses() {
        HashSet<String> distinctDiagnoses = new HashSet<String>();

        for (Patient patient : patients) {
            distinctDiagnoses.add(patient.getDiagnose());
        }

        return distinctDiagnoses;
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

    public Patient searchPatientById(int id) {
        return patients.stream()
                .filter(patient -> patient.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void removePatient(Patient patient){
        patients.remove(patient);
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