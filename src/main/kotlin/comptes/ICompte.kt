package comptes

import operations.Operation

interface ICompte {

    fun virement (montant: Double, compte: Compte): Double?
    fun consulterSolde (): Double
    fun consulterOperation (): MutableList<Operation>
    fun totalVersements (): Double
    fun totalRetraits (): Double
}