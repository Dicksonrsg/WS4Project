package ctrls;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import dao.PersistDB;

public class AbstractCtrl<T extends PersistDB> {

    public void addInfo(String msg) {
        FacesMessage fm = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
	
}
