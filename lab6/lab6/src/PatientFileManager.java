import java.io.*;
import java.util.ArrayList;

public class PatientFileManager {
    public static void writePatientsToFile(String fileName, ArrayList<Patient> patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(patients);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Patient> readPatientsFromFile(String fileName) {
        ArrayList<Patient> patients = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            patients = (ArrayList<Patient>)ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return patients;
    }
}
