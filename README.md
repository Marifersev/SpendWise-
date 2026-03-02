Nombre del proyecto: SpendWise
Descripcion: SpendWise es una sencilla aplicación en Java para registrar pequeños gastos diarios. Ayuda a los usuarios a controlar sus hábitos de gasto y a gestionar presupuestos de manera eficaz.
Que hace: Registrar gastos diarios, Categorizar gastos (comida, transporte, entretenimiento, etc.), Ver el gasto total a lo largo del tiempo, Almacenamiento persistente usando una base de datos
Tecnologias usadas:Java, Spring Boot, Database: H2
Estructura:
SpendWise_app/
├─ .mvn/
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ com/example/SpendWise_app/
│  │  │      ├─ modelos/
│  │  │      │   ├─ Categoria.java
│  │  │      │   ├─ Comercio.java
│  │  │      │   ├─ Gastos.java
│  │  │      │   ├─ MedioPago.java
│  │  │      │   ├─ Usuario.java
│  │  │      ├─ SpendWiseAppApplication.java
│  │  ├─ resources/
│  │  └─ test/
├─ target/
├─ .gitattributes
├─ .gitignore
├─ HELP.md
├─ mvnw
├─ mvnw.cmd
└─ pom.xml
