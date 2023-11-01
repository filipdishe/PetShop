# PET SHOP APPLICATION

## 1. Introduction

This application allows you to manage users, pets and their interactions.
You can automatically create up to 10 users and 20 pets and then buy pets for each user
based on the budget of the user and the price of the pet. 
You can list all users, all pets and view when users tried to buy a pet.

## 2. Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK):** You need a JDK (version 17) installed on your machine.

- **Maven:** You should have Apache Maven installed.

- **Database:** The application uses a relational database (PostgreSQL). Make sure you have a database system installed and running (prefferably PostgreSQL).

- **Git:** You may need Git for cloning the project repository.

## 3. Setup

Follow these steps to set up and run the application:

**1. Clone the repository:**

`git clone https://github.com/filipdishe/PetShop.git`

**2. Database configuration:** 

- Open `src/main/resources/application.properties` and configure the database connection settings.

**3. Build the Application:**

`mvn clean install`

**4. Run the Application**

## 4. Endpoints

Here are the main endpoints you can use on localhost port 8080:

- **Create Users: `POST /api/users/create-users`**

- **Create Pets: `POST /api/pets/create-pets`**

- **List Users: `GET /api/users/list-users`**

- **List Pets: `GET /api/pets/list-pets`**

- **Buy Pets: `POST /api/users/buy`**

- **History Log `GET /api/history/history-log`**

