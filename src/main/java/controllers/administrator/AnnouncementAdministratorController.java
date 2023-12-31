/*
 * AnnouncementAdministratorController.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers.administrator;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AnnouncementService;
import services.CertificationService;
import services.ExamService;
import services.ReviewerService;
import controllers.AbstractController;
import domain.Announcement;
import domain.Certification;
import domain.Exam;
import domain.Reviewer;

@Controller
@RequestMapping("/announcement/administrator")
public class AnnouncementAdministratorController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private AnnouncementService		announcementService;
	@Autowired
	private CertificationService	certificationService;
	@Autowired
	private ExamService				examService;
	@Autowired
	private ReviewerService			reviewerService;


	// Constructors -----------------------------------------------------------

	public AnnouncementAdministratorController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Announcement> announcements;

		announcements = this.announcementService.findAll();
		result = new ModelAndView("announcement/list");
		result.addObject("requestURI", "announcement/administrator/list.do");
		result.addObject("announcements", announcements);

		return result;
	}

	// Creation ---------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Announcement announcement;

		announcement = this.announcementService.create();
		result = this.createEditModelAndView(announcement);

		return result;
	}

	// Edition ----------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int announcementId) {
		ModelAndView result;
		Announcement announcement;

		announcement = this.announcementService.findOne(announcementId);
		Assert.notNull(announcement);
		result = this.createEditModelAndView(announcement);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Announcement announcement, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(announcement);
		else
			try {
				this.announcementService.save(announcement);
				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(announcement, "announcement.commit.error");
			}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Announcement announcement, final BindingResult binding) {
		ModelAndView result;

		try {
			this.announcementService.delete(announcement);
			result = new ModelAndView("redirect:list.do");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(announcement, "announcement.commit.error");
		}

		return result;
	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final Announcement announcement) {
		ModelAndView result;

		result = this.createEditModelAndView(announcement, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(final Announcement announcement, final String message) {
		ModelAndView result;
		Certification certification;
		Collection<Certification> certifications;
		Collection<Exam> exams;
		Collection<Reviewer> reviewers;

		certifications = this.certificationService.findAllActive();
		if (announcement.getCertification() == null) {
			certification = null;
			exams = null;
		} else {
			certification = announcement.getCertification();
			// Can't use certification.getExams() because of a lazy initialisation error.
			// When the announcement is loaded, before it's passed onto the controller, the 
			// transaction is closed; thus, certification.getExams() can't be unfolded :(
			exams = this.examService.getExams(certification.getId());
		}
		reviewers = this.reviewerService.findAll();

		result = new ModelAndView("announcement/edit");
		result.addObject("announcement", announcement);
		result.addObject("certifications", certifications);
		result.addObject("exams", exams);
		result.addObject("reviewers", reviewers);
		result.addObject("message", message);

		return result;
	}

}
