package ctrls;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import dao.PersistDB;

public class AbstractCtrl<T extends PersistDB> {

    public void addInfo(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, ""));
    }

    public void addWarn(String warning) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN , warning, ""));
    }
    
    public String nameUpper(String nu){
        StringBuffer sb = new StringBuffer();
        String[] swhat = nu.split(" ");
        for(String name : swhat){
            char[] stringArray = name.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            name = new String(stringArray);
            sb.append(name).append(" ");
        }
        return sb.toString();
    } 
}
