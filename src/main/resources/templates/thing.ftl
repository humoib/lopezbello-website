<#import "common.ftl" as c />

<@c.page title="">

	<script>
	
	function relates(){
		console.log("#thingId:"+$("#thingId").val());
		$.ajax({
   			type: "PUT",
		    contentType: "application/json; charset=utf-8",
    		url: "${baseUrl!""}${context}/rest/api/1/thing/relate",
    		data: '{"source": "'+$("#thingId").val()+'", "target":"'+$("#relate option:selected").val()+'"}',
    		dataType: "text",
    		success: function (returnData) {
        		console.debug('SUCCESS - related');
    		},
    		error: function (xhr, textStatus, errorThrown) { 
    			console.error("ERROR: "+ xhr.status + ': ' + xhr.statusText +' '+ textStatus +' '+ errorThrown);
    		}
		});
	}
	
	function loadRelations(){
	
	}
	
	</script>
	
	
 	<div class="row">
 	
		<div class="col-2" id="relations">
			<h3><a href="${context}/box/${box.id}">${box.name}</a></h3>
			
		</div>
		
		<!-- CENTRAL -->
		<div class="col-8">

			<!-- VIEW -->
			<#if !operation??>
				
				<#if thing??>
					<input type="hidden" id="thingId" name="thingId" value="${thing.id}">
					
					<h5><a href='${context}/thing/${thing.thingKey}'>${thing.thingKey}</a> : ${thing.summary}</h5>
					
				</#if>
							
				<!-- Action Bar--> 
				<div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
				    <button type="button" class="btn btn-primary"
				    	onclick="window.location.href = '${context}/thing/edit/${thing.id}';">Edit</button>
				    <button type="button" class="btn btn-primary">Assign</button>
				    
				    <button type="button" class="btn btn-secondary"
				    	onclick="window.location.href = '${context}/thing/attach/${thing.id}';">Attach</button>
				    
				    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#relations-modal">Relate</button>
				    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				      More
				    </button>
				    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
				      <a class="dropdown-item" href="#">Delete</a>
				      <a class="dropdown-item" href="#">Dropdown link</a>
				    </div>
				</div>
					
				<div class="btn-group btn-group-sm" role="group">
				    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				      Transit
				    </button>
				    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
				      <a class="dropdown-item" href="#">Dropdown link</a>
				      <a class="dropdown-item" href="#">Dropdown link</a>
				    </div>
	            </div>
				
				<br/>
									
				<#if thing.analysis??>
					<p><b>Analysis:</b></p>
					<p>${thing.analysis!""}</p>
				
					<hr/>
				</#if>
						
				<#if fields??>
			  		<#list fields as field >
			  			<#if field.value?? >
							<p><b>${field.name}</b>: ${field.value}</p>
						</#if>
			  		</#list>	
			  	</#if>
			  	
			  	<hr/>
			  	
			  	<!-- Attachments & relations -->
				<#if !operation?? >
					<#if thing?? >
  						
  						<div class="card">
  							<div class="card-header"><b>Attachments</b>
  								<button type="button" class="btn-small btn-primary float-sm-right" data-toggle="modal" data-target="#relations-modal"
		    						title="Number: ${thingsRelated?size}">
		  							Attach
								</button>
  							</div>
  							<div class="card-body">
								<#if attachments??>
									<ul>
										<#list attachments as attachment >
											<li>${attachment.filename}
										</#list>								
									</ul>
								</#if>
							</div>
						</div>
													
  						<div class="card">
  							<div class="card-header"><b>Relations</b>
  								<button type="button" class="btn-small btn-primary float-sm-right" data-toggle="modal" data-target="#relations-modal"
		    						title="Number: ${thingsRelated?size}">
		  							Relate
								</button>
  							</div>
  							
  							<#if thingsRelated??>
		  						<div class="card-body">
									<ul>
										<#list thingsRelated as thingRelated >
						 	 				<li><a href="${context}/thing/${thingRelated.id}" 
												class="list-group-item list-group-item-action"
												>${thingRelated.humanKey} ${thingRelated.summary}</a>
										</#list>
									</ul>
								</div>
							</#if>
						</div>
						
    	  				
  						
				 		
					</#if>	
				</#if>
				<!-- end relations -->
			
				
			<#elseif (operation=="new"||operation=="edit")>
			
				<!-- EDIT -->
				<#if operation == 'new' >
			      	<form action="${context}/thing/new" method="POST">
	        	<#elseif operation == 'edit' >	  
					<form action="${context}/thing/edit/${thing.id}" method="POST">
				</#if>	
		 		
		 			<input type='hidden' name='boxId' value='${boxId}'>		 			
		 			<input type='hidden' name='thingTypeId' value='${thingTypeId}'>
		 			
 					<div class="form-group row">
				    	<label for="summary" class="col-sm-2 col-form-label">Summary</label>
				    	<div class="col-sm-10">
				      		<input type="text" class="form-control form-control-sm" 
				      			id="summary" name="summary" placeholder="text" 
				      			<#if thing??>
				      				value="${thing.summary}"
				      			</#if>
				      			>
				    	</div>
				    	
				    	<label for="analysis" class="col-sm-2 col-form-label">Analysis</label>
				    	<div class="col-sm-10">
				    		<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" 
				    			name="analysis"><#if thing??>${thing.analysis!""}</#if></textarea>
				    	</div>
				    	
					</div>
					
					<!-- FIELDS -->
		 			<#if fields??>
			 			<#list fields as field >
							<!-- <p><b>field.name:</b> value</p> -->
							
							<#switch field.type>
							<#case "text">
    							<div class="form-group row">
							    	<label for="cf_${field.id}" class="col-sm-2 col-form-label">${field.name}</label>
							    	<div class="col-sm-10">
							      		<input type="text" class="form-control form-control-sm" id="${field.id}" 
							      			name="cf_${field.id}" placeholder="text" 
							      			<#if field.value?? >
							      			value="${field.value}"
						    	  			</#if>
						      				>
						    		</div>
								</div>
							<#break>

							<#case "text-large">
    							<div class="form-group row">
    								<label for="cf_${field.id}" class="col-sm-2 col-form-label">${field.name}</label>
    								<div class="col-sm-10">
	    									<textarea class="form-control form-control-sm" 
	    										id="${field.id}" name="cf_${field.id}" 
	    										rows="3"><#if field.value?? >${field.value}</#if></textarea>
         				    		</div>
									
								</div>
							<#break>

							<#case "select">
    							<div class="form-group row">
    								<label for="cf_${field.id}" class="col-sm-2 col-form-label">${field.name}</label>
    								<div class="col-sm-10">
    									<select id="${field.id}" name="cf_${field.id}">
    										<option value="">### none ###
    										    										
    										<#list options['3'] as option >
 												<option value="${option}"
 												<#if field.value?? && option==field.value> selected</#if>
 												>${option}
											</#list>	
    									
    									</select>
    												
    								</div>									
								</div>
							<#break>
							
							<#case "radio">
    							<div class="form-group row">
    								<label for="cf_${field.id}" class="col-sm-2 col-form-label">${field.name}</label>
    								<div class="col-sm-10">
    									<div class="form-check">
											<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
											<label class="form-check-label" for="flexRadioDefault1">
    											Default radio
											</label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
											<label class="form-check-label" for="flexRadioDefault2">
													Default checked radio
											</label>
										</div>
    								</div>									
								</div>
							<#break>
							
							<#case "datetime">
    							<div class="form-group row">
    								<label for="cf_${field.id}" class="col-sm-2 col-form-label">${field.name}</label>
    								<div class="col-sm-10">
	    									<div class='input-group date' id='datetimepicker5'>
    										
               									<input type='text' class="form-control" />
               									<span class="input-group-addon">
              									 <span class="glyphicon glyphicon-calendar"></span>
             									  </span>
            								</div>
            								
            								<script type="text/javascript">
         $(function () {
             $('#datetimepicker5').datetimepicker({
                 defaultDate: "11/1/2013",
                 disabledDates: [
                     new Date(2013, 11 - 1, 21),
                     "11/22/2013 00:53"
                 ]
             });
         });
      </script>
      
         				    		</div>
									
								</div>
								
								
							<#break>
														
							</#switch>
					  	
					  	</#list>
					</#if>
							
							
							
							
							
							
		 			<!--div class="form-group row">
					    <label for="cf_1000" class="col-sm-2 col-form-label">text</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control form-control-sm" id="cf_1000" placeholder="text">
					    </div>
					</div>
					  
					<div class="form-group row">
					    <label for="cf_1001" class="col-sm-2 col-form-label">select</label>
					    <div class="col-sm-10">
					    
					    	<div class="input-group mb-3">
							  <div class="input-group-prepend">
							    <label class="input-group-text" for="inputGroupSelect01">Options</label>
							  </div>
							  <select class="custom-select" id="cf_1001">
							    <option selected>Choose...</option>
							    <option value="1">One</option>
							    <option value="2">Two</option>
							    <option value="3">Three</option>
							  </select>
							</div>
							
					    </div>
					</div-->
					
					  
				  <!--div class="form-group row">
				    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
				    <div class="col-sm-10">
				      <input type="email" class="form-control form-control-sm" id="inputEmail3" placeholder="Email">
				    </div>
				  </div-->
				  
				  <!--div class="form-group row">
				    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control form-control-sm" id="inputPassword3" placeholder="Password">
				    </div>
				  </div-->
				  
				  <!--fieldset class="form-group">
				    <div class="row">
				      <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
				      <div class="col-sm-10">
				        <div class="form-check">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
				          <label class="form-check-label" for="gridRadios1">
				            First radio
				          </label>
				        </div>
				        <div class="form-check">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
				          <label class="form-check-label" for="gridRadios2">
				            Second radio
				          </label>
				        </div>
				        <div class="form-check disabled">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
				          <label class="form-check-label" for="gridRadios3">
				            Third disabled radio
				          </label>
				        </div>
				      </div>
				    </div>
				  </fieldset-->
				  
				  <!--div class="form-group row">
				    <div class="col-sm-2">Checkbox</div>
				    <div class="col-sm-10">
				      <div class="form-check">
				        <input class="form-check-input" type="checkbox" id="gridCheck1">
				        <label class="form-check-label" for="gridCheck1">
				          Example checkbox
				        </label>
				      </div>
				    </div>
				  </div-->
				  
				  <!-- SUBMIT -->
				  <div class="form-group row">
				    <div class="col-sm-10">
				      <button type="submit" class="btn btn-primary">Submit</button>
				      <a href="#" onclick="window.history.back();" class="btn btn-secondary">Cancel</a>
				    </div>
				  </div>
				  
				</form>
		
			</#if>
			
        </div>
        
        
		<!-- CENTRAL -->
		<div class="col-2">
			<div class="container">
			
			<#if thing?? >
			
				<h5>Info</h5>
					<ul>
						<li><b>Type:</b> ${thing.thingTypeName}
					</ul>
			
				<h5>People</h5>
					<ul>
						<li><b>Creator:</b> ${thing.creator.username!"unknown"}
						<li><b>Assignee:</b> user
						<li><b>Watchers:</b> users
					</ul>
				
				<h5>Dates</h5>
					<ul>
						<#if thing.created??>
							<li><b>Created:</b> ${thing.created?date}
						</#if>
						<#if thing.updated??>
							<li><b>Updated:</b> ${thing.updated?date}
						</#if>
					</ul>
			</#if>
			
			</div>
		</div>
        
	</div> <!-- FIN primera fila -->
	
	<hr/>
	
	<#if !operation?? || (operation?? && (operation!="new" && operation!="edit")) >
	
		<div class="row">
			<div class="col-12">
		
				<#if thing?? >
					
				<ul class="nav nav-tabs">
	 				<li class="nav-item">
	 					<a class="nav-link active" aria-current="page" href="#comments" data-toggle="tab">Comments</a>
	 				</li>
	 				
					<li class="nav-item">
						<a class="nav-link" href="#changes" data-toggle="tab">Changes</a>
					</li>
				</ul>
	
				<div class="tab-content">
	        		<div class="tab-pane active" id="comments">
	        
	       		 	<form action="${context}/thing/newComment" method="POST">
	        			<input type="hidden" name="thingId" value="${thingId}">
			 			
		        		<div class="form-group">
	    					<textarea class="form-control" id="comment" name="comment" rows="3"></textarea>
	    					<button type="submit" class="btn-small btn-primary">Add comment</button>
	  					</div>
		        	
	  				</form>
			
					<#if thingComments?? >
						<#list thingComments as thingComment >
						  	<p>On <b>${thingComment.created?datetime}</b>, <b>${thingComment.actor.username}</b> comment: <b>${thingComment.comment}</b></p>
						</#list>
					</#if>
					
		        </div>
		        <div class="tab-pane" id="changes">changes</div>
		    </div>
	    
	    

			</#if>
		</#if>
			
	
		</div>
	</div>
	
	
	
	
	<!-- Modal for relations -->
	<#if thing?? >
		<div class="modal fade" id="relations-modal" tabindex="-1" role="dialog" 
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  			<div class="modal-dialog modal-dialog-centered" role="document">
  			  <div class="modal-content">
 			     <div class="modal-header">
 			       <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
   				     	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
     				     	<span aria-hidden="true">&times;</span>
      			 		 </button>
      			</div>
      			<div class="modal-body">
      				<select class="form-control form-control-sm" id="relate">
      					<#if thingsToRelate??>
      						<#list thingsToRelate as thing >
      							<option value="${thing.id}">${thing.thingKey} - ${thing.summary}</option>
      						</#list>
      					</#if>
					</select>
     	 		</div>
     	 		<div class="modal-footer">
    	    		<button type="button" class="btn btn-secondary" data-dismiss="modal"
    	    			onclick="$('#relations-modal').modal('hide');">Close</button>
	       			<button type="button" class="btn btn-primary" 
	       				onclick="console.log('relate');relates();$('#relations-modal').modal('hide');location.reload();">Relate</button>
      			</div>
    			</div>
  			</div>
		</div>
	</#if>
	<!-- fin de MODAL for relations -->

</@c.page>
