# Amazon Task Automation

This repository contains the implementation of automated tests for verifying user login functionality and adding items to the cart on the Amazon website.

## 📝 Brief Summary

- **Scenario 1:** Verified that a user cannot log in with a valid but not registered email.
- **Scenario 2:** Verified that items are added to the cart correctly, ensuring that item name, price, quantity, and subtotal are accurate in the cart.

## 🚀 Instructions to Download, Execute Tests, and Generate Report

Follow the steps below to clone the repository, execute the tests, and generate an Allure report.

### 1. Clone the Repository

To get a copy of the project, clone the repository using the following command:

```bash
git clone https://github.com/KyrillosNageh/AmazonTask

"Navigating to the project directory..."
cd AmazonTask

"Running the tests..."
mvn test "-Dsurefire.suiteXmlFiles=testng.xml"

"Generating and serving the Allure report..."
mvn allure:serve
