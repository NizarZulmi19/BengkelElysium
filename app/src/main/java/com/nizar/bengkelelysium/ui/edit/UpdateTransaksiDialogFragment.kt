package com.nizar.bengkelelysium.ui.edit

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.dialog_fragment_tambah_transaksi.*

import com.nizar.bengkelelysium.R
import com.nizar.bengkelelysium.database.ElysiumShop
import com.nizar.bengkelelysium.database.ElysiumShopDatabase
import com.nizar.bengkelelysium.ui.HomeActivity
import com.nizar.bengkelelysium.utils.rupiah
import com.nizar.bengkelelysium.ui.home.ElysiumShopViewModel

@Suppress("SpellCheckingInspection")
class UpdateTransaksiDialogFragment(
    private val dataElysiumShop: ElysiumShop
) : DialogFragment() {

    private lateinit var viewModel: ElysiumShopViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_fragment_update_transaksi, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog_MinWidth)

        val application = requireNotNull(this.activity).application
        val dataSource = ElysiumShopDatabase.getInstance(application).elysiumShopDAO
        val viewModelFactory = ElysiumShopViewModel.Factory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ElysiumShopViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setEditText()

        btn_submit_transaksi.setOnClickListener {
            viewModel.onClickUpdate(dataElysiumShop)
            this.dismiss()
            startActivity(Intent(requireContext(), HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            Toast.makeText(requireContext(), getString(R.string.success_update), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setEditText() {
        et_nama_pelanggan.setText(dataElysiumShop.nama)
        et_paket.setText(dataElysiumShop.paket)
        et_total_harga.setText(rupiah(dataElysiumShop.harga))
        et_total_bayar.setText(rupiah(dataElysiumShop.bayar))
        et_kembalian.setText(rupiah(dataElysiumShop.kembalian))
    }

}
