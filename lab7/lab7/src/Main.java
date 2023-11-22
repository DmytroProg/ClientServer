import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.loadPatientsFromFile("patients.dat");
        Scanner scanner = new Scanner(System.in);
        String[] options = {
                "add patient",
                "see all patients",
                "filter patients by diagnose",
                "filter patients by medicine card",
                "filter patients by insurance",
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
                case 2 -> hospital.displayPatients();
                case 3 -> {
                    System.out.print("Enter diagnose: ");
                    String diagnose = scanner.nextLine();
                    hospital.filterPatientsByDiagnose(diagnose);
                }
                case 4 -> {
                    System.out.print("Enter min medicine card: ");
                    int min = scanner.nextInt();
                    System.out.print("Enter max medicine card: ");
                    int max = scanner.nextInt();
                    hospital.filterPatientsByMedicineCardNumber(min, max);
                }
                case 5 -> {
                    System.out.print("Patients with insurance? (y/n): ");
                    String insurance = scanner.nextLine();
                    hospital.filterPatientsByInsurance(insurance.equals("y"));
                }
                case 6 -> {
                    hospital.savePatientsInFile("patients.dat");
                    return;
                }
            }
        }
    }
}