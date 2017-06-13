package data;

import java.time.LocalDate;
import java.util.List;

import entities.Exercise;
import entities.User;
import entities.Workout;
import entities.WorkoutExercise;

/*
 * This blueprint which provides context for persisting GitStacked web application
 */

public interface PersistenceDAO {

	/*
		put these in UserDAO
	*/
	User createNewUser(User user);
	User persistUser(User user);
	int getUserIdByUsername(String username);
	List<User> getAllUsers();
	
	/*
		put these in AuthDAO
	*/
	User login(User user);
	
	/*
		put these in ExerciseDAO
	*/
	Exercise getExerciseByName(String exerciseName);
	List<Exercise> getListOfExercises();
	void createExercise(Exercise exercise);
	void deleteExercise(Exercise exercise, String choice);
	int getExerciseIdByName(String name);
	Exercise getExerciseById(User user, int id);
	List<Exercise> getAllExercises();
	
	/*
		put these in WorkoutDAO
	*/
	Workout persistWorkout(Workout workout);
	User persistWorkouts(Workout w);
	List<Workout> getWorkoutsFromUser(User user);
	void removeWorkout(int id);
	int getCaloriesByWorkout(Workout workout);
	void removeWorkoutExercise(int id);
	
	/*
		This could go a few places, I would recommend making it it's own bean and
		autowiring it where needed
	*/
	int compareDate(LocalDate otherDate);

		
}
