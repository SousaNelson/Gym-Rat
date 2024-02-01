import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import cv.example.gymrat.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {

    private lateinit var binding: FragmentLocationBinding
    private lateinit var dbRef: DatabaseReference
    private lateinit var tvNomeBD: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        val rootView = binding.root

        getRatData()

        return rootView
    }

    private fun getRatData() {
        dbRef = FirebaseDatabase.getInstance().getReference("Rats")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    // Use last() para obter o último nó na lista de filhos
                    val lastRatSnapshot = snapshot.children.lastOrNull()
                    // Verifica se o snapshot é nulo antes de acessar os valores
                    if (lastRatSnapshot != null) {
                        // Aqui, você acessa os valores de "nome" e "apelido" para o último nó "Rat"
                        val nome = lastRatSnapshot.child("enome").getValue(String::class.java)
                        // Define o texto do TextView
                        binding.tvNomeBD.text = "$nome"
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Lida com o cancelamento da leitura do banco de dados
                // Implemente conforme necessário
            }
        })
    }
}
