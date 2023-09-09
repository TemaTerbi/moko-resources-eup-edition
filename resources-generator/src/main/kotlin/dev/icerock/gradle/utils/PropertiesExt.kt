/*
 * Copyright 2023 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.utils

import org.gradle.api.GradleException
import org.gradle.api.Project

internal fun Project.propertyString(name: String): String? {
    val property: Any = findProperty(name)
        ?: return null

    return property as? String
        ?: throw GradleException("Property $name should be String")
}

internal fun Project.requiredPropertyString(name: String): String {
    val property: Any = findProperty(name)
        ?: throw GradleException("Required property $name not found")

    return property as? String
        ?: throw GradleException("Property $name should be String")
}

internal val Project.isStrictLineBreaks: Boolean
    get() = project
        .propertyString("moko.resources.strictLineBreaks")
        ?.toBoolean() ?: false
