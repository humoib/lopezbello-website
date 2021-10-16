<#import "common.ftl" as c />

<@c.page title="Boxes">

 	<div class="float-left">
 	
 	<h2>Boxes</h2>
 		<p>We've got boxes for store things. Each on its box</p>
	</div>

 	<div class="d-flex flex-row-reverse">
 		<button type="button" class="btn btn-primary float-lg-right" float="right"
 			onclick="window.location.href = '${context}/box/newfirst';"
 			>
			Add Box
		</button>
	</div>
 	
 	<hr/>
 	
	<table class="table table-sm">
	  <thead>
	    <tr>
	      <th scope="col">Key</th>
	      <th scope="col">Name</th>
	      <th scope="col">Type</th>
	      <th scope="col">Colour</th>
	      <th scope="col">View</th>
	      <th scope="col">Created</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<#if boxes??>
		  	<#list boxes as box >
			    <tr>
			      <td><#if box.boxKey?? >${box.boxKey}</#if></td>
			      <td><a href='${context}/box/${box.id}'>${box.name}</a></td>
			      <td>${frontwrapper.getBoxType(box.type!0)}</td>
			      <td><#if box.colour?? >${box.colour}</#if></td>
			      <td><#if box.view?? >${box.view}</#if></td>
			      <td>${box.created?date}</td>
			    </tr>
			</#list>
		</#if>
	  </tbody>
	</table>
	  
</@c.page>
