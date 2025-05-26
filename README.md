# NAME AND COUNTRY PREDICTOR
This Java application connects to Nationalize.io REST API to predict the most likely countries associated with a given first name.

It uses:

- HttpURLConnection to make GET requests

- Gson library to parse the JSON response

- Standard Java classes to build and display results in a readable format



### Technologies used

Java 17

Maven

REST API (GET request)

JSON parsing with Gson

IntelliJ IDEA


### How it works
1. The user enters a First Name 
2. The app makes a GET request to:https://api.nationalize.io?name=yourname
3. The JSON response is parsed and displayed like this:
4. 
5. Όνομα: maria  
Χώρα: GR (πιθανότητα: 0.972)  
Χώρα: IT (πιθανότητα: 0.012)  

...


### How to Run
Clone this repo

Make sure you have Java & Maven installed

Run from terminal or inside IntelliJ:
mvn compile
mvn exec:java -Dexec.mainClass="com.irotr.NameAnalyzer"


### Author
Made as an exercise by @IroTragianou


### If you found this useful leave a star.
