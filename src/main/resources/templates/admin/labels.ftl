<#import "template.ftl" as admin />

<@admin.page title="Labels">

	<!-- Main content -->
    <section class="content">
    
    	<div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">Etiquetas de contenidos</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4"><div class="row">
              <div class="col-sm-12 col-md-6">
              </div><div class="col-sm-12 col-md-6">
              </div></div>
              <div class="row"><div class="col-sm-12">
		              <table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
		                <thead>
		                <tr role="row">
		                	<th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" 
		                		colspan="1" aria-sort="ascending" 
		                		aria-label="Rendering engine: activate to sort column descending">Nombre</th>
		                	<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" 
		                		colspan="1" 
		                		aria-label="Browser: activate to sort column ascending">Color</th>
		                	
		                	<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="actions">Actions</th>
		                	
		                	</tr>
		                </thead>
		                <tbody>
		                
				                <!--tr role="row" class="odd">
				                  <td class="sorting_1">Gecko</td>
				                  <td>Firefox 1.0</td>
				                  <td>Win 98+ / OSX.2+</td>
				                  <td>1.7</td>
				                  <td>A</td>
				                  <td>
				                  		<a class="edit" href="#" title="" data-toggle="tooltip" data-original-title="Edit">
				                  			<ion-icon name="pencil"></ion-icon>
				                  		</a>
				                  		<a class="edit" href="#" title="" data-toggle="tooltip" data-original-title="Remove">
					                  		<ion-icon name="trash"></ion-icon>
					                  	</a>
				                  </td>
				                </tr-->
				                
				                <#list labels as label >
					                <tr role="row" class="even">
					                  <td class="sorting_1">${label.name}</td>
					                  <td>${label.color}</td>
					                 
					                  <td>A</td>
					                </tr>
				                </#list>
				                
							</tbody>
		                
		                <!--tfoot>
		                <tr><th rowspan="1" colspan="1">Rendering engine</th><th rowspan="1" colspan="1">Browser</th><th rowspan="1" colspan="1">Platform(s)</th><th rowspan="1" colspan="1">Engine version</th><th rowspan="1" colspan="1">CSS grade</th></tr>
		                </tfoot-->
		                
		              </table>
              	 </div>
              </div>
              
              
              <div class="row">
              		<div class="col-sm-12 col-md-5">
              			<div class="dataTables_info" id="example2_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div></div><div class="col-sm-12 col-md-7"><div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
				              <ul class="pagination">
					              <li class="paginate_button page-item previous disabled" id="example2_previous"><a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">Previous</a></li>
					              <li class="paginate_button page-item active"><a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">1</a></li>
					              <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0" class="page-link">2</a></li>
					              <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0" class="page-link">3</a></li>
					              <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0" class="page-link">4</a></li>
					              <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0" class="page-link">5</a></li>
					              <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0" class="page-link">6</a></li>
					              <li class="paginate_button page-item next" id="example2_next"><a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Next</a></li>
				              </ul>
              				</div>
              			</div>
              		</div>
              </div>
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

