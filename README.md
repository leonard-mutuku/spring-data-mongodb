# spring-data-mongodb

spring boot application for storing and retrieving data from mongodb. Application exposes rest api with crud operations for user that is used to interact with mongo db.

Mongo is configured in either application properties (spring.data.mongodb.*) or MongoConfig.class in cofig package. The application automatically creates a user_collection with indexs configured in the user.class model or the mongoConfig.class. The index are responsible for data expiration and sort by name.


