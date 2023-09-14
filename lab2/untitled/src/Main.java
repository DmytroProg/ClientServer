import lab2.*;

public class Main {

    /*
    * Generates an array of Patients
    * @return array of patients
    * */
    private static Patient[] generateTestPatientsArray(){
        Patient[] patients = new Patient[4];
        Person[] persons = new Person[4];

        persons[0] = new Person(1, "Jon", "Jonson", "Jonatan", "Jonsons street", "0963524534");
        persons[1] = new Person(2, "Marry", "Marion", "Marinson", "Marin street", "0973564756");
        persons[2] = new Person(3, "Ton", "Tomas", "Tomanson", "Tomans street", "0683645733");
        persons[3] = new Person(4, "Bill", "Billien", "Bilinson", "Billon street", "0966373564");

        patients[0] = new Patient(1, persons[0], 3454, true, "C++");
        patients[1] = new Patient(2, persons[1], 7463, true, "Arrhythmia");
        patients[2] = new Patient(3, persons[2], 2635, false, "Diabetes");
        patients[3] = new Patient(4, persons[3], 3667, false, "Alzheimer's disease");

        return patients;
    }

    /*
    * Shows the patients with the selected diagnose
    * @param patients - array of patients
    * @param diagnose - selected diagnose
    * */
    private static void showPatientsWithDiagnose(Patient[] patients, String diagnose){
        for (Patient patient : patients) {
            if(patient.getDiagnose().equals(diagnose)) {
                System.out.println(patient);
            }
        }
    }

    /*
    * Shows patients whose medicine card number is within the number range
    * @param patients - array of patients
    * @param min - minimal medicine card number
    * @param max - maximal medicine card number
    * */
    private static void showPatientsWithMedicineCardRange(Patient[] patients, int min, int max){
        for (Patient patient : patients) {
            if(patient.getMedicineCardNumber() >= min && patient.getMedicineCardNumber() <= max) {
                System.out.println(patient);
            }
        }
    }

    /*
    * Shows the array of patients without medical insurance
    * @param patients - array of patients
    * */
    public static void showPatientsWIthNoInsurance(Patient[] patients){
        int count = 0;
        for(Patient patient : patients){
            if(!patient.getHasInsurance()){
                System.out.println(patient);
                count++;
            }
        }

        System.out.println("Count os patients without medical insurance: " + count);
    }

    public static void main(String[] args) {
        Patient[] patients = generateTestPatientsArray();

        showPatientsWithDiagnose(patients, "C++");
        System.out.println("-------------------------------");
        showPatientsWithMedicineCardRange(patients,1000, 5000);
        System.out.println("-------------------------------");
        showPatientsWIthNoInsurance(patients);
    }
}