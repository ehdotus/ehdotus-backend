ehdotus backend
===============

Backend for handling **ehdotus** queries.

Launch by typing "mvn spring-boot:run" from command line.

Listens (locally localhost:8080):

GET /api/difficulty
 - provides a JSON-formatted list of DifficultyData-entries in the database

POST /api/difficulty
 - expects JSON-formatted string of a DifficultyData-entry
 - assigns a difficulty to the item (when difficultyestimatorservice is done)
 - stores it to database
 - broadcasts it to others

Provides a WebSocket API that uses Stomp + SockJS for possible fallback; all
users can see the difficulties.

Overall flow of the application is as follows:

1. User/application/client makes a POST request to /api/difficulty
2. The controller at /api/difficulty receives the request, and passes it 
   to DifficultyEstimatorService, where difficulty processing is done
   asynchronously
3. When the Difficulty has been calculated, the DifficultyEstimatorService
   stores the data to the database with the result, and passes the data to
   DifficultyAnnouncer
4. DifficultyAnnouncer broadcasts a message to all clients that have signed
   up to watch the difficultycalculations (currently anyone who opens the
   root page for the app)

note: currently, the backend also publishes random content every 10 seconds.

Uses Java 8 to have a somewhat sensible date API.

Heroku-ready (not sure about this after the websocket addition :)).
