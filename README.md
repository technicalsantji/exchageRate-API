Visit the Spring Initializer website.

Fill in the project details:

Project: Select "Maven" or "Gradle" based on your preference.
Language: Choose "Java" from the dropdown.
Spring Boot: Choose the desired version.
Project Metadata:
Group: Your project's group identifier (e.g., com.example).
Artifact: Your project's artifact identifier (e.g., my-rest-api).
Name: Your project name (e.g., MyRestAPI).
Description: A brief description of your project.
Package Name: Package name for your Java classes (e.g., com.example.myrestapi).
Select the dependencies you need:

For your assignment, include:
Spring Web: For building the RESTful API.
Spring Data MongoDB: For interacting with MongoDB.
Spring Boot DevTools: Optional, for development convenience.
Spring Scheduler: For scheduling tasks.
Click the "Generate" button.

Download the generated ZIP file and extract it to your desired location.

Open the project in your preferred IDE (Eclipse, IntelliJ, etc.) or use a text editor.

## Design Patterns Implemented

- **Scheduler Pattern:**
  - Quartz Scheduler is employed to fetch and store exchange rates at scheduled intervals.

- **Repository Pattern:**
  - MongoDB repository (`ExchangeRateRepository`) is used for data access.

## External APIs

- The application interacts with an external exchange rate API to retrieve the latest rates.

## Future Enhancements

- Implement additional endpoints for more comprehensive exchange rate functionalities.
- Enhance error handling and logging.
- Add user authentication and authorization for secure endpoints.

## Contributing

Feel free to contribute to the project by opening issues or submitting pull requests.

## License

This project is licensed under the [MIT License](LICENSE).

---

**Note:** Replace the [LICENSE](LICENSE) link with the actual link to your license file.

## Acknowledgements

Special thanks to the Spring Boot and Quartz communities for their excellent documentation and support.

## Contact

For any inquiries or feedback, please contact sant kumar via email: your.santkumar11032000@gmail.com.

---

**Note:** Replace "sant kumar" and santkumar11032000@gmail.com" with your actual name and email address.



# ExchangeRate API Test Document

## 1. Testing Objectives

The main objectives of testing the ExchangeRate API are to ensure:

- Proper functionality of CRUD operations for exchange rate entries.
- Accuracy in calculating percentage differences for various time periods.
- Integration with external APIs to fetch historical exchange rate data.
- Adherence to the specified requirements and design patterns.

## 2. Test Scenarios

### 2.1 CRUD Operations

#### 2.1.1 Scenario: Add Exchange Rate Entry
- **Objective:** Verify that a new exchange rate entry can be added successfully.
- **Steps:**
  1. Send a POST request to `/api/exchange-rates` with valid exchange rate data.
  2. Verify that the response status is `201 Created`.
  3. Check the database to ensure the new entry is added.

#### 2.1.2 Scenario: Update Exchange Rate Entry
- **Objective:** Verify that an existing exchange rate entry can be updated successfully.
- **Steps:**
  1. Send a PUT request to `/api/exchange-rates/{id}` with valid exchange rate data.
  2. Verify that the response status is `200 OK`.
  3. Check the database to ensure the entry is updated.

#### 2.1.3 Scenario: Delete Exchange Rate Entry
- **Objective:** Verify that an existing exchange rate entry can be deleted successfully.
- **Steps:**
  1. Send a DELETE request to `/api/exchange-rates/{id}`.
  2. Verify that the response status is `204 No Content`.
  3. Check the database to ensure the entry is deleted.

### 2.2 Percentage Difference Calculation

#### 2.2.1 Scenario: Calculate Percentage Difference
- **Objective:** Verify that the percentage difference for various time periods is calculated correctly.
- **Steps:**
  1. Send a GET request to `/api/exchange-rates/diff/ with sample data.
  2. Verify that the response status is `200 OK`.
  3. Check the response body to ensure the percentage differences are correct.

## 3. Test Environment

- **API Base URL:** http://localhost:8080
- **Database:** MongoDB
- **External API:** [Exchange Rate API](external_api_url)
- **Testing Tool:** Postman, JUnit

## 4. Conclusion

The testing of the ExchangeRate API aims to ensure the correct implementation of CRUD operations, accurate percentage difference calculations, and seamless integration with external APIs. The test scenarios cover a range of functionalities and provide confidence in the reliability of the API.

---

**Note:** Replace `[Exchange Rate API](external_api_url)` with the actual URL of the external API used for historical exchange rate data.



