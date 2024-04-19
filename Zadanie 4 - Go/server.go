package main

import (
	"net/http"
	"github.com/labstack/echo/v4"
	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
)

// Product model
type Product struct {
	gorm.Model
	Name      string
	Price     float64
	CategoryID uint // category key
	Category   Category
}

// Category model
type Category struct {
	gorm.Model
	Name string
}

// Cart model
type Cart struct {
	gorm.Model
	Items []Product `gorm:"many2many:cart_items;"`
}

func main() {

	e := echo.New()

	db, err := gorm.Open(sqlite.Open("gorm.db"), &gorm.Config{})
	if err != nil {
		panic("failed to connect database")
	}

	db.AutoMigrate(&Product{}, &Category{}, &Cart{})


	// -----------
	category := Category{Name: "Electronics"}
	db.Create(&category)
	product := Product{Name: "Laptop", Price: 1500, CategoryID: category.ID}
	db.Create(&product)
	// ------------

	// CRUD 
	e.GET("/products", getProducts(db))
	e.POST("/products", createProduct(db))
	e.GET("/products/:id", getProduct(db))
	e.PUT("/products/:id", updateProduct(db))
	e.DELETE("/products/:id", deleteProduct(db))


	e.GET("/cart", getCart(db))

	e.Logger.Fatal(e.Start(":8081"))
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


// GET /cart
func getCart(db *gorm.DB) echo.HandlerFunc {
	return func(c echo.Context) error {
		var cart Cart
		db.Preload("Items.Category").First(&cart)
		return c.JSON(http.StatusOK, cart)
	}
}
