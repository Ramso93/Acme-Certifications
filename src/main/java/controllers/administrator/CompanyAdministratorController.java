
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

import controllers.AbstractController;
import domain.Company;
import services.CompanyService;

@Controller
@RequestMapping("/company/administrator")
public class CompanyAdministratorController extends AbstractController {

	// Services ---------------------------------------------------------------
	@Autowired
	private CompanyService companyService;


	// Constructors -----------------------------------------------------------
	public CompanyAdministratorController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Company> companys;

		companys = this.companyService.findAll();
		result = new ModelAndView("company/list");
		result.addObject("requestURI", "company/administrator/list.do");
		result.addObject("companys", companys);

		return result;
	}
	// Creation ---------------------------------------------------------------

	// Edition ----------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int companyId) {
		ModelAndView result;
		Company company;

		company = this.companyService.findOne(companyId);
		result = new ModelAndView("company/edit");
		Assert.notNull(company);
		result.addObject("company", company);

		return result;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Company company, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(company);
		else
			try {
				this.companyService.save(company);
				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(company, "company.commit.error");
			}

		return result;
	}
	// Ancillary methods ------------------------------------------------------
	protected ModelAndView createEditModelAndView(final Company company) {
		ModelAndView result;

		result = this.createEditModelAndView(company, null);

		return result;
	}
	protected ModelAndView createEditModelAndView(final Company company, final String message) {
		ModelAndView result;

		result = new ModelAndView("company/edit");
		//result.addObject("company", company);
		result.addObject("message", message);

		return result;
	}
}
