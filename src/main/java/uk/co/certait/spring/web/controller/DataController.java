package uk.co.certait.spring.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.certait.spring.service.UserService;

@Controller
@RequestMapping("/secure")
public class DataController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/admin/getUniqueUserSurnames.do")
	public @ResponseBody
	List<String> getUniqueUserSurnames(@RequestParam("q") String query, @RequestParam("limit") int limit) {
		return userService.getUniqueUserSurnames(query, limit);
	}

	@RequestMapping("/admin/getUniqueUserLocations.do")
	public @ResponseBody
	List<String> getUniqueLocations(@RequestParam("q") String query, @RequestParam("limit") int limit) {
		return userService.getUniqueUserLocations(query, limit);
	}

	public class StringList extends ArrayList<String> {
		public StringList(List<String> data) {
			this.addAll(data);
		}
	}
}
