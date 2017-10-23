package pl.krystiankaniowski.billonsport.ui.adapter.delegates

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalDelegatedAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.ui.data.MatchUI

class MatchDelegateAdapter(val onClick: ((MatchUI) -> Unit)?) : UniversalDelegatedAdapter<MatchUI> {

	companion object {

		class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<MatchUI>(viewGroup, layoutId) {

			@BindView(R.id.tv_date)
			lateinit var tvDate: TextView

			@BindView(R.id.tv_players)
			lateinit var tvPlayers: TextView

			@BindView(R.id.iv_state)
			lateinit var ivState: ImageView

			override fun bind(item: MatchUI?) {
				tvDate.text = item?.date.toString()
				tvPlayers.text = "${item?.team1} vs ${item?.team2}"
				// ivState.
			}

		}

	}

	override fun onCreateViewHolder(viewGroup: ViewGroup?): UniversalViewHolder<MatchUI> = ViewHolder(viewGroup!!, R.layout.list_match)

	override fun onBindViewHolder(viewHolder: UniversalViewHolder<MatchUI>?, item: MatchUI?) {
		viewHolder as ViewHolder
		viewHolder.bind(item)

		if (onClick != null) {
			viewHolder.itemView.isClickable = true
			viewHolder.itemView.setOnClickListener({ _ -> onClick.invoke(item!!) })
		}

	}

	override fun isForViewType(item: MatchUI?): Boolean = true

}