
<div class="list-group">
  	<a href="#" class="list-group-item list-group-item-action active">
    Relations
    				
    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#relations-modal">
  		Add
	</button>
    				
  	</a>
  				
  	<#if thingsRelated??>
			  		<#list thingsRelated as thingRelated >
						<a href="${context}/thing/${thingRelated.id}" class="list-group-item list-group-item-action">${thingRelated.humanKey} ${thingRelated.summary}</a>
			  		</#list>	
	</#if>
			  		
</div>
