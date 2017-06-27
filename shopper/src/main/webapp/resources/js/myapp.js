$(function() {

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	
	case 'My Product':
		$('#viewproducts').addClass('active');
		break;
		
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	
	//to tackle csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	
	
	if(token.length >0 && header.length > 0){
		
		//set the token header for ajax request
		
		$(document).ajaxSend(function(e, xhr, options){
			
			xhr.setRequestHeader(header,token);
		});
		
	}
	//code for Jquery dataTable
	//create DataSet
	
	
	var $table = $('#productListTable');
	//execute the code only where this table

	console.log('Window.categoryid' + window.categoryId)

	if($table.length){
		//console.log('inside the table');
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else{
			
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';

		}
		$table.DataTable({
			
			lengthMenu:[[2,5,10,-1],['2 Records','5 Records','10 Records','All']],
			pageLength:5,
			ajax:{
				url: jsonUrl,
				dataSrc: ''	
			},
			columns: [
			         {
			        	  data: 'code',
			        	  mRender: function(data, type, row){
			 
			        			return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
			        		 }
			          },
			         {
			        	 data:'name'
			         },
			         {
			        	 data:'brand'
			         },
			         {
			        	 data:'unitPrice',
			        		 mRender:function(data ,type, row){
			        			 return '&#8377; ' +data
			        		 }
			         },
			         {
			        	 data:'quantity',
			        	 mRender:function(data ,type, row){
		        			 if(data < 1){
		        				 return '<span style = "color:red"Out Of Stock!!</span>';
		        			 }
		        			 return data;
		        		 }
			         },
			         {
			        	 data: 'id',
			        	 bSortable:false,
			        	 mRender:function(data ,type, row){
		        			 var str ='';
		        	         str += '<a class="btn btn-primary" href="'+window.contextRoot+ '/show/'+data+'/product"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
		        	         
		        	         if(row.quantity < 1){
		        	        	 
			        			 str += '<a class="btn btn-success disabled" href="javascript:void(0)"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

		        	         }
		        	         else{
		        	        	 
		        	        	 if(userRole == 'ADMIN'){
		        	        		 
				        			 str += '<a class="btn btn-warning" href="'+window.contextRoot+ '/manage/'+data+'/product"><span class="glyphicon glyphicon-pencil"></span></a>';

		        	        	 }
		        	        	 else{
				        			 str += '<a class="btn btn-success" href="'+window.contextRoot+ '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

		        	        	 }

		        	        	 
		        	         }
		        			 return str;

		        		 }
			         }
			         
			         ]
			
			
			
			
		});
		
	}
	
	
	//dismissing the alert after 3 sec
	
	var $alert=$('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow'); 
		} ,4000)
	}
	
	///////////////////////////////////
	
	
	
	//datatable for admin
	
	/////////////////////////////////////
	/////////////////////////////////////
	///////////////////////////////////
	
	var $adminProductsTable = $('#adminProductsTable');
	//execute the code only where this table

	if($adminProductsTable.length){
		//console.log('inside the table');
		var jsonUrl =window.contextRoot + '/json/data/admin/all/products';
		
		$adminProductsTable.DataTable({
			
			lengthMenu:[[10,30,50,-1],['10 Records','30 Records','50 Records','All']],
			pageLength:30,
			ajax:{
				url: jsonUrl,
				dataSrc: ''	
			},
			columns: [
			          {
			        	 data:'id' 
			          },
			          
			         {
			        	  data: 'code',
			        	  bSortable:false,
			        	  mRender: function(data, type, row){
			 
			        			return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
			        		 }
			          },
			         {
			        	 data:'name'
			         },
			         {
			        	 data:'brand'
			         },
			      
			         {
			        	 data:'quantity',
			        	 mRender: function(data ,type, row){
		        			 if(data < 1){
		        				 return '<span style = "color:red"Out Of Stock!!</span>';
		        			 }
		        			 return data;
		        		 }
			         },
			         {
			        	 data:'unitPrice',
			        		 mRender:function(data ,type, row){
			        			 return '&#8377; ' +data
			        		 }
			         },
			         {
			        	 data: 'active',
			        	 bSortable:false,
			        	 mRender:function(data, type,row){
			        		 var str='';
			        		 
			        		 str += '<label class="switch">';
			        		 if(data){
				        		 str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>'	;	

			        		 }
			        		 else{
				        		 str += '<input type="checkbox" value="'+row.id+'"/>'	;	

			        		 }
			        		 str += '<div class="slider"></div> </label> ' ;      
			        		 
			        		 return str;
			        		 
			        	 }
			         },
			         {
			        	 data:'id',
			        	 bSortable:false,
			        	 mRender:function(data ,type, row){
		        			 var str='';
		        			str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
		        			str +='<span class="glyphicon glyphicon-pencil"></span> </a>';
		        			
		        			return str;
		        		 }
			        	 
			         }
			         
			         ],
			         
			         initComplete: function(){
			        	 
			        	 var api =this.api();
			        	 
			        	 api.$('.switch input[type="checkbox"]').on('change', function(){
			        			
			        			var checkbox=$(this);
			        			var checked=checkbox.prop('checked');
			        			var dMsg=(checked)?'Do You want to activate product???':
			        								'Do You want to deactivate product???';
			        			var value=checkbox.prop('value');
			        			
			        			bootbox.confirm({
			        				size:'medium',
			        				title:'Product activate or deactivate',
			        				message:dMsg,
			        				callback: function(confirmed){
			        					if(confirmed){
			        						console.log(value);
			        						var activationUrl = window.contextRoot + '/manage/product/' +value+ '/activation';
			        						$.post(activationUrl,function(data){
			        							bootbox.alert({
				        							size:'medium',
				        							title:'information',
				        							message:data
				        						});
			        						});
			        						
			        						
			        					}
			        					else{
			        						checkbox.prop('checked',!checked);
			        					}
			        				}
			        			});
			        		});
			         }			   
			
		         });
		
	          }
	
	//------------------
	//-----------------
	//validation code for category
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length){
		
		$categoryForm.validate({
			
			rules:{
						name:{
								required:true,
								minlength:2,
							},
		              description:{
		            	  	required:true,
			
		              			}
				
			     },
			     messages:{
			    	 name:{
			    		 required:'Plz Add Category Name',
			    		 minlength:'The character of category must be greater than 2 !!'
			    	 },
			    	 description:{
			    		 required:'Plz Add some description for Category',
			    	 },
			    	 
			     },
			     errorElement:'em',
			     errorPlacement: function(error,element){
			    	 //add the class of help-block
			    	 error.addClass('help-block');
			    	 
			    	 //add error element after input element
			    	 error.insertAfter(element);
			     }
		    });
	      }
	
			///----------------
	
//validation for login
	var $loginForm = $('#loginForm');
	
	if($loginForm.length){
		
		$loginForm.validate({
			
			rules:{
						username:{
								required:true,
								email:true
							},
		              password:{
		            	  	required:true
			
		              			}
				
			     },
			     messages:{
			    	 username:{
			    		 required:'Plz give your  UserName',
			    		 email:'Plz Give Your Email id !!'
			    	 },
			    	 password:{
			    		 required:'Enter Your Password',
			    	 },
			    	 
			     },
			     errorElement:'em',
			     errorPlacement: function(error,element){
			    	 //add the class of help-block
			    	 error.addClass('help-block');
			    	 
			    	 //add error element after input element
			    	 error.insertAfter(element);
			     }
		    });
	      }
	
	
	
	
	
	
        });