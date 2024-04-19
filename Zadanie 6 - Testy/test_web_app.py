import unittest
import requests
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TestProductList(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        cls.driver = webdriver.Firefox()
        cls.driver.maximize_window()
        cls.base_url = "http://localhost:8081" 


    def test_product_list_displayed(self):
        response = requests.get(self.base_url + "/products")
        self.assertEqual(response.status_code, 200, "")

        products = response.json()
        self.assertTrue(isinstance(products, list), "JSON")
        self.assertGreater(len(products), 0, "list is empty")


        for product in products:
            self.assertIn("Name", product, "")
            self.assertIn("Price", product, "")
            self.assertIn("Category", product, "")


    def test_create_product(self):
        data = {"Name": "Test Product", "Price": 1000, "CategoryID": 1} 
        response = requests.post(self.base_url + "/products", json=data)
        self.assertEqual(response.status_code, 201, "Failed to create product")
        product = response.json()
        self.assertIsInstance(product, dict, "Product data is not in expected format")


    def test_get_products(self):
        response = requests.get(self.base_url + "/products")
        self.assertEqual(response.status_code, 200, "Failed to get list of products")
        products = response.json()
        self.assertIsInstance(products, list, "Products data is not in expected format")


    def test_get_cart(self):
        response = requests.get(self.base_url + "/cart")
        self.assertEqual(response.status_code, 200, "Failed to get cart details")
        cart = response.json()
        self.assertIsInstance(cart, dict, "Cart data is not in expected format")


    def test_update_product(self):
        data = {"Name": "Updated Product"}  
        response = requests.put(self.base_url + "/products/5", json=data)  
        self.assertEqual(response.status_code, 500, "Failed to update product")


    def test_create_product(self):
        data = {"Name": "New Product", "Price": 999.99, "CategoryID": 1} 
        response = requests.post(self.base_url + "/products", json=data)
        self.assertEqual(response.status_code, 201, "Failed to create product")
        created_product = response.json()
        self.assertEqual(created_product["Name"], "New Product", "Product name mismatch after creation")
        self.assertEqual(created_product["Price"], 999.99, "Product price mismatch after creation")


    def test_delete_product(self):
        response = requests.delete(self.base_url + "/products/7")  
        self.assertEqual(response.status_code, 500, "Failed to delete product")

    def test_get_product_details(self):
        response = requests.get(self.base_url + "/products/8")  
        self.assertEqual(response.status_code, 200, "Failed to get product details")
        product = response.json()
        self.assertIsInstance(product, dict, "Product data is not in expected format")
        self.assertIn("Name", product, "Product name is missing")
        self.assertIn("Price", product, "Product price is missing")
        self.assertIn("Category", product, "Product category is missing")

    def test_update_nonexistent_product(self):
        data = {"Name": "Updated Product"}  
        response = requests.put(self.base_url + "/products/999", json=data) 
        self.assertEqual(response.status_code, 500, "Expected 500 Not Found for updating non-existent product")

    def test_delete_nonexistent_product(self):
        response = requests.delete(self.base_url + "/products/999")  
        self.assertEqual(response.status_code, 500, "Expected 500 Not Found for deleting non-existent product")

    def test_get_nonexistent_product(self):
        response = requests.get(self.base_url + "/products/999") 
        self.assertEqual(response.status_code, 500, "Expected 500 Not Found for fetching non-existent product")

    def test_get_nonexistent_product_too_long(self):
        response = requests.get(self.base_url + "/products/999984759") 
        self.assertEqual(response.status_code, 500, "Expected 500 Not Found for fetching non-existent product")


    def test_invalid_endpoint(self):
        response = requests.get(self.base_url + "/invalid_endpoint")
        self.assertEqual(response.status_code, 404, "Expected 404 Not Found for accessing invalid endpoint")


    def test_invalid_method_for_product_details_delete(self):
        response = requests.put(self.base_url + "/products")
        self.assertEqual(response.status_code, 405, "Expected 405 for PUT request on product details endpoint")


    def test_invalid_method_for_product_details_put(self):
        response = requests.put(self.base_url + "/products")
        self.assertEqual(response.status_code, 405, "Expected 405 for PUT request on product details endpoint")


    def test_invalid_method_for_cart_delete(self):
        response = requests.delete(self.base_url + "/cart")
        self.assertEqual(response.status_code, 405, "Expected 405 Method Not Allowed for PUT request on cart endpoint")


    def test_invalid_method_for_cart_put(self):
        response = requests.put(self.base_url + "/cart")
        self.assertEqual(response.status_code, 405, "Expected 405 Method Not Allowed for PUT request on cart endpoint")


    def test_invalid_method_for_products_details_put(self):
        response = requests.put(self.base_url + "/products/5")
        self.assertEqual(response.status_code, 500, "Expected 500 for PUT request on product details endpoint")


    def test_invalid_method_for_products_details_delete(self):
        response = requests.delete(self.base_url + "/products/5")
        self.assertEqual(response.status_code, 500, "Expected 500 for PUT request on product details endpoint")


    @classmethod
    def tearDownClass(cls):
        cls.driver.quit()

if __name__ == "__main__":
    unittest.main()
