package pl.krystiankaniowski.billonsport.ui.addmatch

interface AddMatchFlow {

	fun showSelectPlayersView()

	fun showConfigureView()

	fun showProcessingView()

	fun showMatchView()

	fun getBundle(): AddMatchBundle

}