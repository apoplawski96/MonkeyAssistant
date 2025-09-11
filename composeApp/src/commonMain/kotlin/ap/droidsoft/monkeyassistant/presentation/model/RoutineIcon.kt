package ap.droidsoft.monkeyassistant.presentation.model

enum class RoutineIcon {
    Exercise, SportsKabaddi, AccountBalance, AttachMoney, GarageMoney, RequestQuote, ShoppingCart, Default
}

val RoutineIcon.resourceId: String
    get() = buildString {
        name.forEachIndexed { index, c ->
            if (c.isUpperCase() && index != 0) append('_')
            append(c.lowercaseChar())
        }
        append("_24px")
    }

val RoutineIcon.dbKey: String
    get() = name

//Image(painterResource(Res.allDrawableResources["compose_multiplatform"]!!), null)