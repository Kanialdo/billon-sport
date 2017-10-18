package pl.krystiankaniowski.billonsport.ui.adapter.delegates

import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalDelegatedAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.ui.adapter.items.LoadingItem

class LoadingDeleagtedAdapter : UniversalDelegatedAdapter<LoadingItem> {

	companion object {

		class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<LoadingItem>(viewGroup, layoutId) {

			@BindView(android.R.id.text1)
			lateinit var message: TextView

			@BindView(android.R.id.progress)
			lateinit var progress: ProgressBar

			override fun bind(item: LoadingItem?) {
				message.text = item?.message
			}

		}

	}

	override fun onCreateViewHolder(viewGroup: ViewGroup?): UniversalViewHolder<LoadingItem> = ViewHolder(viewGroup!!, R.layout.list_loading)

	override fun onBindViewHolder(viewHolder: UniversalViewHolder<LoadingItem>?, item: LoadingItem?) {
		viewHolder as ViewHolder
		viewHolder.bind(item)
	}

	override fun isForViewType(item: LoadingItem?): Boolean = true

}