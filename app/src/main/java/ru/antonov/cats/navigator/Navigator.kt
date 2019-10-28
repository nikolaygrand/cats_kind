package ru.antonov.cats.navigator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import io.reactivex.subjects.PublishSubject
import ru.antonov.cats.app.CatsApplication
import ru.antonov.cats.screens.cats.CatsFragment
import ru.mgts.navigation.ForwardAppend
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import ru.terrakok.cicerone.commands.Replace
import java.io.Serializable
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

class Navigator(val activity: FragmentActivity, private val containerId: Int) : SupportAppNavigator(activity, containerId) {

    private val exitClicks = PublishSubject.create<Unit>()
    val exitDispose = exitClicks
        .doOnNext { showSystemMessage("Нажмите ещё раз, чтобы выйти") }
        .buffer(2000, 0, TimeUnit.MILLISECONDS)
        .filter{ it.size > 1}
        .subscribe {
            exitProcess(0)
        }

    init {
        CatsApplication.appComponent.inject(this)
    }

    fun exit() {
        //replace(Replace(HOME_SCREEN, null))
        exitClicks.onNext(Unit)
    }

    fun showSystemMessage(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }


    fun createFragment(screenKey: String?, data: Any?) : Fragment? {
        Log.d(TAG, "createFragment " + screenKey + " data "+ data.toString())

        return when (screenKey) {
            CatsFragment::class.java.simpleName -> CatsFragment()
            else -> CatsFragment()
        }.apply  {
            val lBundle = arguments?.let {it} ?: Bundle()
            (data as? Serializable)?.run {
                lBundle.putSerializable(data::class.java.simpleName, this)
            }
            arguments = lBundle
        }
    }

    override fun applyCommand(command: Command) {
        super.applyCommand(command)
        if(command is ForwardAppend){
            forwardAppend(command)
        }
    }

    protected fun forwardAppend(command: ForwardAppend) {
        val fragment = createFragment(command.screenKey, command.transitionData)

        val fragmentTransaction = activity.supportFragmentManager.beginTransaction()

        setupFragmentTransaction(
            command,
            activity.supportFragmentManager.findFragmentById(containerId),
            fragment,
            fragmentTransaction
        )

        if (fragment != null) {
            fragmentTransaction
                .add(containerId, fragment)
                .addToBackStack(command.screenKey)
                .commit()
        }
    }

    companion object {
        val TAG = Navigator::class.java.simpleName!!
        const val HOME_SCREEN = "home"
    }
}