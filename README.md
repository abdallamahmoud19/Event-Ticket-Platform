# Event Ticket Platform

A comprehensive full-stack event ticket management system showcasing modern web development practices with secure authentication, QR code generation, and role-based access control.

## 📋 Project Overview

This project demonstrates a complete event ticketing platform where users can create events, generate tickets, validate attendance via QR codes, and manage ticket sales. The system supports multiple user roles including event organizers, staff members, and attendees.

### Key Features

- **Event Management**: Create, update, and publish events with detailed information
- **Ticket Generation**: Generate and manage multiple ticket types per event
- **QR Code Validation**: Scan and validate tickets at event entry points
- **Role-Based Access Control**: Differentiated access for organizers, staff, and attendees
- **Secure Authentication**: OAuth2/JWT-based authentication with Keycloak
- **Real-time Dashboard**: Role-specific dashboards for event management and ticket validation
- **Responsive UI**: Modern, mobile-friendly user interface

## 🏗️ Architecture

### Technology Stack

**Backend:**
- Java 17
- Spring Boot 4.0.5
- Spring Security with OAuth2
- Spring Data JPA
- PostgreSQL / H2 Database
- MapStruct for entity mapping
- ZXing for QR code generation
- Maven

**Frontend:**
- React 19
- TypeScript
- Vite (build tool)
- Tailwind CSS
- Radix UI components
- React Router for navigation
- OIDC Client for authentication
- QR code scanner integration

**Infrastructure:**
- Docker & Docker Compose
- PostgreSQL database
- Keycloak (Identity & Access Management)
- Adminer (Database management)

## 📁 Project Structure

```
tickets/
├── backend/                          # Spring Boot API
│   ├── src/main/java/com/avdo/tickets/
│   │   ├── controllers/             # REST endpoints
│   │   ├── services/                # Business logic
│   │   ├── repositories/            # Data access layer
│   │   ├── domain/                  # DTOs and entities
│   │   ├── entities/                # JPA entities
│   │   ├── exceptions/              # Custom exceptions
│   │   ├── mappers/                 # Entity-DTO mappers
│   │   ├── config/                  # Spring configuration
│   │   └── filters/                 # Authentication filters
│   ├── pom.xml                      # Maven dependencies
│   └── docker-compose.yml           # Infrastructure setup
│
└── frontend/                         # React application
    ├── src/
    │   ├── pages/                   # Page components
    │   ├── components/              # Reusable components
    │   ├── lib/                     # Utilities and API client
    │   ├── hooks/                   # React hooks
    │   ├── domain/                  # TypeScript types
    │   └── assets/                  # Static assets
    ├── package.json                 # npm dependencies
    └── vite.config.ts               # Vite configuration
```

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Node.js 18+
- Docker & Docker Compose
- PostgreSQL (or use Docker)
- Keycloak (or use Docker)

### Backend Setup

1. **Start infrastructure services:**
   ```bash
   cd backend
   docker-compose up -d
   ```

2. **Configure database connection** in `backend/src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=postgres
   spring.datasource.password=changemeinprod!
   ```

3. **Build and run the backend:**
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
   ```

   Backend will be available at: `http://localhost:8080`

### Frontend Setup

1. **Install dependencies:**
   ```bash
   cd frontend
   npm install
   ```

2. **Start development server:**
   ```bash
   npm run dev
   ```

   Frontend will be available at: `http://localhost:5173`

3. **Build for production:**
   ```bash
   npm run build
   ```

## 🔐 Authentication & Authorization

The platform uses OAuth2 with JWT tokens through Keycloak:

- **Keycloak Admin Console**: http://localhost:9090
  - Username: `admin`
  - Password: `admin`

- **User Roles**:
  - **ORGANIZER**: Create and manage events
  - **STAFF**: Validate tickets via QR code scanning
  - **ATTENDEE**: Purchase and view tickets

## 📊 API Endpoints

### Events
- `GET /api/events` - List all events (organizer only)
- `POST /api/events` - Create new event
- `PUT /api/events/{id}` - Update event
- `GET /api/published-events` - List published events (public)

### Tickets
- `POST /api/tickets` - Purchase ticket
- `GET /api/tickets` - List user's tickets
- `GET /api/tickets/{id}` - Get ticket details

### Ticket Types
- `POST /api/ticket-types` - Create ticket type
- `PUT /api/ticket-types/{id}` - Update ticket type
- `GET /api/events/{id}/ticket-types` - List ticket types for event

### Validation
- `POST /api/tickets/validate` - Validate ticket via QR code

## 🗄️ Database Schema

Key entities:
- **User**: Platform users with roles
- **Event**: Event information and metadata
- **TicketType**: Different ticket categories (VIP, Regular, etc.)
- **Ticket**: Individual ticket instances
- **QrCode**: Generated QR codes linked to tickets
- **TicketValidation**: Validation records for attendance tracking

## 🛠️ Development Tools

### Code Quality
- ESLint for JavaScript/TypeScript
- Prettier for code formatting
- MapStruct for compile-time mapping

### Commands

**Frontend:**
```bash
npm run dev       # Start development server
npm run build     # Build for production
npm run lint      # Run ESLint
npm run format    # Format code with Prettier
npm run preview   # Preview production build
npm run mocks     # Start mock API server
```

**Backend:**
```bash
mvn clean install           # Build project
mvn spring-boot:run         # Run application
mvn test                    # Run tests
```

## 🔄 User Flows

### Event Organizer Flow
1. Authenticate via Keycloak
2. Create and configure events
3. Define ticket types with pricing
4. Publish events for attendees
5. Monitor ticket sales
6. Generate QR codes for validation

### Attendee Flow
1. Browse published events
2. Select event and ticket type
3. Complete purchase
4. Receive ticket with QR code
5. Use QR code for event entry

### Staff (Validator) Flow
1. Authenticate as staff member
2. Access QR code scanner
3. Scan ticket QR codes
4. Record attendance in real-time

## 📝 Key Implementation Details

### JWT Authentication
- Tokens issued by Keycloak
- Validated by Spring Security Resource Server
- Custom converter for role extraction

### QR Code Generation
- Uses ZXing library for QR code creation
- Unique per ticket for validation
- Encoded with ticket information

### Database Strategy
- JPA/Hibernate for ORM
- Support for both H2 (development) and PostgreSQL (production)
- Automatic schema updates via Hibernate DDL

### Entity Mapping
- MapStruct for DTO-Entity conversion
- Type-safe mapping with annotation processing
- Reduced boilerplate code

## 🧪 Testing

```bash
# Backend tests
mvn test

# Frontend tests (when added)
npm run test
```

## 📦 Deployment

### Docker Deployment

1. **Build Docker images:**
   ```bash
   # Backend
   docker build -t event-platform-backend ./backend

   # Frontend
   docker build -t event-platform-frontend ./frontend
   ```

2. **Run with Docker Compose:**
   ```bash
   docker-compose up -d
   ```

## 🐛 Common Issues & Solutions

### PostgreSQL Connection Error
- Ensure Docker container is running: `docker-compose up -d`
- Check credentials in `application.properties`
- Verify port 5432 is available

### Keycloak Authentication Issues
- Clear browser cache and cookies
- Verify Keycloak is running on port 9090
- Check realm configuration

### CORS Issues
- Ensure backend CORS is properly configured
- Frontend must use correct API base URL

## 📚 Dependencies

### Backend Key Dependencies
- Spring Boot Starters (Web, Data JPA, Security)
- Spring Security OAuth2 Resource Server
- Lombok for code generation
- MapStruct for mapping
- ZXing for QR code generation

### Frontend Key Dependencies
- React 19 with TypeScript
- React Router for navigation
- Tailwind CSS for styling
- Radix UI for accessible components
- React OIDC Context for authentication
- JWT Decode for token parsing

## 🤝 Contributing

This is a portfolio project demonstrating:
- Full-stack development capabilities
- Microservices architecture patterns
- Secure authentication implementation
- RESTful API design
- Modern frontend development
- Database design and optimization

## 📄 License

This project is provided for educational and portfolio purposes.

## 👨‍💻 About

This project showcases proficiency in:
- **Backend**: Java, Spring Boot, REST APIs, Database design
- **Frontend**: React, TypeScript, Modern UI frameworks
- **DevOps**: Docker, Docker Compose, Configuration management
- **Security**: OAuth2, JWT, Role-based access control
- **Architecture**: Layered architecture, Design patterns, Clean code

## 📞 Contact & Support

For questions or inquiries about this project, please reach out.

---

**Version**: 0.0.1  
**Last Updated**: 2026-05-15  
**Status**: Active Development
