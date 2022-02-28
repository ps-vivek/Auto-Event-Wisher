Docker related setup in this repo was set up based on :
https://saeidfarahi.medium.com/get-started-with-spring-boot-mongodb-and-docker-compose-cfae8283ed1b

Install docker.

Navigate to root folder of property.

Run
docker network create love-network

docker-compose --env-file ".\mongodb\.env" build

docker-compose --env-file ".\mongodb\.env" up -d

----------------
Graphql queries:
----------------

Execute below end points to create an event config
----------------------

----------------------
| GRAPHQL - MUTATION  |
----------------------

--------------------------
| 1)Create single config |
--------------------------
curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"mutation createSingleEventConfig ($input: EventConfigDto) {\n    createSingleEventConfig (input: $input)\n}","variables":{"input":{"eventSenderConfig":{"senderFirstName":"Vivek","senderLastName":"Muralidharan"},"eventReceiverConfig":{"receiverFirstName":"Keshav","receiverLastName":"m","receiverPhoneNumber":"+1GOPACKGO","birthdayInfo":{"customBirthdayWish":"Many More happy returns of the day, Keshav!","receiverBirthDate":"2008-12-23"}}}}}

--------------------------------
| 2)Update single Event config |
-------------------------------
curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"mutation createSingleEventConfig ($input: EventConfigDto) {\n    createSingleEventConfig (input: $input)\n}","variables":{"input":{"id":"621be4040bf9735a2046f0a9","eventSenderConfig":{"senderFirstName":"Vivek","senderLastName":"Muralidharan"},"eventReceiverConfig":{"receiverFirstName":"Keshav","receiverLastName":"M","receiverPhoneNumber":"+1GOPACKGO","birthdayInfo":{"customBirthdayWish":"Many More happy returns of the day, Keshav!","receiverBirthDate":"2008-12-23"}}}}}'

----------------------------------
| 3)Create Multiple Event config |
----------------------------------
curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"mutation createMultiEventConfig ($input: [EventConfigDto]) {\n    createMultiEventConfig (input: $input)\n}","variables":{"input":[{"eventSenderConfig":{"senderFirstName":"Vivek","senderLastName":"M"},"eventReceiverConfig":{"receiverFirstName":"Favre","receiverLastName":"M","receiverPhoneNumber":"+1GOPACKGO","weddingAnniversaryInfo":{"customAnniversaryWish":"Happy anniversary!","receiverPartnerFirstName":"Nan","receiverPartnerLastName":"M","receiverAnniversaryDate":"2250-03-23"},"birthdayInfo":{"customBirthdayWish":"Happy birthday athimber","receiverBirthDate":"1979-07-25"}}},{"eventSenderConfig":{"senderFirstName":"Vivek","senderLastName":"Muralidharan"},"eventReceiverConfig":{"receiverFirstName":"Adithya Vardhan","receiverLastName":"Rodgers","receiverPhoneNumber":"+1GoPackGo","birthdayInfo":{"customBirthdayWish":"Wishing you many more happy returns of the day!","receiverBirthDate":"1919-12-03"}}}]}}'

--------------------------------
| 4)Delete Single Event config |
-------------------------------
curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"mutation DeleteEventConfig ($id: String) {\n    DeleteEventConfig (id: $id)\n}","variables":{"id":"621a33a85f0f35644e62af06"}}'

-------------------
| GRAPHQL - QUERY |
-------------------
-----------------------------
| 1)Query All Event Configs |
-----------------------------
curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"query findAllEvents {\n    findAllEvents {\n        id\n        senderFirstName\n        senderPhoneNumber\n        receiverFirstName\n        receiverPhoneNumber\n        receiverAnniversaryDate\n        receiverBirthDate\n    }\n}","variables":{}}'

-------------------------------
| 2)Query Single Event Config |
-------------------------------
curl --location --request POST 'http://localhost:port/apis/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"query findEventById ($id: String) {\n    findEventById (id: $id) {\n        id\n        senderFirstName\n        senderPhoneNumber\n        receiverFirstName\n        receiverPhoneNumber\n        receiverAnniversaryDate\n        receiverBirthDate\n    }\n}","variables":{"id":"621a33a85f0f35644e62af06"}}'


Once an event is configured, a scheduler will run daily and send out text messages to number configured with custom messages if the current day happens to be the event day.