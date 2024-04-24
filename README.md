## Tecnologías utilizadas

* Lenguaje de programación: Java
* Entorno de desarrollo integrado (IDE): Visual Studio Code
* Kit de desarrollo de Java (JDK): OpenJDK 21
* Versión de Java: 21.0.2
* Framework de pruebas: JUnit 5

## Descripción del proyecto

AlkeWallet es un proyecto de billetera digital que permite a los usuarios realizar diversas operaciones bancarias de manera segura y eficiente. Este proyecto ha sido desarrollado utilizando Java y se ha estructurado en varias clases y una interfaz para facilitar la comprensión y el mantenimiento del código.

La clase `Usuario` es la clase padre que representa a un usuario de la billetera digital. Cada usuario tiene una `Cuenta`, que es una clase hija de `Usuario`. La `Cuenta` contiene un atributo de la clase `Moneda`, que representa la cantidad de dinero que el usuario tiene en su billetera.

Además, hemos implementado una interfaz `OperacionBancaria` en la clase `Cuenta`. Esta interfaz define las operaciones bancarias que un usuario puede realizar, como depositar y retirar dinero.

El punto de entrada de la aplicación es la clase `WalletApp`, que contiene el método `main()`. Esta clase se encarga de iniciar la aplicación y gestionar las interacciones del usuario.