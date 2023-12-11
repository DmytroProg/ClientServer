import java.io.Serializable;

public class Patient implements Serializable {
    private int id;
    private Person person;
    private int medicineCardNumber;
    private boolean hasInsurance;
    private String diagnose;

    public Patient(int id, Person person, int medicineCardNumber, boolean hasInsurance, String diagnose){
        this.id = id;
        setPerson(person);
        setMedicineCardNumber(medicineCardNumber);
        setHasInsurance(hasInsurance);
        setDiagnose(diagnose);
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public Person getPerson(){
        return person;
    }

    public void setMedicineCardNumber(int medicineCardNumber){
        if(medicineCardNumber < 1){
            throw new IllegalArgumentException("medicine card number must be a positive integer number");
        }
        this.medicineCardNumber = medicineCardNumber;
    }

    public int getMedicineCardNumber(){
        return medicineCardNumber;
    }

    public void setHasInsurance(boolean hasInsurance){
        this.hasInsurance = hasInsurance;
    }

    public boolean getHasInsurance(){
        return hasInsurance;
    }

    public void setDiagnose(String diagnose){
        if(diagnose.isEmpty()){
            throw new IllegalArgumentException("diagnose must not be empty");
        }
        this.diagnose = diagnose;
    }

    public String getDiagnose(){
        return diagnose;
    }

    @Override
    public String toString(){
        return "Patient " + id + ": (" + person.toString() + "). Medicine card number " + medicineCardNumber +
                (hasInsurance? " has " : " does not have ") + "insurance, diagnose: " + diagnose;
    }

}
