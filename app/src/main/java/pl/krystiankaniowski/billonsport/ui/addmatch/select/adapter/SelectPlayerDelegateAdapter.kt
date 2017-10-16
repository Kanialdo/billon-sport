package pl.krystiankaniowski.billonsport.ui.addmatch.select.adapter

import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalDelegatedAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalViewHolder

class SelectPlayerDelegateAdapter(val onClick: ((SelectablePlayerUI) -> Unit)?) : UniversalDelegatedAdapter<SelectablePlayerUI> {

	companion object {

		class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<SelectablePlayerUI>(viewGroup, layoutId) {

			@BindView(R.id.container)
			lateinit var llContainer: LinearLayout

			@BindView(R.id.tv_nickname)
			lateinit var tvNickname: TextView

			@BindView(R.id.tv_name)
			lateinit var tvName: TextView

			override fun bind(item: SelectablePlayerUI?) {
				tvNickname.text = item?.nickname + " " + item?.clicked
				tvName.text = item?.fullName
				llContainer.isClickable = true
			}

		}

	}

	override fun onCreateViewHolder(viewGroup: ViewGroup?): UniversalViewHolder<SelectablePlayerUI> = ViewHolder(viewGroup!!, R.layout.list_player_select)

	override fun onBindViewHolder(viewHolder: UniversalViewHolder<SelectablePlayerUI>?, item: SelectablePlayerUI?) {
		viewHolder as ViewHolder
		viewHolder.bind(item)

		if (onClick != null) {
			viewHolder.llContainer.setOnClickListener({ _ -> onClick.invoke(item!!) })
		}

	}

	override fun isForViewType(item: SelectablePlayerUI?): Boolean = true

}