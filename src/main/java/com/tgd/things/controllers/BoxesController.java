package com.tgd.things.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgd.things.beans.db.Thing;
import com.tgd.things.plugins.PhotoServicePlugin;
import com.tgd.things.service.BoxService;
import com.tgd.things.service.ThingService;
import com.tgd.things.utils.FrontWrapper;
import com.tgd.things.utils.ThingUtils;
import com.tgd.things.utils.WebRequestUtils;

@Controller
@ComponentScan
public class BoxesController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoxesController.class);

	@Autowired
	BoxService boxService;

	@Autowired
	ThingService thingService;

	@Value("gs://${gcs-resource-test-bucket}/my-file.txt")
	private Resource gcsFile;

	@Value("gs://${gcs-resource-test-bucket}/foo/")
	private Resource gcsRoot;

	@Value("${valor}")
	private String valor;

	@RequestMapping(value = { "/garage" }, method = RequestMethod.GET)
	public String getThings(Model model, HttpServletRequest request) {
		LOGGER.debug("## GET Maincontroller: things");

		model.addAttribute("context", WebRequestUtils.getContext());
		request.getSession().setAttribute("contextpath", request.getContextPath());

		model.addAttribute("boxes", boxService.getAllBoxes());

		FrontWrapper frontWrapper = new FrontWrapper();
		model.addAttribute("frontwrapper", frontWrapper);

		return BaseController.BOXES_PAGE;
	}

	@RequestMapping(value = { "/box/{boxId}" }, method = RequestMethod.GET)
	public String openBox(Model model, HttpServletRequest request, @PathVariable String boxId) {
		LOGGER.debug("## GET BoxesController: openBox");
		LOGGER.debug("boxId: {}", boxId);

		Long boxIdLong = Long.parseLong(boxId);

		model.addAttribute("context", WebRequestUtils.getContext());

		List<Thing> things = thingService.getBoxThings(Long.parseLong(boxId));
		LOGGER.debug("things size: {}", things.size());

		model.addAttribute("searchedThings", ThingUtils.getdbList2pojoThing(things));

		LOGGER.debug("111 --" + boxService.getById(boxIdLong).get());

		// TDDO : plugin
		if (boxService.getById(boxIdLong).get().getBoxKey().equals("PHOTO")) {
			LOGGER.debug("Llamando a PhotoServicePlugin...");

			LOGGER.debug("HELLO gcsRoot: {}", gcsRoot);

			// Initializer initilizer = new Initializer(someInitialValue,
			// anotherManagedValue)
			// ClassNotManagedBySpring classNotManagedBySpring = nitializer.initClass();

			PhotoServicePlugin photoServicePlugin = new PhotoServicePlugin(gcsRoot, gcsFile);
			String content = photoServicePlugin.getAlbumsHtml();

			model.addAttribute("content", content);
		}

		if (boxService.getById(boxIdLong).get().getView() == null
				|| boxService.getById(boxIdLong).get().getView().trim().equals("")) {
			LOGGER.debug("Box View: SIN VISTA {}", boxService.getById(boxIdLong).get().getView());
			return BaseController.THINGS_PAGE;
		} else {
			LOGGER.debug("Box View: {}", boxService.getById(boxIdLong).get().getView());
			return "boxes/" + boxService.getById(boxIdLong).get().getView();
		}

	}

	//
	// ADD BOXES
//

	/**
	 * NUEVO - Muestra BOXES
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/box/newfirst" }, method = RequestMethod.GET)
	public String showNewBoxSelectBox(Model model, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("## GET BoxController: show new box");

		model.addAttribute("context", WebRequestUtils.getContext());
		model.addAttribute("operation", "new");

		return "newboxselecttype";
	}

	/**
	 * NUEVO
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/box/new/{boxTypeId}" }, method = RequestMethod.GET)
	public String showNewThing(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String boxTypeId) {
		LOGGER.debug("## GET BoxController: show new box");

		model.addAttribute("context", WebRequestUtils.getContext());
		model.addAttribute("operation", "new");
		model.addAttribute("boxTypeId", boxTypeId);

		// box
		// model.addAttribute("box", boxService.getById(Long.parseLong(boxId)).get());

		
		return BOX_PAGE;
	}

	/**
	 * POST NEW BOX
	 * 
	 * 
	 * 
	 * @RequestMapping(value = { "/thing/new" }, method = RequestMethod.POST) public
	 *                       String addNewThing(ThingPojo thingpojo, Model model,
	 *                       HttpServletRequest request, HttpServletResponse
	 *                       response) { LOGGER.debug("## POST ThingsController: add
	 *                       new thing");
	 * 
	 *                       model.addAttribute("context",
	 *                       WebRequestUtils.getContext());
	 * 
	 *                       LOGGER.debug("model -> name: {}",
	 *                       model.getAttribute("name")); LOGGER.debug("req -> name:
	 *                       {}", request.getAttribute("name"));
	 * 
	 *                       LOGGER.debug("thingpojo: {}", thingpojo.toString());
	 * 
	 * 
	 *                       // TODO: summary vacio? // TODO:
	 * 
	 *                       ThingPojo addThing = new ThingPojo();
	 *                       addThing.setBoxId(Long.parseLong(request.getParameter("boxId")));
	 *                       addThing.setSummary(request.getParameter("summary"));
	 *                       addThing.setAnalysis(request.getParameter("analysis"));
	 *                       addThing.setThingTypeId(Long.parseLong(request.getParameter("thingTypeId")));
	 *                       addThing.setCreated(new Date());
	 * 
	 *                       LOGGER.debug("addThing: {}", addThing.toString());
	 * 
	 *                       Thing thing = thingService.saveThing(addThing);
	 *                       LOGGER.trace("thing: {}", thing.toString());
	 * 
	 *                       FieldsManager fieldsManager = new
	 *                       FieldsManager(thingService, customFieldsService); Thing
	 *                       myThing = fieldsManager.updateFieldValues(request,
	 *                       thing, null, null);
	 * 
	 *                       model.addAttribute("thing", thing);
	 * 
	 *                       // box model.addAttribute("box", thing.getBox());
	 * 
	 *                       // no es necesario porque se redirige a la lista //
	 *                       addRelations(model, String.valueOf(thing.getId()));
	 * 
	 *                       // Getting Things List
	 *                       model.addAttribute("searchedThings",
	 *                       thingService.getFirstTwentyThings());
	 * 
	 *                       return "redirect:" + WebRequestUtils.getContext() + "/"
	 *                       + THINGS_PAGE; }
	 */

}