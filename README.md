# 📱 Dine-In Order System

A Java-based restaurant application that allows customers to scan a QR code at their table to view the menu and place orders seamlessly. The system streamlines dine-in ordering, reduces manual effort, and enhances the customer experience.

## 🚀 Features

- Scan QR code to access digital menu
- View categorized food and drink items
- Place dine-in orders directly from the table
- Automatic order mapping to table number
- Real-time order tracking for kitchen and staff
- Easy backend management for menu and orders

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** MySQL / SQLite (can be configured)
- **Frontend:** (To be integrated, optional mobile/web UI)
- **Tools:** IntelliJ IDEA / Eclipse, Postman

## 🧩 Modules

- **Customer Module:** View menu, place orders
- **Order Management:** Handle order status, timing, and delivery to tables
- **Admin Panel:** Add, update, delete menu items and track orders

## 🗂️ Project Structure
```
com.restaurant.dinein │ ├── controller # Handles HTTP requests ├── entity # Entity classes (Order, MenuItem, Table, etc.) ├── repository # JPA Repositories ├── service # Business logic ├── serviceImpl # Service implementation └── application # Main Spring Boot application
```

## ⚙️ How to Run

1. Clone the repository  
2. Import into IntelliJ IDEA or Eclipse  
3. Configure your database in `application.properties`  
4. Run the Spring Boot application  
5. Use Postman to test endpoints or connect with frontend  

## 📌 Future Enhancements

- Mobile-friendly web interface or Android app
- Real-time kitchen notification system
- Payment gateway integration
- Order feedback & rating system

## 👨‍💻 Developed By

**Palak Dave**  
Java Developer | Backend Enthusiast  


