package uk.co.certait.spring.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import uk.co.certait.spring.data.domain.QUser;
import uk.co.certait.spring.service.UserService;
import uk.co.certait.spring.web.utils.AjaxUtils;
import uk.co.certait.spring.web.utils.FilterForm;
import uk.co.certait.spring.web.utils.PaginatedListWrapper;

import com.mysema.query.BooleanBuilder;

@Controller
public class ListUsersController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/secure/admin/listUsers.do", method = RequestMethod.GET)
	public String listUsers(@ModelAttribute FilterForm form, Model model, WebRequest request, @PageableDefaults(sort = { "surname",
			"forename", "address.town" }, value = 10) Pageable pageable) {

		String target;
		model.addAttribute("users", getUsers(form, pageable));

		if (AjaxUtils.isAjaxRequest(request))
			target = "secure/admin/fragments/userTable";
		else
			target = "secure/admin/userList";

		return target;
	}

	@RequestMapping(value = "/secure/admin/filterUsers.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String filterUsers(@ModelAttribute FilterForm form, @RequestParam String action, WebRequest request, Model model,
			Pageable pageable) {

		String target;

		if (!action.equals("applyFilter")) {
			form.clear();
		}

		model.addAttribute("users", getUsers(form, pageable));

		if (AjaxUtils.isAjaxRequest(request)) {
			target = "secure/admin/fragments/userTable";
		}
		else {
			target = "secure/admin/userList";
		}

		return target;
	}

	private PaginatedListWrapper getUsers(FilterForm form, Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();

		if (StringUtils.isNotEmpty(form.getSurname())) {
			builder.and(QUser.user.surname.startsWithIgnoreCase(form.getSurname()));
			pageable.getSort().and(new Sort(Direction.ASC, "surname", "forename"));
		}

		if (StringUtils.isNotEmpty(form.getLocation())) {
			builder.and(QUser.user.address.town.startsWithIgnoreCase(form.getLocation()));
		}

		return new PaginatedListWrapper(userService.getUsersByCriteria(builder.getValue(), pageable));
	}

	@ModelAttribute("tabName")
	public String getTabName() {
		return "Admin";
	}

	@ModelAttribute("filterForm")
	public FilterForm getFilterForm() {
		return new FilterForm();
	}
}
