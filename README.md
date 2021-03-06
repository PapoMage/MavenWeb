﻿## Tech Blog

![Image of inicio](src/main/webapp/images/logo.png)

**Descripcion:**
Trabajo práctico del sexto cuatrimestre de la Escuela DaVinci desarrollado con *Maven*, *JSF* y un maquetado con *Materialize*.
La pagina ofrece un sistema de *login*, *registro* y la posibilidad que los usuarios suban posts y puedan ver los que subieron.
Todo esto se realiza mediante conexiones a una Base de datos *SQL* y con el modelo de la misma generada por *Entities*.
Es una red social que cuenta con subida de posts con o sin imagenes, buscador de usuarios, actualizacion de perfil, seguir usuarios,
agregar post favoritos, comentar posts, etc

**Tecnologias usadas:**
Maven, Tomee, Materialize y Java

Login:

![Image of inicio](src/main/webapp/images/Captura5.JPG)


Registro:

![Image of inicio](src/main/webapp/images/Captura6.JPG)



Home:

![Image of inicio](src/main/webapp/images/Captura1.PNG)



Comentarios:

![Image of inicio](src/main/webapp/images/Captura3.PNG)



Perfil:

![Image of inicio](src/main/webapp/images/Captura4.PNG)



Menu:

![Image of inicio](src/main/webapp/images/Captura2.PNG)

**¿Como utilizo este proyecto?**
Para que el proyecto se conecte con *Maven* y haga la conexion con la Base de datos es necesario seguir los siguientes pasos:
1) En la consola del Sistema (CMD en Windows) ubicarse en la ruta del proyecto.
2) Ingresar el siguiente comando Maven: 
  *mvn clean package tomee:run*
3) Una vez finalizada la carga ingresar en el navegador web debes ingresar en la URL:
  *localhost:8080/index.xhtml*
  Esto te redireccionara al index de la WEB.

Codigo SQL Acceso a la BD:

CREATE DATABASE blog_maven;
GRANT USAGE ON *.* TO mbobbio@localhost IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON blog_maven.* TO mbobbio@localhost;
