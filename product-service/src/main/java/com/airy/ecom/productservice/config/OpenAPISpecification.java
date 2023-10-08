package com.airy.ecom.productservice.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPISpecification {

    public OpenAPI configureAPIDoc(){
        return new OpenAPI()
                .info(new Info()
                        .title("Expense Management")
                        .description("Manage your Expenses using API's")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("Om Shinde")
                                .email("omshinde1706@gmail.com")
                        )
                        .license(new License().name("Airy Licence 2.0"))
                );
    }
}
