package operations

class Retrait (montant: Double): Operation(montant = montant) {

    override fun toString(): String {
        return "Retrait de $montant DHs"
    }
}