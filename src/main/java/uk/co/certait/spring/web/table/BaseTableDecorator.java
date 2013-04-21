package uk.co.certait.spring.web.table;

import org.apache.velocity.app.VelocityEngine;
import org.displaytag.decorator.TableDecorator;

public class BaseTableDecorator extends TableDecorator {

	protected static VelocityEngine engine;
	
	static{
		engine = new VelocityEngine();
		engine.setProperty("resource.loader", "class");
		engine.setProperty("class.resource.loader.description", "Velocity Classpath Resource Loader");;
		engine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		engine.setProperty("class.resource.loader.cache", "true");
		engine.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		engine.init();
	}
}
