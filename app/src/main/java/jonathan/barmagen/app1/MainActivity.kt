package jonathan.barmagen.app1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import jonathan.barmagen.app1.viewmodels.VMMain
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //private lateinit var vmmain: VMMain
    private lateinit var textView: TextView
    private lateinit var btnPlus: Button
    private lateinit var btnMenos: Button
    private lateinit var etCantContador: EditText
    private val vmmain: VMMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        textView=findViewById<TextView>(R.id.textView)
        btnPlus=findViewById(R.id.button)
        btnMenos=findViewById(R.id.button2)
        etCantContador = findViewById(R.id.etCantContador)

        initViewModels()
        setupObservers()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun initViewModels(){
        //vmmain = ViewModelProvider(this)[VMMain::class.java]

        btnPlus.setOnClickListener { vmmain.onBtn1Clicked() }
        btnMenos.setOnClickListener { vmmain.onBtn2Clicked() }
        etCantContador.addTextChangedListener {
            it?.toString()?.let { text ->
                if (text.matches(Regex("^\\d+$"))) {
                    vmmain.etCantContador.value = text
                } else {
                    vmmain.etCantContador.value = "0"
                    etCantContador.error = "Debe usarse solo numeros."
                }
                //vmmain.etCantContador.value = text
            }
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                vmmain.sContador.collect { newValue ->
                    textView.text = newValue
                }
            }
        }
    }

    /*
    private fun observers(){
        vmmain.sContador.observe(this, Observer {
            //Log.v("HomeFragment","LOADING THE FOLLOWING LIST-------->>>>>>>>>>>    "+it.uid)
            textView.text = it
        })

    }
    */
}