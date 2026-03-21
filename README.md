# Smartphone Shop - Thymeleaf Sample

This is a **Spring Boot** web application built with **Thymeleaf** that demonstrates a simple e-commerce shopping cart system. Users can browse smartphones, view product details, manage their cart, and complete a checkout process.

---

## 📦 Features

- **Homepage & Search**: Browse all products and search by name.
- **Product Detail Page**: View product specifications including OS, CPU, RAM, Storage, Display, Resolution, Battery, and Charging.
- **Shopping Cart**: Add products to cart, increase/decrease quantity, remove items.
- **Checkout**: View order summary with total price and item count.
- **Order Confirmation**: Confirm order and see a success page with confetti animation.
- **Session-based Cart**: Cart is maintained using HttpSession with live cart count in the header.

---

## 🛠 Technologies Used

- **Backend**: Java, Spring Boot, Spring MVC
- **Frontend**: Thymeleaf, HTML, CSS
- **Session Management**: HttpSession
- **Build Tool**: Maven
- **Java Version**: 17+ recommended

---

## 📁 Project Structure

src/
├─ main/
│ ├─ java/jp/ac/ccmc/thymeleaf_sample/
│ │ ├─ ThymeleafSampleApplication.java # Main Spring Boot application
│ │ ├─ MainController.java # Handles homepage, search, product details
│ │ ├─ CartController.java # Handles cart operations and checkout
│ │ └─ CartItem.java # Cart item model
│ └─ resources/
│ ├─ templates/
│ │ ├─ index.html # Homepage
│ │ ├─ detail.html # Product detail page
│ │ ├─ cart.html # Shopping cart page
│ │ ├─ checkout.html # Checkout page
│ │ └─ success.html # Order confirmation page
│ └─ application.properties # Spring Boot configuration


---

## 🚀 Getting Started

# 1. Clone the repository
git clone https://github.com/your-username/thymeleaf-product-showcase-v2.git
cd thymeleaf-product-showcase-v2

# 2. Build and run the application using Maven
mvn clean install
mvn spring-boot:run

The application will start at http://localhost:8080.

3. Usage
Homepage: Browse all products and search using the search bar.
Product Details: Click a product to see detailed specifications and add it to the cart.
Cart: Adjust quantity or remove items.
Checkout: Review order and confirm purchase.
Order Confirmation: Displays a success message with confetti animation.
📌 Notes
Cart Persistence: Cart data is stored in the user session and will reset if the session ends.
Data Source: Product information is hardcoded in MainController.java. In a real application, connect to a database.
UI Design: Responsive layout using CSS. Minimal JavaScript for animations.
