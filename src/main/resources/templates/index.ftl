<#import "common.ftl" as c/>

<@c.page title="Main page">

    	<!-- custom page content -->
    	
	  	<div class="row">
 	
 		<#if things??>
 		<div class="card-columns">
		  	<#list things as thing >
				<!-- index: ${thing?index} -->
				<div class="card-group">
					<div class="card">
						<div class="card-body">
				  			<h3 class="doc"><a href="${context}/thing/${thing.id}">${thing.summary}</a></h3>
				  			<small>
				  				<#if thing.created??>
				  					${thing.created?date}
				  				</#if>
				  			</small>
						</div>
					</div>
				
				</div>
			</#list>
	    </div>
		</#if>
	
</@c.page>
