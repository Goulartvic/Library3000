package br.com.neoway.library;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import control.UserControl;
import model.User;
import model.UserType;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean logged;
	private User loggedUser;
	private String email;
	private String password;
	private UserControl userControl = new UserControl();

	public LoginBean() {

	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		loggedUser = userControl.authenticateUser(email, password);
		if (loggedUser.getUserType()==UserType.ADM) {
			logged = true;
			return "indexADM.xhtml";
		}
		if (loggedUser == null) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Invalid user or password!",
					""));
		} else {
			logged = true;
			return "indexUser";
		}
		return "";
	}

	public String toRegister() {
		return "registerUser.xhtml";
	}

	public String logout() {
		loggedUser = null;
		logged = false;
		return "index.xhtml";
	}

}