package uk.co.certait.spring.web.table;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import uk.co.certait.spring.data.domain.User;

public class UserTableDecorator extends BaseTableDecorator {

	public String getEditLink(){
		User user = (User) getCurrentRowObject();
		
		return "<a class=\"btn btn-small btn-info\" href=\"secure/admin/editUserDetails.do?userId=" + user.getId() +  "\"><i class=\"icon-edit icon-white\"></i> Edit</a> ";
	}
	public String getFullDetails() throws Exception {
		User user = (User) getCurrentRowObject();
		
		VelocityContext context = new VelocityContext();
		Template template = engine.getTemplate("/templates/html/userPopover.vm");
		context.put("user", user);
		Writer writer = new StringWriter();
		template.merge(context,  writer);
		
		return writer.toString();
	}
}
