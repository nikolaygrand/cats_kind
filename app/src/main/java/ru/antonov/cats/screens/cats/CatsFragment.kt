package ru.antonov.cats.screens.cats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import ru.antonov.cats.R
import ru.terrakok.cicerone.android.support.SupportAppScreen

class CatsFragment: MvpFragment<CatsView, CatsPresenter>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cats_all, null, false)
    }

    override fun createPresenter(): CatsPresenter = CatsPresenter()
}