package br.com.travelmate.converter;

import br.com.travelmate.model.Area;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="AreaConverter")
public class AreaConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Area> listaArea = (List<Area>) component.getAttributes().get("listaArea");
        for (Area area : listaArea) {
                if (area.getDescricao().equalsIgnoreCase(value)) {
                    return area;
                }
            }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value.toString().equalsIgnoreCase("0")) {
            return "Selecione";
        } else {
            Area area = (Area) value;
            return area.getDescricao();
        }
    }
}
