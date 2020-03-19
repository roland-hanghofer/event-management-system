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

### Secure REST API
https://gist.github.com/thomasdarimont/8d6bc243d3b504439e67d57cb0d0bb72

### Web App

```
npm install primeng --save
npm install primeicons --save
npm install @angular/animations --save
npm install chart.js --save
npm install @angular/cdk --save
ng config defaults.styleExt=scss
ng config schematics.@schematics/angular:component.styleext scss
```

#### Styles von CSS auf SCSS wechseln

https://www.hering.me/angular-7-von-css-nach-sass-scss/

angular.json:

```
"styles": [
    "src/styles.css",
    "node_modules/primeicons/primeicons.css",
    "node_modules/primeng/resources/themes/luna-blue/theme.css",
    "node_modules/primeng/resources/primeng.min.css"
],
"scripts": [
    "node_modules/chart.js/dist/Chart.js"
]
```

#### Erstellen der Services 

```
npm install ng-swagger-gen --save-dev
node_modules/.bin/ng-swagger-gen -i http://127.0.0.1:8080/v2/api-docs
```
