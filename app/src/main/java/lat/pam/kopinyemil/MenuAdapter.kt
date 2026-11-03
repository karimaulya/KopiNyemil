package lat.pam.kopinyemil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val items: List<FoodMenu>,
    private val onItemClick: (FoodMenu) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val boxBackgrounds = intArrayOf(
        R.drawable.bg_box_kuning,
        R.drawable.bg_box_pink,
        R.drawable.bg_box_biru,
        R.drawable.bg_box_hijau,
        R.drawable.bg_box_merah
    )

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.ivMenu)
        val name: TextView = view.findViewById(R.id.tvMenuName)
        val desc: TextView = view.findViewById(R.id.tvMenuDesc)
        val price: TextView = view.findViewById(R.id.tvMenuPrice)
        val btnMinus: TextView = view.findViewById(R.id.btnMinus)
        val tvQuantity: TextView = view.findViewById(R.id.tvQty)
        val btnPlus: TextView = view.findViewById(R.id.btnPlus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageRes)
        holder.image.setBackgroundResource(boxBackgrounds[position % boxBackgrounds.size])
        holder.name.text = item.name
        holder.desc.text = item.description
        holder.price.text = item.price

        val qty = CartManager.getQuantity(item)
        holder.tvQuantity.text = qty.toString()

        holder.btnPlus.setOnClickListener {
            CartManager.addItem(item)
            notifyItemChanged(position)
        }

        holder.btnMinus.setOnClickListener {
            if (CartManager.getQuantity(item) > 0) {
                CartManager.removeItem(item)
                notifyItemChanged(position)
            }
        }

        holder.itemView.setOnClickListener {
            onItemClick(item)
            notifyItemChanged(holder.bindingAdapterPosition)
        }
    }

    override fun getItemCount(): Int = items.size
}
