package pl.krystiankaniowski.billonsport.mvp

interface BaseContract {

	interface View

	interface Presenter<in V : View> {

		fun takeView(view: V)

		fun dropView()

	}

}



