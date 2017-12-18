package view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import controller.ImageUserController;
import controller.UserController;
import model.ImageUser;

@Named
@MultipartConfig(location="/tmp",
fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5,
maxRequestSize=1024*1024*5*5)
public class ProfileMb implements Serializable {
	
	private static final long serialVersionUID = 8942090240801747977L;
	
	@Inject
	UserController uc;
	@Inject
	AuthMb authMb;
	@Inject 
	ImageUserController imgCntl;
	
	private Part file;
	
	String pass1;
	String pass2;
	
	
	public void changePassword() {

		if(pass1.equals(pass2) && pass1 != "") {
			uc.changePassword(pass2,authMb.getUser());
		}else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Las claves no coinciden", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		pass1 = "";
		pass2 = "";
		
		
	}
	
	public void changeImage() {
		
		ImageUser img;
		
		try{
			img = null;
			if(file != null && file.getSize() > 0 && file.getContentType().startsWith("image/")){
				img = imgCntl.upload(file);
				authMb.getUser().setImage(img);
				imgCntl.updateImage(authMb.getUser(), img);
			}else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Porfavor, asegurese que haya seleccionado una imagen", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	

	
	
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	
	
	
	
	
	
	

}
