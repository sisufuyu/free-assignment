# free-assignment

This repository is for Java Spring-boot assignment from https://free.fi/. 

## Requirements
For building and running the application you need:
- Java 17
- Java IDE(for example Eclipse)
- Maven 3

## Development Environment Setup
This project fetchs exchange rates from https://apilayer.com/marketplace/exchangerates_data-api, subscribes to it and get your own API Key and create a .env file with 
APIKEY=yourownkey. Put the .env file into the root directory of project. 

## Run the project locally
* **Using Eclipse**
1. **Download** and unzip the source repositoryor **clone** git repository:
      ```git clone https://github.com:sisufuyu/free-assignment.git```

2. **Start** eclipse

3. **Import** maven project into eclipse by **select** _"File" &#8594; "Import..."_<br>

4. **Write** "maven" in _"Select an import source"_ field, **select** _"Existing Maven Projects"_ and then **click** on _"Next >"_<br>

5. **Browse** to the directory where you save the project and then **click** on _"Finish"_<br>

6. **Click** right mouse button on the FreeAssignmentApplication.java and **click** on "Run As" -> "Java Application"

* **Using Docker**
The project is dockerized also, you can pull it:
``` docker pull sisufuyu/free-assignment:latest ```
and run it:
``` docker run -p8000:8080 sisufuyu/free-assignment:latest ```

## Postman examples
The project has two endpoints:
* POST validate_ssn
    * Request
        * ssn and country_code as input parameter in JSON body
        * Only supports country_code: FI supported currently
    * Response
        * ssn_valid (true/false)
![image](https://user-images.githubusercontent.com/20355911/231526842-61b7c1c7-331a-41fd-afbf-e38eb46d5c4d.png)

* GET exchange_amount
    * EUR, SEK and USD supported now
    * Request
        * from
        * to
        * from_amount
    * Response
        * from
        * to
        * to_amount
        * exchange_rate
![image](https://user-images.githubusercontent.com/20355911/231528256-87d8978c-7396-462e-b397-7bc8520b7066.png)

* Scheduled execution of exchange rate update every one hour

    
