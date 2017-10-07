package pl.krystiankaniowski.billonsport.ui.adapter.delegates

import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalDelegatedAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.ui.data.PlayerUI

class PlayerDelegateAdapter : UniversalDelegatedAdapter<PlayerUI> {

	companion object {

		class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<PlayerUI>(viewGroup, layoutId) {

			@BindView(R.id.tv_nickname)
			lateinit var tvNickname: TextView

			@BindView(R.id.tv_name)
			lateinit var tvName: TextView

			@BindView(R.id.tv_mean)
			lateinit var tvMean: TextView

			@BindView(R.id.tv_unconfident)
			lateinit var tvUnconfident: TextView

			override fun bind(item: PlayerUI?) {
				tvNickname.text = item?.nickname
				tvName.text = item?.fullName
				tvMean.text = item?.ratingMean
				tvUnconfident.text = item?.ratingUnconfident
			}

		}

	}

	override fun onCreateViewHolder(viewGroup: ViewGroup?): UniversalViewHolder<PlayerUI> = ViewHolder(viewGroup!!, R.layout.list_player)

	override fun onBindViewHolder(viewHolder: UniversalViewHolder<PlayerUI>?, item: PlayerUI?) {
		viewHolder as ViewHolder
		viewHolder.bind(item)
	}

	override fun isForViewType(item: PlayerUI?): Boolean = true

}