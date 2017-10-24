package pl.krystiankaniowski.billonsport.ui.match

import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.mvp.BaseContract

interface MatchDetailsContract {

	interface View : BaseContract.View {

		fun setTeams(team1: List<Player>, team2: List<Player>)

		fun showActionButtons()

		fun hideActionButtons()

	}

	interface Presenter : BaseContract.Presenter<View> {

		fun clickTeam1Win()

		fun clickTeam2Win()

		fun clickDraw()

	}

}