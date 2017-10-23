package pl.krystiankaniowski.billonsport.ui.data

import pl.krystiankaniowski.billonsport.core.data.Match
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElementType

open class MatchUI(
		val id: String,
		val date: Long,
		val team1: String,
		val team2: String) : ViewElement {

	companion object {

		fun fromMatch(match: Match) = MatchUI(match.id, match.date, match.team1.toString(), match.team2.toString())

	}

	override fun getViewType(): Int = ViewElementType.MATCH_ITEM.ordinal

}