package ru.antonov.cats.navigator

import ru.terrakok.cicerone.Screen

data class ScreenItem(val screen: String, val data: Any?): Screen()