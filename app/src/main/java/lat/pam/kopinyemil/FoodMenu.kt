package lat.pam.kopinyemil

data class FoodMenu(
    val emoji: String,
    val name: String,
    val description: String,
    val price: String
)

val menuList = listOf(
    FoodMenu("☕", "Kopi Susu Gula Aren", "Espresso, susu, gula aren", "Rp 22.000"),
    FoodMenu("🍩", "Donat Cokelat", "Donat empuk, glaze cokelat", "Rp 12.000"),
    FoodMenu("🍞", "Sourdough Loaf", "Roti fermentasi alami", "Rp 35.000"),
    FoodMenu("☕", "Cappuccino", "Espresso, foam susu lembut", "Rp 25.000"),
    FoodMenu("🍵", "Matcha Latte", "Matcha Jepang, susu segar", "Rp 27.000")
)
