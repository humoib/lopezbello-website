<#import "common.ftl" as c />

<@c.page title="Thing">    
	
	<table class="table table-sm table-bordered table-hover table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Key</th>
	      <th scope="col">Summary</th>
	      <th scope="col">Type</th>
	      <th scope="col">Created</th>
	      <th scope="col">Updated</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<#if searchedThings??>
		  	<#list searchedThings as thing >
			    <tr>
			      <td scope="row"><a href='${context}/thing/${thing.id}'>${thing.box.boxKey}-${thing.key}</a></td>
			      <td><a href='${context}/thing/${thing.id}'>${thing.summary}</a></td>
			      <td>${thing.thingType.name}</td>
			      <td>${thing.created?date}</td>
			      <td>
			      	<#if thing.updated??>
			      	${thing.updated?date}
			      	</#if>
			      </td>
			    </tr>
			</#list>
			
			<#if searchedThings?size==0>
			<tr>
				<td colspan="4">No results</td>
			</tr>
			</#if>
		</#if>
		
	  </tbody>
	</table>
	

	<!-- pagination -->
	<#if totalPages?? && (totalPages>0) >
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-end">
			
		    <li class="page-item 
		    <#if actualPage==1> disabled</#if>
		    ">
		      <a class="page-link" href="${context}/things/${actualPage-1}" tabindex="-1">Previous</a>
		    </li>
		    
		    <#if totalPages??>
		    	<#list 1..totalPages as i>
		    	
		    		<#if actualPage!=i>
			    
			    	<li class="page-item"><a class="page-link" href="${context}/things/${i}">${i}</a></li>
  				
  				    <#else>
  				    
  				    <li class="page-item active">
				      <span class="page-link">
				        ${i}
				        <span class="sr-only">(current)</span>
				      </span>
				    </li>
		    	
  				    </#if>
  				    
				</#list>
		    </#if>
		    
		    <li class="page-item 
		    <#if actualPage==totalPages> disabled</#if>
		    ">
		      <a class="page-link" href="${context}/things/${actualPage+1}">Next</a>
		    </li>
		    
		  </ul>
		</nav>
	
	  </#if>
	  <!-- end pagination --> 
	  
		
</@c.page>
