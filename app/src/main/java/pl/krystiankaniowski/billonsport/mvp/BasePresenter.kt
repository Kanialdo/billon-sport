package pl.krystiankaniowski.billonsport.mvp

abstract class BasePresenter<View : BaseContract.View> : BaseContract.Presenter<View> {

    var view: View? = null

    final override fun takeView(view: View) {
        @Suppress("SENSELESS_COMPARISON")
        assert(view == null, { "View set already" })
        this.view = view
        onSubscribe()
    }

    final override fun dropView() {
        onUnsubscribe()
        this.view = null
    }

    abstract fun onSubscribe()

    abstract fun onUnsubscribe()

}
