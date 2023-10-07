public class Password {
    private String password;
    private int minLength;
    private boolean hasUpperCase;
    private boolean hasDigits;
    private boolean hasSpecialCharacters;
    private final String specialChars = "@#$!&*%^";

    public Password(String password, int minLength, boolean hasUpperCase, boolean hasDigits, boolean hasSpecialCharacters){
        this.password = password;
        this.minLength = minLength;
        this.hasUpperCase = hasUpperCase;
        this.hasDigits = hasDigits;
        this.hasSpecialCharacters = hasSpecialCharacters;
    }
    public Password(String password){
        this.password = password;
        this.minLength = -1;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public boolean isHasUpperCase() {
        return hasUpperCase;
    }

    public void setHasUpperCase(boolean hasUpperCase) {
        this.hasUpperCase = hasUpperCase;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public boolean isHasDigits() {
        return hasDigits;
    }

    public void setHasDigits(boolean hasDigits) {
        this.hasDigits = hasDigits;
    }

    public boolean isHasSpecialCharacters() {
        return hasSpecialCharacters;
    }

    public void setHasSpecialCharacters(boolean hasSpecialCharacters) {
        this.hasSpecialCharacters = hasSpecialCharacters;
    }

    public boolean isPasswordCorrect() {
        if (minLength != -1 && password.length() < minLength)
            return false;
        if (hasUpperCase && password.toLowerCase().equals(password))
            return false;
        if (hasDigits && !checkForDigits())
            return false;
        if(hasSpecialCharacters && !checkForSpecialCharacters())
            return false;
        return true;
    }

    private boolean checkForDigits(){
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForSpecialCharacters(){
        for (char c : password.toCharArray()) {
            if (specialChars.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    }
}
