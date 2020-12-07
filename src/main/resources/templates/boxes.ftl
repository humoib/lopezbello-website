<#import "common.ftl" as c />

<@c.page title="Boxes">    
	  
 	
	<table class="table table-sm">
	  <thead>
	    <tr>
	      <th scope="col">Key</th>
	      <th scope="col">Name</th>
	      <th scope="col">Colour</th>
	      <th scope="col">View</th>
	      <th scope="col">Created</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<#if boxes??>
		  	<#list boxes as box >
			    <tr>
			      <td><#if box.key?? >${box.key}</#if></td>
			      <td><a href='${context}/box/${box.id}'>${box.name}</a></td>
			      <td><#if box.colour?? >${box.colour}</#if></td>
			      <td><#if box.view?? >${box.view}</#if></td>
			      <td>${box.created?date}</td>
			    </tr>
			</#list>
		</#if>
	  </tbody>
	</table>
	  
</@c.page>
