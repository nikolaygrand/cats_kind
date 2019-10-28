package ru.antonov.cats.main

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.antonov.cats.R
import ru.antonov.cats.app.CatsApplication
import ru.antonov.cats.navigator.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import androidx.core.app.ComponentActivity.ExtraData
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import ru.antonov.cats.main.MainPresenter






class MainActivity : MvpActivity<MainView, MainPresenter>(), MainView {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = Navigator(this, R.id.fragment_main_layout)

    override fun onCreate(savedInstanceState: Bundle?) {
        CatsApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        btnNextScreen.setOnClickListener { presenter.nextScreen() }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun createPresenter(): MainPresenter = MainPresenter()
}
