package com.example.codehiveregistrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class coursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        var rvCourses = findViewById<RecyclerView>(R.id.rvCourses)
        var coursesList = listOf(
            Courses("Python", "5476", "Python Introduction", "Mwai"),
            Courses("JavaScript", "67587", "React in JavaScript", "Maina"),
            Courses("NYJ", "67997", "Navigating your journey", "Veronicah"),
            Courses("Professional Development", "47587", "Understanding yourself", "Rodgers"),
            Courses("UI/UX Design", "97587", "User experience and User interface", "Erick"),
            Courses("UX Research", "36550", "study of target user and their requirements", "Joy")

        )
        var coursesAdapter=CoursesAdapter(coursesList)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=coursesAdapter

}
}