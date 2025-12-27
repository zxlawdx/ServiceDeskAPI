plugins {
	java
	id("org.springframework.boot") version "3.5.9"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
    // Web / API
    implementation("org.springframework.boot:spring-boot-starter-web")

    // 🔥 JPA / Hibernate (OBRIGATÓRIO)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // REST automático (opcional, pode manter)
    implementation("org.springframework.boot:spring-boot-starter-data-rest")

    // GraphQL (opcional)
    implementation("org.springframework.boot:spring-boot-starter-graphql")

    // Session JDBC (opcional, mas exige banco)
    implementation("org.springframework.session:spring-session-jdbc")

    // 🔥 Driver PostgreSQL (OBRIGATÓRIO)
    runtimeOnly("org.postgresql:postgresql")

    // Testes
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.graphql:spring-graphql-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
