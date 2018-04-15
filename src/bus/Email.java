package bus;

import java.io.Serializable;

public class Email implements Serializable{

	private static final long serialVersionUID = -3936676914708045686L;
	private String domain;
	private String topdomain;
	private String username;

	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) throws RaiseException {
		Validation.validDomain(domain);
		this.domain = domain.trim();
	}
	public String getTopdomain() {
		return topdomain;
	}
	public void setTopdomain(String topdomain) throws RaiseException {
		Validation.validSubDomain(topdomain);
		this.topdomain = topdomain.trim();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) throws RaiseException {
		Validation.validUserName(username);
		this.username = username.trim();
	}
	
	public Email() {
		super();
	}
	public Email(String username, String domain, String topdomain) throws RaiseException {
		super();
		setDomain(domain);
		setTopdomain(topdomain);
		setUsername(username);
	}
	public Email(Email email) throws RaiseException {
		setDomain(email.domain);
		setTopdomain(email.topdomain);
		setUsername(email.username);
	}
	
	@Override
	public String toString() {
		return username + "@" + domain + "." + topdomain; 
	}
}
