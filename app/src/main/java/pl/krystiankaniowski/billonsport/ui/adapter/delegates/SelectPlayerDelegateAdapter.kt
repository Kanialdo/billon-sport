package pl.krystiankaniowski.billonsport.ui.adapter.delegates

import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalDelegatedAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.ui.addmatch.select.SelectPlayersContract

class SelectPlayerDelegateAdapter(val onClick: ((SelectPlayersContract.SelectablePlayerUI) -> Unit)?) : UniversalDelegatedAdapter<SelectPlayersContract.SelectablePlayerUI> {

	companion object {

		class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<SelectPlayersContract.SelectablePlayerUI>(viewGroup, layoutId) {

			@BindView(R.id.container)
			lateinit var llContainer: LinearLayout

			@BindView(R.id.tv_nickname)
			lateinit var tvNickname: TextView

			@BindView(R.id.tv_name)
			lateinit var tvName: TextView

			override fun bind(item: SelectPlayersContract.SelectablePlayerUI?) {
				tvNickname.text = item?.nickname + " " + item?.clicked
				tvName.text = item?.fullName
				llContainer.isClickable = true
			}

		}

	}

	override fun onCreateViewHolder(viewGroup: ViewGroup?): UniversalViewHolder<SelectPlayersContract.SelectablePlayerUI> = ViewHolder(viewGroup!!, R.layout.list_player_select)

	override fun onBindViewHolder(viewHolder: UniversalViewHolder<SelectPlayersContract.SelectablePlayerUI>?, item: SelectPlayersContract.SelectablePlayerUI?) {
		viewHolder as ViewHolder
		viewHolder.bind(item)

		if (onClick != null) {
			viewHolder.llContainer.setOnClickListener({ _ -> onClick.invoke(item!!) })
		}

	}

	override fun isForViewType(item: SelectPlayersContract.SelectablePlayerUI?): Boolean = true

}