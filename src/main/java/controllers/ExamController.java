/*
 * ExamController.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ExamService;
import domain.Exam;

@Controller
@RequestMapping("/exam")
public class ExamController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private ExamService	examService;


	// Constructors -----------------------------------------------------------

	public ExamController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/findByCertificationId")
	public ModelAndView findByCertificationId(@RequestParam final int certificationId) {
		ModelAndView result;
		Collection<Exam> exams;

		exams = this.examService.getExams(certificationId);

		result = new ModelAndView("exam/dropdown");
		result.addObject("exams", exams);

		return result;
	}

}
