package comptes

import operations.Operation
import operations.Retrait
import operations.Versement

interface ICompte {

    fun verser (montant: Double): Versement
    fun retirer (montant: Double): Retrait
    fun virement (montant: Double, compte: Compte): Double
    fun consulterSolde (): Double
    fun consulterOperation (): MutableList<Operation>
    fun totalVersements (): Double
    fun totalRetraits (): Double
}