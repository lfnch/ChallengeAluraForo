# ChallengeAluraForo 28/11/2024

## Introducción.

¡Bienvenido al Challenge Back End de Alura! En este reto, replicaremos el funcionamiento interno de un 
foro a nivel de back-end, desarrollando una API REST con Spring. Este proyecto, llamado Foro Hub,
se centrará en la gestión de tópicos, permitiendo a los usuarios crear, visualizar, actualizar 
y eliminar tópicos mediante operaciones CRUD. Además, integraremos validaciones de negocio, 
persistencia de datos en una base de datos y un sistema de autenticación para garantizar la seguridad.
¡Prepárate para profundizar en la construcción de APIs siguiendo las mejores prácticas!

## Indice.
1.[ Contexto de negocio.](#1-contexto-de-negocio)

2.[ Visión de la solución.](#2-visión-de-la-solución)

3.[ Alcance y limitaciones.](#3-alcance-y-limitaciones)

4.[ Contexto del sistema.](#4-contexto-del-sistema)

5.[ Informacion adiccional.](#5-informacion-adiccional)

## 1 Contexto de negocio

### 1.1 Antecedentes

Un foro es un espacio donde los participantes de una plataforma comparten preguntas y respuestas
sobre temas específicos. En Alura, el foro es una herramienta esencial para que estudiantes,
 profesores y moderadores colaboren y resuelvan dudas relacionadas con cursos y proyectos.

Aunque estamos familiarizados con su propósito y apariencia, entender su funcionamiento 
interno plantea preguntas clave: ¿dónde se almacenan las informaciones? ¿Cómo se relacionan 
los tópicos con sus respuestas? ¿De qué manera los usuarios interactúan con estas estructuras de datos?

Este proyecto, llamado Foro Hub, surge como un desafío para replicar, a nivel de back-end, 
los procesos que hacen posible un foro funcional. Utilizando Spring, desarrollaremos una API REST 
centrada en la gestión de tópicos, implementando funcionalidades CRUD, validaciones, 
persistencia de datos y un sistema de autenticación. Este proyecto busca no solo crear 
una API funcional, sino también adoptar las mejores prácticas del modelo REST y herramientas 
modernas para simplificar el desarrollo.

### 1.2. Frase del problema.
¿Cómo diseñar y desarrollar una API REST eficiente y segura, utilizando Spring, 
que gestione tópicos en un foro, permitiendo operaciones CRUD, validando reglas de negocio, 
asegurando la persistencia de datos y restringiendo el acceso mediante autenticación y autorización?

### 1.3 Objectivos del negocio

| Objectivo         |Descripción del objetivo de negocio                                 |
| ----------------- | ------------------------------------------------------------------ |
| on-1              | Crear un nuevo tópico    |
| on-2              | Mostrar todos los tópicos creados    |
| on-3              | Mostrar un tópico específico    |
| on-4              | Actualizar un tópico   |
| on-5              | Eliminar un tópico    |

ob -> objectivo del negocio


## 2 Visión de la solución

### 2.1 Frase de Vision

Desarrollar una API REST robusta y escalable, basada en Spring, que permita gestionar tópicos en un foro con operaciones CRUD, 
validaciones de negocio, persistencia confiable y un sistema de autenticación y autorización, promoviendo buenas prácticas de desarrollo 
y facilitando la colaboración entre usuarios.

### 2.2 Caracteristicas del sistema

| Caracteristica|Descripción|Prioridad|
| --------| --------| --------|
| crs-01| Tecnologias open source  | alta |
| crs-02| Requiere acceso a internet | alta |
| crs-03| Independiente de plataforma (windows, linux, etc) | alta |
| crs-04| Rapido, distribuido, escalable | alta |
| crs-05| Persistencia de los datos | alta |
| crs-06| Ingreso por medio de EndPoins | alta |
| crs-07| Consulta y filtrado personalizado | alta |

crs -> Caracteristica del sistema.

## 3 Alcance y limitaciones

### 3.1 Alcance

| Número de reléase|Tema principal|
| --------| --------|
| Version 1.0| Funcionalidad completa sobre los objectivos de negocio |

## 4 Contexto del sistema

### 4.1 Resumen de involucrados

| Nombre|Descripción|Responsabilidades|
| --------| --------| --------|
| Luis Felipe Nieves Ch.| Analista y Desarrollador de sistemas de Información grupo G7 | Analista y Desarrollador el sistema |

### 4.2 Diagramas de Contexto


### 4.3 Entorno de operacion

- Lenguaje: Java
- IDE: IntelliJ IDEA / Eclipse
- Dependencias: Maven
- JSON: Jackson
- Base de Datos: MariaDb
- Framework : Spring Boot
- Sistema Operativo: Multiplataforma
- Control de Versiones: Git

## 5 Informacion adiccional

Licencia MIT

Copyright (c) 2024, LUIS FELIPE NIEVES CH.

Por la presente se concede permiso, de forma gratuita, a cualquier persona que obtenga una copia
de este software y los archivos de documentación asociados (el "Software"), para utilizar
el Software sin restricción, incluyendo sin limitación los derechos para usar, copiar, modificar,
fusionar, publicar, distribuir, sublicenciar y/o vender copias del Software, y para permitir a las
personas a las que se les proporcione el Software hacerlo, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las copias o partes sustanciales
del Software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O IMPLÍCITA,
INCLUYENDO PERO NO LIMITADO A GARANTÍAS DE COMERCIALIZACIÓN, IDONEIDAD PARA UN PROPÓSITO PARTICULAR
Y NO INFRACCIÓN. EN NINGÚN CASO LOS AUTORES O TITULARES DEL COPYRIGHT SERÁN RESPONSABLES DE
NINGUNA RECLAMACIÓN, DAÑO U OTRA RESPONSABILIDAD, YA SEA EN UNA ACCIÓN CONTRACTUAL, EXTRACONTRACTUAL
O DE OTRO TIPO, QUE SURJA DE, O EN CONEXIÓN CON EL SOFTWARE O EL USO U OTROS TRATOS EN EL
SOFTWARE.