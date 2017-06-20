$(function() {

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Login':
		$('#login').addClass('active');
		break;

	case 'My Product':
		$('#viewproducts').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
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
		        			 if(data > 1){
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
		        	        	 
			        			 str += '<a class="btn btn-success disabled" href="javascript:voiid(0)"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

		        	         }
		        	         else{
			        			 str += '<a class="btn btn-success" href="'+window.contextRoot+ '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

		        	        	 
		        	         }
		        			 return str;

		        		 }
			         }
			         
			         ]
			
			
			
			
		});
		
	}
	
});