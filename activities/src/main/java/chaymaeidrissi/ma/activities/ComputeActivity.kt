package chaymaeidrissi.ma.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class ComputeActivity : AppCompatActivity(), TextWatcher{
    private lateinit var computeButton: Button
    private lateinit var text1: EditText
    private lateinit var text2: EditText
    private lateinit var textv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)



        computeButton = findViewById(R.id.btn_calculer)
        text1 = findViewById(R.id.field_1)
        text2 = findViewById(R.id.field_2)
        textv = findViewById(R.id.resultat)

        text1.addTextChangedListener(this)
        text2.addTextChangedListener(this)

        computeButton.setOnClickListener {

            var resultat = Integer.parseInt(text1.text.toString())+Integer.parseInt(text2.text.toString())
            textv.text = "$resultat"

        }

    }

    override fun afterTextChanged(p0: Editable?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        computeButton.isEnabled = text1.toString().isNotEmpty()&& text2.toString().isNotEmpty()
    }

}