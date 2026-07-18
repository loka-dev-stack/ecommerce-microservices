package com.Product_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
	    info = @Info(
	        title = "Product Service API",
	        version = "1.0",
	        description = "REST APIs for Product Management",
	        contact = @Contact(
	            name = "Lokanath Patra",
	            email = "lokanah8patra@gmail.com"
	        )
	    )
	)
public class SwaggerConfig {
//	http://localhost:8092/swagger-ui/index.html

}

