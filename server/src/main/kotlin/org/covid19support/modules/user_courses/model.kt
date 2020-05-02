package org.covid19support.modules.user_courses

import org.covid19support.modules.courses.Courses
import org.covid19support.modules.users.Users
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

data class UserCourse(val id: Int?,
                      val userId: Int,
                      val courseId: Int,
                      val courseDate: DateTime,
                      val courseTime: DateTime,
                      val courseLength: Short)

object UserCourses : IntIdTable("user_courses") {
    val user_id: Column<Int> = integer("user_id").references(Users.id)
    val course_id: Column<Int> = integer("course_id").references(Courses.id)
    val course_date: Column<DateTime> = datetime("course_date")
    val course_time: Column<DateTime> = datetime("course_time")
    val course_length: Column<Short> = short("course_length")
    override val primaryKey = PrimaryKey(id, name = "PK_User_Courses_Id")

    fun toUserCourse(resultRow: ResultRow): UserCourse {
        return UserCourse(resultRow[id].value, resultRow[user_id], resultRow[course_id], resultRow[course_date], resultRow[course_time], resultRow[course_length])
    }
}