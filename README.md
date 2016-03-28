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

http://localhost:9999/accommodation 			ok
http://localhost:9999/alimentation				ok
http://localhost:9999/ecotour					ok
http://localhost:9999/items						ok
http://localhost:9999/items/1					ok
http://localhost:9999/items/1/content			ok
http://localhost:9999/items/1/conversations		ok
http://localhost:9999/items/1/scores			ok
http://localhost:9999/people					ok
http://localhost:9999/people/1					ok
http://localhost:9999/shoppingCart				ok
http://localhost:9999/shoppingCart/2			ok
http://localhost:9999/suppliers					ok
http://localhost:9999/transport					ok


#5. Probar los métodos POST

--POST Person min-params	ok
curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"Supplier\",\"jobTitle\":\"OtherTitle\",\"role\":\"SUPPLIER\"}} http://localhost:9999/people

--POST Person full-params	ok
curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"CurlTest\",\"jobTitle\":\"CurlTest\",\"role\":\"USER\",\"username\":\"CurlTest\",\"password\":\"CurlTest\",\"address\":\"CurlTest\",\"email\":\"CurlTest\"}} http://localhost:9999/people

--POST Item basic			ok
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"BASIC\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"parent\":null}} http://localhost:9999/items

--POST Accommodation		ok
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"ACCOMMODATION\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"parent\":null,\"accommodationType\":\"DOUBLE\",\"city\":\"BOGOTA\",\"country\":\"COLOMBIA\",\"hotelName\":\"hotel1\",\"numberOfRooms\":\"4\"}} http://localhost:9999/accommodation

--POST Alimentation			ok
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"ALIMENTATION\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"parent\":null,\"alimentationType\":\"LUNCH\",\"calories\":\"2000\"}} http://localhost:9999/alimentation

--POST Transport			ok
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"TRANSPORT\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"parent\":null,\"type\":\"TAXY\",\"origin\":\"originText\",\"destination\":\"destinationText\",\"initialHour\":\"8am\",\"finalHour\":\"8pm\"}} http://localhost:9999/transport

--POST Ecotour				ok
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"ECOTOUR\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"parent\":null,\"ecoTourType\":\"HIKING\",\"itinerary\":\"itineraryText\"}} http://localhost:9999/ecotour

--POST Item Package			ok
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"BASIC\",\"itemType\":\"PACKAGE\",\"status\":\"HIDDEN\",\"name\":\"Tour1\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"parent\":null}} http://localhost:9999/items

--POST Package Detail - ADD New Item 			ok
curl -H "Content-Type: application/json" -X POST -d {\"category\":\"ECOTOUR\",\"itemType\":\"SINGLE\",\"status\":\"HIDDEN\",\"name\":\"SubTour2\",\"description\":\"Tour1Description\",\"price\":450000,\"score\":5,\"supplier\":{\"id\":1},\"tags\":null,\"urlImage\":\"http://lorempixel.com/300/300/nature/\",\"contentType\":\"IMAGE_PNG\",\"parent\":{\"itemId\":218},\"ecoTourType\":\"HIKING\",\"itinerary\":\"itineraryText\"}} http://localhost:9999/ecotour

--POST ShoppingCart			ok
curl -H "Content-Type: application/json" -X POST -d {\"type\":\"PURSHASE\",\"status\":\"NEW\",\"customer\":{\"id\":2},\"dateTransaction\":\"2016-03-13\"} http://localhost:9999/shoppingCart

--POST ShoppingCartDetail	NO
curl -H "Content-Type: application/json" -X POST -d {\"transaction\":{\"id\":2},\"item\":{\"itemId\":1},\"price\":10,\"quantity\":2} http://localhost:9999/shoppingCart/2/detail

--POST Supplier\			ok
curl -H "Content-Type: application/json" -X POST -d {\"fullName\":\"gerson\",\"jobTitle\":\"OtherTitle\",\"role\":\"SUPPLIER\"}} http://localhost:9999/suppliers

--POST Conversation			ok
curl -H "Content-Type: application/json" -X POST -d {\"conversationtype\":\"ANSWER\",\"entry\":\"hola2\",\"dateEntry\":\"2016-03-24\",\"author\":{\"id\":1},\"item\":{\"itemId\":1}}} http://localhost:9999/items/2/conversations

--POST ItemContent			ok
curl -H "Content-Type: application/json" -X POST -d {\"name\":\"foto1\",\"url\":\"httpLocation\",\"contentType\":\"IMAGE_PNG\",\"item\":{\"itemId\":1}}} http://localhost:9999/items/2/content

--POST ItemScore (comment)	ok
curl -H "Content-Type: application/json" -X POST -d {\"text\":\"Elmejorproducto\",\"score\":5,\"dateEntry\":\"2016-02-24\",\"item\":{\"itemId\":1},\"author\":{\"id\":1}}} http://localhost:9999/items/2/scores

--POST ChangeTransactionStatus
curl -X POST http://localhost:9999/shoppingCart/2/changeStatusPurshased
curl -X POST http://localhost:9999/shoppingCart/2/changeStatusNew
curl -X POST http://localhost:9999/shoppingCart/2/changeStatusRejected
curl -X POST http://localhost:9999/shoppingCart/2/changeStatusValidated

--POST ChangeItemStatus
curl -X POST http://localhost:9999/items/2/publishItem
curl -X POST http://localhost:9999/items/2/hiddeItem

--POST Login -- FALTA!!!
curl -X POST http://localhost:9999/login

\"\":\"\",


Notas:

1. Para importar el driver de oracle al repositorio local

mvn install:install-file -Dfile=C:\Users\alejo\sw\sqldeveloper\jdbc\lib\ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar