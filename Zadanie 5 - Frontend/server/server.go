package main

import (
    "net/http"
    "strconv"
    "errors"
    "fmt"

    "github.com/labstack/echo/v4"
    "github.com/labstack/echo/v4/middleware"
    "gorm.io/driver/sqlite"
    "gorm.io/gorm"
)

// Product model
type Product struct {
    gorm.Model
    Name       string
    Price      float64
    CategoryID uint     // category key
    Category   Category `json:"category"`
}

// Category model
type Category struct {
    gorm.Model
    Name string
}

// Cart model
type Cart struct {
    gorm.Model
    Items     []Product `gorm:"many2many:cart_items;"`
    PaymentID uint      // Pole przechowujące identyfikator płatności
}

// Payment model
type Payment struct {
    gorm.Model
    Amount float64
    Status string
}

func main() {
    e := echo.New()

    // CORS
    e.Use(middleware.CORS())

    db, err := gorm.Open(sqlite.Open("gorm.db"), &gorm.Config{})
    if err != nil {
        panic("failed to connect database")
    }

    db.AutoMigrate(&Product{}, &Category{}, &Cart{}, &Payment{}) // Migrate Payment model

    // Define endpoints
    e.GET("/products", getProducts(db))
    e.POST("/products", createProduct(db))
    e.GET("/products/:id", getProduct(db))
    e.PUT("/products/:id", updateProduct(db))
    e.DELETE("/products/:id", deleteProduct(db))

    e.GET("/cart", getCart(db))
    e.POST("/cart/add/:id", addToCart(db))     // Add to Cart endpoint
    e.DELETE("/cart/remove/:id", removeFromCart(db)) // Remove from Cart endpoint

    e.POST("/payment", makePayment(db)) // Payment endpoint
    e.GET("/payment/:id", getPayment(db)) // Payment by ID endpoint

    // Start server
    e.Logger.Fatal(e.Start(":8080"))
}

// GET /cart
func getCart(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        var cart Cart
        db.Preload("Items.Category").First(&cart)
        return c.JSON(http.StatusOK, cart)
    }
}

// POST /cart/add/:id
func addToCart(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        id := c.Param("id")
        var product Product
        if result := db.Preload("Category").First(&product, id); result.Error != nil {
            return result.Error
        }

        var cart Cart
        db.FirstOrCreate(&cart) // Create cart if not exists

        // Reload product with category
        db.Preload("Category").First(&product, id)

        // Append product to cart items
        db.Model(&cart).Association("Items").Append(&product)

        return c.JSON(http.StatusOK, cart)
    }
}

// DELETE /cart/remove/:id
func removeFromCart(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        id := c.Param("id")
        var product Product
        if result := db.Preload("Category").First(&product, id); result.Error != nil {
            return result.Error
        }

        var cart Cart
        db.First(&cart) // Retrieve cart

        // Reload product with category
        db.Preload("Category").First(&product, id)

        // Remove product from cart items
        db.Model(&cart).Association("Items").Delete(&product)

        return c.JSON(http.StatusOK, cart)
    }
}


// GET /payment/:id
func getPayment(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        idStr := c.Param("id")
        fmt.Println("ID:", idStr) // Upewnij się, że prawidłowo pobierasz parametr ID

        // Konwersja parametru ID na typ liczbowy (uint)
        id, err := strconv.ParseUint(idStr, 10, 64)
        if err != nil {
            // Obsługa błędu konwersji
            return c.JSON(http.StatusBadRequest, echo.Map{"error": "Nieprawidłowy format ID płatności"})
        }

        var payment Payment
        if err := db.Where("id = ?", id).First(&payment).Error; err != nil {
            if errors.Is(err, gorm.ErrRecordNotFound) {
                return c.JSON(http.StatusNotFound, echo.Map{"error": "Płatność o podanym ID nie istnieje"})
            }
            return c.JSON(http.StatusInternalServerError, echo.Map{"error": "Wystąpił błąd podczas pobierania płatności"})
        }

        return c.JSON(http.StatusOK, payment)
    }
}


// POST /payment
func makePayment(db *gorm.DB) echo.HandlerFunc {
    
    return func(c echo.Context) error {
        fmt.Println("Hello!")
        payment := new(Payment)
        if err := c.Bind(payment); err != nil {
            return err
        }
        
        // Ustawienie statusu płatności na Success, jeśli nie został podany
        if payment.Status == "" {
            payment.Status = "Success"
        }

        // Wykonanie płatności
        if err := db.Create(payment).Error; err != nil {
            return err
        }

        return c.JSON(http.StatusOK, payment)
    }
}

// GET /products
func getProducts(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        var products []Product
        db.Preload("Category").Find(&products)
        return c.JSON(http.StatusOK, products)
    }
}

// POST /products
func createProduct(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        product := new(Product)
        if err := c.Bind(product); err != nil {
            return err
        }
        db.Create(product)
        return c.JSON(http.StatusCreated, product)
    }
}

// GET /products/:id
func getProduct(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        id := c.Param("id")
        var product Product
        if result := db.Preload("Category").First(&product, id); result.Error != nil {
            return result.Error
        }
        return c.JSON(http.StatusOK, product)
    }
}

// PUT /products/:id
func updateProduct(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        id := c.Param("id")
        var product Product
        if result := db.First(&product, id); result.Error != nil {
            return result.Error
        }

        if err := c.Bind(&product); err != nil {
            return err
        }

        if result := db.Save(&product); result.Error != nil {
            return result.Error
        }

        return c.JSON(http.StatusOK, product)
    }
}

// DELETE /products/:id
func deleteProduct(db *gorm.DB) echo.HandlerFunc {
    return func(c echo.Context) error {
        id := c.Param("id")
        var product Product
        if result := db.First(&product, id); result.Error != nil {
            return result.Error
        }

        if result := db.Delete(&product); result.Error != nil {
            return result.Error
        }

        return c.NoContent(http.StatusNoContent)
    }
}
