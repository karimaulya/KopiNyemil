package lat.pam.kopinyemil

import androidx.annotation.DrawableRes

data class FoodMenu(
    @param:DrawableRes val imageRes: Int,
    val name: String,
    val description: String,
    val price: String
)

val menuList = listOf(
    FoodMenu(R.drawable.ice_palm_sugar, "Iced Palm Sugar Latte", "Authentic palm sugar sweetness, fresh milk, and rich espresso.", "Rp22.000"),
    FoodMenu(R.drawable.ice_americano, "Iced Americano", "Pure black coffee extraction to refresh your day.", "Rp18.000"),
    FoodMenu(R.drawable.matcha_latte, "Matcha Latte Pop", "Premium Japanese green tea mixed with milk, creamy and sweet.", "Rp27.000"),
    FoodMenu(R.drawable.classic_capuccino, "Classic Cappuccino", "Sharp espresso blended with super soft milk foam.", "Rp25.000"),
    FoodMenu(R.drawable.taro_milkshake, "Taro Milkshake", "Sweet retro-style purple taro milk to boost your mood.", "Rp24.000"),
    FoodMenu(R.drawable.crispy_french_fries, "Crispy French Fries", "Crunchy and savory fries, the perfect hangout buddy.", "Rp18.000"),
    FoodMenu(R.drawable.choco_donut, "Choco Sprinkles Donut", "Soft vintage donut with thick chocolate sprinkles.", "Rp12.000"),
    FoodMenu(R.drawable.sourdough, "Sourdough Loaf", "Naturally fermented bread, crispy on the outside and soft inside.", "Rp35.000"),
    FoodMenu(R.drawable.nougat_toast, "Nougat Toast", "Classic toast spread with mocha cream and peanuts.", "Rp20.000"),
    FoodMenu(R.drawable.choco_cookie, "Classic Choco Cookie", "Crunchy cookie with melted chocolate in every bite.", "Rp10.000")
)
