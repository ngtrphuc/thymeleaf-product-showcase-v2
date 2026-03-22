# 📱 Smartphone Shop Simulation - Thymeleaf Showcase

This is a **Spring Boot** web application that **simulates** a real-world e-commerce shopping experience. It focuses on demonstrating full-stack development skills, specifically handling complex UI states and session management.

---

## 📦 Key Features

- **Dynamic Simulation**: Simulates a complete customer journey from browsing to a "Confetti" success page.
- **Product Discovery**: Search functionality and detailed specification views.
- **Advanced Cart Logic**: Real-time quantity updates and total price calculations within `HttpSession`.
- **Two-Step Checkout**: Newly added shipping information stage before final order confirmation.
- **Responsive UI**: A sleek, dark-themed modern interface built from scratch with CSS.

---

## 🛠 Technical Stack & Highlights

- **Backend**: Java 17, Spring Boot 3, Spring MVC.
- **Frontend**: 
  - **Thymeleaf**: Dynamic rendering of product catalogs, shopping carts, and order summaries.
  - **Modern CSS**: Fully custom, responsive layouts with a focus on clean typography.
  - **Interactive JS**: Integrated `canvas-confetti` library for a rewarding post-purchase experience.
- **Key Implementation Details**:
  - **Multi-step Checkout Flow**: Simulated a realistic 2-step process (Shipping Info -> Order Review -> Success).
  - **Dynamic Search**: Real-time filtering of product lists via request parameters.
  - **Session Persistence**: Cart and user data managed seamlessly across pages using `HttpSession`.

---

## 📁 Project Structure

src/
├─ main/
│  ├─ java/jp/ac/ccmc/thymeleaf_sample/
│  │  ├─ ThymeleafSampleApplication.java # Spring Boot entry point
│  │  ├─ MainController.java             # Catalog, Search & Product details logic
│  │  ├─ CartController.java             # Cart management & Checkout flow logic
│  │  └─ CartItem.java                   # Data model for shopping cart items
│  └─ resources/
│     ├─ static/
│     │  ├─ css/
│     │  │  └─ style.css                 # Global custom styles (Flexbox/Grid)
│     │  └─ images/                      # Smartphone product images (jpg/png)
│     ├─ templates/
│     │  ├─ index.html                   # Shop home & Search results
│     │  ├─ detail.html                  # Product specifications & "Add to cart"
│     │  ├─ cart.html                    # Cart overview (Update/Remove items)
│     │  ├─ shipping.html                # Step 1: Customer info collection form
│     │  ├─ checkout.html                # Step 2: Final order review & summary
│     │  └─ success.html                 # Completion page with Confetti animation
│     └─ application.properties          # Server & Spring configurations
└─ pom.xml                               # Project dependencies (Spring Boot, Thymeleaf)                     

## 🚀 Getting Started

# 1. Clone the repository
git clone https://github.com/your-username/thymeleaf-product-showcase-v2.git
cd thymeleaf-product-showcase-v2

# 2. Build and run the application using Maven
mvn clean install
mvn spring-boot:run
The application will start at http://localhost:8080.

# 3. Usage
Homepage: Browse all products and search using the search bar.

## 🎯 Purpose

This project was created to practice full-stack web development using Spring Boot and to simulate a real-world e-commerce workflow.


