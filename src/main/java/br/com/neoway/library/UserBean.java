package br.com.neoway.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import control.UserControl;
import model.User;
import model.UserType;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();
	private UserControl control = new UserControl();
	private User selectedUser;
	private List<User> users = new ArrayList<User>();
	private boolean value1;

	public boolean isValue1() {
		return value1;
	}

	public List<User> listSelectedUser(){
		return java.util.Arrays.asList(selectedUser);
	}

	public void setValue1(boolean value1) {
		this.value1 = value1;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<User> getUsers() {
		return users;
	}

	public String toRegister() {
		return "registerUser";
	}

	public String cancelRegister() {
		return "index";
	}

	public String saveUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			user.setUserType(UserType.NORMAL);
			control.save(user);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "User registered successfully",
					""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "index.xhmtl";
	}

	public String saveAdmin() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (value1) {
				user.setUserType(UserType.ADM);
			}
			else{
				user.setUserType(UserType.NORMAL);
			}
			control.save(user);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "User registered successfully",
					""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "userList.xhmtl";

	}

	public String delete() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			control.delete(selectedUser);
			users.remove(selectedUser);
			selectedUser = null;
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"User deleted successfully", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "userList.xhtml";
	}

	public String update(User userPar) {
		selectedUser = userPar;
		listSelectedUser();

		return "updateUser.xhtml";

	}

	public String listAll() {
		users = control.searchAll();
		return "userList.xhtml";
	}

	public String admRegisterUser() {
		return "admRegisterUser.xhtml";
	}

	public String updateUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			control.update(user);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "User updated successfully",
					""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
		return "userList.xhtml";
	}
	
	public String admCancel(){
		return "userList.xhtml";
	}
	
	public String backToIndexADM(){
		return "indexADM.xhtml";
	}
	
}