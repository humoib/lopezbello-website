package com.tgd.things.controllers.things;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgd.things.beans.CustomFieldReduced;
import com.tgd.things.beans.CustomFieldValueReduced;
import com.tgd.things.beans.NewCommentPojo;
import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.db.Thing;
import com.tgd.things.beans.db.ThingComment;
import com.tgd.things.config.ThingsAppConstants;
import com.tgd.things.controllers.BaseController;
import com.tgd.things.managers.FieldsManager;
import com.tgd.things.service.BoxService;
import com.tgd.things.service.CustomFieldsService;
import com.tgd.things.service.ThingCommentService;
import com.tgd.things.service.ThingService;
import com.tgd.things.system.ThingsSystem;
import com.tgd.things.utils.ThingUtils;
import com.tgd.things.utils.WebRequestUtils;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
@ComponentScan
public class ThingsController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingsController.class);

	@Autowired
	BoxService boxService;

	@Autowired
	ThingService thingService;

	@Autowired
	ThingCommentService thingCommentService;

	@Autowired
	CustomFieldsService customFieldsService;

	@RequestMapping(value = { "/things", "/things/{pageId}" }, method = RequestMethod.GET)
	public String getThings(Model model, HttpServletRequest request, @PathVariable("pageId") Optional<Integer> pageId) {
		LOGGER.debug("## GET Maincontroller: things");

		Integer page = 0;
		Pageable pageObject = null;

		if (pageId.isPresent()) {
			LOGGER.debug("page: {}", pageId.get());
			page = pageId.get() - 1;
		} else {
			page = 0;
		}

		model.addAttribute("context", WebRequestUtils.getContext());
		request.getSession().setAttribute("contextpath", request.getContextPath());

		// LOGGER.debug("Getting first 20 Things");
		// model.addAttribute("searchedThings", thingService.getFirstTwentyThings());

		pageObject = PageRequest.of(page, ThingsAppConstants.DEFAULT_PAGE_SIZE, Sort.by("updated").descending());
		Page<Thing> allThings = thingService.findAll(pageObject);
		model.addAttribute("searchedThings", allThings.getContent());

		// pages
		LOGGER.debug("actualPage: {}", page + 1);
		model.addAttribute("actualPage", page + 1);
		LOGGER.debug("allThings -> size: {} / {}", allThings.getTotalElements(), allThings.getTotalPages());
		LOGGER.debug("totalPages: {}", allThings.getTotalPages());
		model.addAttribute("totalPages", allThings.getTotalPages());

		return THINGS_PAGE;
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String searchPlaces(Model model, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("POST ThingsController: search things");

		model.addAttribute("context", WebRequestUtils.getContext());
		model.addAttribute("search", request.getParameter("search"));
		String searchString = request.getParameter("search");
		model.addAttribute("searchedThings", thingService.searchThings(searchString));

		return THINGS_PAGE;
	}

	@RequestMapping(value = { "/thing/{id}" }, method = RequestMethod.GET)
	public String showThing(Model model, HttpServletRequest request, @PathVariable String id) {
		LOGGER.debug("## GET Maincontroller: showThing");

		model.addAttribute("baseUrl", ThingsSystem.getBaseUrl());
		model.addAttribute("context", WebRequestUtils.getContext());

		// TODO: review
		// request.getSession().setAttribute("contextpath",
		// request.getContextPath());
		// model.addAttribute("context", WebRequestUtils.getContext());

		Thing thing = null;
		if (id != null && id.contains("-")) {
			// thing by string key
			thing = thingService.getThingByKey(String.valueOf(id));
			LOGGER.debug("thing: {}", thing.toString());
			model.addAttribute(THING_PAGE, thing);
		} else {
			// thing by long id
			Optional<Thing> thingOptional = thingService.getThing(Long.parseLong(id));
			thing = thingOptional.get();
			LOGGER.debug("thing: {}", thing.toString());
			model.addAttribute(THING_PAGE, thingOptional.get());
		}

		// box
		model.addAttribute("box", thing.getBox());

		// Object with fields
		// HashMap fields = new HashMap();

		List<CustomFieldValueReduced> fields = customFieldsService.getAllFieldValuesFromThing(thing);
		for (CustomFieldValueReduced field : fields) {
			LOGGER.debug("FIELD ---> id: {} name: {} type: {} value: {}", field.getKey(), field.getName(),
					field.getType(), field.getValue());
		}
		/*
		 * Iterable<CustomField> myFields =
		 * customFieldsService.getCustomFields(thing.get().getThingType()); for
		 * (CustomField cf : myFields) { LOGGER.debug("ThingType: {} - cf: {}",
		 * thing.get().getThingType().getName(), cf.toString());
		 * 
		 * CustomFieldReduced cfReduced = new CustomFieldReducedImpl (); cfReduced. }
		 */

		model.addAttribute("thingId", thing.getId());

		List<ThingComment> comments = (List<ThingComment>) thingCommentService.getComments(thing);
		if (comments != null) {
			LOGGER.debug("COMMENTS: size:{}", comments.size());
			for (ThingComment comment : comments) {
				LOGGER.debug("Comment ->" + comment.getComment());
			}
		}

		model.addAttribute("thingComments", comments);
		model.addAttribute("fields", fields);

		addRelations(model, String.valueOf(thing.getId()));

		// fields.putAll(FieldsManager.getViewFields(thing.get().getThingType()));

		return THING_PAGE;
	}

	private void addRelations(Model model, String id) {
		// Relations
		Optional<Thing> a = thingService.getThing(Long.parseLong(id));
		LOGGER.debug("thingService.getThing(Long.parseLong(id)).get()): " + a.get());
		model.addAttribute("thingsRelated",
				thingService.getAllRelatedThings(thingService.getThing(Long.parseLong(id)).get()));
		List<ThingPojo> thingsToRelate = new ArrayList<ThingPojo>();
		Iterable<Thing> allThings = thingService.getAllThings();

		Iterator<Thing> iter = allThings.iterator();
		while (iter.hasNext()) {
			thingsToRelate.add(ThingUtils.db2pojoThing(iter.next()));
		}
		model.addAttribute("thingsToRelate", thingsToRelate);
	}

	@RequestMapping(value = { "/thing/relationsBox/{id}" }, method = RequestMethod.GET)
	public String getRelationsDivContent(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id) {
		LOGGER.debug("## GET ThingsController: relations box");

		// Relations
		Optional<Thing> a = thingService.getThing(Long.parseLong(id));

		LOGGER.debug("thingService.getThing(Long.parseLong(id)).get()): " + a.get());
		model.addAttribute("thingsRelated",
				thingService.getAllRelatedThings(thingService.getThing(Long.parseLong(id)).get()));
		model.addAttribute("thingsToRelate", thingService.getAllThings());

		return "thingRelations";
	}

	/**
	 * NUEVO - Muestra BOXES
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/thing/newfirst" }, method = RequestMethod.GET)
	public String showNewThingSelectBox(Model model, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("## GET ThingsController: show new thing");

		model.addAttribute("context", WebRequestUtils.getContext());
		model.addAttribute("operation", "new");

		model.addAttribute("boxes", boxService.getAllBoxesWithThingTypes());

		// Fields
		// TODO: ponemos TAREA
		List<CustomFieldReduced> fields = customFieldsService
				.getAllFieldsFromThingType(thingService.findThingTypeById(new Long(1)));
		model.addAttribute("fields", fields);

		return "newthingselectbox";
	}

	/**
	 * NUEVO
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/thing/new/{boxId}/{thingTypeId}" }, method = RequestMethod.GET)
	public String showNewThing(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String boxId, @PathVariable String thingTypeId) {
		LOGGER.debug("## GET ThingsController: show new thing");

		model.addAttribute("context", WebRequestUtils.getContext());
		model.addAttribute("operation", "new");
		model.addAttribute("boxId", boxId);
		model.addAttribute("thingTypeId", thingTypeId);

		// box
		model.addAttribute("box", boxService.getById(boxId).get());

		// Fields
		LOGGER.trace("Thing Type: {}", thingService.findThingTypeById(Long.parseLong(thingTypeId)));
		List<CustomFieldReduced> fields = customFieldsService
				.getAllFieldsFromThingType(thingService.findThingTypeById(Long.parseLong(thingTypeId)));
		LOGGER.debug("Fields: {}", fields);
		for (CustomFieldReduced field : fields) {
			LOGGER.debug("field: ---" + field.getId() + ":" + field.getName());
		}
		if (fields != null) {
			model.addAttribute("fields", fields);
		}

		// Options
		// TOOD: tipo 3
		HashMap options = new HashMap();
		options.put("3", customFieldsService.getCustomFieldOptions("option"));
		LOGGER.debug("OPTIONS {}", options);
		model.addAttribute("options", options);

		return THING_PAGE;
	}

	/**
	 * POST NEW THING
	 * 
	 * 
	 */
	@RequestMapping(value = { "/thing/new" }, method = RequestMethod.POST)
	public String addNewThing(ThingPojo thingpojo, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.debug("## POST ThingsController: add new thing");

		model.addAttribute("context", WebRequestUtils.getContext());

		LOGGER.debug("model -> name: {}", model.getAttribute("name"));
		LOGGER.debug("req -> name: {}", request.getAttribute("name"));

		LOGGER.debug("thingpojo: {}", thingpojo.toString());

		// Locale currentLocale = LocaleContextHolder.getLocale();
		// LOGGER.info("Locale: {}", currentLocale);
		/*
		 * DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
		 * otherSymbols.setDecimalSeparator(','); DecimalFormat numberFormat =
		 * (DecimalFormat) DecimalFormat.getInstance(LocaleContextHolder.getLocale());
		 * numberFormat.setDecimalFormatSymbols(otherSymbols);
		 */

		// TODO: summary vacio?
		// TODO:

		ThingPojo addThing = new ThingPojo();
		addThing.setBoxId(Integer.parseInt(request.getParameter("boxId")));
		addThing.setSummary(request.getParameter("summary"));
		addThing.setAnalysis(request.getParameter("analysis"));
		addThing.setThingTypeId(Long.parseLong(request.getParameter("thingTypeId")));
		addThing.setCreated(new Date());

		LOGGER.debug("addThing: {}", addThing.toString());

		Thing thing = thingService.saveThing(addThing);
		LOGGER.trace("thing: {}", thing.toString());

		FieldsManager fieldsManager = new FieldsManager(thingService, customFieldsService);
		Thing myThing = fieldsManager.updateFieldValues(request, thing, null, null);

		model.addAttribute("thing", thing);

		// box
		model.addAttribute("box", thing.getBox());

		// no es necesario porque se redirige a la lista
		// addRelations(model, String.valueOf(thing.getId()));

		// Getting Things List
		model.addAttribute("searchedThings", thingService.getFirstTwentyThings());

		return "redirect:" + WebRequestUtils.getContext() + "/" + THINGS_PAGE;
	}

	@RequestMapping(value = { "/thing/edit/{id}" }, method = RequestMethod.GET)
	public String showEditThing(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id) {
		LOGGER.debug("## GET ThingsController: edit thing");

		model.addAttribute("context", WebRequestUtils.getContext());

		Optional<Thing> thing = thingService.getThing(Long.parseLong(id));
		LOGGER.debug("thing: {}", thing);
		model.addAttribute(THING_PAGE, thing.get());

		model.addAttribute("boxId", thing.get().getBox().getId());
		model.addAttribute("thingId", thing.get().getId());
		model.addAttribute("thingTypeId", thing.get().getThingType().getId());

		// box
		model.addAttribute("box", thing.get().getBox());

		/*
		 * List<Content> contentList = thingService.getAllContents(Long.parseLong(id));
		 * LOGGER.debug("contents - size: {} - List: {}", contentList.size(),
		 * contentList); model.addAttribute("contentList", contentList);
		 */

		// Fields
		// TODO: ponemos TAREA
		List<CustomFieldValueReduced> fields = customFieldsService.getAllFieldValuesFromThing(thing.get());
		model.addAttribute("fields", fields);

		// Options
		// TOOD: tipo 3
		HashMap options = new HashMap();
		options.put("3", customFieldsService.getCustomFieldOptions("option"));
		LOGGER.debug("OPTIONS {}", options);
		model.addAttribute("options", options);

		model.addAttribute("operation", "edit");

		return THING_PAGE;
	}

	/**
	 * 
	 * @param thingform
	 * @param model
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/thing/edit/{id}" }, method = RequestMethod.POST)
	public String editThing(ThingPojo thingform, Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id) {
		LOGGER.debug("## POST ThingsController: update thing");

		model.addAttribute("context", WebRequestUtils.getContext());

		LOGGER.debug("thingform: {}", thingform.toString());

		Locale currentLocale = LocaleContextHolder.getLocale();
		LOGGER.info("Locale: {}", currentLocale);

		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
		otherSymbols.setDecimalSeparator(',');
		DecimalFormat numberFormat = (DecimalFormat) DecimalFormat.getInstance(LocaleContextHolder.getLocale());
		numberFormat.setDecimalFormatSymbols(otherSymbols);

		// Get thing from DB
		Thing thing = thingService.getThing(Long.parseLong(id)).get();

		// Creates the POJO object
		ThingPojo editThing = new ThingPojo();
		editThing.setId(thing.getId());
		editThing.setKey(thing.getKey());
		editThing.setBoxId(thing.getBox().getId().intValue());
		editThing.setThingTypeId(thing.getThingType().getId());
		editThing.setSummary(request.getParameter("summary"));
		editThing.setAnalysis(request.getParameter("analysis"));
		editThing.setCreated(thing.getCreated());

		editThing.setDescription(request.getParameter("description"));

		Thing thingSaved = thingService.saveThing(editThing);
		LOGGER.trace("thing: {}", thingSaved.toString());
		model.addAttribute("thing", thingSaved);
		model.addAttribute("thingId", thingSaved.getId());

		// box
		model.addAttribute("box", thingSaved.getBox());

		// relations
		// LOGGER.trace("thingService.getThing(Long.parseLong(id)).get()): " +
		// thingSaved);
		// model.addAttribute("thingsRelated",
		// thingService.getAllRelatedThings(thingSaved));

		addRelations(model, id);

		// update field values
		FieldsManager fieldsManager = new FieldsManager(thingService, customFieldsService);
		Thing myThing = fieldsManager.updateFieldValues(request, thing, null, id);
		LOGGER.info("saveThing: {} {}", editThing.getId(), editThing.getSummary());

		// CUSTOM FIELDS
		// TODO : suponemos que todos los camps están en la pantalla
		/*
		 * List<CustomFieldReduced> fields = customFieldsService
		 * .getAllFieldsFromThingType(thingService.findById(new Long(1))); for
		 * (CustomFieldReduced field : fields) {
		 * LOGGER.debug("FIELD ---> id: {} name: {} type: {}", field.getKey(),
		 * field.getName(), field.getType()); String temp = request.getParameter("cf_" +
		 * field.getId()); LOGGER.debug("REQUEST PARAM {} value {}", "cf_" +
		 * field.getId(), request.getParameter("cf_" + field.getId())); if (temp != "")
		 * { int ret = customFieldsService.updateValue(editThing, field.getName(),
		 * temp); LOGGER.debug("updated " + temp + " - ret:" + ret); } }
		 */

		model.addAttribute(THING_PAGE, thing);

		/*
		 * List<Content> contentList = thingService.getAllContents(Long.parseLong(id));
		 * LOGGER.debug("contents - size: {} - List: {}", contentList.size(),
		 * contentList); model.addAttribute("contentList", contentList);
		 */
		// model.addAttribute("labelsUtils", new LabelsUtils());

		// LOGGER.debug("Getting first 20 Things");
		// model.addAttribute("searchedThings", thingService.getFirstTwentyThings());

		// Fields
		// TODO: ponemos TAREA
		List<CustomFieldValueReduced> fields = customFieldsService.getAllFieldValuesFromThing(thingSaved);
		model.addAttribute("fields", fields);

		LOGGER.debug("WebRequestUtils.getContext(): " + WebRequestUtils.getContext());
		LOGGER.debug("---> " + "redirect:" + WebRequestUtils.getContext() + "/" + THINGS_PAGE);

		return "redirect:" + WebRequestUtils.getContext() + "/" + THINGS_PAGE;
	}

	// newComment
	@RequestMapping(value = { "/thing/newComment" }, method = RequestMethod.POST)
	public String addNewComment(ThingPojo thingpojo, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.debug("## POST ThingsController: add new comment");

		model.addAttribute("context", WebRequestUtils.getContext());

		LOGGER.debug("model -> name: {}", model.getAttribute("name"));
		LOGGER.debug("req -> name: {}", request.getAttribute("name"));

		// LOGGER.debug("thingpojo: {}", thingpojo.toString());

		// Locale currentLocale = LocaleContextHolder.getLocale();
		// LOGGER.info("Locale: {}", currentLocale);
		/*
		 * DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
		 * otherSymbols.setDecimalSeparator(','); DecimalFormat numberFormat =
		 * (DecimalFormat) DecimalFormat.getInstance(LocaleContextHolder.getLocale());
		 * numberFormat.setDecimalFormatSymbols(otherSymbols);
		 */

		Long thingId = Long.parseLong(request.getParameter("thingId"));
		Optional<Thing> myThing = thingService.getThing(thingId);

		/*
		 * addThing.setSummary(request.getParameter("summary"));
		 * addThing.setThingTypeId(Long.parseLong(request.getParameter(
		 * "thingTypeId"))); addThing.setCreated(new Date());
		 */
		LOGGER.debug("myThing: {}", myThing.get().toString());

		LOGGER.debug("new comment: {}", request.getParameter("comment"));

		NewCommentPojo newComment = new NewCommentPojo();
		newComment.setThingId(thingId);
		newComment.setComment(request.getParameter("comment"));
		thingCommentService.saveComment(newComment);

		/*
		 * 
		 * Thing thing = thingService.saveThing(addThing); LOGGER.trace("thing: {}",
		 * thing.toString());
		 * 
		 * FieldsManager fieldsManager = new FieldsManager(thingService,
		 * customFieldsService); Thing myThing =
		 * fieldsManager.updateFieldValues(request, thing, null, null);
		 */

		model.addAttribute("thingId", myThing.get().getId());
		model.addAttribute("thingComments", (List<ThingComment>) thingCommentService.getComments(myThing.get()));
		model.addAttribute(THING_PAGE, myThing.get());

		// Getting Things List
		model.addAttribute("searchedThings", thingService.getFirstTwentyThings());

		return "redirect:" + WebRequestUtils.getContext() + "/" + THING_PAGE + "/" + myThing.get().getId();
	}
}
