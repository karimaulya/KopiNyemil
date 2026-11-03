package lat.pam.kopinyemil

import java.util.Locale

object CartManager {
    private val cartMap = mutableMapOf<FoodMenu, Int>()

    var onCartUpdatedListener: (() -> Unit)? = null

    fun getQuantity(item: FoodMenu): Int {
        return cartMap[item] ?: 0
    }

    fun addItem(item: FoodMenu) {
        val current = getQuantity(item)
        cartMap[item] = current + 1
        onCartUpdatedListener?.invoke()
    }

    fun removeItem(item: FoodMenu) {
        val current = getQuantity(item)
        if (current > 1) {
            cartMap[item] = current - 1
        } else {
            cartMap.remove(item)
        }
        onCartUpdatedListener?.invoke()
    }

    fun getTotalCount(): Int {
        return cartMap.values.sum()
    }

    fun getTotalPrice(): Int {
        var total = 0
        for ((item, qty) in cartMap) {
            total += parsePrice(item.price) * qty
        }
        return total
    }

    fun getCartItems(): List<Pair<FoodMenu, Int>> {
        return cartMap.entries.map { Pair(it.key, it.value) }
    }

    fun clear() {
        cartMap.clear()
        onCartUpdatedListener?.invoke()
    }

    private fun parsePrice(priceStr: String): Int {
        val clean = priceStr.replace("[^0-9]".toRegex(), "")
        return clean.toIntOrNull() ?: 0
    }

    fun formatRupiah(amount: Int): String {
        return String.format(Locale.GERMANY, "Rp%,d", amount)
    }
}
