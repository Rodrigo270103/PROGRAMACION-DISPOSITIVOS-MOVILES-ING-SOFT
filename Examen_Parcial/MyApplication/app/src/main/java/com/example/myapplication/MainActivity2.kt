package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var option1RadioButton: RadioButton
    private lateinit var option2RadioButton: RadioButton
    private lateinit var option3RadioButton: RadioButton
    private lateinit var submitButton: Button
    private lateinit var retryButton: Button
    private lateinit var feedbackTextView: TextView
    private lateinit var scoreTextView: TextView

    private val questions = listOf(
        "¿Cuál es la capital de Francia?",
        "¿Cuál es el río más largo del mundo?",
        "¿Quién escribió 'Don Quijote de la Mancha'?",
        "¿Cuál es el país más grande del mundo por área terrestre?",
        "¿Quién escribió la novela 'Cien años de soledad'?",
        "¿Cuál es la capital de Australia?",
        "¿Cuál es la montaña más alta del mundo?",
        "¿Cuál es el océano más grande del mundo?",
        "¿Cuál es el metal más abundante en la corteza terrestre?",
        "¿Quién pintó la Mona Lisa?"
    )

    private val options = listOf(
        listOf("Roma", "París", "Londres"),
        listOf("Nilo", "Amazonas", "Misisipi"),
        listOf("Miguel de Cervantes", "William Shakespeare", "Leo Tolstoy"),
        listOf("Canadá", "Rusia", "Estados Unidos"),
        listOf("Pablo Neruda", "Mario Vargas Llosa", "Gabriel García Márquez"),
        listOf("Melbourne", "Sídney", "Canberra"),
        listOf("Monte Kilimanjaro", "Monte Everest", "Monte K2"),
        listOf("Pacífico", "Atlántico", "Índico"),
        listOf("Aluminio", "Calcio", "Hierro"),
        listOf("Pablo Picasso", "Leonardo da Vinci", "Vincent van Gogh")
    )

    private val correctAnswers = listOf(1, 0, 0, 1, 2, 2, 1, 0, 2, 1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Inicializar las vistas
        questionTextView = findViewById(R.id.questionTextView)
        option1RadioButton = findViewById(R.id.option1RadioButton)
        option2RadioButton = findViewById(R.id.option2RadioButton)
        option3RadioButton = findViewById(R.id.option3RadioButton)
        submitButton = findViewById(R.id.submitButton)
        retryButton = findViewById(R.id.retryButton)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        scoreTextView = findViewById(R.id.scoreTextView)

        // Mostrar la primera pregunta
        showQuestion()

        // Configurar el OnClickListener para el botón de envío
        submitButton.setOnClickListener {
            // Verificar si se seleccionó una opción
            val selectedOptionId = findViewById<RadioGroup>(R.id.optionsRadioGroup).checkedRadioButtonId
            val selectedOption = findViewById<RadioButton>(selectedOptionId)

            // Verificar la respuesta
            val correctOptionId = findViewById<RadioButton>(findViewById<RadioGroup>(R.id.optionsRadioGroup).getChildAt(correctAnswers[currentQuestionIndex]).id)

            if (selectedOptionId == correctOptionId.id) {
                score++ // Incrementar la puntuación si es correcta
                feedbackTextView.text = "¡Respuesta correcta!"
                selectedOption.setBackgroundResource(R.drawable.custom_radio_button_correct)
            } else {
                feedbackTextView.text = "Respuesta incorrecta"
                selectedOption.setBackgroundResource(R.drawable.custom_radio_button_incorrect)

                // Encontrar el RadioButton correcto y establecer su color de fondo a verde
                correctOptionId.setBackgroundResource(R.drawable.custom_radio_button_correct)
            }

            // Deshabilitar los botones de opción después de seleccionar una respuesta
            option1RadioButton.isEnabled = false
            option2RadioButton.isEnabled = false
            option3RadioButton.isEnabled = false

            // Pasar a la siguiente pregunta o mostrar la puntuación final después de un retraso de 3 segundos
            submitButton.isEnabled = false // Deshabilitar el botón mientras se muestra la retroalimentación
            Handler(Looper.getMainLooper()).postDelayed({
                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                    showQuestion()
                } else {
                    showScore()
                }
                submitButton.isEnabled = true // Volver a habilitar el botón después del retraso
            }, 1000) // 1000 milisegundos = 1 segundos
        }

        // Configurar el OnClickListener para el botón de volver a intentar
        retryButton.setOnClickListener {
            // Reiniciar el juego
            currentQuestionIndex = 0
            score = 0
            showQuestion()
            retryButton.visibility = TextView.GONE // Ocultar el botón de volver a intentar
            scoreTextView.text = "" // Limpiar el texto de la puntuación
        }
    }

    private fun showQuestion() {
        // Mostrar la pregunta y opciones
        questionTextView.text = questions[currentQuestionIndex]
        option1RadioButton.text = options[currentQuestionIndex][0]
        option2RadioButton.text = options[currentQuestionIndex][1]
        option3RadioButton.text = options[currentQuestionIndex][2]

        // Limpiar la retroalimentación
        feedbackTextView.text = ""

        // Limpiar el fondo de los botones de opción
        option1RadioButton.setBackgroundColor(Color.TRANSPARENT)
        option2RadioButton.setBackgroundColor(Color.TRANSPARENT)
        option3RadioButton.setBackgroundColor(Color.TRANSPARENT)

        // Habilitar los botones de opción
        option1RadioButton.isEnabled = true
        option2RadioButton.isEnabled = true
        option3RadioButton.isEnabled = true

        // Asegurar que las opciones sean visibles
        option1RadioButton.visibility = TextView.VISIBLE
        option2RadioButton.visibility = TextView.VISIBLE
        option3RadioButton.visibility = TextView.VISIBLE

        // Asegurar que el botón de envío sea visible
        submitButton.visibility = TextView.VISIBLE
    }


    private fun showScore() {
        // Mostrar la puntuación final
        questionTextView.text = "Juego completado"
        option1RadioButton.visibility = TextView.GONE
        option2RadioButton.visibility = TextView.GONE
        option3RadioButton.visibility = TextView.GONE
        submitButton.visibility = TextView.GONE
        retryButton.visibility = TextView.VISIBLE // Mostrar el botón de volver a intentar
        feedbackTextView.text = "Puntuación: $score / ${questions.size}"
    }
}