/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.koin.core.logger

import java.text.SimpleDateFormat
import java.util.*


/**
 * Logger that print on system.out
 * @author - Arnaud GIULIANI
 */
class PrintLogger(level: Level = Level.NONE, val dateFormat: String = "HH:mm:ss:SSS") : Logger() {

    init {
        this.level = level
    }

    private val df = SimpleDateFormat(dateFormat)

    private fun date() = df.format(Date()).toString()

    override fun log(level: Level, msg: MESSAGE) {
        val printer = if (level >= Level.ERROR) System.err else System.out
        if (this.level <= level) {
            printer.println("${date()} [$level] ${msg()}")
        }
    }
}