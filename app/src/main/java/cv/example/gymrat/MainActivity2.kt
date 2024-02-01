package cv.example.gymrat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {
    private lateinit var etNome : EditText
    private lateinit var etApelido : EditText
    private lateinit var btnEnter: Button

    private lateinit var dbRef : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        etNome = findViewById(R.id.etNome)
        etApelido = findViewById(R.id.etApelido)
        btnEnter = findViewById(R.id.btnEnter)

        dbRef = FirebaseDatabase.getInstance().getReference("Rats")

        btnEnter.setOnClickListener{
            saveRat()

            // apos salvar o nome e apelido, inicia a nova activity
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
    private fun saveRat(){
        //receber valores

        val eNome = etNome.text.toString()
        val eApelido = etApelido.text.toString()

        if(eNome.isEmpty()){
            etNome.error = "Please enter name"
        }
        if(eApelido.isEmpty()){
            etApelido.error = "Please enter name"
        }
        val RatID = dbRef.push().key!!
        val theRats = RatModule(RatID,eNome,eApelido) // os valores sao passados para o modulo
        dbRef.child(RatID).setValue(theRats)//envia os dados para a db

    }
}