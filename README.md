# EcoTouring

# Pasos para correr el código:

0. Descargar el directorio al git local

1. Ubicarse en la carpeta del proyecto

cd ..\dropwizard-EcoOracle

2. Limpiar y compilar

mvn clean
mvn package

3. Correr el fat jar que levanta el servidor 

java -jar target/dropwizard-EcoTouring-1.0.0-SNAPSHOT.jar server produccion.yml

4. Probar cada una de las siguientes peticiones GET

http://localhost:8080/people
http://localhost:8080/people/2/view_freemarker
http://localhost:8080/items
http://localhost:8080/item/1
http://localhost:8080/suppliers
http://localhost:8080/categories

http://localhost:8080/people/2/shoppingCart
http://localhost:8080/people/2/shoppingCart/2
http://localhost:8080/item/1/conversations
http://localhost:8080/item/1/scores
http://localhost:8080/item/1/content

5. Probar los métodos POST

curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"gerson\",\"jobTitle\":\"OtherTitle\"}} http://localhost:8080/people

Notas:

1. Para importar el driver de oracle al repositorio local

mvn install:install-file -Dfile=C:\Users\alejo\sw\sqldeveloper\jdbc\lib\ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar