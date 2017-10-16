package pl.krystiankaniowski.billonsport.ui.addmatch.select.adapter

import pl.krystiankaniowski.billonsport.ui.data.PlayerUI

class SelectablePlayerUI(player: PlayerUI, var clicked: Boolean) :
		PlayerUI(player.id, player.nickname, player.fullName, player.ratingMean, player.ratingUnconfident)