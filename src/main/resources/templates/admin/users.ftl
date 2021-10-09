<#import "template.ftl" as admin />

<@admin.page title="Users">

	<!-- Main content -->
    <section class="content">

		<div class="d-flex">
		      <div>
		
		      </div>
		      <div class="ml-auto">
					<div class="btn-group" role="group" aria-label="Basic example">
					  <button type="button" class="btn btn-primary">Left</button>
					  <button type="button" class="btn btn-primary">Middle</button>
					  <button type="button" class="btn btn-primary">Right</button>
					</div>
		      </div>
		 </div>
		
    
    		<table class="table table-sm">
			  <thead>
			    <tr>
			      <th scope="col" width="10%">Username</th>
			      <th scope="col">e-mail</th>
			    </tr>
			  </thead>
			  
			  <tbody>
			  	<#list users as user >
			  		<tr>
				      <th scope="row">${user.username}</th>
				      <td>${(user.email)!"not set"}</td>
				      <td>
				      	  <a href="">Edit</a>&nbsp;&nbsp;
			              <a href="" class="button btn-sm btn-outline-secondary">
			                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-three-dots" viewBox="0 0 16 16">
			  <path d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z"></path>
			</svg>
			                <span class="visually-hidden"></span>
			              </a>
				      </td>
				    </tr>
      			</#list>
			    
			  </tbody>
			</table>
      
      
    </section>
    <!-- /.content -->
    
    
    
</@admin.page>

