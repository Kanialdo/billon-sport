package pl.krystiankaniowski.billonsport.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment : Fragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var fragmentView: View
    private lateinit var unbinder : Unbinder

    // ---------------------------------------------------------------------------------------------

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentView = inflater!!.inflate(getLayoutId(), container, false)
        unbinder = ButterKnife.bind(this, fragmentView);
        prepareView(fragmentView)
        return fragmentView
    }

    override fun onResume() {
        super.onResume()
        subscribePresenter()
    }

    override fun onPause() {
        unsubscribePresenter()
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return childFragmentInjector
    }

    // ---------------------------------------------------------------------------------------------

    abstract fun prepareView(view: View)

    abstract fun dropView()

    abstract fun getLayoutId(): Int

    abstract fun subscribePresenter()

    abstract fun unsubscribePresenter()


}
