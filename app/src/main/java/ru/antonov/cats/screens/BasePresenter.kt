package ru.antonov.cats.screens

import android.text.method.TextKeyListener.clear
import androidx.annotation.NonNull
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import org.reactivestreams.Subscription
import com.hannesdorfmann.mosby3.mvp.MvpView


open class BasePresenter<View : MvpView> : MvpPresenter<View> {

    override fun destroy() {
    }

    override fun attachView(view: View) {

    }

    override fun detachView(retainInstance: Boolean) {

    }

    override fun detachView() {

    }
}