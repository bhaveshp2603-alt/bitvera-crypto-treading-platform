# Bitvera - Crypto Trading Platform
## 📌 Project Overview

Bitvera is a full-stack cryptocurrency trading platform built using Java and Spring Boot for the backend and React.js with Redux for the frontend. The platform integrates the CoinGecko API to fetch real-time cryptocurrency market data.

It allows users to securely register and log in using JWT authentication, manage their crypto wallets, and perform buy and sell operations. The system demonstrates complete frontend-backend integration, secure transaction handling, and real-world trading platform architecture.

Bitvera was developed to simulate a structured crypto trading environment similar to platforms like Binance and CoinDCX, while promoting awareness and usability of cryptocurrency trading in India.
## ❗ Problem Statement

Cryptocurrency trading platforms such as Binance and CoinDCX provide advanced trading features, but their systems can be complex for beginners to understand from a technical perspective. Additionally, there is limited exposure to structured educational trading environments that demonstrate how secure financial systems are built.

From a development perspective, building a crypto trading platform involves solving several technical challenges including secure JWT-based authentication, real-time API integration, wallet balance management, transaction validation, and seamless frontend-backend communication.

Bitvera was developed to address these challenges by creating a simplified yet technically robust full-stack trading platform that demonstrates real-world financial system architecture and secure transaction handling.
## 🚀 Key Features

- 🔐 JWT-based user authentication with Two-Step Verification (2FA)
- 👛 Secure wallet management with real-time balance tracking
- 🔄 Wallet-to-wallet transfers and bank account withdrawals
- 💰 Buy and sell cryptocurrency functionality
- 📈 Live market data and price charts using CoinGecko API
- 📊 Detailed coin information and trend visualization
- 🧾 Complete transaction history tracking
- 👤 Account and profile management system
- 🛠 Admin dashboard for user and transaction monitoring

Bitvera simulates a real-world crypto trading environment similar to Binance and CoinDCX, built with a full-stack Java (Spring Boot) backend and React-Redux frontend.
## 📸 Screenshots

### 🔐 Authentication Page
Modern and secure login interface with dark theme and glass-style UI design. 
Includes user authentication with JWT-based security and protected routing.

---

### 📊 Market Dashboard
Real-time cryptocurrency listings displaying market cap, volume, 24h change, and price updates. 
Integrated filtering options such as Top 50, Gainers, and Losers for better market analysis.

---

### 📈 Coin Price Chart
Interactive real-time price chart with multiple time filters (1 Day, 1 Week, 1 Month, 1 Year). 
Enables users to analyze historical trends and market movements before making trading decisions.

---

### 💱 Trade – Buy & Sell Crypto
Secure trading interface allowing users to buy and sell cryptocurrencies with live price synchronization. 
Orders update wallet balances instantly and reflect in portfolio and transaction history.

---

### 👛 Wallet Management
Comprehensive wallet system supporting deposits, wallet-to-wallet transfers, and withdrawals to bank accounts. 
Includes full transaction history tracking with secure validation.

---

### 📂 Navigation & User Control Panel
Structured side navigation providing quick access to Portfolio, Watchlist, Activity, Wallet, Payment Details, Withdrawal, and Profile management. 
Ensures smooth and intuitive user experience across the platform.
## 🏗️ Tech Stack

### 🔹 Backend
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- JPA / Hibernate
- RESTful APIs

### 🔹 Frontend
- React.js
- Redux (State Management)
- Axios (API Integration)
- ShadCN UI
- Tailwind CSS

### 🔹 Database
- MySQL

### 🔹 External Services
- CoinGecko API (Real-time cryptocurrency market data)

### 🔹 Security
- JWT-based Authentication
- Two-Step Verification (2FA)
- Encrypted password storage
## 🏗️ System Architecture

Bitvera follows a layered architecture pattern to ensure scalability, maintainability, and clean separation of concerns.

### 🔹 Backend Architecture (Spring Boot)

Controller Layer  
→ Handles HTTP requests and API endpoints.

Service Layer  
→ Contains business logic for trading, wallet management, authentication, and transaction processing.

Repository Layer  
→ Uses JPA/Hibernate to interact with the MySQL database.

Security Layer  
→ Implements JWT-based authentication and Two-Step Verification (2FA) for secure access control.

### 🔹 Frontend Architecture (React + Redux)

- React.js for UI development  
- Redux for global state management  
- Axios for REST API communication  
- ShadCN UI for modern, responsive design components  

### 🔹 External Integration

- CoinGecko API integration for real-time cryptocurrency price data and market charts.

### 🔹 System Flow

User → React Frontend → REST API (Spring Boot) → Service Layer → Database (MySQL)  
External Market Data ← CoinGecko API
## 📡 API Endpoints

### 🔐 Authentication

| Method | Endpoint | Description |
|--------|----------|------------|
| POST | /auth/signup | Register a new user |
| POST | /auth/signin | User login & JWT generation |

---

### 📈 Coin & Market Data

| Method | Endpoint | Description |
|--------|----------|------------|
| GET | /coins?page={page} | Get paginated coin list |
| GET | /coins/top50 | Get top 50 cryptocurrencies |
| GET | /coins/treading | Get trending coins |
| GET | /coins/details/{coinId} | Get coin details |
| GET | /coins/{coinId}/chart?days={days} | Get market chart data |

---

### 👤 User

| Method | Endpoint | Description |
|--------|----------|------------|
| GET | /api/users/profile | Get logged-in user profile |

---

### ⭐ Watchlist

| Method | Endpoint | Description |
|--------|----------|------------|
| GET | /api/watchlist/user | Get user watchlist |
| PATCH | /api/watchlist/add/coin/{coinId} | Add coin to watchlist |

---

### 📦 Orders

| Method | Endpoint | Description |
|--------|----------|------------|
| GET | /api/orders | Get user orders |

---

### 👛 Wallet

| Method | Endpoint | Description |
|--------|----------|------------|
| GET | /api/wallet | Get wallet details |
| PUT | /api/wallet/deposit?order_id={id}&payment_id={id} | Confirm deposit |
| PUT | /api/wallet/{walletId}/transfer | Wallet-to-wallet transfer |
| GET | /api/transactions | Get wallet transaction history |

---

### 💳 Payments

| Method | Endpoint | Description |
|--------|----------|------------|
| POST | /api/payment/RAZORPAY/amount/{amount} | Create Razorpay payment |
| GET | /api/payment-details | Get user payment details |
| POST | /api/payment-details | Add bank/payment details |

---

### 💰 Withdrawal

| Method | Endpoint | Description |
|--------|----------|------------|
| POST | /api/withdrawal/{amount} | Create withdrawal request |
| GET | /api/withdrawal | Get withdrawal history |
## ⚙️ Installation & Setup

### 🔹 Prerequisites
- Java 17+
- Node.js 18+
- MySQL
- Maven

---

### 🔹 Backend Setup (Spring Boot)

1. Clone the repository
   git clone https://github.com/your-username/bitvera.git

2. Navigate to backend folder
   cd backend

3. Configure MySQL database in `application.properties`

4. Install dependencies and run the application
   mvn clean install
   mvn spring-boot:run

Backend will run on:
http://localhost:5454

---

### 🔹 Frontend Setup (React)

1. Navigate to frontend folder
   cd frontend

2. Install dependencies
   npm install

3. Start the development server
   npm run dev

Frontend will run on:
http://localhost:5173
## 🔮 Future Enhancements

- 📱 Mobile application version (Android & iOS)
- 📊 Advanced trading charts with technical indicators
- 🤖 AI-based trading suggestions and market predictions
- 💳 Integrated payment gateway for seamless deposits
- 🔔 Real-time price alerts and push notifications
- 🌍 Multi-language and multi-currency support
- 📈 Advanced analytics dashboard for users
- 🔐 Biometric authentication support
- ☁️ Cloud deployment using AWS / Docker
## 👨‍💻 Author

**Bhavesh Pawar**

Full-Stack Java Developer  
Passionate about building secure and scalable financial systems.

- GitHub: https://github.com/bhaveshp2603-alt
- LinkedIn: https://www.linkedin.com/in/bhavesh-pawar-18a0b9293/
- Email: bhaveshp2603@gmail.com