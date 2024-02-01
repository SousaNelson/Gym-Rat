import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import cv.example.gymrat.databinding.FragmentTrainBinding

class TrainFragment : Fragment() {

    private lateinit var binding: FragmentTrainBinding
    private lateinit var textViewContador: TextView

    private val tempoTotal = 60000 // Tempo total em milissegundos
    private val intervaloAtualizacao = 1000 // Intervalo de atualização do contador em milissegundos

    private lateinit var countDownTimer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainBinding.inflate(inflater, container, false)
        val rootView = binding.root
        textViewContador = binding.textViewContador
        iniciarContador()

        return rootView
    }

    private fun iniciarContador() {
        countDownTimer = object : CountDownTimer(tempoTotal.toLong(), intervaloAtualizacao.toLong()) {
            override fun onTick(millisUntilFinished: Long) {
               val segundosRestantes = millisUntilFinished / 1000
                textViewContador.text = "Tempo restante: $segundosRestantes s"
            }
            override fun onFinish() {
                textViewContador.text = "Contador finalizado!"
            }
        }
        countDownTimer.start()
    }

    override fun onDestroyView() {
        // Certifique-se de cancelar o CountDownTimer ao destruir a view
        countDownTimer.cancel()
        super.onDestroyView()
    }
}
