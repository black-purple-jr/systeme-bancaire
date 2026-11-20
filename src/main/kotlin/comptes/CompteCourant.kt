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

    override fun verser(montant: Double): Versement {
        if (montant <= 0.0) throw Exception("Montant doit être supérieure à 0")

        var operation = Versement(montant)
        listeOperations.add(operation)

        solde += montant
        totalVersements += montant

        return operation
    }

    override fun retirer(montant: Double): Retrait {
        if (montant <= 0.0) throw Exception("Montant doit être supérieure à 0")
        if (montant > solde + decouvert) throw Exception("Vous ne pouvez pas retirer ce montant")

        var operation = Retrait(montant)
        listeOperations.add(operation)

        solde -= montant
        totalRetraits += montant

        return operation
    }

    override fun virement(montant: Double, compte: Compte): Double {
        if (montant <= 0.0) throw Exception("Montant doit être supérieure à 0")
        if (montant >= solde) throw Exception("Vous ne pouvez pas retirer ce montant")

        this.solde -= montant
        compte.solde += montant

        return montant
    }

    override fun consulterSolde(): Double {
        return solde
    }

    override fun consulterOperation(): MutableList<Operation> {
        return listeOperations
    }

    override fun totalVersements(): Double {
        return totalVersements
    }

    override fun totalRetraits(): Double {
        return totalRetraits
    }

    override fun toString(): String {
        return "CompteCourant(compte = $code, solde = $solde, statut = $statut)"
    }
}

















