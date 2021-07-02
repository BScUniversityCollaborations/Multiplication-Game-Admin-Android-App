package com.unipi.p17172p17168p17164.multiplicationgameadminapp.utils

import com.google.android.material.behavior.SwipeDismissBehavior
import com.google.android.material.snackbar.BaseTransientBottomBar

// Create a custom object to declare all the constant values in a single file. The constant values declared here is can be used in whole application.
/**
 * A custom object to declare all the constant values in a single file. The constant values declared here is can be used in whole application.
 */
object Constants {
    // General Constants
    const val TAG: String = "[MultiplicationGameAdminApp]"
    const val SHARED_PREFERENCES_PREFIX: String = "MultiplicationGameAdminPrefs"
    const val LOGGED_IN_EMAIL: String = "logged_in_email"
    const val SPLASH_SCREEN_DELAY: Long = 1500
    const val VOLUME_MEDIUM: Float = 75f
    const val VOLUME_MAX: Float = 100f
    const val DEFAULT_TEST_TIMER_DELAY: Long = 60000
    val SNACKBAR_BEHAVIOR = BaseTransientBottomBar.Behavior().apply {
        setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY) }

    // Firebase Constants
    // This is used for the collection name for USERS.
    const val COLLECTION_USERS: String = "users"
    const val COLLECTION_LOGS: String = "logs"

    // Fields
    const val FIELD_DATE_ADDED: String = "dateAdded"
    const val FIELD_DATE_REGISTERED: String = "dateRegistered"
    const val FIELD_EMAIL: String = "email"
    const val FIELD_FULL_NAME: String = "fullName"
    const val FIELD_ID: String = "id"
    const val FIELD_TABLE_ID: String = "tableId"
    const val FIELD_NUMBER: String = "number"
    const val FIELD_LIMIT: String = "limit"
    const val FIELD_NAME: String = "name"
    const val FIELD_DESC: String = "desc"
    const val FIELD_USER_ID: String = "userId"

    // Intent Extras
    const val EXTRA_USER_ID: String = "extraUserId"
    const val EXTRA_USER_EMAIL: String = "extraUserEmail"
    const val EXTRA_USER_FULL_NAME: String = "extraUserFullName"
}
// END