<#import "template.ftl" as admin />

<@admin.page title="Custom Fields">

	<!-- Main content -->
    <section class="content">
    
    	<div class="row">
        <div class="col-12">
          
          <div class="card">
              <div class="card-header">
                <!--h3 class="card-title">Responsive Hover Table</h3-->
                
                <div class="btn-group">
                      <button type="button" class="btn btn-default">Left</button>
                      <button type="button" class="btn btn-default">Middle</button>
                      <button type="button" class="btn btn-default">Create</button>
                </div>
                    

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
                      <th>Name</th>
                      <th>--</th>
                      <th>--</th>
                      <th>--</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                  <#if customfields??>
				  	<#list customfields as customfield >
				  	
	                    <tr>
	                      <td>${customfield.id}</td>
	                      <td>${customfield.name}</td>
	                      <td>${customfield.type}</td>
	                      <td>---</td>
	                      <td></td>
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

