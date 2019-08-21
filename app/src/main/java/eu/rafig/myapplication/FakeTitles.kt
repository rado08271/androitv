/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package eu.rafig.myapplication

object FakeTitles {
    val LIST: List<Titles> by lazy {
        setup()
    }
    private fun setup(): List<Titles> {
        val title = arrayOf(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
        )

        val list = title.indices.map {
            buildInfo(
                title[it]
            )
        }

        return list
    }

    private fun buildInfo(titleString: String): Titles {
        val title = Titles()
        title.title = titleString
        return title
    }
}