package com.nizar.bengkelelysium.ui.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nizar.bengkelelysium.R
import com.nizar.bengkelelysium.database.ElysiumShop
import com.nizar.bengkelelysium.databinding.RecyclerviewElysiumshopBinding
import com.nizar.bengkelelysium.utils.RecyclerViewClickListener
import com.nizar.bengkelelysium.utils.convertLongToDateString
import com.nizar.bengkelelysium.utils.rupiah

class ElysiumShopAdapter(
    private val elysiumShop: List<ElysiumShop>
) : RecyclerView.Adapter<ElysiumShopAdapter.ElysiumShopViewHolder>() {

    var listener: RecyclerViewClickListener? = null

    inner class ElysiumShopViewHolder(
        val recyclerviewElysiumshopBinding: RecyclerviewElysiumshopBinding
    ) : RecyclerView.ViewHolder(recyclerviewElysiumshopBinding.root)

    override fun getItemCount() = elysiumShop.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ElysiumShopViewHolder (
        DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_elysiumshop, parent, false)
    )

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ElysiumShopViewHolder, position: Int) {
        holder.recyclerviewElysiumshopBinding.tvDate.text = convertLongToDateString(elysiumShop[position].tanggal)
        holder.recyclerviewElysiumshopBinding.tvNamaPelanggan.text = elysiumShop[position].nama
        holder.recyclerviewElysiumshopBinding.tvPaket.text = "(${elysiumShop[position].paket})"
        holder.recyclerviewElysiumshopBinding.tvHarga.text = rupiah(elysiumShop[position].harga)

        when (elysiumShop[position].paket) {
            ("Body Kit") -> {
                holder.recyclerviewElysiumshopBinding.imagePaket.setImageResource(R.drawable.body_kit)
            }
            ("SparePart") -> {
                holder.recyclerviewElysiumshopBinding.imagePaket.setImageResource(R.drawable.sparepart)
            }
            ("Service") -> {
                holder.recyclerviewElysiumshopBinding.imagePaket.setImageResource(R.drawable.service_mobil)
            }
        }

        holder.recyclerviewElysiumshopBinding.listDataCukur.setOnClickListener {
            Log.i("clicked", "oke bisa")
            listener?.onRecyclerViewItemClicked(it, elysiumShop[position])
        }
    }
}