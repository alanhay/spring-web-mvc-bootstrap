package uk.co.certait.spring.web.editor;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;

		try {
			date = format.parse(text);
		}
		catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}

		super.setValue(date);
	}
	
	@Override
	public String getAsText() {
		return super.getAsText();
	}
}
