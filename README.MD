# API Automation Program

## Overview
This project is an API automation testing framework designed to test various API endpoints efficiently. It uses **TestNG** as the test framework and supports both **web and API automation**.

## Features
- Automated API testing using **TestNG**
- Support for **POST**, **PUT**, and other HTTP methods
- Parameterized test execution for different environments
- Integration with **Allure Reports** for test results visualization
- Configurable test execution via **XML test suites**

## Technologies Used
- **Java** (100%)
- **TestNG** (Test framework)
- **REST Assured** (API testing library)
- **Allure** (Reporting framework)
- **Maven** (Build automation tool)

## Project Structure
```
API_AUTOMATION_PROGRAM/
├── src/test/java/org/ljaj   # Test source files
├── testng_*.xml             # TestNG suite files
├── pom.xml                  # Maven configuration file
├── allure-results/          # Test execution reports
├── .idea/                   # IDE-specific settings
├── .gitignore               # Git ignore file
├── README.md                # Project documentation
```

## Setup and Execution
### Prerequisites
- **Java 11+** installed
- **Maven** installed
- **IDE (IntelliJ IDEA, Eclipse, etc.)**

### Steps to Run Tests
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/API_AUTOMATION_PROGRAM.git
   cd API_AUTOMATION_PROGRAM
   ```
2. Install dependencies:
   ```sh
   mvn clean install
   ```
3. Run TestNG test suite:
   ```sh
   mvn test -DsuiteXmlFile=testng_3_all.xml
   ```
4. Generate Allure Report:
   ```sh
   mvn allure:serve
   ```

## Test Execution
To execute different test suites, modify the `-DsuiteXmlFile` parameter with the appropriate XML file:
```sh
mvn test -DsuiteXmlFile=testng_APITesting_POST_NonBDDStyle.xml
```

## Reporting
- Test results are automatically saved in the `allure-results/` directory.
- Use `mvn allure:serve` to generate and view a detailed HTML report.

## Contribution
Contributions are welcome! Follow these steps:
1. Fork the repository
2. Create a new branch (`feature-branch`)
3. Commit your changes
4. Push to your fork
5. Open a Pull Request



## Contact
For any queries or contributions, reach out to:
- Name: IJAJ R SHAIKH
- GitHub: https://github.com/ijaj-bit/APIAUTOMATION_PROGRAM
- Email: ijaj7732@gmail.com


