
package controllers.reviewer;

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

import controllers.AbstractController;
import domain.Certification;
import domain.Pencil458;
import services.Pencil458Service;

@Controller
@RequestMapping("/pencil/reviewer")
public class Pencil458ReviewerController extends AbstractController {

	//
	private Certification		certification;
	private boolean				alerta	= false;
	// Services ---------------------------------------------------------------
	@Autowired
	private Pencil458Service	pencil458Service;


	// Constructors -----------------------------------------------------------
	public Pencil458ReviewerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Pencil458> pencil458s;

		pencil458s = this.pencil458Service.findAllWithCertificate();
		/*
		 * for (final Pencil458 pencil458 : pencil458s) {
		 * System.out.println(pencil458.getId());
		 * System.out.println(pencil458.getAnniversary866());
		 * System.out.println(pencil458.getBirthdate045());
		 * System.out.println(pencil458.getDescription375());
		 * System.out.println(pencil458.getWeight343());
		 * System.out.println(pencil458.getCertification().getTitle());
		 * }
		 */
		result = new ModelAndView("pencil/list");
		result.addObject("requestURI", "pencil/reviewer/list.do");
		result.addObject("pencil458s", pencil458s);

		return result;
	}
	// Creation ---------------------------------------------------------------

	// Edition ----------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int pencil458Id) {
		final ModelAndView result;
		Pencil458 pencil458;

		pencil458 = this.pencil458Service.findOne(pencil458Id);
		Assert.notNull(pencil458);

		if (pencil458.getCertification().getId() > 0) {
			this.certification = pencil458.getCertification();
			this.alerta = true;
		}
		result = new ModelAndView("pencil/edit");
		//result.addObject("requestURI", "pencil/reviewer/edit.do");
		result.addObject("pencil458", pencil458);
		//System.out.println("1 IdCerti " + pencil458.getCertification().getId());
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Pencil458 pencil458, final BindingResult binding) {
		ModelAndView result;
		//System.out.println("2 IdCerti " + pencil458.getCertification().getId());
		if (this.alerta) {
			pencil458.setCertification(this.certification);
			this.alerta = false;
		}
		this.pencil458Service.save(pencil458);
		//System.out.println("3 IdCerti " + pencil458.getCertification().getId());
		result = new ModelAndView("redirect:list.do");

		return result;
	}

	// Ancillary methods ------------------------------------------------------

}
