package com.crs.www.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crs.www.entity.Student;
import com.crs.www.service.IStudentManagementService;

@RequestMapping("/student")
public class StudentOperationController {

	@Autowired
	private IStudentManagementService stdService;
	@GetMapping("/")
	public String showHomePage()
	{
		return "welcome";
	}
	@GetMapping("/report")
	public String fetchAllStudent(Map<String,Object> map)
	{
		Iterable<Student> it=stdService.showAllStudent();
		map.put("stdList", it);
		return "show_report";
	}
	@GetMapping("/std_add")
	public String showForsaveStudent(@ModelAttribute("stud")Student stud)
	{
		return "register_student";
	}
	@PostMapping("/std_add")
	public String saveStudent(@ModelAttribute("stud") Student stud,Map<String,Object>map )
	{
		String msg=stdService.registerStudent(stud);
		Iterable<Student> itStud=stdService.showAllStudent();
		map.put("resultMsg", msg);
		map.put("stdList", itStud);
		return "show_student_report";
	}
	@GetMapping("/std_edit")
	public String showEditStudentFormPage(@RequestParam("no")int no,@ModelAttribute("std")Student std)
	{
		Student std1=stdService.getStudentByNo(no);
		BeanUtils.copyProperties(std1, std);
		return "update_student";
	}
	@PostMapping("/std_edit")
	public String editStudent(RedirectAttributes attrs,@ModelAttribute("std")Student std)
	{
		String msg=stdService.updateStudent(std);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:std_report";
	}
	@GetMapping("/std_delete")
	public String deleteStudent(RedirectAttributes attrs,@RequestParam int no)
	{
		String msg=stdService.deleteStudentById(no);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:std_report";
	}
}
