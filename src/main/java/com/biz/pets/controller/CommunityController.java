package com.biz.pets.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.pets.domain.PageDTO;
import com.biz.pets.domain.ReviewDTO;
import com.biz.pets.domain.ServiceDTO;
import com.biz.pets.service.PageService;
import com.biz.pets.service.ReviewService;
import com.biz.pets.service.ServiceService;

@RequestMapping(value="/community")
@Controller
public class CommunityController {
	
	@Autowired
	ReviewService rService;
	
	@Autowired
	ServiceService sService;
	
	@Autowired
	PageService pService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String list(Model model, @RequestParam(value="currentPageNo", required = false,defaultValue = "1") int currentPageNo) {
		
		long totalCount = rService.totalCount();
		PageDTO pageDTO = pService.getPagination(totalCount, currentPageNo); 
		
		List<ReviewDTO> reList = rService.selectPagination(pageDTO);
		
		model.addAttribute(pageDTO);
		model.addAttribute("RELIST", reList);
	
		return "community/list";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(String id, @ModelAttribute ReviewDTO reDTO, Model model) {
		long re_seq = 0;
		try {
			re_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		reDTO = rService.getReview(re_seq);
		
		model.addAttribute("reDTO",reDTO);
		return "community/view";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("reDTO") ReviewDTO reDTO, Model model) {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		reDTO.setRe_date(sd.format(date));

		model.addAttribute("reDTO",reDTO);
		
		return "community/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("reDTO") ReviewDTO reDTO, Model model, SessionStatus sStatus) {
		int ret = rService.insert(reDTO);
	
		sStatus.setComplete();
		
		return "redirect:/community/list";
	}
		
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String id, @ModelAttribute ReviewDTO reDTO, Model model) {
		long re_seq = 0;
		try {
			re_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		reDTO = rService.getReview(re_seq);
		
		model.addAttribute("reDTO", reDTO);
		return "community/insert";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute ReviewDTO reDTO, Model model, SessionStatus sStatus) {

		int ret = rService.update(reDTO);
		
		sStatus.setComplete();
		return "redirect:/community/list";
	
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@ModelAttribute ReviewDTO reDTO, long re_seq) {
		int ret = rService.delete(reDTO.getRe_seq());
		
		return "redirect:/community/list";
	}
	
	/* Service */
	@RequestMapping(value="/service/list",method=RequestMethod.GET)
	public String serviceList(Model model) {
		List<ServiceDTO> seList = sService.getAllList();
		
		model.addAttribute("SELIST", seList);
	
		return "community/service/list";
	}
	
	@RequestMapping(value="/service/view",method=RequestMethod.GET)
	public String serviceView(String id, @ModelAttribute ServiceDTO seDTO, Model model) {
		long se_seq = 0;
		try {
			se_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		seDTO = sService.getService(se_seq);
		
		model.addAttribute("seDTO",seDTO);
		return "community/service/view";
	}
	
	@RequestMapping(value="/service/insert",method=RequestMethod.GET)
	public String serviceInsert(@ModelAttribute("seDTO") ServiceDTO seDTO, Model model) {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		seDTO.setSe_date(sd.format(date));

		model.addAttribute("seDTO",seDTO);
		
		return "community/service/insert";
	}
	
	@RequestMapping(value="/service/insert",method=RequestMethod.POST)
	public String servicInsert(@ModelAttribute("seDTO") ServiceDTO seDTO, Model model, SessionStatus sStatus) {
		int ret = sService.insert(seDTO);
	
		sStatus.setComplete();
		
		return "redirect:/community/service/list";
	}
		
	@RequestMapping(value="/service/update",method=RequestMethod.GET)
	public String serviceUpdate(String id, @ModelAttribute ServiceDTO seDTO, Model model) {
		long se_seq = 0;
		try {
			se_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		seDTO = sService.getService(se_seq);
		
		model.addAttribute("seDTO", seDTO);
		return "community/service/insert";
	}

	@RequestMapping(value="/service/update",method=RequestMethod.POST)
	public String serviceUpdate(@ModelAttribute ServiceDTO seDTO, Model model, SessionStatus sStatus) {

		int ret = sService.update(seDTO);
		
		sStatus.setComplete();
		return "redirect:/community/service/list";
	
	}
	
	@RequestMapping(value="/service/delete",method=RequestMethod.GET)
	public String serviceDelete(@ModelAttribute ServiceDTO seDTO, long se_seq) {
		int ret = sService.delete(seDTO.getSe_seq());
		
		return "redirect:/community/service/list";
	}
	
	/*
	@Autowired
	PageService pService;
	
	

	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model, @RequestParam
			
			(value = "currentPageNo", required = false, defaultValue ="1") long currentPageNo) {
		
		List<ReviewDTO> reList = rService.getAllList();
		List<ReviewDTO> perPageList = new ArrayList<ReviewDTO>();
		
		PageDTO pageDTO = rService.getPage(currentPageNo);
		
		int endItem = (int) (pageDTO.getCurrentPageNo() * pageDTO.getLitsPerPage());
		int startItem = (int) ((pageDTO.getCurrentPageNo()-1) * pageDTO.getLitsPerPage());
		
		try {
			perPageList.removeAll(perPageList);
			for(int i = startItem; i < endItem; i++) {
				ReviewDTO reviewDTO = reList.get(i);
				perPageList.add(reviewDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("PAGE", pageDTO);
		model.addAttribute("RELIST", reList);
		
		return "community/view";
	}
	
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public String page(Locale locale, Model model) {
		return "pagination";
	}
	
	


	@RequestMapping(value = "/view_page", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String news(
			@RequestParam(value = "currentPageNo",
				required = false,
				defaultValue = "1")
			long currentPageNo,
			Model model) {

		try {
			
			long totalCount;
			PageDTO pageDTO = pService.makePagination(totalCount, currentPageNo);
			model.addAttribute("PAGE",pageDTO);
			
			JSONArray resArray = nService.getNaver(cat, search,currentPageNo);
			model.addAttribute("NAVER_ITEMS", resArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("currentPageNo",currentPageNo);
		return "community/view_page";
	
	}

*/
	/*
	
	@RequestMapping(value="/view_ser",method=RequestMethod.GET)
	public String view_ser() {
		return "community/view_ser";
	}
	

	
	


	
	
	 * insert POST가 memoDTO를 수신할때
	 * 입력 form에서 사용자가 입력한 값들이 있으면
	 * 그 값들을 memoDTO의 필드변수에 setting을 하고
	 * 
	 * 만약 없으면
	 * 메모리 어딘가에 보관중인 SessionAttributes로 설정된
	 * memoDTO변수에서 값을 가져와서 비어있는
	 * 필드변수를 채워서서 매개변수에 주입한다.
	 * 
	 * 따라서 form에서 보이지 않아도 되는 값들은
	 * 별도의 코딩을 하지 않아도
	 * 자동으로 insert POST로 전송되는 효과를 낸다.
	 * 단, 이 기능을 효율적으로 사용하려면
	 * jsp 코드에서 Spring-form tag로 input 를 코딩해야 한다.
	 */
	/*

	



	
	 * 브라우저에서 delete를 호출할때
	 * m_seq변수에 값을 포함하지 않고 req 보내면
	 * 서버에서는 400 오류가 발생을 한다.
	 * 
	 * 그 이유는 Spring web에서 넘겨저 온 데이터를
	 * long형으로 형변환을 수행하여 값을 받으려고 시도를 한다.
	 * 그 과정에서 값이 없으면 null을 long으로 변환하는 코드가
	 * 실행되어 서버내부에서 exception이 발생하고
	 * 400 오류를 web에게 알려주게 된다.
	 * 
	 * 이것을 방지하기 위해 String으로 일단 받고
	 * 별도로 Long.valueOf()를 실행하는 코드가 안전하다.
	 * 
	 * 하지만
	 * delete를 호출할때
	 * 절대!!! m_seq이 없게는 호출되지 않는다는 가정하에
	 * 바로 long형의 변수로 수신할수 있다.
	 * 


	
	
		 */
	

}
