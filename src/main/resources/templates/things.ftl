<#import "common.ftl" as c />

<@c.page title="Thing">    
	
	<table class="table table-sm table-bordered table-hover table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Key</th>
	      <th scope="col">Summary</th>
	      <th scope="col">Type</th>
	      <th scope="col">Created</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<#if searchedThings??>
		  	<#list searchedThings as thing >
			    <tr>
			      <td scope="row"><a href='${context}/thing/${thing.id}'>${thing.box.key}-${thing.key}</a></td>
			      <td><a href='${context}/thing/${thing.id}'>${thing.summary}</a></td>
			      <td>${thing.thingType.name}</td>
			      <td>${thing.created?date}</td>
			    </tr>
			</#list>
		</#if>
	  </tbody>
	</table>
	  
</@c.page>
