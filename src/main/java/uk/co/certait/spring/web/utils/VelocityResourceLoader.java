package uk.co.certait.spring.web.utils;

/*
 *  decisionsdecisions ltd
 * Created on 17 Jun 2007
 *
 * $Author$
 * $LastChangedBy$
 * $LastChangedDate$
 * $Rev$
 * $URL$
 */

import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;

public class VelocityResourceLoader
{
    public static Template loadTemplateFromClasspath(String templateName) throws Exception
    {
        Properties props = new Properties();
        props.put("resource.loader", "class");      
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(props);
        Template template = Velocity.getTemplate(templateName);
     
        return template;
    }
}