package pl.krystiankaniowski.billonsport.mvp

open class BasePresenter<View : BaseContract.View> : BaseContract.Presenter<View> {

    var view: View? = null

    final override fun takeView(view: View) {
        @Suppress("SENSELESS_COMPARISON")
        assert(view == null, {"View set already"})
        this.view = view
    }

    final override fun dropView() {
        this.view = null
    }

}
