package ru.antonov.cats.main

import android.util.Log
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import ru.antonov.cats.app.CatsApplication
import ru.antonov.cats.screens.BasePresenter
import ru.antonov.cats.screens.cats.CatsFragment
import ru.mgts.navigation.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class MainPresenter: MvpPresenter<MainView> {

    @Inject
    lateinit var router: Router

    init {
        CatsApplication.appComponent.inject(this)
    }

    override fun destroy() {

    }

    override fun attachView(view: MainView) {
       Log.d("hfghfghfg", "dfgdfg")
    }

    override fun detachView(retainInstance: Boolean) {

    }

    override fun detachView() {

    }

    fun nextScreen() {
        router.appendScreen(CatsFragment::class.java.simpleName)
    }

}