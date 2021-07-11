######################## TWITTER CHALENGE INFO ########################

La aplicación se puede lanzar en 2 modos, con el modo streaming encendido o apagado, en función de los argumentos con los que se arranque:
	- Streaming encendido: Lanzar la aplicación con el argumento "stream". 
	- Streaming apagado: Lanzar la aplicación sin el argumento "stream".
	
La configuración de las claves y tokens de acceso para conectar con el API de Twitter se encuentra ubicada en el fichero src\main\resources\commons\twitter4j.properties. 
Para que la aplicación funcione en modo streaming es imprescindible realizar esta configuración correctamente.
	
La base de datos está configurada para que los datos se queden almacenados y no se pierdan al parar la aplicación. Estará accesible con la 
aplicación arrancada en la url http://localhost:7070/twitter-challenge/h2-console/, con la siguiente configuración de acceso:
	- Driver Class: 	org.h2.Driver
	- JDBC URL: 		jdbc:h2:file:./data/demo
	- User Name:		sa
	- Password:
	
Los servicios están publicados bajo API swagger, accesible en la ruta http://localhost:7070/twitter-challenge/swagger-ui/index.html#/

