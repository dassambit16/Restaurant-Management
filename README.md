# Restaurant Management

This is a Restaurant Management Service API built using Spring Boot and Java. It provides functionality for user management, food item management, and order processing. Below, you'll find an overview of the key components, endpoints, and how to use them.

## Frameworks and Language Used

- Framework: Spring Boot
- Language: Java

## Data Flow

### Model

- **User**: Represents a user of the system.
- **SignUpOutput**: Response model for user sign-up.
- **SignInInput**: Input model for user sign-in.
- **Food**: Represents food items.
- **Order**: Represents orders made by users.
- **Admin**: Represents an admin user.

### Repository

These are Spring Data JPA repositories for data access and storage.

### Controller

- **user-controller:**
  - **POST /user/signup**: Endpoint for user registration.
  - **POST /user/signIn**: Endpoint for user sign-in.
  - **POST /order**: Endpoint for creating orders.

- **GET /foods**: Endpoint to retrieve a list of food items.

- **visitor-controller:**
  - **GET /food**: Endpoint for retrieving information about a specific food item.

- **admin-controller:**
  - **POST /food**: Endpoint for adding new food items.
  - **POST /Admin/signUp**: Endpoint for admin user registration.

## How to Use

1. **Clone the Repository**: You can clone this repository to your local machine using the following command:
