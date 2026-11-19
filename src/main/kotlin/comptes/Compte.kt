package comptes

import comptes.types.StatutDeCompte
import operations.Operation


abstract class Compte (
    val code: String,
    var solde: Double,
    val statut: StatutDeCompte
): ICompte {

    val listeOperations: MutableList<Operation> = mutableListOf()
    var totalVersements: Double = 0.0
    var totalRetraits: Double = 0.0

    override abstract fun virement (montant: Double, compte: Compte): Double?
    override abstract fun consulterSolde (): Double
    override abstract fun consulterOperation (): MutableList<Operation>
    override abstract fun totalVersements (): Double
    override abstract fun totalRetraits (): Double
}