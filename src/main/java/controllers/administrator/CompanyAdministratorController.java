
package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		result.addObject("companys", companys);
		result.addObject("requestURI", "company/administrator/list.do");
		return result;
	}
	// Creation ---------------------------------------------------------------

	// Edition ----------------------------------------------------------------

	// Ancillary methods ------------------------------------------------------

}
