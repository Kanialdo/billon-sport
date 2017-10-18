package pl.krystiankaniowski.billonsport.ui.adapter.delegates

import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalDelegatedAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalViewHolder
import pl.krystiankaniowski.billonsport.ui.adapter.items.MessageItem

class MessageDeleagtedAdapter : UniversalDelegatedAdapter<MessageItem> {

	companion object {

		class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<MessageItem>(viewGroup, layoutId) {

			@BindView(android.R.id.text1)
			lateinit var title: TextView

			@BindView(android.R.id.text2)
			lateinit var description: TextView

			override fun bind(item: MessageItem?) {
				title.text = item?.title
				description.text = item?.description
			}

		}

	}

	override fun onCreateViewHolder(viewGroup: ViewGroup?): UniversalViewHolder<MessageItem> = ViewHolder(viewGroup!!, R.layout.list_message)

	override fun onBindViewHolder(viewHolder: UniversalViewHolder<MessageItem>?, item: MessageItem?) {
		viewHolder as ViewHolder
		viewHolder.bind(item)
	}

	override fun isForViewType(item: MessageItem?): Boolean = true

}