package cv.example.gymrat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        etNome = findViewById(R.id.etApelido)
        btnEnter = findViewById(R.id.btnEnter)

        dbRef = FirebaseDatabase.getInstance().getReference("Rats")

    }
}