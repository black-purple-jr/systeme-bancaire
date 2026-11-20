import comptes.Compte
import comptes.CompteCourant
import comptes.CompteEpargne
import comptes.types.StatutDeCompte
import operations.Operation

fun main() {

    val listeComptes: MutableList<Compte> = mutableListOf(
        CompteCourant("C001", 1000.0, StatutDeCompte.CREATED, 500.0),
        CompteEpargne("C002", 10000.0, StatutDeCompte.CREATED, 4.0),
        CompteCourant("C003", 20.0, StatutDeCompte.CREATED, 500.0),
        CompteCourant("C004", 0.0, StatutDeCompte.CREATED, 500.0),
        CompteEpargne("C005", 0.0, StatutDeCompte.CREATED, 3.0)
    )

    println(listeComptes.filter { it -> it.solde == 0.0 })

    val montant = 800.0
    println(listeComptes.filter { it -> it.solde > montant })
    println(listeComptes.filter { it -> it.solde > montant && it.statut == StatutDeCompte.CREATED })

    listeComptes[0].verser(100.0)
    listeComptes[0].verser(1000.0)
    listeComptes[0].retirer(1600.0)
    listeComptes[0].verser(2500.0)

    listeComptes[3].verser(25000.0)

    println(listeComptes.maxBy { compte -> compte.totalVersements() })

    fun trouverParTypeDeCompte(liste: MutableList<Compte>, isCompteCourant: Boolean): List<Compte> {
        val returnList: MutableList<Compte> = mutableListOf()

        if (isCompteCourant) {
            liste.forEach { compte ->
                if (compte is CompteCourant) {
                    returnList.add(compte)
                }
            }
        } else {
            liste.forEach { compte ->
                if (compte is CompteEpargne) {
                    returnList.add(compte)
                }
            }
        }

        return returnList
    }

    println(trouverParTypeDeCompte(listeComptes, false))

    println(listeComptes.maxBy { compte -> compte.listeOperations.size })

    fun totalVersementsEtTotalDesRetraits(compte: Compte): Map<String, Double> {
        return mapOf(
            "totalVersements" to compte.totalVersements(),
            "totalRetraits" to compte.totalRetraits(),
        )
    }

    println(totalVersementsEtTotalDesRetraits(listeComptes[0]))

    fun Compte.afficherResumerDesTransactions(): MutableList<Operation> {
        return this.listeOperations
    }

    println(listeComptes[0].afficherResumerDesTransactions())


}