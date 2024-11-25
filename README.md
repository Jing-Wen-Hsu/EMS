# EMS 員工管理系統

## 介紹

這是一個用於員工資料管理的系統（Employee Management System，簡稱 EMS），該系統能夠進行員工資料的新增、刪除、修改及查詢操作。系統使用 MariaDB 作為資料庫，並支援員工編號由使用者手動輸入，而非使用自增長的方式。

## 安裝

### 1. 安裝環境

本專案使用 **Java 17** 和 **Spring Boot 3**。請確保已安裝以下環境：
- Java 17
- Maven 或 Gradle
- MariaDB 資料庫

### 2. 設置資料庫

1. 在 MariaDB 中創建一個名為 `ems` 的資料庫：
    ```sql
    CREATE DATABASE ems;
    ```

2. 配置您的資料庫連接。您可以在 `application.properties` 或 `application.yml` 檔案中設置資料庫連接：

    ```properties
    spring.datasource.url=jdbc:mariadb://localhost:3306/ems
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

### 3. 克隆專案

```bash
git clone https://github.com/yourusername/ems.git
cd ems
