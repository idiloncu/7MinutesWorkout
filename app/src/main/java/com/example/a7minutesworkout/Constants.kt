package com.example.a7minutesworkout

object Constants {

    fun defaultExerciseList():ArrayList<ExerciseModel>{
        val exerciseList=ArrayList<ExerciseModel>()
        val jumpingJacks=ExerciseModel(1,"Jumping Jacks",R.drawable.ic_jumping_jacks,false,false)
        exerciseList.add(jumpingJacks)

        val sidePlank = ExerciseModel(2, "Side Plank", R.drawable.ic_plank, false, false)
        exerciseList.add(sidePlank)

        val pushUp = ExerciseModel(3, "Push Up", R.drawable.ic_push_up, false, false)
        exerciseList.add(pushUp)

        val squats = ExerciseModel(4, "Squats", R.drawable.ic_squat, false, false)
        exerciseList.add(squats)

        val stepUpOnChair = ExerciseModel(5, "Wall Sit", R.drawable.ic_step_up_onto_chair, false, false)
        exerciseList.add(stepUpOnChair)


        return exerciseList

    }
}