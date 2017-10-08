package pl.krystiankaniowski.billonsport.ui.base

import android.support.annotation.CallSuper
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import butterknife.BindView
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import pl.krystiankaniowski.billonsport.ui.adapter.UniversalRecyclerAdapter
import pl.krystiankaniowski.billonsport.ui.adapter.ViewElement

abstract class BaseListFragment : BaseFragment() {

	@BindView(android.R.id.list)
	internal lateinit var recyclerAdapter: RecyclerView

	internal lateinit var adapter: UniversalRecyclerAdapter<ViewElement>

	// ---------------------------------------------------------------------------------------------

	@CallSuper
	override fun prepareView(view: View) {

		var builder = UniversalRecyclerAdapter.Builder<ViewElement>()
		builder = registerAdapters(builder)
		adapter = builder.build()

		recyclerAdapter.setHasFixedSize(true)
		recyclerAdapter.adapter = adapter
		recyclerAdapter.layoutManager = LinearLayoutManager(context)
		recyclerAdapter.itemAnimator = DefaultItemAnimator()

	}

	@CallSuper
	override fun dropView() {
	}

	abstract fun registerAdapters(builder: UniversalRecyclerAdapter.Builder<ViewElement>): UniversalRecyclerAdapter.Builder<ViewElement>

	// ---------------------------------------------------------------------------------------------

	open fun setLoadingData() {
		Toast.makeText(context, "loading", Toast.LENGTH_SHORT).show()
	}

	open fun setItems(items: MutableList<out ViewElement>) {
		adapter.setData(items)
		adapter.notifyDataSetChanged()
	}

	open fun updateItem(item: ViewElement, position: Int) {
		adapter.data[position] = item
		adapter.notifyItemChanged(position)
	}

	open fun setNoData(message: String?) {
		Toast.makeText(context, "no data $message", Toast.LENGTH_SHORT).show()
	}

	open fun setLoadingDataError(message: String?) {
		Toast.makeText(context, "error $message", Toast.LENGTH_SHORT).show()
	}

}