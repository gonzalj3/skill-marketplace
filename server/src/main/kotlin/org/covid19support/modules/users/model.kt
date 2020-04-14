package org.covid19support.modules.users

import org.jetbrains.exposed.sql.*

data class User(
        val id: Int?,
        val email: String,
        @Transient
        val password: String,
        val first_name: String,
        val last_name: String,
        val description: String?,
        val is_instructor: Boolean
)

object Users : Table() {
    val id: Column<Int> = integer("id").autoIncrement().primaryKey()
    val email: Column<String> = varchar("email", 256).uniqueIndex()
    val password: Column<String> = varchar("password", 64)
    val first_name: Column<String> = varchar("first_name", 32)
    val last_name: Column<String> = varchar("last_name", 32)
    val description: Column<String?> = varchar("description", 1024).nullable()
    val is_instructor: Column<Boolean> = bool("is_instructor").default(false);

    fun toUser(resultRow: ResultRow): User {
        return User(resultRow[id], resultRow[email], resultRow[password], resultRow[first_name], resultRow[last_name], resultRow[description], resultRow[is_instructor])
    }
}
