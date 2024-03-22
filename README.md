# Spring Boot Introducción

Spring Boot es un marco de trabajo Java que simplifica 
drásticamente el desarrollo de aplicaciones, ofreciendo 
configuraciones predeterminadas inteligentes y una 
autoconfiguración que reduce la necesidad de configuración manual. 
Con una integración pertfecta en el ecosistema de Spring Framework, 
facilita el desarrollo rápido al proporcionar una estructura de 
proyecto clara, empaquetamiento autónomo y un servidor web integrado. 
Además, promueve una convención sobre configuración y gestiona las
 dependencias de manera eficiente a través de "starters". En conjunto, 
Spring Boot permite a los desarrolladores centrarse en escribir 
código de aplicación, acelerando el proceso de desarrollo y 
simplificando la implementación de aplicaciones Java.


## Herramientas utilizadas

- Java
- Maven
- Intelij IDEA
- Git


## Creación del proyecto con Spring Initializr

Esta herramienta nos permite crear de una manera 
sencilla un proyecto spring el cual podemos seleccionar 
las dependencias, el lenguaje y gestor de paquetes a utilizar.

Para ello accedemos a start.spring.io 
En este caso seleccionamos Maven proyect, 
Lenguage Java, Versión, creamos el Group, Name
 y demás datos que nos pide para la creación del proyecto, 
al final tendremos para seleccionar el tipo de 
empaquetado (Jar o War), y la versión de Java a utilizar.
Al final podremos generar el proyecto el cual se descargará 
y posteriormente se podrá abrir con el IDE InteliJ.
Para comprobar la ejecución del proyecto nos paramos sobre el archivo,
 en este caso, DemoApplication, dar click derecho y darle a Run, 
en la terminal se podrá ver que se ejecuta correctamente.


## Proyecto

El proyecto servirá para realizar operaciones basicas de calculadora como suma y resta.
El objetivo es poder implementar servicios que puedan ser consumidos desde el browser.


### Properties

Dentro del archivo _application.properties_ se puede realizar configuraciones 
como asignar el puerto o un contextPath al cual poder 
acceder desde el Browser 
```bash
server.port=8080
server.servlet.context-path=/calculator
```
Desde el browser
```bash
http://localhost:8080/calculator/
```

### Anotaciones

SPRING se encarga de buscar todas las clases con
anotación @Configuration y ejecuta todos los
métodos @Bean para ir creando las instancias
de las clases que vayamos a utilizar durante
el aplicativo.
Luego de este paso ya se podría inyectar la
instancia dentro de cada uno de los controladores
que lo vayan a necesitar.

```bash
@Configuration
public class ApplicationConfig {
    @Bean
    public Calculator configCalculator() {
        System.out.println("Creando Bean calculator");
        return new Calculator();
    }
}
```
La clase Controller tendrá la anotación @RestController que se utiliza para crear controladores que manejan solicitudes HTTP RESTful, es decir, las solicitudes que tienen que ver con la manipulación y transferencia de datos en un formato específico (JSON o XML) a través de los métodos HTTP GET, POST, PUT, DELETE.

```bash
@RestController
public class AddController {

    public static final int FIRST_NUM = 100;
    public static final int SECOND_NUM = 50;

    @Autowired
    private Calculator calculator;

    public AddController() {

        System.out.println("Creando Controller Add");
    }

    @GetMapping("/servicio/sumar")
    public String sumar() {

        return "Sumando " + FIRST_NUM + " y " + SECOND_NUM + " da " + calculator.add(FIRST_NUM, SECOND_NUM);
    }
}
```

Los métodos que tienen la anotación @GetMapping definirán los endpoints y estarán disponibles para ser accedidos desde un browser o desde otras aplicaciones a través de solicitudes HTTP GET. El valor del path en @GetMapping determina la URL a la que se puede acceder para llamar al método correspondiente.
