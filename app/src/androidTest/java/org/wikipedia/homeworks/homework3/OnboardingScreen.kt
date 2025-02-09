package org.wikipedia.homeworks.homework3

import com.google.android.material.button.MaterialButton
import android.widget.ImageView
import android.widget.TextView

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_continue_button",
    "onboarding_continue"
)

val logoImage = listOf(
    ImageView::class.java,
    "fragment_onboarding_logo"
)

val welcomeText = listOf(
    TextView::class.java,
    "fragment_onboarding_welcome_text",
    "onboarding_welcome_message"
)

val exploreTitle = listOf(
    TextView::class.java,
    "fragment_explore_title",
    "onboarding_explore_title"
)

val exploreDescription = listOf(
    TextView::class.java,
    "fragment_explore_description",
    "onboarding_explore_description"
)

val getStartedButton = listOf(
    MaterialButton::class.java,
    "fragment_explore_get_started_button",
    "onboarding_get_started"
)