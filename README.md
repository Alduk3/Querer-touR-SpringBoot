# Querer-touR

QuerertouR es una guía interactiva para explorar los pueblos y sitios de interés del departamento de Antioquia, Colombia. Dirigido a turistas y residentes, ofrece información detallada para planificar y disfrutar de experiencias turísticas locales de manera fácil y eficiente.

## Nuestro propósito

QuerertouR nace de la necesidad de brindar visibilidad a los pueblos del departamento de Antioquia y algunos sitios de interés de Medellín de una manera diferente, ya que utiliza puntos físicos estratégicos para acceder a la información de dichos lugares. 
Como estrategia para cumplir dicho objetivo, inicialmente, el primer acercamiento al aplicativo se da por medio de los códigos QR ubicados en las principales terminales aéreas de Antioquia y en las terminales terrestres de los pueblos del departamento de Antioquia. También habrá un QR diferente al de las terminales, ubicado en el parque principal de cada pueblo del departamento de Antioquia y en los sitios de interés que ofrece la aplicación.
Además de ofrecer visibilidad de dichos lugares, se busca  fomentar el comercio local de los pequeños negocios y emprendimientos locales poco conocidos que se encuentran en los pueblos del departamento de Antioquia

## Nuestro Objetivo

QuerertouR tiene como objetivo ser una ayuda y/o guía interactiva tanto para los turistas nacionales e internacionales como para los habitantes locales que tienen interés en visitar los pueblos del departamento de Antioquia con sus respectivos sitios de interés y algunos sitios de la ciudad de Medellín, y de esta manera, promover el turismo cultural, ecológico y social.
Además, busca brindar visibilidad de los comercios locales poco conocidos en los pueblos del departamento de Antioquia, fomentando así el comercio local.

## Para quién estamos creando valor

En primera instancia la aplicación web está dirigida a turistas nacionales e internacionales, pero también será de utilidad para los habitantes locales para obtener información y sitios de interés acerca de los pueblos del departamento de Antioquia.

## Integrantes

- Carolina Garcia
- Santiago Echeverry
- Alejandro Duque
- Darwing Mosquera

## Paso a Paso 

### 1. Configuracion Base de Datos

```MySql
CREATE DATABASE querertour_api_db;
```

> [!WARNING]
> Si estas en windows asegurate de tener instalado y activado el XAMPP 

## Modelo o diseño del proyecto

### Modelo Base de Datos

```mermaid
 erDiagram
 TOWN ||--o{ SITE : has
 TOWN{
 UUID id
 String name
 String img
 String audio
 String location
 String description
 String short_description
 String QR
 }
 SITE||--o{ COMPANY_BRANCH: located
SITE {
UUID id
String name
String audio
String location
String description
String id_town
String QR
}
COMPANY||--o{ COMPANY_BRANCH: has
COMPANY {
Int id
String nit
String name
String phone
String address
String email
String area
}
COMPANY_BRANCH {
UUID id
String name
String id_site
String id_company
String QR
}
USER||--o{ COMMENT: has
USER {
Int id
 String name
 String document_type
 String document
 String last_name
 String email
 String password
 String rol
}
COMMENT{
Int id
String comment
String img
String rating
String creation_date
Int id_user
Int id_where
}

```
### Modelo UML de clases

> [!Note]
> Se agregara una vez se termine el trabajo

### Modelo Arquitectura de componentes

#### Arquitectura de microservicios
```mermaid
graph LR
A(Client) --> B(JWT)
B --> C(NestJs)
C --> D[(Mongo DB)]
B --> H([JWT Secret])
E --> H
A --> E(Spring Secure)
E --> F(Spring Boot)
F --> G[(MySQL)]
```

#### Arquitectura Hexagonal
##### NestJs
```Markdown
src/
 ├── app/
 │ ├── module/
 │ │ ├── application/
 │ │ │ ├── command/
 │ │ │ ├── query/
 │ │ │ └── handler/
 │ │ ├── domain/
 │ │ │ ├── model/
 │ │ │ ├── service/
 │ │ │ └── repository/
 │ │ └── infrastructure/
 │ │ ├── repository/
 │ │ └── config/
 │ └── shared/
 │ └── utils/
 └── main.ts
```

##### Spring Boot
```Markdown
src/
└── main/
    ├── java/
	│   └── com/
	│       └── riwi/
	│           └── querer-tour/
	│               ├── querer-tourApp.java
	│               ├── domain/
	│               │   ├── entities/
	│               │   └── repositories/
	│               ├── api/
	│               │   ├── controllers/
	│               │   ├── dto/
	│               │   └── error_handler/
	│               ├── infrastructure/
	│               │   ├── abstract_services/
	│               │   ├── services/
	│               │   └── helpers/
	│               ├── util/
	│               │   ├── enums/
	│               │   └── exceptions/
	│               └── config/
    └── resources/
				├── application.properties
				├── configs/
				└── email/
```

## Levantamiento de Requisitos

> [!Note]
> Se tiene en documento, falta agregar al README

## Tablero de gestion de proyectos

Como equipo decidimos usar Notion como gestor de proyecto [Tablero](https://notion.io)

## Documentación de los endpoints (Swagger)

> [!Note]
> Se agregara una vez se termine el trabajo