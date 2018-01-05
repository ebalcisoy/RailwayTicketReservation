
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private Pattern email_pattern;
	private Pattern password_pattern;
	private Pattern ssn_pattern;
	private Pattern telephone_pattern;
	private Pattern passport_pattern;
	private Pattern name_pattern;
	private Pattern surname_pattern;
	private Pattern date_pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[*@#$%!]).{8,40})";
	private static final String SSN_PATTERN = "((?=\\d).{11})";
	private static final String TELEPHONE_PATTERN = "((?=\\d).{10})";
	private static final String PASSPORT_PATTERN = "^[A-Za-z]\\d{2}\\s\\d{5}$";
	private static final String NAME_PATTERN = "[a-zA-Zþçýðöü]*";
	private static final String SURNAME_PATTERN = "[a-zA-Zþçýðöü]*";
	private static final String DATE_PATTERN ="^((0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d))$";

	public Validator() {
		password_pattern = Pattern.compile(PASSWORD_PATTERN);
		ssn_pattern = Pattern.compile(SSN_PATTERN);
		email_pattern = Pattern.compile(EMAIL_PATTERN);
		telephone_pattern = Pattern.compile(TELEPHONE_PATTERN);
		passport_pattern = Pattern.compile(PASSPORT_PATTERN);
		name_pattern = Pattern.compile(NAME_PATTERN);
		surname_pattern = Pattern.compile(SURNAME_PATTERN);
		date_pattern = Pattern.compile(DATE_PATTERN);
	}
	

	public boolean password_validate(final String password) {
		matcher = password_pattern.matcher(password);
		return matcher.matches();
	}
	
	public boolean ssn_validate(final String ssn) {
		matcher = ssn_pattern.matcher(ssn);
		return matcher.matches();
	}
	
	public boolean email_validate(final String email) {
		matcher = email_pattern.matcher(email);
		return matcher.matches();
	}
	
	public boolean telephone_validate(final String telephone) {
		matcher = telephone_pattern.matcher(telephone);
		return matcher.matches();
	}
	
	public boolean passport_validate(final String passport) {
		matcher = passport_pattern.matcher(passport);
		return matcher.matches();
	}
	
	public boolean name_validate(final String name) {
		matcher = name_pattern.matcher(name);
		return matcher.matches();
	}
	
	public boolean surname_validate(final String surname) {
		matcher = surname_pattern.matcher(surname);
		return matcher.matches();
	}
	
	public boolean date_validate(final String date) {
		matcher = date_pattern.matcher(date);
		return matcher.matches();
	}
}
