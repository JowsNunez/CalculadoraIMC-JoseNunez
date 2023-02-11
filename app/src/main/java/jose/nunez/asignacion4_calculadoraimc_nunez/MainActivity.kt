package jose.nunez.asignacion4_calculadoraimc_nunez

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        val etxtweight: EditText = findViewById(R.id.weigth) as EditText
        val etxtheight: EditText = findViewById(R.id.height) as EditText
        val txtimc: TextView = findViewById(R.id.imc) as TextView
        val txtrange: TextView = findViewById(R.id.range) as TextView
        val btncalcular: Button = findViewById(R.id.btnCalcular) as Button


        btncalcular.setOnClickListener {


            // obtenemos los valores de los EditText y los convertimos a Double
            var heigth: Double = etxtheight.text.toString().toDouble()
            var weight: Double = etxtweight.text.toString().toDouble()

            // Calculamos el imc con los valores obtenidos del EditText
            var imc = calcularImc(weight, heigth)
            // Verificamos en que rango se encuentra el IMC
            range(imc, txtrange)

            txtimc.setText(String.format("%.2f ",imc))


            // Ocultamos el teclado
            imm.hideSoftInputFromWindow(etxtheight.getWindowToken(), 0)
            imm.hideSoftInputFromWindow(etxtweight.getWindowToken(), 0)

        }


    }



    // metodo para calcular el imc

    private fun calcularImc(weight: Double, heigth: Double) = weight / Math.pow(heigth, 2.0)



    // metodo para evaluar el rango del imc
    private fun range(imc: Double, textView: TextView) {


        if (imc > 0 && imc <= 18.5) {
            textView.setText("Bajo Peso")
            textView.setBackgroundResource(R.color.colorGreenish)
        } else if (imc >= 18.85 && imc <= 25.9) {
            textView.setText("Normal")
            textView.setBackgroundResource(R.color.colorGreen)
        } else if (imc >= 25.0 && imc <= 29.9) {
            textView.setText("Sobre Peso")
            textView.setBackgroundResource(R.color.colorYellow)
        } else if (imc >= 30.0 && imc <= 34.9) {
            textView.setText("Obesidad Grado 1")
            textView.setBackgroundResource(R.color.colorOrange)
        } else if (imc >= 35.0 && imc <= 39.9) {
            textView.setText("Obesidad Grado 2")
            textView.setBackgroundResource(R.color.colorRed)
        } else if (imc >= 40) {
            textView.setText("Obesidad Grado 3")
            textView.setBackgroundResource(R.color.colorBrown)

        } else {
            textView.setText("Valor invalido")
        }
    }



}




