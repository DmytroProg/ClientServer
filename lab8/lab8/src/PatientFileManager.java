import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class PatientFileManager {
    public static void writePatientsToFile(String fileName, HashSet<Patient> patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(patients);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static HashSet<Patient> readPatientsFromFile(String fileName) {
        HashSet<Patient> patients = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            patients = (HashSet<Patient>)ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return patients;
    }
}
