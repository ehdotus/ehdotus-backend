ehdotus backend
===============

Backend for handling **ehdotus** queries.

Launch by typing "mvn spring-boot:run" from command line.

Listens (locally localhost:8080):

GET /difficulty
 - provides a JSON-formatted list of Difficulty-entries in the database

POST /difficulty
 - expects JSON-formatted string of a Difficulty-entry
 - randomly assigns a difficulty to the item
 - stores it to database
 - returns it for processing

Uses Java 8 to have a somewhat sensible date API.

Heroku-ready.
