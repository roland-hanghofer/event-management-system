# EventManagementSystem

## REST Api

### Basic settings

The base path is set in the file *application.properties* by inserting the entry `spring.mvc.servlet.path=/api`



### Swagger

Dependencies for *Swagger* which are put into *pom.xml*

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```

Enabling swagger by using a configuration class

```java
@Configuration
@EnableSwagger2
public class ApplicationConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
```

Swagger Ui can be accessed by visiting the site http://localhost:8080/api/swagger-ui.html#/

### Azure Cosmos DB
https://docs.microsoft.com/en-us/azure/java/spring-framework/configure-spring-data-mongodb-with-cosmos-db
