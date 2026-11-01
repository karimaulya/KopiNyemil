package lat.pam.kopinyemil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val items: List<FoodMenu>,
    private val onItemClick: (FoodMenu) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    // warna kotak foto bergantian ala retro
    private val boxBackgrounds = intArrayOf(
        R.drawable.bg_box_kuning,
        R.drawable.bg_box_pink,
        R.drawable.bg_box_biru,
        R.drawable.bg_box_hijau,
        R.drawable.bg_box_merah
    )

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val emoji: TextView = view.findViewById(R.id.tvMenuEmoji)
        val name: TextView = view.findViewById(R.id.tvMenuName)
        val desc: TextView = view.findViewById(R.id.tvMenuDesc)
        val price: TextView = view.findViewById(R.id.tvMenuPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.emoji.text = item.emoji
        holder.emoji.setBackgroundResource(boxBackgrounds[position % boxBackgrounds.size])
        holder.name.text = item.name
        holder.desc.text = "• ${item.description}"
        holder.price.text = item.price
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount(): Int = items.size
}
