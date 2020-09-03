
# backend
run the ./gradlew build (ensuring you have java 11 or above)
install postgres 10
The API will generate the tables you need based on the DB runtime arguments below. Make sure you have configurated them to match your installation.
Make sure it runs on localhost 8080 as the frontend is configured to expect this.
java -jar -DdBURL=jdbc:postgresql://localhost:5432/ -DdbUser=postgres -DdbPassword=root target/bookstoreapi-0.0.1-SNAPSHOT.jar

You can also open the backend from Intellij and Spring boot will autoconfigure with the IDE to run. Just make sure to include the runtime arguments

# frontend
Angular from the /bookstore-app folder run:
ng serve --proxy-config proxy.config.json
You can then see the site on http://localhost:4200/