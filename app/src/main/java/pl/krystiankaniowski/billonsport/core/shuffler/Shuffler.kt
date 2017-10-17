package pl.krystiankaniowski.billonsport.core.shuffler

import pl.krystiankaniowski.billonsport.core.data.Player

interface Shuffler {

	fun getMatchQuality(team1: List<Player>, team2: List<Player>) : Double

}