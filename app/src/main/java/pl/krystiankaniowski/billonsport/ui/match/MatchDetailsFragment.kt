package pl.krystiankaniowski.billonsport.ui.match

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import io.reactivex.disposables.CompositeDisposable
import pl.krystiankaniowski.billonsport.R
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.di.scopes.ActivityScoped
import pl.krystiankaniowski.billonsport.ui.BaseFragment
import javax.inject.Inject

/**
 * Created by kryst on 24.10.2017.
 */

@ActivityScoped
class MatchDetailsFragment @Inject constructor() : BaseFragment(), MatchDetailsContract.View {

	private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

	@Inject
	internal lateinit var presenter: MatchDetailsContract.Presenter

	@BindView(R.id.tv_team_1)
	internal lateinit var tv_team_1: TextView

	@BindView(R.id.tv_team_2)
	internal lateinit var tv_team_2: TextView

	@BindView(R.id.ll_actions)
	internal lateinit var llActions: LinearLayout

	// ---------------------------------------------------------------------------------------------

	override fun getLayoutId(): Int = R.layout.fragment_match_details

	override fun prepareView(view: View) {
	}

	override fun dropView() {
		compositeDisposable.clear()
	}

	override fun subscribePresenter() {
		presenter.takeView(this)
	}

	override fun unsubscribePresenter() {
		presenter.dropView()
	}

	// ---------------------------------------------------------------------------------------------

	override fun showActionButtons() {
		llActions.visibility = View.VISIBLE
	}

	override fun hideActionButtons() {
		llActions.visibility = View.GONE
	}

	override fun setTeams(team1: List<Player>, team2: List<Player>) {
		tv_team_1.text = team1.map { it.nickname }.toString()
		tv_team_2.text = team2.map { it.nickname }.toString()
	}

	// ---------------------------------------------------------------------------------------------

	@OnClick(R.id.b_win_team_1)
	internal fun clickWinTeam1() {
		presenter.clickTeam1Win()
	}

	@OnClick(R.id.b_draw)
	internal fun clickDraw() {
		presenter.clickDraw()
	}

	@OnClick(R.id.b_win_team_2)
	internal fun clickWinTeam2() {
		presenter.clickTeam2Win()
	}

}