import java.io.*;

public class PatientFileManager {
    public static void writePatientsToFile(String fileName, Patient[] patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(patients);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Patient[] readPatientsFromFile(String fileName) {
        Patient[] patients = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            patients = (Patient[])ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return patients;
    }
}
