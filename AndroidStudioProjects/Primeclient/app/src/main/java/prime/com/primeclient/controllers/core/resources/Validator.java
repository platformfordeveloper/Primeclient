package prime.com.primeclient.controllers.core.resources;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BrahmaRishi on 27/01/17.
 */

public class Validator {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Boolean validateEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        if (!email.isEmpty()) {
            if (matcher.matches()) {
                return true;
            }
        } else {
//            throw new Exception();
        }
        return null;
    }

    public Boolean validatePassword(String password) {
        if (!password.isEmpty())
            return true;
        return false;
    }
}
