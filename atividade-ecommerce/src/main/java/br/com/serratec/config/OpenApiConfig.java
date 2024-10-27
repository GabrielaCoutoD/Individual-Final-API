package br.com.serratec.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	//o value captura o valor entre 
	//parenteses la do application.properties
	@Value("${dominio.openapi.dev-url}")
	private String devUrl;
	
	@Value("${dominio.openapi.prod-url}")
	private String prodUrl;
	
	@Bean
	public OpenAPI myOpenApi() {
		//1)
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("URL da área de desenvolvimento");
		
		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription("URL da área de produção");
		
		//2)
		Contact contact = new Contact();
		contact.setName("eCommerce Bar Delivery");
		contact.setEmail("eCommerce@mail.com");
		contact.setUrl("https://www.serratec.com.br");
		
		//3)
		License apacheLicense = new License().name("Apache").
				url("https://opensource.org/licenses/Apache-2.0");
		Info info = new Info().title("ATIVIDADE ECOMMERCE - GRUPO3 - 2024.2").version("1.0").contact(contact)
				.description("eCommerce Bar").termsOfService("https://www.serratec.com.br")
				.license(apacheLicense);
		//4)
		return new OpenAPI().info(info).servers(List.of(devServer,prodServer));
		//List.of() passa informações que não podem ser modificadas
	}
}
