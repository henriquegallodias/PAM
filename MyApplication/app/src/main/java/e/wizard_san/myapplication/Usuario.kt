package e.wizard_san.myapplication

import android.media.Image
import java.util.*

class Usuario(nome: String,email: String,pass: String) {

    var id: Int = -1
    var nome: String = nome
    var email: String = email
    var pass: String = pass
    var created: Date = Date()
    lateinit var foto: Image

}
