<#import "template.ftl" as admin />

<@admin.page title="Thing Types">

	<!-- Main content -->
    <section class="content">
    
    	<div class="row">
        <div class="col-12">
          
          <div class="card">
              <div class="card-header">
                <!--h3 class="card-title">Responsive Hover Table</h3-->

                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Thing Type</th>
                      <th>Description</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                  <#if thingtypes??>
				  	<#list thingtypes as thingtype >
				  	
	                    <tr>
	                      <td>${thingtype.id}</td>
	                      <td>${thingtype.name}</td>
	                      <td><#if thingtype.description??>${thingtype.description}</#if></td>
	                      <td>
	                      	<!-- Call to action buttons -->
                            <ul class="list-inline m-0">
                            	<!--li class="list-inline-item">
                                	<button class="btn btn-primary btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Add"><i class="fa fa-table"></i></button>
                            	</li-->
                            	<li class="list-inline-item">
                                    <button class="btn btn-success btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Edit"><i class="fa fa-edit"></i></button>
                            	</li>
                            	<li class="list-inline-item">
                            		<button class="btn btn-danger btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Delete"><i class="fa fa-trash"></i></button>
                                </li>
                            </ul>
	                      	
	                      </td>
	                    </tr>
	                    
	                  </#list>
					</#if>
                
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
          <!-- /.card -->

         
        </div>
        <!-- /.col -->
      </div>
      
      
      
    </section>
    <!-- /.content -->
    
    
    
</@admin.page>

