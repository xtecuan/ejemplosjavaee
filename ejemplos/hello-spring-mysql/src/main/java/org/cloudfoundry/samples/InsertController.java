/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudfoundry.samples;

import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author xtecuan
 */
@Controller
public class InsertController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private ReferenceDataRepository referenceRepository;
	
	/**
	 * Prepares the Model with some metadata and the list of States retrieved
	 * from the DB. Then, selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		logger.info("Llamada a insert");
		return "insert";
	}
        
        @RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insert_do(Model model,HttpServletRequest request,  
            HttpServletResponse response) {
		logger.info("Llamada a insert.do");
                
                
                State estado = new State();
                String id = request.getParameter("id");
                estado.setId(Long.valueOf(id));
                String statecode = request.getParameter("statecode");
                estado.setStateCode(statecode);
                String name = request.getParameter("name");
                estado.setName(name);
                
                
                referenceRepository.guardar(estado);
                
               
                
                model.addAttribute("dbinfo", referenceRepository.getDbInfo());
		model.addAttribute("states", referenceRepository.findAll());
                
		return "home";
	}
        
        
}
