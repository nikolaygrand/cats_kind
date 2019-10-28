package ru.mgts.navigation

import ru.terrakok.cicerone.commands.Command

data class ForwardAppend (val screenKey : String, val transitionData : Any?): Command