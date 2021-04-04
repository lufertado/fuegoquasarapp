# Fuego Quasar App

This is a springboot application to determine the location of a ship and the message it emits, based on the information
that 3 satellites
(Kenoby, Skywalker and Sato) receives from it (distance and message).


### How to run
Run the following command in the root of the project:

`gradlew clean build -x test`

Then, go to `/build/libs` folder and run the following command to start the SpringBoot app:

`java -jar fuegoquasarapp-1.0-SNAPSHOT.jar   `

### API

####1. Top secret:
   It receives a list of satellites in which each satellite has a name, the distance to the ship and the message it
   receives.

Url: 
`POST /topsecret`

Request:

      {
         "satellites":[`
            {
               "name":"kenobi",
               "distance":100.0,
               "message":[
                  "este",
                  "",
                  "",
                  "mensaje",
                  ""
               ]
            },
            {
               "name":"skywalker",
               "distance":115.5,
               "message":[
                  "",
                  "es",
                  "",
                  "",
                  "secreto"
               ]
            },
            {
               "name":"sato",
               "distance":142.7,
               "message":[
                  "este",
                  "",
                  "un",
                  "",
                  ""
               ]
            }
         ]
      }

Response:`200 OK`

      {
         "position": {
            "x": 1.0917619707373333E8,
            "y": 2.181939473272E8
         },
         "message": "este es un mensaje secreto"
      }


####2. Top secret Split (POST):
   Receives a satellite name in the path of the URL and the distance and message
   from that satellite in the body of the request.

Url: 
`POST /topsecret_split`

Request:

      {
         "distance":100.0,
         "message":[
            "este",
            "",
            "",
            "mensaje",
            ""
         ]
      }

####3. Top secret Split (GET):
   Retrieves ship location and message if info from 3 satellites is available (setted before with
   /topsecret_split POST endpoint), otherwise it returns error code 404 indicating there is not enough information..

Url:
`GET /topsecret_split`

Request:

      {
         "distance":100.0,
         "message":[
            "este",
            "",
            "",
            "mensaje",
            ""
         ]
      }

Response: 

`200 OK`

      {
         "position": {
            "x": 1.0917619707373333E8,
            "y": 2.181939473272E8
         },
         "message": "este es un mensaje secreto"
      }

   `400 BAD REQUEST`

      {
          "message": "There's no enough information (satellites) to calculate ship information"
      }