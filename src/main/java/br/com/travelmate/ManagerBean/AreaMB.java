package br.com.travelmate.ManagerBean;

import br.com.travelmate.model.Area;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AreaMB implements Serializable{
    
    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    
    
    public String novo(){
        return "cadArea";
    }
    
}
