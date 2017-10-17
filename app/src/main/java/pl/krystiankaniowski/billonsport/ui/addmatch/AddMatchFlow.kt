package pl.krystiankaniowski.billonsport.ui.addmatch

interface AddMatchFlow {

	fun showSelectPlayersView()

	fun showProcessingView()

	fun showMatchView()

	fun getBundle(): AddMatchBundle

}