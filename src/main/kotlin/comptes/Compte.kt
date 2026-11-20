package comptes

import comptes.types.StatutDeCompte
import operations.Operation
import operations.Retrait
import operations.Versement


abstract class Compte(
    val code: String,
    var solde: Double,
    var statut: StatutDeCompte
) : ICompte {

    companion object {
        var totalComptesCree: Int = 0
    }

    init {
        totalComptesCree++
    }

    val listeOperations: MutableList<Operation> = mutableListOf()
    var totalVersements: Double = 0.0
    var totalRetraits: Double = 0.0

    abstract override fun retirer(montant: Double): Retrait
    abstract override fun verser(montant: Double): Versement
    abstract override fun virement(montant: Double, compte: Compte): Double
    abstract override fun consulterSolde(): Double
    abstract override fun consulterOperation(): MutableList<Operation>
    abstract override fun totalVersements(): Double
    abstract override fun totalRetraits(): Double

    fun changerStatut(nouveauStatut: StatutDeCompte): StatutDeCompte? {

        when (statut) {
            StatutDeCompte.DELETED -> return null
            StatutDeCompte.CREATED -> statut = nouveauStatut
            StatutDeCompte.SUSPENDED -> statut = nouveauStatut
            StatutDeCompte.BLOCKED -> statut = nouveauStatut
        }

        return statut
    }
}