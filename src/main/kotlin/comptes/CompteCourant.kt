package comptes

import comptes.types.StatutDeCompte
import operations.Operation
import operations.Retrait
import operations.Versement

class CompteCourant(
    code: String,
    solde: Double,
    statut: StatutDeCompte,
    val decouvert: Double
) : Compte(code, solde, statut) {

    var totolComptesCourantsCree: Int = 0

    init {
        totolComptesCourantsCree++
    }

    fun verser (montant: Double): Versement? {
        if (montant <= 0.0) return null

        var operation: Versement = Versement("VER001", "19-11-2026", montant)
        listeOperations.add(operation)

        solde += montant
        totalVersements += montant

        return operation
    }

    fun retirer (montant: Double): Retrait? {
        if (montant <= 0.0) return null
        if (montant >= solde) return null

        var operation: Retrait
        if (montant <= solde + decouvert) {
            operation = Retrait("RET001", "19-11-2026", montant)
            listeOperations.add(operation)

            solde -= montant
            totalVersements += montant

            return operation
        }

        return null
    }

    override fun virement (montant: Double, compte: Compte): Double? {
        if (montant <= 0.0) return null
        if (montant >= solde) return null

        this.solde -= montant
        compte.solde += montant

        return montant
    }

    override fun consulterSolde (): Double {
        return solde
    }

    override fun consulterOperation (): MutableList<Operation> {
        return listeOperations
    }

    override fun totalVersements (): Double {
        return totalVersements
    }

     override fun totalRetraits (): Double {
        return totalRetraits
    }
}

















