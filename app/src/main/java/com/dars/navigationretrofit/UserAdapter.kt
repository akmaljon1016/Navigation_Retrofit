package com.dars.navigationretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dars.navigationretrofit.databinding.UserItemBinding
import com.dars.navigationretrofit.model.UsersItem

class UserAdapter : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    var emptyList = emptyList<UsersItem>()

    class MyViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val bittaUser = emptyList[position]

        holder.binding.apply {
            txtId.text = bittaUser.id.toString()
            txtName.text = bittaUser.name
            txtCity.text = bittaUser.address.city
            txtUsername.text = bittaUser.username
            txtPhone.text = bittaUser.phone
            txtEmail.text = bittaUser.email
        }
    }

    override fun getItemCount(): Int {
        return emptyList.size
    }

    fun setData(data: List<com.dars.navigationretrofit.model.UsersItem>) {
        emptyList = data
        notifyDataSetChanged()
    }
}