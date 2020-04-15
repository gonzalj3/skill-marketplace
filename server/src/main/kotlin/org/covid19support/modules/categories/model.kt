package org.covid19support.modules.categories

import org.jetbrains.exposed.sql.*

data class Category(val name: String)

object Categories : Table("categories") {
    val name: Column<String> = varchar("name", 128).primaryKey()

    fun toCategory(resultRow: ResultRow): Category {
        return Category(resultRow[name])
    }
}