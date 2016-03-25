# EcoTouring

# Pasos para correr el código:

0. Descargar el directorio al git local

#1. Ubicarse en la carpeta del proyecto

cd ..\dropwizard-EcoOracle

#2. Limpiar y compilar

mvn clean
mvn package

#3. Correr el fat jar que levanta el servidor 

java -jar target/dropwizard-EcoTouring-1.0.0-SNAPSHOT.jar server produccion.yml

#4. Probar cada una de las siguientes peticiones GET

http://localhost:9999/people
http://localhost:9999/people/2/view_freemarker
http://localhost:9999/items
http://localhost:9999/items/1
http://localhost:9999/suppliers
http://localhost:9999/categories

http://localhost:9999/people/2/shoppingCart
http://localhost:9999/people/2/shoppingCart/2
http://localhost:9999/items/1/conversations
http://localhost:9999/items/1/scores
http://localhost:9999/items/1/content


*    POST    /items/{itemId} (uniandes.fabricasw.ecotouring.resources.ItemResource)
*    GET     /items/{itemId}/shoppingCart (uniandes.fabricasw.ecotouring.resources.ItemResource)


#5. Probar los métodos POST

--Min params
curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"Supplier\",\"jobTitle\":\"OtherTitle\",\"role\":\"SUPPLIER\"}} http://localhost:9999/people

--Max params
curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"CurlTest\",\"jobTitle\":\"CurlTest\",\"role\":\"USER\",\"category\":null,\"username\":\"CurlTest\",\"password\":\"CurlTest\",\"address\":\"CurlTest\",\"email\":\"CurlTest\"}} http://localhost:9999/people

curl -H "Content-Type: application/json" -X POST -d {\"name\":\"newCategory\"} http://localhost:9999/categories

--Item básico
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"BASIC\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"item\":null}} http://localhost:9999/items
--Alojamiento
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"ACCOMMODATION\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"item\":null,\"accommodationType\":\"DOUBLE\",\"city\":\"BOGOTA\",\"country\":\"COLOMBIA\",\"hotelName\":\"hotel1\",\"numberOfRooms\":\"4\"}} http://localhost:9999/accommodation
--Alimentación
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"ALIMENTATION\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"item\":null,\"alimentationType\":\"LUNCH\",\"calories\":\"2000\"}} http://localhost:9999/alimentation
--Transporte
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"TRANSPORT\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"item\":null,\"type\":\"TAXY\",\"origin\":\"originText\",\"destination\":\"destinationText\",\"initialHour\":\"8am\",\"finalHour\":\"8pm\"}} http://localhost:9999/transport
--Ecotour
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"ECOTOUR\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"item\":null,\"ecoTourType\":\"HIKING\",\"itinerary\":\"itineraryText\"}} http://localhost:9999/ecotour

\"\":\"\",

curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"gerson\",\"jobTitle\":\"OtherTitle\"}} http://localhost:9999/suppliers

curl -H "Content-Type: application/json" -X POST -d {\"conversationtype\":\"ANSWER\",\"entry\":\"hola2\",\"dateEntry\":\"2016-03-24\",\"author\":{\"id\":1},\"item\":{\"itemId\":1}}} http://localhost:9999/items/2/conversations

curl -H "Content-Type: application/json" -X POST -d {\"name\":\"foto1\",\"url\":\"httpLocation\",\"contentType\":\"IMAGE_PNG\",\"item\":{\"itemId\":1}}} http://localhost:9999/items/2/content

curl -H "Content-Type: application/json" -X POST -d {\"text\":\"Elmejorproducto\",\"score\":5,\"dateEntry\":\"2016-02-24\",\"item\":{\"itemId\":1},\"author\":{\"id\":1}}} http://localhost:9999/items/2/scores


curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"gerson\",\"jobTitle\":\"OtherTitle\"}} http://localhost:9999/people/2/shoppingcart
curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"gerson\",\"jobTitle\":\"OtherTitle\"}} http://localhost:9999/people/2/shoppingcart/2/item/ 

Notas:

1. Para importar el driver de oracle al repositorio local

mvn install:install-file -Dfile=C:\Users\alejo\sw\sqldeveloper\jdbc\lib\ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar