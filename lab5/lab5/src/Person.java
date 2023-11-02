import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private String address;
    private String phoneNumber;

    public Person(int id, String name, String surname, String middleName, String address, String phoneNumber){
        this.id = id;
        setName(name);
        setSurname(surname);
        setMiddleName(middleName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        if(name.isEmpty()) {
           throw new IllegalArgumentException("name must not be empty");
        }
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        if(surname.isEmpty()) {
            throw new IllegalArgumentException("surname must not be empty");
        }
        this.surname = surname;
    }

    public String getSurname(){
        return surname;
    }

    public void setMiddleName(String middleName){
        if(middleName.isEmpty()) {
            throw new IllegalArgumentException("middle name must not be empty");
        }
        this.middleName = middleName;
    }

    public String getMiddleName(){
        return middleName;
    }

    public void setAddress(String address){
        if(address.isEmpty()) {
            throw new IllegalArgumentException("address must not be empty");
        }
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("phone number must not be empty");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString(){
        return id + "| " + surname + " " + name + " " + middleName + ", " + address + " phone: (" + phoneNumber + ")";
    }
}
