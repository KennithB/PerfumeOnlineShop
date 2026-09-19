# Perfume Online Shop

A desktop Java Swing application for browsing, managing, and purchasing perfumes.

---

## Requirements

- **Java JDK 11** or newer
- **MySQL Server** running locally on port `3306`

---

## Setup Instructions

### 1. External Libraries
- Both `AbsoluteLayout` and `JCalendar` components are now embedded directly in the source code.
- To enable database actions (cart, checkout, sales), place `mysql-connector-java.jar` (or `mysql-connector-j-*.jar`) in the `lib/` folder.

### 2. Database Setup
1. Create a MySQL database named `products`:
   ```sql
   CREATE DATABASE products;
   ```
2. By default, the application connects with:
   - **Host:** `127.0.0.1:3306`
   - **Database:** `products`
   - **User:** `root`
   - **Password:** `password`

---

## How to Run

### Option A: Using the Launcher Script (Windows)
Double-click `run.bat` in File Explorer, or in PowerShell:
```powershell
.\run.bat
```

### Option B: Using PowerShell
```powershell
.\run.ps1
```

### Option C: Using NetBeans / IDE
Open the project directory in Apache NetBeans and click **Run Project (F6)**.

---

## Project Structure

```
PerfumeOnlineShop/
├── lib/               # External JAR libraries
├── nbproject/         # NetBeans build configuration
├── src/               # Java source files and UI forms
│   └── images/        # Application image assets
├── README.md          # Project documentation
├── RELEASES.md        # Version release notes
├── run.bat            # Windows batch launcher
└── run.ps1            # PowerShell launcher
```
