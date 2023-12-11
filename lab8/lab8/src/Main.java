import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.loadPatientsFromFile("patients.dat");
        Scanner scanner = new Scanner(System.in);
        String[] options = {
                "add patient",
                "filter patients by diagnose",
                "filter patients by medicine card",
                "get patients with no insurance",
                "get diagnoses and count of patients sorted",
                "get diagnoses",
                "get diagnoses and count of patients",
                "exit"
        };

        while(true){
            for(int i = 0; i < options.length; i++){
                System.out.println((i+1) + " " + options[i]);
            }
            System.out.print("Enter number of an option: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            switch (index) {
                // IntelliJ IDEA підказала так зробити
                case 1 -> hospital.addPatient(scanner);
                case 2 -> {
                    System.out.print("Enter diagnose: ");
                    String diagnose = scanner.nextLine();
                    for(Patient patient : hospital.getPatientsByDiagnoseSortedByMedicineCard(diagnose)){
                        System.out.println(patient);
                    }
                }
                case 3 -> {
                    System.out.print("Enter min medicine card: ");
                    int min = scanner.nextInt();
                    System.out.print("Enter max medicine card: ");
                    int max = scanner.nextInt();
                    for(Patient patient : hospital.getPatientsByMedicineCard(min, max)){
                        System.out.println(patient);
                    }
                }
                case 4 -> {
                    for(Patient patient : hospital.getPatientsWithNoInsurance()){
                        System.out.println(patient);
                    }
                }
                case 5 -> {
                    HashMap<String, Long> diagnosisCountMap = hospital.getDiagnosesWithCountSortedByCount();

                    for (Map.Entry<String, Long> entry : diagnosisCountMap.entrySet()) {
                        System.out.println("Diagnosis: " + entry.getKey() + ", Count: " + entry.getValue());
                    }
                }
                case 6 -> {
                    for(String diagnose: hospital.getDistinctDiagnoses()){
                        System.out.println(diagnose);
                    }
                }
                case 7 -> {
                    HashMap<String, Integer> diagnosisCountMap = hospital.getDiagnosesWithCount();

                    for (Map.Entry<String, Integer> entry : diagnosisCountMap.entrySet()) {
                        System.out.println("Diagnosis: " + entry.getKey() + ", Count: " + entry.getValue());
                    }
                }
                case 8 -> {
                    hospital.savePatientsInFile("patients.dat");
                    return;
                }
            }
        }
    }
}