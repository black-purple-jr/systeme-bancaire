package operations

class Versement (montant: Double): Operation(montant = montant) {
    override fun toString(): String {
        return "Versement de $montant DHs"
    }
}