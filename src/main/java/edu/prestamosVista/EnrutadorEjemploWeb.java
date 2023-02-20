package edu.prestamosVista;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import edu.prestamosVista.aplicacion.AplicacionConfiguracionContexto;
import edu.prestamosVista.web.WebConfiguracionContexto;

//Mapea y gestiona las rutas
public class EnrutadorEjemploWeb extends AbstractAnnotationConfigDispatcherServletInitializer {

	//Carga la configuracion de la aplicacion
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AplicacionConfiguracionContexto.class };
    }

	//Carga la configuracion de la web
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfiguracionContexto.class };
    }

    //Gestiona la contruccion de la array que forma la ruta URL
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
