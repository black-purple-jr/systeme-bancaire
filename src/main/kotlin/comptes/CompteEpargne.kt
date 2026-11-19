package comptes

import comptes.types.StatutDeCompte
import operations.Operation

class CompteEpargne(
    code: String,
    solde: Double,
    statut: StatutDeCompte,
    val tauxInterets: Double
) : Compte(code, solde, statut) {

    var totolComptesEpargnesCree: Int = 0

    init {
        totolComptesEpargnesCree++
    }

    fun actualiserSolde(): Double {
        solde = solde + (solde * tauxInterets)
        return solde
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