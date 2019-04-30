package vue.validateur;

import java.util.regex.Pattern;

public class PatternValidation implements Validation {
    private String pattern;
    public PatternValidation(String pattern){
        this.pattern = pattern;
    }
    @Override
    public boolean valider(Object o) {
        if(!Pattern.matches(pattern, (String)o)){
            return false;
        }
        return true;
    }
}
