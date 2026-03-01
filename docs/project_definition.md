## AI-Powered Career Counseling Platform – Project Definition

### 1. Project Purpose

The **AI-Powered Career Counseling Platform** aims to support university students in planning and managing their career development using intelligent, data-driven recommendations. The platform combines traditional mentoring with AI-based guidance to help students:

- **Explore career paths** based on their skills, interests, and academic background.
- **Receive personalized recommendations** for courses, internships, and learning resources.
- **Track their progress** towards short-term and long-term career goals.
- **Communicate with mentors** and receive structured feedback.

From a Software Engineering perspective, this project is designed to:

- Apply **full-stack development** practices (Spring Boot backend, React frontend).
- Practice **software architecture and design** for a multi-role system.
- Use **relational databases (PostgreSQL)** for persistent, consistent data management.
- Demonstrate **team collaboration**, documentation, and maintainable coding standards.

### 2. User Roles

The system will support three main roles: **Admin**, **Mentor**, and **Student**. Each role has different responsibilities and permissions.

#### 2.1 Admin

The **Admin** role is responsible for managing the overall platform configuration and user ecosystem.

- **Manage users**: Create, update, deactivate Admin, Mentor, and Student accounts.
- **Assign roles**: Control which users are Mentors or Students and manage role changes.
- **Configure global settings**: Control platform-wide settings such as registration rules, access periods, and notification preferences.
- **Monitor system usage**: View high-level statistics (number of active users, sessions, mentor–student assignments, etc.).
- **Moderate content**: Review and handle inappropriate or low-quality content (e.g., comments, messages, or public posts, if implemented).

#### 2.2 Mentor

The **Mentor** role provides domain knowledge, guidance, and feedback to students.

- **View assigned students**: See a list of students they are responsible for mentoring.
- **Review student profiles**: Access students’ skills, interests, academic data, and goal summaries.
- **Provide feedback**: Comment on AI-generated recommendations and students’ plans (e.g., learning paths, internship choices).
- **Schedule and manage sessions**: Create and manage mentoring sessions (online/face-to-face) and track meeting history.
- **Validate AI suggestions**: Approve, adjust, or reject AI recommendations to improve their quality and reliability.

#### 2.3 Student

The **Student** role is the main end-user of the platform.

- **Create and maintain a profile**: Enter skills, interests, preferred industries, and academic information.
- **Set career goals**: Define short-term (e.g., internship, project) and long-term (e.g., job role, sector) goals.
- **Receive AI recommendations**: Get course, internship, and learning resource suggestions based on their profile and goals.
- **Interact with mentors**: Request mentoring sessions, ask questions, and receive feedback.
- **Track progress**: Monitor their development over time using dashboards or progress indicators.

### 3. Scope for the Course Project

For the **Software Engineering course**, the minimum scope includes:

- **Authentication and authorization** for the three roles.
- **Basic CRUD operations** for users, profiles, goals, and mentor–student assignments.
- A **simple AI recommendation module** (e.g., rule-based or using basic similarity scoring) that can be extended in future iterations.
- A **web-based UI** (React) that clearly separates functionality by role.
- **Documentation** (this project definition, architecture overview, and API description) to demonstrate engineering practices.
