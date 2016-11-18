package ctrls;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import dao.PersistDB;

public class AbstractCtrl<T extends PersistDB> {

    public void addInfo(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "ok"));
    }

    public void addWarn(String warning) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN , warning, "ok"));
    }
    
}
