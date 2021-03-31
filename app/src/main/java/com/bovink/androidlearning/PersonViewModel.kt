package com.bovink.androidlearning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author bovink
 * @since 2021/3/31
 */
class PersonViewModel : ViewModel() {

    var persons: MutableList<Person> = mutableListOf(Person("李磊", "上海"),
            Person("韩梅梅", "杭州"))

    var index: MutableLiveData<Int> = MutableLiveData(0)


    fun getCurrentName(): String {

        return persons.get(index.value!!).personName
    }

    fun getCurrentAddr(): String {
        return persons.get(index.value!!).personAddr
    }
}