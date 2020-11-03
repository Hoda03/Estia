package chaymaeidrissi.ma.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private var nbClick = 0
    private lateinit var textView: TextView
    private  lateinit var  compteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        textView = findViewById(R.id.resultat)
        compteButton = findViewById(R.id.btn_compute)
        compteButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)

        }

        clickButton.setOnClickListener {
            Toast.makeText(baseContext, "Tu m'as cliqué", Toast.LENGTH_LONG).show()
        }
        clickButton.setOnClickListener {
            textView.visibility = View.VISIBLE
            nbClick++
            val newText = "Cliquez moi $nbClick"
            if (nbClick > 5) {
                textView.visibility = View.GONE
                clickButton.isEnabled = false
            }
            textView.text = newText
        }
    }

}
