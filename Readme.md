# 🧾 Saga Orchestrator — Microservices Architecture

Este proyecto implementa el patrón **Saga Orchestration** utilizando microservicios en Spring Boot. El flujo principal orquesta la creación de una orden y su pago, garantizando consistencia distribuida entre servicios.

---

## 🏗 Arquitectura

```
                      ┌──────────────────┐
                      │  API Client      │
                      │ (Postman, etc.)  │
                      └───────┬──────────┘
                              │
                              ▼
                    ┌────────────────────┐
                    │  Orchestrator MS   │
                    │ (Saga Coordinator) │
                    └───────┬────────────┘
                            │
     ┌──────────────────────┼────────────────────────┐
     ▼                      ▼                        ▼
┌────────────┐      ┌──────────────┐        ┌─────────────┐
│ Order MS   │      │ Payment MS   │        │ Eureka       │
│ DB propia  │      │ DB propia    │        │ Service      │
└────────────┘      └──────────────┘        │ Registry     │
                                             └─────────────┘
```

---

## 🧠 ¿Cómo funciona la Saga?

### Flujo principal (Happy Path)

1. El **Cliente** envía una solicitud de crear una orden
2. El **Orchestrator** ejecuta:

    * Crear Orden (Order MS)
    * Procesar Pago (Payment MS)
3. Devuelve resultado final

### Compensación (Rollback distribuido)

Si falla el pago:

* El **Orchestrator** invoca una operación compensatoria en Order MS → *Cancelar Orden*

---

## 🧩 Microservicios

| Microservicio       | Rol                | DB       | Notas                    |
| ------------------- | ------------------ | -------- | ------------------------ |
| `eureka-server`     | Service Discovery  | —        | Registro de servicios    |
| `msvc-orchestrator` | Orquestador Saga   | —        | Coordina el proceso      |
| `msvc-order`        | Gestión de órdenes | H2/MySQL | DB efímera por ejecución |
| `msvc-payment`      | Procesa pagos      | H2/MySQL | DB efímera por ejecución |

---

## 🚀 Ejecución

### 1️⃣ Levantar Eureka

```bash
cd eureka-server
mvn spring-boot:run
```

### 2️⃣ Levantar microservicios

En terminales separadas:

```bash
cd msvc-order
mvn spring-boot:run
```

```bash
cd msvc-payment
mvn spring-boot:run
```

```bash
cd msvc-orchestrator
mvn spring-boot:run
```

---

## 🧪 Probar desde Postman

### Crear Order (Saga Start)

**POST**

```
http://localhost:8080/api/orders
```

**Body**

```json
{
  "user_id": 1,
  "product_id": 100,
  "quantity": 2
}
```

### Respuesta Exitosa

```json
{
  "status": "COMPLETED",
  "orderId": 10,
  "paymentStatus": "APPROVED"
}
```

### Respuesta si el pago falla

```json
{
  "status": "FAILED",
  "reason": "PAYMENT_REJECTED",
  "compensation": "ORDER_CANCELLED"
}
```

---

## 📡 Eureka Dashboard

```
http://localhost:8761
```

Debe mostrar:

* MSVC-ORCHESTRATOR
* MSVC-ORDER
* MSVC-PAYMENT

---

## 🧰 Tecnologías

* Java 17
* Spring Boot 3
* Eureka
* Feign Client
* H2 / MySQL
* Saga Pattern

---

## 📦 Estructura del repositorio

```
saga-orquestador
 ├── eureka-server
 ├── msvc-orchestrator
 ├── msvc-order
 ├── msvc-payment
 └── README.md
```

---

## 🛠 Mejoras futuras

* Circuit Breaker (Resilience4j)
* Swagger
* Docker Compose
* Seed DB scripts

---

## ✅ Notas

* Los servicios `order` y `payment` utilizan bases de datos independientes
* Las bases se crean y eliminan en cada ejecución
* Eureka maneja el discovery, Feign la comunicación entre servicios

---
