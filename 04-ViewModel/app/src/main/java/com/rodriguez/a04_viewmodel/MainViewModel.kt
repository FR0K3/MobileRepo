package com.rodriguez.a04_viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    //En tiempo real
    //var query = MutableLiveData("")
    //var result = Transformations.map(query) { query ->
    //    if (query.isEmpty())
    //        "Por favor ingrese una palabra"
    //    else
    //        "Este es el resultado juas juas: $query"

    var query = MutableLiveData("")
    var result = MutableLiveData("")

    fun onSearch(){
        result.value = "Este es el resultado juas juas: ${query.value}"
    }
}