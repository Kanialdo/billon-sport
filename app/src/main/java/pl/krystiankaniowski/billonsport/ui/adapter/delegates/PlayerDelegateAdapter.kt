package pl.krystiankaniowski.billonsport.ui.adapter.delegates

import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalDelegatedAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalViewHolder

class PlayerDelegateAdapter : UniversalDelegatedAdapter<Player> {

    companion object {

        class ViewHolder(viewGroup: ViewGroup, layoutId: Int) : UniversalViewHolder<Player>(viewGroup, layoutId) {

            @BindView(R.id.tv_nickname)
            lateinit var tvNickname: TextView

            @BindView(R.id.tv_name)
            lateinit var tvName: TextView

            @BindView(R.id.tv_mean)
            lateinit var tvMean: TextView

            @BindView(R.id.tv_unconfident)
            lateinit var tvUnconfident: TextView

            override fun bind(item: Player?) {
                tvNickname.text = item?.nickname
                tvName.text = "${item?.firstName} ${item?.lastName}"
                tvMean.text = item?.rating?.mean.toString()
                tvUnconfident.text = item?.rating?.unconfident.toString()
            }

        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup?): UniversalViewHolder<Player> = ViewHolder(viewGroup!!, R.layout.list_player)

    override fun onBindViewHolder(viewHolder: UniversalViewHolder<Player>?, item: Player?) {
        viewHolder as ViewHolder
        viewHolder.bind(item)
    }

    override fun isForViewType(item: Player?): Boolean = true

}