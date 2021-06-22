package unoesc.edu.emprestimo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import unoesc.edu.emprestimo.model.Estado;

@FacesConverter(value = "estadoConverter", forClass = Estado.class)
public class EstadoConverter implements javax.faces.convert.Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Estado p = (Estado) component.getAttributes().get(value);
            return p;
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Estado)) {
			Estado p = (Estado) value; 
			component.getAttributes().put( String.valueOf(p.getId()), p);
            return String.valueOf(p.getId());
        }

		return null;
	}
}
