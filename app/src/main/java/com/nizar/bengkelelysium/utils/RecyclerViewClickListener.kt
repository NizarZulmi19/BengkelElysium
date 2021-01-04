package com.nizar.bengkelelysium.utils

import android.view.View
import com.nizar.bengkelelysium.database.ElysiumShop

interface RecyclerViewClickListener {

 fun onRecyclerViewItemClicked(view: View, elysiumShop: ElysiumShop)

}