package com.dars.navigationretrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dars.navigationretrofit.databinding.FragmentHomeBinding
import com.dars.navigationretrofit.model.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var userAdapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userAdapter = UserAdapter()
        binding.recyclerview.adapter = userAdapter

        val netWorkCall = RetrofitHelper.getInstance().create(NetworkApi::class.java)

        val call = netWorkCall.getUser()

        call.enqueue(object : Callback<List<UsersItem>>{
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                response.body()?.let { userAdapter.setData(it) }
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

            }

        })

    }
}