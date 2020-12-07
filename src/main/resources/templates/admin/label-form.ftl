<#import "common.ftl" as c />

<@c.page title="Contenido">

	  <fieldset>

	      <form action="${context}/content/new" method="POST">
	 	    
	 	    <input type="hidden" name="hitoId" value="${hitoId}">
	 	    
	 	    <div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1" name="labels">
			  <label class="form-check-label" for="inlineCheckbox1">1</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2" name="labels">
			  <label class="form-check-label" for="inlineCheckbox2">2</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3" name="labels">
			  <label class="form-check-label" for="inlineCheckbox3">3 (disabled)</label>
			</div>

		    <div class="row responsive-label">
		    	<div class="col-sm-12 col-md-3">
		    		<label for="sf1-text" class="doc">Descripción</label>
		    	</div>
				<div class="col-sm-12 col-md">
					<textarea id="text" name="text" 
						rows="20" cols="60"
						class="doc" style="width:85%;" placeholder="Textarea"></textarea>
				</div>
			</div>
		  
		  	<div class="row responsive-label mt-auto p-1"> 
			  	<button type="button" class="btn btn-secondary">Cancelar</button>
			  	<button type="submit" class="btn btn-primary">Enviar datos</button>
			</div>
		    	
		</form>
		  	
	</fieldset>
			
</@c.page>
