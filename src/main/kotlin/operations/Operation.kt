package operations

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

abstract class Operation(
    val numero: String = genererNumero(),
    // J'ai importé la classe LocalDateTime pour que chaque opération aura la de creation
    val date: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
    val montant: Double
) {
    companion object {
        private var compteur = 0

        // J'ai crée cette fonction pour que les numéros des opération soit diffrents comme  les identifiants
        private fun genererNumero(): String {
            compteur++
            return "OP${compteur.toString().padStart(5, '0')}"
        }
    }
}