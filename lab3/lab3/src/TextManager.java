public class TextManager {
    /*
    * Replaces the letters A (or a) after letter P (or p) with a letter O (or o) in the words
    * */
    public static String replace(String text){
        StringBuilder stringBuilder = new StringBuilder();
        int difference = 'O' - 'A';

        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == 'p' || text.charAt(i) == 'P'){
                if(text.length() > i + 1 && text.toLowerCase().charAt(i + 1) == 'a'){
                    stringBuilder.append(text.charAt(i)).append((char)(text.charAt(i+1) + difference));
                    i++;
                    continue;
                }
            }
            stringBuilder.append(text.charAt(i));
        }

        return stringBuilder.toString();
    }
}
