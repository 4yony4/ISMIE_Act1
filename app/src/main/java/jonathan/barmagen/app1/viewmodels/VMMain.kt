package jonathan.barmagen.app1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VMMain : ViewModel() {

    private val _sContador = MutableStateFlow("0")
    val sContador: StateFlow<String> = _sContador
    val etCantContador = MutableStateFlow("1")

    var iContador: Int = 0

    fun onBtn1Clicked() {
        iContador+=etCantContador.value.toInt()
        _sContador.value = iContador.toString()
    }

    fun onBtn2Clicked() {
        iContador-=etCantContador.value.toInt()
        _sContador.value = iContador.toString()
    }
}

/*
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


 */