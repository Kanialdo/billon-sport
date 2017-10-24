package pl.krystiankaniowski.billonsport.database.sample

import pl.krystiankaniowski.billonsport.core.data.MatchResult
import pl.krystiankaniowski.billonsport.database.AppDatabase
import pl.krystiankaniowski.billonsport.database.entities.MatchDB
import pl.krystiankaniowski.billonsport.database.entities.MatchMemberDB
import pl.krystiankaniowski.billonsport.database.entities.PlayerDB

class DatabaseSample {

	fun fillSamplePlayers(database: AppDatabase) {

		Thread {

			val KANIA = "Kania"
			val OLEK = "Olek"
			val Konrad = "Konrad"
			val Michał_Kowal = "Michał Kowal"
			val Krzysiek = "Krzysiek"
			val Maciejka = "Maciejka"
			val Bartek = "Bartek"
			val Przysmaki = "Przysmaki"
			val Wojtas = "Wojtas"
			val Edi = "Edi"
			val Jacek = "Jacek"
			val Kamil = "Kamil"
			val Patryk = "Patryk"
			val Maciek_R = "Maciek R"
			val Mały_Kania = "Mały Kania"
			val Olek_Karpinski = "Olek_Karpinski"
			val LUKASZ = "LUKASZ"

			database.playerDao().insertPlayer(createPlayer(KANIA))
			database.playerDao().insertPlayer(createPlayer(OLEK))
			database.playerDao().insertPlayer(createPlayer(Konrad))
			database.playerDao().insertPlayer(createPlayer(Michał_Kowal))
			database.playerDao().insertPlayer(createPlayer(Krzysiek))
			database.playerDao().insertPlayer(createPlayer(Bartek))
			database.playerDao().insertPlayer(createPlayer(Przysmaki))
			database.playerDao().insertPlayer(createPlayer(Wojtas))
			database.playerDao().insertPlayer(createPlayer(Maciejka))
			database.playerDao().insertPlayer(createPlayer(Edi))
			database.playerDao().insertPlayer(createPlayer(Jacek))
			database.playerDao().insertPlayer(createPlayer(Kamil))
			database.playerDao().insertPlayer(createPlayer(Patryk))
			database.playerDao().insertPlayer(createPlayer(Maciek_R))
			database.playerDao().insertPlayer(createPlayer(Mały_Kania))
			database.playerDao().insertPlayer(createPlayer(Olek_Karpinski))

			createMatch(database, "1", listOf(KANIA, OLEK, Jacek, Mały_Kania, Wojtas), listOf(Przysmaki, Konrad, Kamil, Maciek_R, Bartek, Patryk)) //1
			createMatch(database, "2", listOf(KANIA, Przysmaki, Mały_Kania, Maciek_R, Patryk, Wojtas), listOf(OLEK, Konrad, Kamil, Jacek, Bartek)) //2
			createMatch(database, "3", listOf(KANIA, OLEK, Przysmaki, Maciek_R, Jacek, Kamil), listOf(Mały_Kania, Konrad, Bartek, Patryk, Wojtas)) //2

			createMatch(database, "4", listOf(OLEK, Patryk, Konrad, Maciejka, Edi, Mały_Kania), listOf(KANIA, Bartek, Wojtas, Krzysiek,Jacek, Michał_Kowal, Kamil))//1
			createMatch(database, "5", listOf(OLEK, Michał_Kowal,Edi, Kamil, Maciejka, Krzysiek, Jacek), listOf(Patryk, Konrad, Bartek, Wojtas, Mały_Kania, KANIA))//1
			createMatch(database, "6", listOf(Konrad, Michał_Kowal, KANIA, Jacek, Kamil, Mały_Kania), listOf(OLEK, Patryk, Maciejka, Wojtas, Bartek, Edi, Krzysiek))//1

			//createMatch(database, "7", listOf(KANIA, Olek_Karpinski, Bartek, LUKASZ, Edi, OLEK), listOf())
			//createMatch(database, "8", listOf(), listOf())
			//createMatch(database, "9", listOf(), listOf())

		}.start()

	}

	private fun createPlayer(name: String) = PlayerDB(name, name, name, name, 25.0f, 8.3f)

	private fun createMatch(database: AppDatabase, id: String, team1: List<String>, team2: List<String>) {
		database.eventDao().insertMatch(MatchDB(id, 0, MatchResult.UNKNOWN))
		var list = mutableListOf<MatchMemberDB>()
		for (player in team1) {
			list.add(MatchMemberDB(id, player, 1))
		}
		for (player in team2) {
			list.add(MatchMemberDB(id, player, 2))
		}
		database.eventDao().insertMatchPlayers(list)
	}

}