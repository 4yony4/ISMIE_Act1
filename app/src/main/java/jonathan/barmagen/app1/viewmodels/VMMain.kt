package jonathan.barmagen.app1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VMMain : ViewModel() {

    private val _sContador= MutableLiveData<String>().apply {
        value = "0"
    }
    val sContador: LiveData<String> = _sContador

    var iContador:Int=0

    fun onBtn1Clicked() {
        // Handle button 1 click
        //println("Button 1 clicked")
        iContador++;
        _sContador.value=iContador.toString()
    }

    fun onBtn2Clicked() {
        // Handle button 2 click
        iContador--;
        _sContador.value=iContador.toString()
    }

}