# Project Tasks

## 📌 Refactoring & Code Cleanup
- Improve code readability and maintainability.
- Remove unused code and dependencies.
- Apply best practices for clean code (SOLID principles, DRY, etc.).
- Optimize package structure for better organization.

## 📌 Implement Liquibase
- Add Liquibase to manage database migrations.
- Create initial changelog files for schema versioning.
- Ensure Liquibase runs automatically during application startup.
- Document migration process in the README.

## 📌 Create DTOs for Request & Response
- Define Data Transfer Objects (DTOs) for API requests and responses.
- Implement conversion between entities and DTOs using `ModelMapper` or `MapStruct`.
- Ensure DTOs include only necessary fields for security and efficiency.

## 📌 Implement Caching for Fast Retrieval
- Identify frequently accessed data for caching.
- Use Spring Cache (`@Cacheable`, `@CachePut`, `@CacheEvict`).
- Configure an appropriate caching provider (e.g., Redis, Caffeine, Ehcache).

## 📌 Implement Cache Strategy (if needed)
- Choose between write-through, write-back, or write-around strategies.
- Optimize cache expiration and eviction policies.
- Monitor cache performance and adjust configurations as needed.

## 📌 Implement Spring Security with JWT
- Set up authentication and authorization using JWT.
- Implement user login, registration, and token generation.
- Secure API endpoints with role-based access control (RBAC).
- Configure token expiration and refresh logic.
- Implement necessary filters for JWT validation.

## ✅ Next Steps
- Test all implemented features.
- Write unit and integration tests.
- Update API documentation (Swagger/OpenAPI).
