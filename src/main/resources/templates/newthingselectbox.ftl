<#import "common.ftl" as c />

<@c.page title="">

 	<div class="row">
		<div class="col-2">&nbsp;</div>
		
		<div class="col-10">

			<#if (boxes??)&&(boxes?size>0) >
			
			  	<#list boxes as box >
					<!-- index: ${box?index} -->
				
					<div class="card small" style="margin: 0.5rem 0.25rem;">
				  		<div class="section">
				  			<h3 class="doc">${box.name}</h3>
				  			
				  				<#if box.thingTypes??>
			  					<ul>
				  					<#list box.thingTypes as thingType >
										<li><a href='${context}/thing/new/${box.id}/${thingType.id}'>${thingType.name}</a>
				  					</#list>
								</ul>
				  				</#if>
				  				<small>
				  					<#if box.created??>
				  						${box.created?date}
				  					</#if>
				  				</small>
						 </div>
					</div>
				</#list>
		
			<#else>
				<h2>No thing types for create one!</h2>
			</#if>
				
        </div>
        
	</div>
	  
</@c.page>
