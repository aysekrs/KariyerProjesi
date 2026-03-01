## AI Career Advisor

AI Career Advisor is a full-stack web application that helps university students plan their careers by combining **AI-generated advice** with **human mentoring**. It is designed as a **3rd-year Software/Computer Engineering Software Engineering project** but follows patterns that are close to production-ready systems.

The platform supports multiple roles (Admin, Mentor, Student), stores structured data in PostgreSQL, and integrates with an AI API (e.g., OpenAI) to generate personalized career suggestions.

### Features

- **AI Integration**
  - Sends structured prompts (skills, goals, background) to an AI API.
  - Receives natural-language career advice (e.g., next steps, course suggestions, project ideas).
  - Encapsulated in a dedicated `CareerAdviceService` on the backend for easy extension.

- **Role-Based Access**
  - **Admin**: Manages users and roles, oversees platform usage.
  - **Mentor**: Reviews student profiles and AI suggestions, provides feedback.
  - **Student**: Creates a profile, sets goals, and requests AI-powered advice.
  - Backed by a `users` table with a `role` field (ADMIN, MENTOR, STUDENT).

- **PostgreSQL Persistence**
  - Stores users, user profiles (skills, education, goals), and career suggestions.
  - Uses **JPA/Hibernate** for clean data access via repositories.
  - Includes a `database.sql` file that defines PostgreSQL tables and role enum.

- **Modern Frontend Experience**
  - React-based single-page UI.
  - Landing page, login, and home views designed for students and mentors.
  - Tailwind CSS utility classes (or equivalent styling) for a clean, modern look.

### Tech Stack

- **Backend**
  - Spring Boot (Java 17+)
  - Spring Web (REST APIs)
  - Spring Data JPA (Hibernate)
  - PostgreSQL Driver
  - Jakarta Bean Validation (for request validation)

- **Frontend**
  - React (18+)
  - Tailwind CSS (or standard CSS with a Tailwind-ready structure)

- **AI & Tooling**
  - OpenAI API (or similar LLM provider) for generating career advice
  - Maven for backend build and dependency management
  - npm / React Scripts for frontend development

### Project Structure

- **backend/**
  - `src/main/java/com/example/careercounseling/`
    - `controller/` – REST controllers (e.g., `RegistrationController`)
    - `service/` – business logic and AI integration (e.g., `UserService`, `CareerAdviceService`)
    - `repository/` – Spring Data JPA repositories (e.g., `UserRepository`)
    - `entity/` – JPA entities (e.g., `User`, `UserRole`)
    - `dto/` – data transfer objects (e.g., `RegistrationRequest`)
    - `CareerCounselingApplication` – Spring Boot entry point
  - `pom.xml` – backend dependencies and build configuration

- **frontend/**
  - `src/pages/` – top-level pages (e.g., `LandingPage`, `Home`, `Login`)
  - `src/components/` – reusable UI components
  - `src/services/` – API client helpers (e.g., `api.js` for `/api/auth/register`)
  - `src/index.js`, `src/App.js`, `src/index.css`

- **docs/**
  - `project_definition.md` – roles (Admin, Mentor, Student) and core features

- **database.sql**
  - PostgreSQL schema for `users`, `user_profiles`, and `career_suggestions`.

### API Endpoints

Current backend endpoints are implemented using Spring Boot REST controllers. All endpoints are prefixed with `/api`.

#### Authentication & User Management

- **Register User**
  - **Method**: `POST`
  - **URL**: `/api/auth/register`
  - **Description**: Registers a new user (Student, Mentor, or Admin) in the system.
  - **Request Body (JSON)**:

    ```json
    {
      "fullName": "Alice Student",
      "email": "alice@example.com",
      "password": "securePassword123",
      "role": "STUDENT"
    }
    ```

  - **Response (201 Created)**:

    ```json
    {
      "id": 1,
      "fullName": "Alice Student",
      "email": "alice@example.com",
      "password": "securePassword123",
      "role": "STUDENT"
    }
    ```

  - **Notes**:
    - If a user with the same email already exists, the service throws an error (`IllegalArgumentException` in the current implementation).
    - In a real production system, the password would be **hashed** (e.g., using Spring Security’s `PasswordEncoder`) and not returned in full in the response.

#### Career Advice (Conceptual Endpoint)

The backend contains a `CareerAdviceService` that demonstrates how to construct a prompt and call an AI API (for example, OpenAI’s Chat Completions endpoint). A typical production-style endpoint would look like:

- **Method**: `POST`
- **URL**: `/api/ai/career-advice`
- **Description**: Generates AI-based career advice using the student’s skills and goals.
- **Request Body (JSON)**:

  ```json
  {
    "skills": "Java, Spring Boot, React",
    "goals": "Become a full-stack developer and get an internship"
  }
  ```

- **Response (200 OK)**:

  ```json
  {
    "advice": "Based on your skills in Java, Spring Boot, and React, you should build 2–3 full-stack projects..."
  }
  ```

You can wire `CareerAdviceService` into a controller (e.g., `CareerAdviceController`) to expose this endpoint once the AI key and security settings are ready.

### Getting Started

#### 1. Prerequisites

- Java 17+
- Maven 3+
- Node.js and npm
- PostgreSQL running locally (or accessible remotely)
- An OpenAI API key (or an equivalent AI provider key) for full AI integration

#### 2. Backend Setup

1. Navigate to the backend folder:

   ```bash
   cd backend
   ```

2. Configure PostgreSQL and AI settings in `application.properties` or `application.yml` (e.g., database URL, username, password, OpenAI API key).
3. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

4. The API will be available at `http://localhost:8080`.

#### 3. Frontend Setup

1. Navigate to the frontend folder:

   ```bash
   cd frontend
   ```

2. Install dependencies:

   ```bash
   npm install
   ```

3. Start the React dev server:

   ```bash
   npm start
   ```

4. The UI will be available at `http://localhost:3000`.

### Production-Readiness Notes

- **Security**
  - Use Spring Security for authentication and authorization.
  - Hash passwords and never return them in responses.
  - Store API keys and secrets in environment variables, not in source code.

- **Validation**
  - Apply Bean Validation annotations (e.g., `@NotBlank`, `@Email`) on DTOs such as `RegistrationRequest`.
  - Handle validation errors gracefully with standard error responses.

- **Error Handling**
  - Implement global exception handling with `@ControllerAdvice` and consistent error payloads.

- **Testing**
  - Add unit tests for services and repositories.
  - Add integration tests for critical API endpoints.

Although this repository is designed as a **student project**, the structure and documentation are intentionally close to **real-world production practices**, making it a solid foundation for further development and learning.

