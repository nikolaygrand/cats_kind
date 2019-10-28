package ru.mgts.navigation

import android.util.Log
import ru.antonov.cats.BuildConfig
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import java.util.*

class Router : Router() {
    val history : Stack<Screen> = Stack()

    override fun exit() {
        if (BuildConfig.DEBUG) {
            Thread.dumpStack()
        }
        super.exit()
        if(history.size > 0){
            history.pop()
        }
    }

    fun last() : String =
        if(history.size > 0){
            history[history.size - 1].screenKey
        } else {
            ""
        }

    override fun navigateTo(screen: Screen?) {
        super.navigateTo(screen)
        Log.d("Router", "navigateTo: $screen")
        history.push(screen)
    }

    override fun newRootScreen(screen: Screen?) {
        super.newRootScreen(screen)
        Log.d("Router", "newRootScreen: $screen")
        history.clear()
        history.push(screen)
    }

    override fun replaceScreen(screen: Screen?) {
        super.replaceScreen(screen)
        if(history.size > 0) {
            history.pop()
        }
        history.push(screen)

    }

    fun appendScreen(screenKey: String) {
        appendScreen(screenKey, null)
    }

    fun appendScreen(screenKey: String, data: Any?) {
        if (BuildConfig.DEBUG) {
            Thread.dumpStack()
        }
        executeCommands(ForwardAppend(screenKey, data))
        Log.d("Router", "replaceScreen: $screenKey")
        //history.push(ScreenItem(screenKey, 0))
    }
}
