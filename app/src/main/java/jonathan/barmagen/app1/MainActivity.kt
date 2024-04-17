package jonathan.barmagen.app1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import jonathan.barmagen.app1.viewmodels.VMMain
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var vmmain: VMMain
    private lateinit var textView: TextView
    private lateinit var btnPlus: Button
    private lateinit var btnMenos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        textView=findViewById<TextView>(R.id.textView)
        btnPlus=findViewById(R.id.button)
        btnMenos=findViewById(R.id.button2)
        initViewModels()
        observers()


        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }


    private fun initViewModels(){
        vmmain = ViewModelProvider(this)[VMMain::class.java]
        btnPlus.setOnClickListener(View.OnClickListener { vmmain.onBtn1Clicked() })
        btnMenos.setOnClickListener(View.OnClickListener { vmmain.onBtn2Clicked() })

    }

    private fun observers(){
        vmmain.sContador.observe(this, Observer {
            //Log.v("HomeFragment","LOADING THE FOLLOWING LIST-------->>>>>>>>>>>    "+it.uid)
            textView.text = it
        })

    }

}