package vcmsa.projects.tipcalculation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // find our UI components by their IDs
        val edtAmount=findViewById<EditText>(R.id.edtAmount)
        val edtTipPercentage=findViewById<EditText>(R.id.edtTipPercentage)
        val btnCalculate=findViewById<Button>(R.id.btnCalculate)
        val txtTip=findViewById<TextView>(R.id.txtTip)

        btnCalculate.setOnClickListener{
            val Amount=edtAmount.text.toString().toDoubleOrNull()?:0.0
            val TipPercentage=edtTipPercentage.text.toString().toDoubleOrNull()?:0.0
            val tipAmount=Amount*(TipPercentage/100)

            // display result
            txtTip.text = "Tip Amount: R${String.format("%.2f", tipAmount)}"
        }
    }
}