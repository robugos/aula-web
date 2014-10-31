package br.com.aulaweb.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "converteData")
public class ConverteData implements Converter{
	
	SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		try {
			
			return df.parseObject(arg2);
		}catch (Exception ex) {
			return "";
		}
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		try {
			
			return df.format((Date) arg2);
		}catch (Exception ex) {
			return "";
		}
	}
	
	

}