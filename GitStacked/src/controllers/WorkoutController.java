package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.PersistenceDAO;
import entities.Exercise;
import entities.LoginUserType;
import entities.User;
import entities.Workout;
import entities.WorkoutExercise;

@SessionAttributes({"user"})
@Controller
public class WorkoutController {

	@Autowired
	private PersistenceDAO dao;
	
	@ModelAttribute("user")
	public User newUser() {
		return new User();
	}
	
	@RequestMapping(path = "createUser.do", method = RequestMethod.GET) 
	public ModelAndView signupForm() {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("user", user);
		mv.setViewName("signup.jsp");
		return mv;
	}
	
	@RequestMapping(path = "createUser.do", method = RequestMethod.POST) 
	public ModelAndView createUser(@ModelAttribute("user") User user) {
		System.out.println(user);
		dao.createNewUser(user);
//		ModelAndView mv = new ModelAndView("profile.jsp", "user", user);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("profile.jsp");
		return mv;
	}
	
	@RequestMapping(path = "login.do", method = RequestMethod.GET) 
	public ModelAndView loginForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping(path = "login.do", method = RequestMethod.POST) 
	public ModelAndView login(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		if (dao.login(user) == null) {
			mv.setViewName("incorrectLogin.jsp");
			return mv;
		}
		if(dao.login(user).getLoginUsertype() == LoginUserType.ADMIN){
			mv.addObject("user", dao.login(user));
			mv.setViewName("admin.jsp");
			return mv;
		}
		mv.addObject("user", dao.login(user));
		mv.setViewName("profile.jsp");
		return mv;
	}
	
	@RequestMapping(path = "editUser.do", method = RequestMethod.POST) 
	public ModelAndView editWeight(@ModelAttribute("user") User user) {
		System.out.println(user);
		ModelAndView mv = new ModelAndView("profile.jsp", "user", dao.persistUser(user));
		return mv;
	}
	
	@RequestMapping(path = "getExercise.do", method = RequestMethod.GET) 
	public ModelAndView getExerciseByName(@RequestParam("exerciseName") String exerciseName) {
		ModelAndView mv = new ModelAndView("exercisePage.jsp", "exercise", dao.getExerciseByName(exerciseName));
		return mv;
	}
	
	@RequestMapping(path = "createWorkout.do", method = RequestMethod.GET)
	public ModelAndView createWorkout(@ModelAttribute("user") User user, WorkoutExercise workoutexercise) {
		ModelAndView mv = new ModelAndView("workoutBuilder.jsp", "exercises", dao.getListOfExercises());
//		user.getWorkouts().get(0)
		return mv;
	}
	
	@RequestMapping(path = "createWorkout.do", method = RequestMethod.POST)
	public ModelAndView publishWorkout(@RequestParam("exerciseId") int id, @ModelAttribute("user") User user, @RequestParam("reps") String reps, @RequestParam("weight") String weight) {
		Exercise exercise = dao.getExerciseById(user, id);
		int r = Integer.parseInt(reps);
		int w = Integer.parseInt(weight);
		WorkoutExercise workoutexercise = new WorkoutExercise(exercise, r, w);
		System.out.println(workoutexercise);
		Workout workout = new Workout();
		workout.addWorkoutExercise(workoutexercise);
		user.addWorkout(workout);
		List<Workout> userWorkouts = user.getWorkouts();
//		userWorkouts.add(workout);
		ModelAndView mv = new ModelAndView("profile.jsp");
		mv.addObject("userWorkouts", userWorkouts);
		dao.persistUser(user);
		for (Workout workout2 : userWorkouts) {
			System.out.println(workout2);
		}
		return mv;
	}
	
}
