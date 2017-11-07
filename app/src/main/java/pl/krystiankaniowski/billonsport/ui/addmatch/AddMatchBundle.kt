package pl.krystiankaniowski.billonsport.ui.addmatch

import javax.inject.Inject

class AddMatchBundle @Inject constructor() {

	var playersIds: Set<String> = HashSet()
	var teamsCount: Int = 2
	var rounds: Int = 1
	var minMatchQuality: Float = 0.4f

}