package ru.antonov.cats.screens.cats

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import ru.antonov.cats.app.CatsApplication
import ru.antonov.cats.screens.BasePresenter

class CatsPresenter: BasePresenter<CatsView>() {
    init {
        CatsApplication.appComponent.inject(this)
    }
}