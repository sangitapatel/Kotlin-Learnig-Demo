package com.exmple.MVVM.WithoutCoroutine.repository
import androidx.lifecycle.MutableLiveData
import com.exmple.MVVM.WithoutCoroutine.model.User
import com.exmple.MVVM.WithoutCoroutine.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun getUsers(liveData: MutableLiveData<List<User>>) {
        RetrofitInstance.api.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                liveData.postValue(emptyList()) // send empty list on failure
            }
        })
    }
}