<#import "common.ftl" as c/>

<@c.page title="Main page">

    	<!-- custom page content -->
    	
	  	<div class="row">
 	
 		<#if things??>
 		
 		<div class="card-group">
		  	<#list things as thing >
				<!-- index: ${thing?index} -->
			
				<div class="card " style="">
			  			<h5 class="doc"><a href="${context}/thing/${thing.id}">${thing.summary}</a></h3>
			  				<small>
			  					<#if thing.created??>
			  						${thing.created?date}
			  					</#if>
			  				</small>
				</div>
			</#list>
			</div>
		</#if>
		
	    </div>
	
</@c.page>
