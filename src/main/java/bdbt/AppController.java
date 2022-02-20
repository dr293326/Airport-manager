package bdbt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private AirplaneDAO airplaneDAO;
	@Autowired
	private FlightDAO flightDAO;
	@Autowired
	private TicketDAO ticketDAO;
	
	@RequestMapping("/")
	public String showEntryPage(Model model) {
		//List<Employee> employeeList = employeeDAO.list();
		//model.addAttribute("employeeList", employeeList);
		return "index";
	}
	
	@RequestMapping("/loginSuccess")
	public String show(Model model) {
		//List<Employee> employeeList = employeeDAO.list();
		//model.addAttribute("employeeList", employeeList);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String whoAmI = authentication.getName();
		if (whoAmI.equals("admin")) {
			return "adminPanel";
		}
		else
		{
			return "userPanel";
		}
	}
	
	@RequestMapping("/employees")
	public String showEmployees(Model model) {
		List<Employee> employeeList = employeeDAO.list();
		model.addAttribute("employeeList", employeeList);
		return "employees";
	}
	
	@RequestMapping("/airplanes")
	public String showAirplanes(Model model) {
		List<Airplane> airplaneList = airplaneDAO.list();
		model.addAttribute("airplaneList", airplaneList);
		return "airplanes";
	}
	
	@RequestMapping("/flights")
	public String showFlights(Model model) {
		List<Flight> flightList = flightDAO.list();
		model.addAttribute("flightList", flightList);
		return "flights";
	}
	
	@RequestMapping("/userFlights")
	public String showUserFlights(Model model) {
		List<Flight> flightList = flightDAO.list();
		model.addAttribute("flightList", flightList);
		return "userFlights";
	}
	
	@RequestMapping("/tickets")
	public String showTickets(Model model) {
		List<Ticket> ticketList = ticketDAO.list();
		model.addAttribute("ticketList", ticketList);
		return "tickets";
	}
	
	@RequestMapping("/userTickets")
	public String showUserTickets(Model model) {
		List<Ticket> userTicketList = ticketDAO.listAvailable();
		model.addAttribute("userTicketList", userTicketList);
		return "userTickets";
	}
	
	// ==================== ADD ====================
	
	@RequestMapping("/addEmployee")
	public String showEmployeeAddingForm(Model model){
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	@RequestMapping("/addAirplane")
	public String showAirplaneAddingForm(Model model){
		
		Airplane airplane = new Airplane();
		model.addAttribute("airplane", airplane);
		return "addAirplane";
	}
	
	@RequestMapping("/addFlight")
	public String showFlightAddingForm(Model model){
		
		Flight flight = new Flight();
		model.addAttribute("flight", flight);
		return "addFlight";
	}
	
	@RequestMapping("/addTicket")
	public String showTicketAddingForm(Model model){
		
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "addTicket";
	}
	
	// ==================== SAVE ====================
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employee") Employee employee) {
		
		if (employee.validate()) {
			employeeDAO.save(employee);
			return "redirect:/employees";
		}
		else {
			return "redirect:/addEmployee";
		}
	}
	
	@RequestMapping(value = "/saveAirplane", method = RequestMethod.POST)
	public String saveAirplane(@ModelAttribute("airplane") Airplane airplane) {
		
		if (airplane.validate()) {
			airplaneDAO.save(airplane);
			return "redirect:/airplanes";
		}
		else {
			return "redirect:/addAirplane";
		}
	}
	
	@RequestMapping(value = "/saveFlight", method = RequestMethod.POST)
	public String saveFlight(@ModelAttribute("flight") Flight flight) {
		
		if (flight.validate()) {
			flightDAO.save(flight);
			return "redirect:/flights";
		}
		else {
			return "redirect:/AddFlight";
		}
	}
	
	@RequestMapping(value = "/saveTicket", method = RequestMethod.POST)
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		
		if (ticket.validate()) {
			ticketDAO.save(ticket);
			return "redirect:/tickets";
		}
		else {
			return "redirect:/addTicket";
		}
		
		
	}
	
	// ==================== EDIT ====================
	
	@RequestMapping("/editEmployee/{id_pracownika}")
	public ModelAndView showEmployeeEditForm(@PathVariable(name="id_pracownika") int id_pracownika) {
		ModelAndView mav = new ModelAndView("editEmployee");
		Employee employee = employeeDAO.get(id_pracownika);
		mav.addObject("employee",employee);
		return mav;
	}
	
	@RequestMapping("/editAirplane/{id_samolotu}")
	public ModelAndView showAirplaneEditForm(@PathVariable(name="id_samolotu") int id_samolotu) {
		ModelAndView mav = new ModelAndView("editAirplane");
		Airplane airplane = airplaneDAO.get(id_samolotu);
		mav.addObject("airplane",airplane);
		return mav;
	}
	
	@RequestMapping("/editFlight/{id_lotu}")
	public ModelAndView showFLightEditForm(@PathVariable(name="id_lotu") int id_lotu) {
		ModelAndView mav = new ModelAndView("editFlight");
		Flight flight = flightDAO.get(id_lotu);
		mav.addObject("flight",flight);
		return mav;
	}
	
	@RequestMapping("/editTicket/{id_biletu}")
	public ModelAndView showTicketEditForm(@PathVariable(name="id_biletu") int id_biletu) {
		ModelAndView mav = new ModelAndView("editTicket");
		Ticket ticket = ticketDAO.get(id_biletu);
		mav.addObject("ticket", ticket);
		return mav;
	}
	
	// ==================== UPDATE ====================
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		
		if (employee.validate()) {
			employeeDAO.update(employee);
			return "redirect:/employees";
		}
		else {
			return "redirect:/editEmployee/" + employee.getId_pracownika();
		}
	}
	
	@RequestMapping(value = "/updateAirplane", method = RequestMethod.POST)
	public String updateAirplane(@ModelAttribute("airplane") Airplane airplane) {
		
		if (airplane.validate()) {
			airplaneDAO.update(airplane);
			return "redirect:/airplanes";
		}
		else {
			return "redirect:/editAirplane/" + airplane.getId_samolotu();
		}
	}
	
	@RequestMapping(value = "/updateFlight", method = RequestMethod.POST)
	public String updateFlight(@ModelAttribute("flight") Flight flight) {
		
		if (flight.validate()) {
			flightDAO.update(flight);
			return "redirect:/flights";
		} 
		else {
			return "redirect:/editFlight/" + flight.getId_lotu();
		}
	}
	
	@RequestMapping(value = "/updateTicket", method = RequestMethod.POST)
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket) {
		
		if (ticket.validate()) {
			ticketDAO.update(ticket);
			return "redirect:/tickets";
		}
		else {
			return "redirect:/editTicket/" + ticket.getId_biletu();
		}
	}
	
	// ==================== DELETE ====================
	
	@RequestMapping("/deleteEmployee/{id_pracownika}")
	public String deleteEmployee(@PathVariable(name = "id_pracownika") int id_pracownika) {
		employeeDAO.delete(id_pracownika);
		return "redirect:/employees";
	}
	
	@RequestMapping("/deleteAirplane/{id_samolotu}")
	public String deleteAirplane(@PathVariable(name = "id_samolotu") int id_samolotu) {
		airplaneDAO.delete(id_samolotu);
		return "redirect:/airplanes";
	}
	
	@RequestMapping("/deleteFlight/{id_lotu}")
	public String deleteFlight(@PathVariable(name = "id_lotu") int id_lotu) {
		flightDAO.delete(id_lotu);
		return "redirect:/flights";
	}
	
	@RequestMapping("/deleteTicket/{id_biletu}")
	public String deleteTicket(@PathVariable(name = "id_biletu") int id_biletu) {
		ticketDAO.delete(id_biletu);
		return "redirect:/tickets";
	}
}
