package agendaSpring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import agendaSpring.controllers.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses= {HomeController.class})
public class AppWebConfiguration {

}
